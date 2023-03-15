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

package cz.csob.ency.cds.demands.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CdsDemandGdprInfo}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfo
 * @generated
 */
public class CdsDemandGdprInfoWrapper
	extends BaseModelWrapper<CdsDemandGdprInfo>
	implements CdsDemandGdprInfo, ModelWrapper<CdsDemandGdprInfo> {

	public CdsDemandGdprInfoWrapper(CdsDemandGdprInfo cdsDemandGdprInfo) {
		super(cdsDemandGdprInfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("gdprInfoId", getGdprInfoId());
		attributes.put("demandId", getDemandId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("isEmployee", isIsEmployee());
		attributes.put("employeeCategory", getEmployeeCategory());
		attributes.put("employeeReasoning", getEmployeeReasoning());
		attributes.put("isClient", isIsClient());
		attributes.put("clientCategory", getClientCategory());
		attributes.put("clientReasoning", getClientReasoning());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long gdprInfoId = (Long)attributes.get("gdprInfoId");

		if (gdprInfoId != null) {
			setGdprInfoId(gdprInfoId);
		}

		Long demandId = (Long)attributes.get("demandId");

		if (demandId != null) {
			setDemandId(demandId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean isEmployee = (Boolean)attributes.get("isEmployee");

		if (isEmployee != null) {
			setIsEmployee(isEmployee);
		}

		String employeeCategory = (String)attributes.get("employeeCategory");

		if (employeeCategory != null) {
			setEmployeeCategory(employeeCategory);
		}

		String employeeReasoning = (String)attributes.get("employeeReasoning");

		if (employeeReasoning != null) {
			setEmployeeReasoning(employeeReasoning);
		}

		Boolean isClient = (Boolean)attributes.get("isClient");

		if (isClient != null) {
			setIsClient(isClient);
		}

		String clientCategory = (String)attributes.get("clientCategory");

		if (clientCategory != null) {
			setClientCategory(clientCategory);
		}

		String clientReasoning = (String)attributes.get("clientReasoning");

		if (clientReasoning != null) {
			setClientReasoning(clientReasoning);
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
	}

	@Override
	public CdsDemandGdprInfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the client category of this cds demand gdpr info.
	 *
	 * @return the client category of this cds demand gdpr info
	 */
	@Override
	public String getClientCategory() {
		return model.getClientCategory();
	}

	/**
	 * Returns the client reasoning of this cds demand gdpr info.
	 *
	 * @return the client reasoning of this cds demand gdpr info
	 */
	@Override
	public String getClientReasoning() {
		return model.getClientReasoning();
	}

	/**
	 * Returns the create date of this cds demand gdpr info.
	 *
	 * @return the create date of this cds demand gdpr info
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the demand ID of this cds demand gdpr info.
	 *
	 * @return the demand ID of this cds demand gdpr info
	 */
	@Override
	public long getDemandId() {
		return model.getDemandId();
	}

	/**
	 * Returns the description of this cds demand gdpr info.
	 *
	 * @return the description of this cds demand gdpr info
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the employee category of this cds demand gdpr info.
	 *
	 * @return the employee category of this cds demand gdpr info
	 */
	@Override
	public String getEmployeeCategory() {
		return model.getEmployeeCategory();
	}

	/**
	 * Returns the employee reasoning of this cds demand gdpr info.
	 *
	 * @return the employee reasoning of this cds demand gdpr info
	 */
	@Override
	public String getEmployeeReasoning() {
		return model.getEmployeeReasoning();
	}

	/**
	 * Returns the gdpr info ID of this cds demand gdpr info.
	 *
	 * @return the gdpr info ID of this cds demand gdpr info
	 */
	@Override
	public long getGdprInfoId() {
		return model.getGdprInfoId();
	}

	/**
	 * Returns the is client of this cds demand gdpr info.
	 *
	 * @return the is client of this cds demand gdpr info
	 */
	@Override
	public boolean getIsClient() {
		return model.getIsClient();
	}

	/**
	 * Returns the is employee of this cds demand gdpr info.
	 *
	 * @return the is employee of this cds demand gdpr info
	 */
	@Override
	public boolean getIsEmployee() {
		return model.getIsEmployee();
	}

	/**
	 * Returns the modified date of this cds demand gdpr info.
	 *
	 * @return the modified date of this cds demand gdpr info
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cds demand gdpr info.
	 *
	 * @return the primary key of this cds demand gdpr info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this cds demand gdpr info.
	 *
	 * @return the title of this cds demand gdpr info
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this cds demand gdpr info.
	 *
	 * @return the user ID of this cds demand gdpr info
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this cds demand gdpr info.
	 *
	 * @return the user name of this cds demand gdpr info
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this cds demand gdpr info.
	 *
	 * @return the user uuid of this cds demand gdpr info
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this cds demand gdpr info.
	 *
	 * @return the uuid of this cds demand gdpr info
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this cds demand gdpr info is is client.
	 *
	 * @return <code>true</code> if this cds demand gdpr info is is client; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsClient() {
		return model.isIsClient();
	}

	/**
	 * Returns <code>true</code> if this cds demand gdpr info is is employee.
	 *
	 * @return <code>true</code> if this cds demand gdpr info is is employee; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsEmployee() {
		return model.isIsEmployee();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the client category of this cds demand gdpr info.
	 *
	 * @param clientCategory the client category of this cds demand gdpr info
	 */
	@Override
	public void setClientCategory(String clientCategory) {
		model.setClientCategory(clientCategory);
	}

	/**
	 * Sets the client reasoning of this cds demand gdpr info.
	 *
	 * @param clientReasoning the client reasoning of this cds demand gdpr info
	 */
	@Override
	public void setClientReasoning(String clientReasoning) {
		model.setClientReasoning(clientReasoning);
	}

	/**
	 * Sets the create date of this cds demand gdpr info.
	 *
	 * @param createDate the create date of this cds demand gdpr info
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the demand ID of this cds demand gdpr info.
	 *
	 * @param demandId the demand ID of this cds demand gdpr info
	 */
	@Override
	public void setDemandId(long demandId) {
		model.setDemandId(demandId);
	}

	/**
	 * Sets the description of this cds demand gdpr info.
	 *
	 * @param description the description of this cds demand gdpr info
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the employee category of this cds demand gdpr info.
	 *
	 * @param employeeCategory the employee category of this cds demand gdpr info
	 */
	@Override
	public void setEmployeeCategory(String employeeCategory) {
		model.setEmployeeCategory(employeeCategory);
	}

	/**
	 * Sets the employee reasoning of this cds demand gdpr info.
	 *
	 * @param employeeReasoning the employee reasoning of this cds demand gdpr info
	 */
	@Override
	public void setEmployeeReasoning(String employeeReasoning) {
		model.setEmployeeReasoning(employeeReasoning);
	}

	/**
	 * Sets the gdpr info ID of this cds demand gdpr info.
	 *
	 * @param gdprInfoId the gdpr info ID of this cds demand gdpr info
	 */
	@Override
	public void setGdprInfoId(long gdprInfoId) {
		model.setGdprInfoId(gdprInfoId);
	}

	/**
	 * Sets whether this cds demand gdpr info is is client.
	 *
	 * @param isClient the is client of this cds demand gdpr info
	 */
	@Override
	public void setIsClient(boolean isClient) {
		model.setIsClient(isClient);
	}

	/**
	 * Sets whether this cds demand gdpr info is is employee.
	 *
	 * @param isEmployee the is employee of this cds demand gdpr info
	 */
	@Override
	public void setIsEmployee(boolean isEmployee) {
		model.setIsEmployee(isEmployee);
	}

	/**
	 * Sets the modified date of this cds demand gdpr info.
	 *
	 * @param modifiedDate the modified date of this cds demand gdpr info
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this cds demand gdpr info.
	 *
	 * @param primaryKey the primary key of this cds demand gdpr info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this cds demand gdpr info.
	 *
	 * @param title the title of this cds demand gdpr info
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this cds demand gdpr info.
	 *
	 * @param userId the user ID of this cds demand gdpr info
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this cds demand gdpr info.
	 *
	 * @param userName the user name of this cds demand gdpr info
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this cds demand gdpr info.
	 *
	 * @param userUuid the user uuid of this cds demand gdpr info
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this cds demand gdpr info.
	 *
	 * @param uuid the uuid of this cds demand gdpr info
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CdsDemandGdprInfoWrapper wrap(
		CdsDemandGdprInfo cdsDemandGdprInfo) {

		return new CdsDemandGdprInfoWrapper(cdsDemandGdprInfo);
	}

}