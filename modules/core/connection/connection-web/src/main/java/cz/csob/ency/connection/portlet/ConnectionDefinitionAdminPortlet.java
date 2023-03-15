package cz.csob.ency.connection.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import cz.csob.ency.connection.constants.ConnectionDefinitionPortletKeys;
import cz.csob.ency.connection.service.ConnectionDefinitionLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;

/**
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.layout-cacheable=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "javax.portlet.display-name=Connection Definition",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/admin/view.jsp",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.name=" + ConnectionDefinitionPortletKeys.CONNECTIONDEFINITION_ADMIN,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator",
        },
        service = Portlet.class
)
public class ConnectionDefinitionAdminPortlet extends MVCPortlet {

    private static final Log log = LogFactoryUtil.getLog(ConnectionDefinitionAdminPortlet.class);

    public void addConnectionDefinition(ActionRequest request, ActionResponse response)
            throws PortalException {

        long connectionId = ParamUtil.getLong(request, "connectionId");
        String name = ParamUtil.getString(request, "name");
        String serverAddress = ParamUtil.getString(request, "serverAddress");
        String serverPort = ParamUtil.getString(request, "serverPort", "1433");
        String databaseName = ParamUtil.getString(request, "databaseName");
        String driver = ParamUtil.getString(request, "driver");
        //   String url = ParamUtil.getString(request, "url");
        Boolean integratedSecurity = ParamUtil.getBoolean(request, "integratedSecurity", false);
        String username = ParamUtil.getString(request, "username");
        String password = ParamUtil.getString(request, "password");
        String additionalParams = ParamUtil.getString(request, "additionalParams");

        try {
            _connectionDefinitionLocalService.addConnectionDefinition(
                    name, driver, serverAddress, serverPort
                    , databaseName, integratedSecurity, username, password, additionalParams);
        } catch (PortalException pe) {
            log.error(pe);

            response.setRenderParameter(
                    "mvcPath", "/admin/edit.jsp");
        }
    }

    //  @Reference
    //  private SqlTools sqlTools;

    public void deleteConnectionDefinition(ActionRequest request, ActionResponse response)
            throws PortalException {

        long connectionId = ParamUtil.getLong(request, "connectionId");

        try {
            _connectionDefinitionLocalService.deleteConnectionDefinition(connectionId);
        } catch (PortalException pe) {
            log.error(pe);
        }
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        boolean headers = false;

        super.render(renderRequest, renderResponse);
    }

    public void updateConnectionDefinition(ActionRequest request, ActionResponse response)
            throws PortalException {

        long connectionId = ParamUtil.getLong(request, "connectionId");
        String name = ParamUtil.getString(request, "name");
        String serverAddress = ParamUtil.getString(request, "serverAddress");
        log.info("Server Address = " + serverAddress);
        String serverPort = ParamUtil.getString(request, "serverPort", "1433");
        String databaseName = ParamUtil.getString(request, "databaseName");
        String driver = ParamUtil.getString(request, "driver");
        //   String url = ParamUtil.getString(request, "url");
        Boolean integratedSecurity = ParamUtil.getBoolean(request, "integratedSecurity", false);
        String username = ParamUtil.getString(request, "username");
        String password = ParamUtil.getString(request, "password");
        String additionalParams = ParamUtil.getString(request, "additionalParams");

        try {
            _connectionDefinitionLocalService.updateConnectionDefinition(
                    connectionId, name, driver, serverAddress, serverPort
                    , databaseName, integratedSecurity, username, password, additionalParams);

        } catch (PortalException pe) {
            log.error(pe);
            response.setRenderParameter(
                    "mvcPath", "/admin/edit.jsp");
        }
    }

    @Reference
    private ConnectionDefinitionLocalService _connectionDefinitionLocalService;
}