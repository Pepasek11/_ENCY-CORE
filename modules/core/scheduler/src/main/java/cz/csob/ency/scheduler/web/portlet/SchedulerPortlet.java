package cz.csob.ency.scheduler.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.scheduler.service.SchedulerLocalService;
import cz.csob.ency.scheduler.service.SchedulerUtil;
import cz.csob.ency.scheduler.web.constants.SchedulerPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.layout-cacheable=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.use-default-template=true",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
                "javax.portlet.display-name=Scheduled Job Manager",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.init-param.portlet-title-based-navigation=true",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.init-param.help-template=/help.jsp",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.name=" + SchedulerPortletKeys.SCHEDULER_PORTLET,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator",
                "javax.portlet.supports.mime-type=text/html",
                "com.liferay.portlet.add-default-resource=true"
        },
        service = Portlet.class
)
public class SchedulerPortlet extends MVCPortlet {
    private static final int NOT_RESULTS = 0;
    private static final Log _log = LogFactoryUtil.getLog(SchedulerPortlet.class);
    private static final Log log = LogFactoryUtil.getLog(SchedulerPortlet.class);

    public void editScheduledJob(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        StorageType st = StorageType.PERSISTED;
        String jobName = ParamUtil.getString(actionRequest, "storageType");
        String groupName = ParamUtil.getString(actionRequest, "storageType");
        String storageType = ParamUtil.getString(actionRequest, "storageType", st.toString());

        if (!Validator.isBlank(storageType)) {
            st = StorageType.valueOf(StorageType.class, storageType);
        }

        if (Validator.isBlank(jobName) || Validator.isBlank(groupName)) {
            // Add scheduled task

        }
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        SchedulerUtil.getScheduledJobs(renderRequest);
        super.render(renderRequest, renderResponse);

    }
    @Reference
    protected SchedulerLocalService schedulerLocalService;

}
