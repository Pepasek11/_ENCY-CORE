/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.scheduler.sort;

import com.liferay.portal.kernel.util.OrderByComparator;
import cz.csob.ency.scheduler.job.SchedulerJob;

import java.util.Date;

public class EndTimeComparator extends OrderByComparator<SchedulerJob> {
    public static final String ORDER_BY_ASC = "SchedulerJob.endTime ASC";
    public static final String ORDER_BY_DESC = "SchedulerJob.endTime DESC";
    public static final String[] ORDER_BY_FIELDS = {"endTime"};

    private final boolean _ascending;

    public EndTimeComparator() {
        this(false);
    }

    public EndTimeComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(SchedulerJob schedulerJob1, SchedulerJob schedulerJob2) {
        Date date1 = schedulerJob1.getEndTime();
        if (date1 == null) {
            date1 = new Date(0);
        }

        Date date2 = schedulerJob2.getEndTime();
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