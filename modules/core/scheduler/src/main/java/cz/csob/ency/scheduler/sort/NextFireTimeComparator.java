/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
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

package cz.csob.ency.scheduler.sort;

import com.liferay.portal.kernel.util.OrderByComparator;
import cz.csob.ency.scheduler.job.SchedulerJob;

import java.util.Date;

/**
 * @author steven.barba
 * @author Tobias Liefke
 */
public class NextFireTimeComparator  extends OrderByComparator<SchedulerJob> {
    public static final String ORDER_BY_ASC = "SchedulerJob.nextFireTime ASC";
    public static final String ORDER_BY_DESC = "SchedulerJob.nextFireTime DESC";
    public static final String[] ORDER_BY_FIELDS = {"nextFireTime"};

    private final boolean _ascending;

    public NextFireTimeComparator() {
        this(false);
    }

    public NextFireTimeComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(SchedulerJob schedulerJob1, SchedulerJob schedulerJob2) {
        Date date1 = schedulerJob1.getNextFireTime();
        if (date1 == null) {
            date1 = new Date(0);
        }

        Date date2 = schedulerJob2.getNextFireTime();
        if (date2 == null) {
            date2 = new Date(0);
        }

        if (_ascending) {
            return date1.compareTo(date2);
        } else {
            return date2.compareTo(date1);
        }
    }

    @Override
    public String getOrderBy() {
        if (_ascending) {
            return ORDER_BY_ASC;
        }

        return ORDER_BY_DESC;
    }

    @Override
    public String[] getOrderByFields() {
        return ORDER_BY_FIELDS;
    }

    @Override
    public boolean isAscending() {
        return _ascending;
    }
}