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

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EncyWorkflow service. Represents a row in the &quot;ency_workflow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>cz.csob.ency.workflow.model.impl.EncyWorkflowModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>cz.csob.ency.workflow.model.impl.EncyWorkflowImpl</code>.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflow
 * @generated
 */
@ProviderType
public interface EncyWorkflowModel extends BaseModel<EncyWorkflow> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ency workflow model instance should use the {@link EncyWorkflow} interface instead.
	 */

	/**
	 * Returns the primary key of this ency workflow.
	 *
	 * @return the primary key of this ency workflow
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ency workflow.
	 *
	 * @param primaryKey the primary key of this ency workflow
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this ency workflow.
	 *
	 * @return the uuid of this ency workflow
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this ency workflow.
	 *
	 * @param uuid the uuid of this ency workflow
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the workflow ID of this ency workflow.
	 *
	 * @return the workflow ID of this ency workflow
	 */
	public long getWorkflowId();

	/**
	 * Sets the workflow ID of this ency workflow.
	 *
	 * @param workflowId the workflow ID of this ency workflow
	 */
	public void setWorkflowId(long workflowId);

	/**
	 * Returns the class name of this ency workflow.
	 *
	 * @return the class name of this ency workflow
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this ency workflow.
	 *
	 * @param className the class name of this ency workflow
	 */
	public void setClassName(String className);

	/**
	 * Returns the title of this ency workflow.
	 *
	 * @return the title of this ency workflow
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this ency workflow.
	 *
	 * @param title the title of this ency workflow
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this ency workflow.
	 *
	 * @return the description of this ency workflow
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this ency workflow.
	 *
	 * @param description the description of this ency workflow
	 */
	public void setDescription(String description);

	/**
	 * Returns the initial state name of this ency workflow.
	 *
	 * @return the initial state name of this ency workflow
	 */
	@AutoEscape
	public String getInitialStateName();

	/**
	 * Sets the initial state name of this ency workflow.
	 *
	 * @param initialStateName the initial state name of this ency workflow
	 */
	public void setInitialStateName(String initialStateName);

	/**
	 * Returns the version of this ency workflow.
	 *
	 * @return the version of this ency workflow
	 */
	public long getVersion();

	/**
	 * Sets the version of this ency workflow.
	 *
	 * @param version the version of this ency workflow
	 */
	public void setVersion(long version);

	/**
	 * Returns the active of this ency workflow.
	 *
	 * @return the active of this ency workflow
	 */
	public Boolean getActive();

	/**
	 * Sets the active of this ency workflow.
	 *
	 * @param active the active of this ency workflow
	 */
	public void setActive(Boolean active);

	/**
	 * Returns the create date of this ency workflow.
	 *
	 * @return the create date of this ency workflow
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this ency workflow.
	 *
	 * @param createDate the create date of this ency workflow
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ency workflow.
	 *
	 * @return the modified date of this ency workflow
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ency workflow.
	 *
	 * @param modifiedDate the modified date of this ency workflow
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public EncyWorkflow cloneWithOriginalValues();

}