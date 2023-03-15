package cz.csob.ency.cds.demands.web.internal.portlet.action.resource;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.upload.UploadHandler;
import cz.csob.ency.cds.demands.constants.CdsDemandPortletKeys;
import cz.csob.ency.cds.demands.web.internal.upload.CdsDemandUploadFileEntryHandler;
import cz.csob.ency.cds.demands.web.internal.upload.CdsDemandUploadResponseHandler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + CdsDemandPortletKeys.CDSDEMAND,
                "javax.portlet.name=" + CdsDemandPortletKeys.CDSDEMAND_ADMIN,
                "mvc.command.name=/cdsdemand/upload_file_entry"
        },
        service = MVCActionCommand.class
)
public class UploadFileEntryMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        _uploadHandler.upload(
                _uploadFileEntryHandler, _uploadResponseHandler,
                actionRequest, actionResponse);

        SessionMessages.clear(actionRequest);
    }

    @Reference
    private CdsDemandUploadFileEntryHandler _uploadFileEntryHandler;
    @Reference
    private UploadHandler _uploadHandler;
    @Reference
    private CdsDemandUploadResponseHandler _uploadResponseHandler;

}
