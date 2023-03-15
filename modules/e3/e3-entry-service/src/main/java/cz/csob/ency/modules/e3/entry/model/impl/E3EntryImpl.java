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

package cz.csob.ency.modules.e3.entry.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import cz.csob.ency.modules.e3.app.model.E3App;
import cz.csob.ency.modules.e3.app.service.E3AppLocalServiceUtil;
import cz.csob.ency.modules.e3.entry.model.E3Entry;

import javax.portlet.ActionRequest;
import java.io.Serializable;
import java.util.HashMap;

/**
 * The extended model implementation for the E3Entry service. Represents a row in the &quot;E3Entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>cz.csob.ency.modules.e3.entry.model.E3Entry</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class E3EntryImpl extends E3EntryBaseImpl {
    private static final Log _log = LogFactoryUtil.getLog(E3EntryImpl.class);

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a e3 entry model instance should use the {@link cz.csob.ency.modules.e3.entry.model.E3Entry} interface instead.
     */
    public E3EntryImpl() {
        super();
        setValues(new HashMap<>());
    }

    public String getAppCode() {
        E3App app = E3AppLocalServiceUtil.getApp(getAppClass());
        return app.getAppCode();
    }

    public String getDescription() {
        E3App app = E3AppLocalServiceUtil.getApp(getAppClass());
        return app.getEntryDescription(this);
    }

    public String getSummary() {
        E3App app = E3AppLocalServiceUtil.getApp(getAppClass());
        return app.getEntrySummary(this);
    }

    public Serializable getValue(String key) {
        return getValues().getOrDefault(key, null);
    }

    public Boolean isIndexable() {
        E3App app = E3AppLocalServiceUtil.getApp(getAppClass());
        return app.isIndexable();
    }

    public Boolean isVersioned() {
        E3App app = E3AppLocalServiceUtil.getApp(getAppClass());
        return app.isIndexable();
    }

    @Override
    public void setAuthorId(long authorId) {
        super.setAuthorId(authorId);
        setAuthorName(getUserNameById(authorId));
    }

    @Override
    public void setUserId(long userId) {
        super.setUserId(userId);
        setUserName(getUserNameById(userId));
        if (getAuthorId() == 0L) {
            setAuthorId(getUserId());
        }
    }

    public E3Entry setValue(String key, Serializable value) {
        getValues().put(key, value);
        return this;
    }

    public E3Entry setValues(ActionRequest actionRequest) {
        E3App app = E3AppLocalServiceUtil.getApp(getAppClass());
        app.setEntryValues(actionRequest, this);
        return this;
    }

    protected String getUserNameById(long userId) {
        String name = "#Invalid UID#";
        if (userId == 0) {
            return "";
        }
        try {
            User u = UserLocalServiceUtil.getUserById(userId);
            name = u.getFullName();
        } catch (PortalException e) {
            _log.error("Unable to set Entry created by user name. User with UID " + userId + " was not found.");
            _log.error(e);
        }
        return name;
    }

}