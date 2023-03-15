package cz.csob.ency.common.json.jsonws;

import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBMessageDisplay;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBMessageLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.comment.CommentManager;
import com.liferay.portal.kernel.comment.DiscussionPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.function.Function;

/**
 * @author Adolfo Pérez
 */
@AccessControlled
@Component(
        immediate = true,
        property = {
                "json.web.service.context.name=ency",
                "json.web.service.context.path=Comment"
        },
        service = CommentManagerJSONWS.class
)
@JSONWebService
public class CommentManagerJSONWS extends BaseServiceImpl {

    public long addComment(
            long groupId, String className, long classPK, String body,ServiceContext serviceContext)
            throws PortalException {

        DiscussionPermission discussionPermission =
                _commentManager.getDiscussionPermission(getPermissionChecker());

        long companyId = _getCompanyId(groupId);

        discussionPermission.checkAddPermission(
                companyId, groupId, className, classPK);

        return _addComment(
                serviceContext.getUserId(), groupId, className, classPK, body,
                _createServiceContextFunction(companyId));
    }

    private long _addComment(long userId, long groupId, String className, long classPK,
                             String body,
                             Function<String, ServiceContext> serviceContextFunction)
            throws PortalException {
        MBMessageDisplay messageDisplay =
                _mbMessageLocalService.getDiscussionMessageDisplay(
                        userId, groupId, className, classPK,
                        WorkflowConstants.STATUS_APPROVED);

        MBThread thread = messageDisplay.getThread();

        ServiceContext serviceContext = serviceContextFunction.apply(
                MBMessage.class.getName());

        //@Todo overit ze prvy parameter externalRefereneceCode muze byt blank
        MBMessage mbMessage = _mbMessageLocalService.addDiscussionMessage(
                StringPool.BLANK, userId, StringPool.BLANK, groupId, className, classPK,
                thread.getThreadId(), thread.getRootMessageId(), StringPool.BLANK,
                body, serviceContext);

        return mbMessage.getMessageId();
    }

    private Function<String, ServiceContext> _createServiceContextFunction() {
        return new Function<String, ServiceContext>() {

            @Override
            public ServiceContext apply(String className) {
                return new ServiceContext();
            }

        };
    }

    private Function<String, ServiceContext> _createServiceContextFunction(
            final int workflowAction) {

        return new Function<String, ServiceContext>() {

            @Override
            public ServiceContext apply(String className) {
                ServiceContext serviceContext = new ServiceContext();

                serviceContext.setWorkflowAction(workflowAction);

                return serviceContext;
            }

        };
    }

    private Function<String, ServiceContext> _createServiceContextFunction(
            final long companyId) {

        return new Function<String, ServiceContext>() {

            @Override
            public ServiceContext apply(String className) {
                ServiceContext serviceContext = new ServiceContext();

                serviceContext.setCompanyId(companyId);

                return serviceContext;
            }

        };
    }


    private long _getCompanyId(long groupId) throws PortalException {
        Group group = _groupLocalService.getGroup(groupId);

        return group.getCompanyId();
    }

    @Reference
    private CommentManager _commentManager;

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private MBMessageLocalService _mbMessageLocalService;

}