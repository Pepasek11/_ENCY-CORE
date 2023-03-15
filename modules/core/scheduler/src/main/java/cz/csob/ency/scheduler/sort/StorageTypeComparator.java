/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package cz.csob.ency.scheduler.sort;

import com.liferay.portal.kernel.util.OrderByComparator;
import cz.csob.ency.scheduler.job.SchedulerJob;

/**
 * @author steven.barba
 *
 */
public class StorageTypeComparator extends OrderByComparator<SchedulerJob> {
    public static final String ORDER_BY_ASC = "SchedulerJob.storageType ASC";
    public static final String ORDER_BY_DESC = "SchedulerJob.storageType DESC";
    public static final String[] ORDER_BY_FIELDS = {"storageType"};

    private final boolean _ascending;

    public StorageTypeComparator() {
        this(false);
    }

    public StorageTypeComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(SchedulerJob job0, SchedulerJob job1) {

        int value = job0.getStorageType().toLowerCase().compareTo(job1.getStorageType().toLowerCase());

        if (_ascending) {
            return value;
        } else {
            return -value;
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