package cz.csob.ency.modules.e3.web.portlet.base.actions;
/**
 * @todo Handlovanie spravnych chyb a ich zobrazenie
 * @todo Workflow support
 * @todo Podpora dalsich prikazov (subscribe ...)
 * @todo Podpora Trash?
 * @todo Podpora Ajax?
 * @todo Describe
 */


import com.liferay.asset.kernel.exception.AssetCategoryException;
import com.liferay.asset.kernel.exception.AssetTagException;
import com.liferay.blogs.exception.*;
import com.liferay.bulk.selection.BulkSelection;
import com.liferay.document.library.kernel.exception.FileSizeException;
import com.liferay.friendly.url.exception.DuplicateFriendlyURLEntryException;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.change.tracking.CTTransactionException;
import com.liferay.portal.kernel.exception.ImageResolutionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.sanitizer.SanitizerException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.MultiSessionMessages;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.TransactionConfig;
import com.liferay.portal.kernel.transaction.TransactionInvokerUtil;
import com.liferay.portal.kernel.upload.LiferayFileItemException;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadRequestSizeException;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import cz.csob.ency.modules.e3.web.internal.bulk.selection.E3EntryBulkSelectionFactory;
import cz.csob.ency.modules.e3.web.internal.bulk.selection.E3EntryBulkSelectionFactoryUtil;
import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalService;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalServiceUtil;
import cz.csob.ency.modules.e3.exceptions.MissingParameterException;
import cz.csob.ency.modules.e3.web.portlet.base.actions.constants.E3RenderCommand;

