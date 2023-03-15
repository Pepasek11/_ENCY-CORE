/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * Copyright (C) 2021- Československá obchodní banka, a. s.
 * <p>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package cz.csob.ency.scheduler.job;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * @author steven.barba
 * @author miroslav.cermak
 *
 */
public interface SchedulerJob extends Serializable {
    static final String NULL_VALUE_DISPLAY = "-";

    String getJobName();

    void setJobName(String jobName);

    String getGroupName();

    void setGroupName(String groupName);

    String getTriggerState();

    void setTriggerState(String triggerState);

    Date getStartTime();

    void setStartTime(Date startTime);

    Date getEndTime();

    void setEndTime(Date endTime);

    Date getPreviousFireTime();

    void setPreviousFireTime(Date previousFireTime);

    Date getNextFireTime();

    void setNextFireTime(Date nextFireTime);

    String getStorageType();

    void setStorageType(String storageType);

    String getShortName();

    String getShortGroup();
}
