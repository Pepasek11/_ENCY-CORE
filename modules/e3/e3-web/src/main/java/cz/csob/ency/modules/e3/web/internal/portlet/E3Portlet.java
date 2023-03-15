package cz.csob.ency.modules.e3.web.internal.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import cz.csob.ency.modules.e3.web.portlet.base.BaseE3Portlet;
import cz.csob.ency.modules.e3.entry.constants.E3PortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.add-default-resource=true",
                "com.liferay.portlet.application-type=full-page-application",
                "com.liferay.portlet.application-type=widget",
                "com.liferay.portlet.css-class-wrapper=portlet-e3-entry",
                "com.liferay.portlet.display-category=category.ency",
                "com.liferay.portlet.header-portlet-css=/e3/css/main.css",
                "com.liferay.portlet.icon=/blogs/icons/e3.png",
                "com.liferay.portlet.layout-cacheable=true",
                "com.liferay.portlet.preferences-owned-by-group=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.scopeable=true",
                "com.liferay.portlet.struts-path=e3",
                "javax.portlet.display-name=Ency",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.always-display-default-configuration-icons=true",
                "javax.portlet.init-param.always-send-redirect=true",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.name=" + E3PortletKeys.E3Portlet,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=guest,power-user,user",
                "javax.portlet.supported-public-render-parameter=tag",
            //    "javax.portlet.version=3.0"
        },
        service = Portlet.class
)
public class E3Portlet extends BaseE3Portlet {
    private static final Log _log = LogFactoryUtil.getLog(E3Portlet.class);

    @Override
    public void render(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        super.render(renderRequest, renderResponse);
    }

}