import javax.portlet.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class BaseE3EntryMVCActionCommand extends BaseMVCActionCommand {
    private static final Log _log = LogFactoryUtil.getLog(BaseE3EntryMVCActionCommand.class);
    private static final TransactionConfig _transactionConfig =
            TransactionConfig.Factory.create(
                    Propagation.REQUIRED, new Class<?>[]{Exception.class});

    public BaseE3EntryMVCActionCommand() {
    }

    private E3EntryLocalService _entryService() {
        return E3EntryLocalServiceUtil.getService();
    }

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse) {

        String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

        _log.info("In action {cmd=" + cmd + "}");
        try {
            E3Entry entry = null;

            UploadException uploadException =
                    (UploadException) actionRequest.getAttribute(
                            WebKeys.UPLOAD_EXCEPTION);

            if (uploadException != null) {
                Throwable throwable = uploadException.getCause();

                if (uploadException.isExceededFileSizeLimit()) {
                    throw new FileSizeException(throwable);
                }

                if (uploadException.isExceededLiferayFileItemSizeLimit()) {
                    throw new LiferayFileItemException(throwable);
                }

                if (uploadException.isExceededUploadRequestSizeLimit()) {
                    throw new UploadRequestSizeException(throwable);
                }

                throw new PortalException(throwable);
            } else if (cmd.equals(Constants.ADD) ||
                    cmd.equals(Constants.UPDATE)) {

                Callable<E3Entry> updateEntryCallable =
                        new UpdateEntryCallable(actionRequest);

                entry = TransactionInvokerUtil.invoke(
                        _transactionConfig, updateEntryCallable);
            } else if (cmd.equals(Constants.DELETE)) {
                _deleteEntries(actionRequest, false);
                //         } else if (cmd.equals(Constants.MOVE_TO_TRASH)) {
                //             _deleteEntries(actionRequest, true);
                //         } else if (cmd.equals(Constants.RESTORE)) {
                //             _restoreTrashEntries(actionRequest);
                //         } else if (cmd.equals(Constants.SUBSCRIBE)) {
                //             _subscribe(actionRequest);
                //        } else if (cmd.equals(Constants.UNSUBSCRIBE)) {
                //             _unsubscribe(actionRequest);
            }

            boolean ajax = ParamUtil.getBoolean(actionRequest, "ajax");
/*
            if (ajax) {
                JSONPortletResponseUtil.writeJSON(
                        actionRequest, actionResponse,
                        JSONUtil.put(
                                "attributeDataImageId",
                                EditorConstants.ATTRIBUTE_DATA_IMAGE_ID
                        ).put(
                                "content", entry.getContent()
                        ).put(
                                "coverImageFileEntryId",
                                entry.getCoverImageFileEntryId()
                        ).put(
                                "entryId", entry.getEntryId()
                        ).put(
                                "urlTitle", entry.getUrlTitle()
                        ));

                return;
            }
*/

            String portletResource = ParamUtil.getString(
                    actionRequest, "portletResource");
            int workflowAction = ParamUtil.getInteger(
                    actionRequest, "workflowAction",
                    WorkflowConstants.ACTION_PUBLISH);
            //            WorkflowConstants.ACTION_SAVE_DRAFT);

            if (Validator.isNotNull(portletResource) &&
                    (workflowAction != WorkflowConstants.ACTION_SAVE_DRAFT)) {

                hideDefaultSuccessMessage(actionRequest);

                MultiSessionMessages.add(
                        actionRequest, portletResource + "requestProcessed");
            }

            String redirect = ParamUtil.getString(actionRequest, "redirect");

            if ((entry != null) &&
                    (workflowAction == WorkflowConstants.ACTION_SAVE_DRAFT)) {

                _sendDraftRedirect(actionRequest, actionResponse, entry);
            } else if (cmd.equals(Constants.UPDATE)) {

                _sendUpdateRedirect(actionRequest, actionResponse, entry);
            } else if (Validator.isNotNull(redirect) &&
                    cmd.equals(Constants.ADD) && (entry != null)) {

                _sendAddRedirect(
                        actionRequest, actionResponse, entry.getEntryId());
            }
        } catch (AssetCategoryException | AssetTagException exception) {
            SessionErrors.add(actionRequest, exception.getClass(), exception);

            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", E3RenderCommand.EDIT_ENTRY_COMMAND);
            actionResponse.setRenderParameter(
                    "entryId", ParamUtil.getString(actionRequest, "entryId"));
            actionResponse.setRenderParameter(
                    "appClass", ParamUtil.getString(actionRequest, "appClass"));

            hideDefaultSuccessMessage(actionRequest);
        } catch (CTTransactionException ctTransactionException) {
            throw ctTransactionException;
        } catch ( // @todo
                DuplicateFriendlyURLEntryException | EntryContentException |
                        EntryCoverImageCropException | EntryDescriptionException |
                        EntryDisplayDateException | EntrySmallImageNameException |
                        EntrySmallImageScaleException | EntryTitleException |
                        EntryUrlTitleException | FileSizeException |
                        ImageResolutionException | LiferayFileItemException |
                        SanitizerException | UploadRequestSizeException exception) {

            SessionErrors.add(actionRequest, exception.getClass());

            actionResponse.setRenderParameter(
                    "mvcRenderCommandName", E3RenderCommand.EDIT_ENTRY_COMMAND);
            actionResponse.setRenderParameter(
                    "entryId", ParamUtil.getString(actionRequest, "entryId"));
            actionResponse.setRenderParameter(
                    "appClass", ParamUtil.getString(actionRequest, "appClass"));

            hideDefaultSuccessMessage(actionRequest);
        } catch (NoSuchEntryException | PrincipalException exception) {
            SessionErrors.add(actionRequest, exception.getClass());

            actionResponse.setRenderParameter("mvcPath", "/e3/error.jsp");

            hideDefaultSuccessMessage(actionRequest);
        } catch (Throwable throwable) {
            _log.error(throwable, throwable);

            actionResponse.setRenderParameter("mvcPath", "/e3/error.jsp");

            hideDefaultSuccessMessage(actionRequest);
        }
    }

    private void _deleteEntries(
            ActionRequest actionRequest, boolean moveToTrash)
            throws Exception {

        List<TrashedModel> trashedModels = new ArrayList<>();

        BulkSelection<E3Entry> blogsEntryBulkSelection =
                E3EntryBulkSelectionFactoryUtil.create(
                        _getParameterMap(actionRequest));

        blogsEntryBulkSelection.forEach(
                blogsEntry -> _deleteEntry(actionRequest, blogsEntry, moveToTrash, trashedModels));

        if (moveToTrash && !trashedModels.isEmpty()) {
            addDeleteSuccessData(
                    actionRequest,
                    HashMapBuilder.<String, Object>put(
                            "trashedModels", trashedModels
                    ).build());
        }
    }

    private void _deleteEntry(
            ActionRequest actionRequest, E3Entry entry, boolean moveToTrash,
            List<TrashedModel> trashedModels) {

        try {
//            if (moveToTrash) {
//                trashedModels.add(
//                        _entryService.moveEntryToTrash(entry.getEntryId()));
//            } else {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                    E3Entry.class.getName(), actionRequest);
            _entryService().deleteEntry(entry, serviceContext);
//            }
        } catch (PortalException portalException) {
            ReflectionUtil.throwException(portalException);
        }
    }

    private Map<String, String[]> _getParameterMap(ActionRequest actionRequest)
            throws Exception {

        Map<String, String[]> parameterMap = new HashMap<>(
                actionRequest.getParameterMap());

        parameterMap.put(
                "groupId",
                new String[]{
                        String.valueOf(_portal().getScopeGroupId(actionRequest))
                });

        return parameterMap;
    }

    private String _getSaveAndContinueRedirect(
            ActionRequest actionRequest, ActionResponse actionResponse, E3Entry entry, String redirect)
            throws Exception {

        PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(
                JavaConstants.JAVAX_PORTLET_CONFIG);
        RenderURL portletURL = actionResponse.createRedirectURL(MimeResponse.Copy.NONE);
        /*
        LiferayPortletURL portletURL = PortletURLFactoryUtil.create(
                actionRequest, portletConfig.getPortletName(),
                PortletRequest.RENDER_PHASE);
        portletURL.setPortletId(actionResponse.getNamespace());

         */

        portletURL.setParameter("mvcRenderCommandName", E3RenderCommand.EDIT_ENTRY_COMMAND);

        portletURL.setParameter(Constants.CMD, Constants.UPDATE);
        portletURL.setParameter("redirect", redirect);
        portletURL.setParameter(
                "groupId", String.valueOf(entry.getGroupId()));
        portletURL.setParameter(
                "entryId", String.valueOf(entry.getEntryId()));
        portletURL.setWindowState(actionRequest.getWindowState());
        _log.info(portletURL.toString());

        return portletURL.toString();
    }

    private void _sendAddRedirect(
            ActionRequest actionRequest, ActionResponse actionResponse,
            long entryId)
            throws Exception {

        String redirect = ParamUtil.getString(actionRequest, "redirect");

        String portletResource = _httpUtil().getParameter(
                redirect, "portletResource", false);

        if (Validator.isNotNull(portletResource)) {
            String namespace = _portal().getPortletNamespace(portletResource);

            redirect = _httpUtil().addParameter(
                    redirect, namespace + "className", E3Entry.class.getName());
            redirect = _httpUtil().addParameter(
                    redirect, namespace + "entryId", entryId);
        }

        sendRedirect(
                actionRequest, actionResponse, _portal().escapeRedirect(redirect));
    }

    private void _sendDraftRedirect(
            ActionRequest actionRequest, ActionResponse actionResponse,
            E3Entry entry)
            throws Exception {

        String redirect = ParamUtil.getString(actionRequest, "redirect");

        sendRedirect(
                actionRequest, actionResponse,
                _getSaveAndContinueRedirect(actionRequest, actionResponse, entry, redirect));
    }

    private void _sendUpdateRedirect(
            ActionRequest actionRequest, ActionResponse actionResponse, E3Entry entry)
            throws Exception {

        String redirect = ParamUtil.getString(actionRequest, "redirect");

        if (Validator.isBlank(redirect)) {
            PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(
                    JavaConstants.JAVAX_PORTLET_CONFIG);

            LiferayPortletURL portletURL = PortletURLFactoryUtil.create(
                    actionRequest, portletConfig.getPortletName(),
                    PortletRequest.RENDER_PHASE);

            portletURL.setParameter(
                    "mvcRenderCommandName", E3RenderCommand.VIEW_ENTRY_COMMAND);


            portletURL.setParameter("redirect", redirect);
            portletURL.setParameter(
                    "groupId", String.valueOf(entry.getGroupId()));
            portletURL.setParameter(
                    "entryId", String.valueOf(entry.getEntryId()));
            portletURL.setWindowState(actionRequest.getWindowState());
            sendRedirect(
                    actionRequest, actionResponse, portletURL.toString());
        } else {

            String namespace = actionResponse.getNamespace();

            redirect = _httpUtil().setParameter(
                    redirect, namespace + "redirectToLastFriendlyURL", false);

            sendRedirect(
                    actionRequest, actionResponse, _portal().escapeRedirect(redirect));
        }
    }

    private E3Entry _updateEntry(ActionRequest actionRequest)
            throws Exception {
        /*
        actionRequest.getActionParameters().getNames().stream().forEach(s ->
                _log.info(s + ":" + actionRequest.getActionParameters().getValue(s))
        );
         */

        Long entryId = ParamUtil.getLong(actionRequest, "entryId", 0);
        String appClass = ParamUtil.getString(actionRequest, "appClass", StringPool.BLANK);

        if (entryId == 0 && Validator.isBlank(appClass)) {
            //@todo exception? or set error messages
            throw new MissingParameterException("Unable to determine entryId or appClass when saving entry.");
        }

        E3Entry entry = null;

        // @todo check values
        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                E3Entry.class.getName(), actionRequest);

        if (entryId <= 0) {

            // Add entry

            entry = _entryService().createEntry(appClass);

            if (entry == null) {
                throw new PortletException("Unable create entry.");
            }

            entry.setValues(actionRequest);
            _entryService().addEntry(entry, true, serviceContext);

        } else {

            // Update Entry

            entry = _entryService().getEntry(entryId);

            if (entry == null) {
                throw new NoSuchE3EntryException("Entry not found. Entry Id= " + entryId);
            }

            entry.setValues(actionRequest);
            _entryService().updateEntry(entry, true, serviceContext);
        }


        /*
        _assetDisplayPageEntryFormProcessor.process(
                E3Entry.class.getName(), entry.getEntryId(), actionRequest);
*/
        String portletResource = ParamUtil.getString(
                actionRequest, "portletResource");

        if (Validator.isNotNull(portletResource)) {
            MultiSessionMessages.add(
                    actionRequest, portletResource + "requestProcessed");
        }

        return entry;


    }

    private final Http _httpUtil() {return HttpUtil.getHttp();};
    private final Portal _portal() {return PortalUtil.getPortal();} ;
    //    private final AssetDisplayPageEntryFormProcessor _assetDisplayPageEntryFormProcessor;

    private class UpdateEntryCallable implements Callable<E3Entry> {

        private UpdateEntryCallable(ActionRequest actionRequest) {
            _actionRequest = actionRequest;
        }

        @Override
        public E3Entry call() throws Exception {
            return _updateEntry(_actionRequest);
        }

        private final ActionRequest _actionRequest;

    }
}