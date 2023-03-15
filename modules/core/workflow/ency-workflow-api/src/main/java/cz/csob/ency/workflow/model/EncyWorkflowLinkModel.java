/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.workflow.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EncyWorkflowLink service. Represents a row in the &quot;ency_workflowlink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>cz.csob.ency.workflow.model.impl.EncyWorkflowLinkModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>cz.csob.ency.workflow.model.impl.EncyWorkflowLinkImpl</code>.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowLink
 * @generated
 */
@ProviderType
public interface EncyWorkflowLinkModel
	extends BaseModel<EncyWorkflowLink>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ency workflow link model instance should use the {@link EncyWorkflowLink} interface instead.
	 */

	/**
	 * Returns the primary key of this ency workflow link.
	 *
	 * @return the primary key of this ency workflow link
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ency workflow link.
	 *
	 * @param primaryKey the primary key of this ency workflow link
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this ency workflow link.
	 *
	 * @return the uuid of this ency workflow link
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this ency workflow link.
	 *
	 * @param uuid the uuid of this ency workflow link
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the workflow link ID of this ency workflow link.
	 *
	 * @return the workflow link ID of this ency workflow link
	 */
	public long getWorkflowLinkId();

	/**
	 * Sets the workflow link ID of this ency workflow link.
	 *
	 * @param workflowLinkId the workflow link ID of this ency workflow link
	 */
	public void setWorkflowLinkId(long workflowLinkId);

	/**
	 * Returns the group ID of this ency workflow link.
	 *
	 * @return the group ID of this ency workflow link
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this ency workflow link.
	 *
	 * @param groupId the group ID of this ency workflow link
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this ency workflow link.
	 *
	 * @return the company ID of this ency workflow link
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ency workflow link.
	 *
	 * @param companyId the company ID of this ency workflow link
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ency workflow link.
	 *
	 * @return the user ID of this ency workflow link
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this ency workflow link.
	 *
	 * @param userId the user ID of this ency workflow link
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ency workflow link.
	 *
	 * @return the user uuid of this ency workflow link
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ency workflow link.
	 *
	 * @param userUuid the user uuid of this ency workflow link
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ency workflow link.
	 *
	 * @return the user name of this ency workflow link
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this ency workflow link.
	 *
	 * @param userName the user name of this ency workflow link
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ency workflow link.
	 *
	 * @return the create date of this ency workflow link
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this ency workflow link.
	 *
	 * @param createDate the create date of this ency workflow link
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ency workflow link.
	 *
	 * @return the modified date of this ency workflow link
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ency workflow link.
	 *
	 * @param modifiedDate the modified date of this ency workflow link
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the class name of this ency workflow link.
	 *
	 * @return the class name of this ency workflow link
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this ency workflow link.
	 *
	 * @param className the class name of this ency workflow link
	 */
	public void setClassName(String className);

	/**
	 * Returns the folder class name of this ency workflow link.
	 *
	 * @return the folder class name of this ency workflow link
	 */
	@AutoEscape
	public String getFolderClassName();

	/**
	 * Sets the folder class name of this ency workflow link.
	 *
	 * @param folderClassName the folder class name of this ency workflow link
	 */
	public void setFolderClassName(String folderClassName);

	/**
	 * Returns the folder pk of this ency workflow link.
	 *
	 * @return the folder pk of this ency workflow link
	 */
	public long getFolderPK();

	/**
	 * Sets the folder pk of this ency workflow link.
	 *
	 * @param folderPK the folder pk of this ency workflow link
	 */
	public void setFolderPK(long folderPK);

	/**
	 * Returns the workflow ID of this ency workflow link.
	 *
	 * @return the workflow ID of this ency workflow link
	 */
	public long getWorkflowId();

	/**
	 * Sets the workflow ID of this ency workflow link.
	 *
	 * @param workflowId the workflow ID of this ency workflow link
	 */
	public void setWorkflowId(long workflowId);

	@Override
	public EncyWorkflowLink cloneWithOriginalValues();

}