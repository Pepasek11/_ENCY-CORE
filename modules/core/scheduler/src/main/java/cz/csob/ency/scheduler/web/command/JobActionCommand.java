/**
 * Copyright 2000-present Liferay, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.csob.ency.scheduler.web.command;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import cz.csob.ency.scheduler.constants.SchedulerConstants;
import cz.csob.ency.scheduler.service.SchedulerUtil;
import cz.csob.ency.scheduler.web.constants.SchedulerPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + SchedulerPortletKeys.SCHEDULER_PORTLET,
        "mvc.command.name=jobAction"
    },
    service = MVCActionCommand.class
)
public class JobActionCommand implements MVCActionCommand {
    private static final Log _log = LogFactoryUtil.getLog(JobActionCommand.class);
    private static final String SESSION_MESSAGE_ERROR = "your-request-failed-to-complete";

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

        _handleActionCommand(actionRequest);

        return true;
    }

    private void _handleActionCommand(ActionRequest actionRequest) {
        // Getting the name of the button pressed
        String jobAction = ParamUtil.getString(actionRequest, SchedulerConstants.PARAMETER_JOB_ACTION,
            StringPool.BLANK);
        _log.info("Going to handle action " + jobAction);
        if (!jobAction.isEmpty()) {
            if (jobAction.equals(SchedulerConstants.ACTION_REFRESH)) {
                // None action here for now. just going to render phase
            } else if (jobAction.equals(SchedulerConstants.ACTION_SHUTDOWN)) {
                try {
                    SchedulerUtil.doServiceAction(jobAction);
                } catch (SchedulerException e) {
                    _log.error(e);
                    SessionErrors.add(actionRequest, SESSION_MESSAGE_ERROR);
                }
            } else {
                try {
                    SchedulerUtil.doScheduledJobsAction(actionRequest, jobAction);
                } catch (Exception e) {
                    _log.error(e);
                    SessionErrors.add(actionRequest, SESSION_MESSAGE_ERROR);
                }
            }
        }
    }
}