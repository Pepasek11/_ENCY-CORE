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

package cz.csob.ency.pdr.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PDRMapping}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see PDRMapping
 * @generated
 */
public class PDRMappingWrapper
	extends BaseModelWrapper<PDRMapping>
	implements ModelWrapper<PDRMapping>, PDRMapping {

	public PDRMappingWrapper(PDRMapping pdrMapping) {
		super(pdrMapping);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("mappingId", getMappingId());
		attributes.put("title", getTitle());
		attributes.put("systemId", getSystemId());
		attributes.put("tableId", getTableId());
		attributes.put("columnId", getColumnId());
		attributes.put("attributeId", getAttributeId());
		attributes.put("mappingRules", getMappingRules());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("state", getState());
		attributes.put("stateByUserId", getStateByUserId());
		attributes.put("stateByUserName", getStateByUserName());
		attributes.put("stateDate", getStateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long mappingId = (Long)attributes.get("mappingId");

		if (mappingId != null) {
			setMappingId(mappingId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long systemId = (Long)attributes.get("systemId");

		if (systemId != null) {
			setSystemId(systemId);
		}

		Long tableId = (Long)attributes.get("tableId");

		if (tableId != null) {
			setTableId(tableId);
		}

		Long columnId = (Long)attributes.get("columnId");

		if (columnId != null) {
			setColumnId(columnId);
		}

		Long attributeId = (Long)attributes.get("attributeId");

		if (attributeId != null) {
			setAttributeId(attributeId);
		}

		String mappingRules = (String)attributes.get("mappingRules");

		if (mappingRules != null) {
			setMappingRules(mappingRules);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Long stateByUserId = (Long)attributes.get("stateByUserId");

		if (stateByUserId != null) {
			setStateByUserId(stateByUserId);
		}

		String stateByUserName = (String)attributes.get("stateByUserName");

		if (stateByUserName != null) {
			setStateByUserName(stateByUserName);
		}

		Date stateDate = (Date)attributes.get("stateDate");

		if (stateDate != null) {
			setStateDate(stateDate);
		}
	}

	@Override
	public PDRMapping cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attribute ID of this pdr mapping.
	 *
	 * @return the attribute ID of this pdr mapping
	 */
	@Override
	public long getAttributeId() {
		return model.getAttributeId();
	}

	/**
	 * Returns the column ID of this pdr mapping.
	 *
	 * @return the column ID of this pdr mapping
	 */
	@Override
	public long getColumnId() {
		return model.getColumnId();
	}

	/**
	 * Returns the company ID of this pdr mapping.
	 *
	 * @return the company ID of this pdr mapping
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pdr mapping.
	 *
	 * @return the create date of this pdr mapping
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this pdr mapping.
	 *
	 * @return the group ID of this pdr mapping
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mapping ID of this pdr mapping.
	 *
	 * @return the mapping ID of this pdr mapping
	 */
	@Override
	public long getMappingId() {
		return model.getMappingId();
	}

	/**
	 * Returns the mapping rules of this pdr mapping.
	 *
	 * @return the mapping rules of this pdr mapping
	 */
	@Override
	public String getMappingRules() {
		return model.getMappingRules();
	}

	/**
	 * Returns the modified date of this pdr mapping.
	 *
	 * @return the modified date of this pdr mapping
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this pdr mapping.
	 *
	 * @return the mvcc version of this pdr mapping
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this pdr mapping.
	 *
	 * @return the primary key of this pdr mapping
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this pdr mapping.
	 *
	 * @return the state of this pdr mapping
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the state by user ID of this pdr mapping.
	 *
	 * @return the state by user ID of this pdr mapping
	 */
	@Override
	public long getStateByUserId() {
		return model.getStateByUserId();
	}

	/**
	 * Returns the state by user name of this pdr mapping.
	 *
	 * @return the state by user name of this pdr mapping
	 */
	@Override
	public String getStateByUserName() {
		return model.getStateByUserName();
	}

	/**
	 * Returns the state by user uuid of this pdr mapping.
	 *
	 * @return the state by user uuid of this pdr mapping
	 */
	@Override
	public String getStateByUserUuid() {
		return model.getStateByUserUuid();
	}

	/**
	 * Returns the state date of this pdr mapping.
	 *
	 * @return the state date of this pdr mapping
	 */
	@Override
	public Date getStateDate() {
		return model.getStateDate();
	}

	/**
	 * Returns the system ID of this pdr mapping.
	 *
	 * @return the system ID of this pdr mapping
	 */
	@Override
	public long getSystemId() {
		return model.getSystemId();
	}

	/**
	 * Returns the table ID of this pdr mapping.
	 *
	 * @return the table ID of this pdr mapping
	 */
	@Override
	public long getTableId() {
		return model.getTableId();
	}

	/**
	 * Returns the title of this pdr mapping.
	 *
	 * @return the title of this pdr mapping
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this pdr mapping.
	 *
	 * @return the user ID of this pdr mapping
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pdr mapping.
	 *
	 * @return the user name of this pdr mapping
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pdr mapping.
	 *
	 * @return the user uuid of this pdr mapping
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attribute ID of this pdr mapping.
	 *
	 * @param attributeId the attribute ID of this pdr mapping
	 */
	@Override
	public void setAttributeId(long attributeId) {
		model.setAttributeId(attributeId);
	}

	/**
	 * Sets the column ID of this pdr mapping.
	 *
	 * @param columnId the column ID of this pdr mapping
	 */
	@Override
	public void setColumnId(long columnId) {
		model.setColumnId(columnId);
	}

	/**
	 * Sets the company ID of this pdr mapping.
	 *
	 * @param companyId the company ID of this pdr mapping
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pdr mapping.
	 *
	 * @param createDate the create date of this pdr mapping
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this pdr mapping.
	 *
	 * @param groupId the group ID of this pdr mapping
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mapping ID of this pdr mapping.
	 *
	 * @param mappingId the mapping ID of this pdr mapping
	 */
	@Override
	public void setMappingId(long mappingId) {
		model.setMappingId(mappingId);
	}

	/**
	 * Sets the mapping rules of this pdr mapping.
	 *
	 * @param mappingRules the mapping rules of this pdr mapping
	 */
	@Override
	public void setMappingRules(String mappingRules) {
		model.setMappingRules(mappingRules);
	}

	/**
	 * Sets the modified date of this pdr mapping.
	 *
	 * @param modifiedDate the modified date of this pdr mapping
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this pdr mapping.
	 *
	 * @param mvccVersion the mvcc version of this pdr mapping
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this pdr mapping.
	 *
	 * @param primaryKey the primary key of this pdr mapping
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this pdr mapping.
	 *
	 * @param state the state of this pdr mapping
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the state by user ID of this pdr mapping.
	 *
	 * @param stateByUserId the state by user ID of this pdr mapping
	 */
	@Override
	public void setStateByUserId(long stateByUserId) {
		model.setStateByUserId(stateByUserId);
	}

	/**
	 * Sets the state by user name of this pdr mapping.
	 *
	 * @param stateByUserName the state by user name of this pdr mapping
	 */
	@Override
	public void setStateByUserName(String stateByUserName) {
		model.setStateByUserName(stateByUserName);
	}

	/**
	 * Sets the state by user uuid of this pdr mapping.
	 *
	 * @param stateByUserUuid the state by user uuid of this pdr mapping
	 */
	@Override
	public void setStateByUserUuid(String stateByUserUuid) {
		model.setStateByUserUuid(stateByUserUuid);
	}

	/**
	 * Sets the state date of this pdr mapping.
	 *
	 * @param stateDate the state date of this pdr mapping
	 */
	@Override
	public void setStateDate(Date stateDate) {
		model.setStateDate(stateDate);
	}

	/**
	 * Sets the system ID of this pdr mapping.
	 *
	 * @param systemId the system ID of this pdr mapping
	 */
	@Override
	public void setSystemId(long systemId) {
		model.setSystemId(systemId);
	}

	/**
	 * Sets the table ID of this pdr mapping.
	 *
	 * @param tableId the table ID of this pdr mapping
	 */
	@Override
	public void setTableId(long tableId) {
		model.setTableId(tableId);
	}

	/**
	 * Sets the title of this pdr mapping.
	 *
	 * @param title the title of this pdr mapping
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this pdr mapping.
	 *
	 * @param userId the user ID of this pdr mapping
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pdr mapping.
	 *
	 * @param userName the user name of this pdr mapping
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pdr mapping.
	 *
	 * @param userUuid the user uuid of this pdr mapping
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PDRMappingWrapper wrap(PDRMapping pdrMapping) {
		return new PDRMappingWrapper(pdrMapping);
	}

}