package cz.csob.ency.modules.e3.web.context;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.modules.e3.app.model.E3App;
import cz.csob.ency.modules.e3.app.service.E3AppLocalService;
import cz.csob.ency.modules.e3.app.service.E3AppLocalServiceUtil;
import cz.csob.ency.modules.e3.constants.E3EntryModes;
import cz.csob.ency.modules.e3.entry.exception.NoSuchE3EntryException;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.web.portlet.base.actions.constants.E3RenderCommand;
import cz.csob.ency.modules.e3.web.util.E3EntryUtil;

import javax.portlet.PortletMode;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class E3EntryDisplayContext {
    private static final Log _log = LogFactoryUtil.getLog(E3EntryDisplayContext.class);

    public E3EntryDisplayContext(LiferayPortletRequest liferayPortletRequest,
                                 LiferayPortletResponse liferayPortletResponse)
            throws NoSuchE3EntryException, PortalException {
        _appLocalService = E3AppLocalServiceUtil.getService();
        _liferayPortletRequest = liferayPortletRequest;
        _liferayPortletResponse = liferayPortletResponse;

        _portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
                liferayPortletRequest);

        _httpServletRequest = _liferayPortletRequest.getHttpServletRequest();

        try {
            _entry = E3EntryUtil.getEntry(liferayPortletRequest);
        } catch (NoSuchE3EntryException ex) {
            // it's possibly ok. I.e. new entry
        }


        if (_entry != null) {
            _app = E3AppLocalServiceUtil.getApp(_entry);
        } else {
            String appClass = ParamUtil.getString(liferayPortletRequest, "appClass", "");

            if (Validator.isBlank(appClass)) {
                appClass = (String) liferayPortletRequest.getAttribute("appClass");
            }

            if (Validator.isBlank(appClass)) {
                _log.warn("Unable to find entryid or appclass");
                throw new NoSuchE3EntryException("Unable to find entryid or appclass");
            }
            _log.info("got app class " + appClass);

            _app = E3AppLocalServiceUtil.getApp(appClass);
            if (_app == null) {
                _log.warn("Unable to find entryid nor appclass");
                throw new PortalException("Invalid request. No entry and no appClass ");
            }
        }
    }

    public E3App getApp() {
        return _app;
    }

    public E3Entry getEntry() {
        return _entry;
    }

    public String getEntryMode() {
        String mvcRenderCommandName = ParamUtil.getString(
                _liferayPortletRequest, "mvcRenderCommandName", "/");

        PortletMode mode = _liferayPortletRequest.getPortletMode();

        if (mvcRenderCommandName.equals(E3RenderCommand.EDIT_ENTRY_COMMAND)) {
            return E3EntryModes.EDIT_MODE;
        }

        if (mvcRenderCommandName.equals("/") && mode.equals(PortletMode.EDIT)) {
            return E3EntryModes.EDIT_MODE;
        }

        return E3EntryModes.VIEW_MODE;
    }

    public String getPortletId() {
        return _app.getAppMainPortletName();
    }

    public Map getRenderContext() {
        if (_app == null) {
            return new HashMap();
        }
        if (_entry == null) {
            return _appLocalService.getAppRenderContext(_app.getAppClass().getName());
        }
        return _appLocalService.getAppRenderContext(_entry);
    }

    public Boolean isNew() {
        return Validator.isNull(_entry);
    }
    private final E3AppLocalService _appLocalService;
    private final HttpServletRequest _httpServletRequest;
    private final LiferayPortletRequest _liferayPortletRequest;
    private final LiferayPortletResponse _liferayPortletResponse;
    private final PortalPreferences _portalPreferences;
    private E3App _app = null;
    private E3Entry _entry = null;
}
