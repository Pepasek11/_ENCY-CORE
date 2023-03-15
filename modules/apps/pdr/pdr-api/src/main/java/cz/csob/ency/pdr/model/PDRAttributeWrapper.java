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
 * This class is a wrapper for {@link PDRAttribute}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see PDRAttribute
 * @generated
 */
public class PDRAttributeWrapper
	extends BaseModelWrapper<PDRAttribute>
	implements ModelWrapper<PDRAttribute>, PDRAttribute {

	public PDRAttributeWrapper(PDRAttribute pdrAttribute) {
		super(pdrAttribute);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("attributeId", getAttributeId());
		attributes.put("fullName", getFullName());
		attributes.put("parentId", getParentId());
		attributes.put("nameCz", getNameCz());
		attributes.put("nameEn", getNameEn());
		attributes.put("nameSk", getNameSk());
		attributes.put("order", getOrder());
		attributes.put("level", getLevel());
		attributes.put("idsPath", getIdsPath());
		attributes.put("description", getDescription());
		attributes.put("personalDataTypeId", getPersonalDataTypeId());
		attributes.put("tagName", getTagName());
		attributes.put("isRoA", isIsRoA());
		attributes.put("isRtP", isIsRtP());
		attributes.put("separatorBefore", getSeparatorBefore());
		attributes.put("separatorAfter", getSeparatorAfter());
		attributes.put("isMerge", isIsMerge());
		attributes.put("isLabel", isIsLabel());
		attributes.put("isObject", isIsObject());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long attributeId = (Long)attributes.get("attributeId");

		if (attributeId != null) {
			setAttributeId(attributeId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String nameCz = (String)attributes.get("nameCz");

		if (nameCz != null) {
			setNameCz(nameCz);
		}

		String nameEn = (String)attributes.get("nameEn");

		if (nameEn != null) {
			setNameEn(nameEn);
		}

		String nameSk = (String)attributes.get("nameSk");

		if (nameSk != null) {
			setNameSk(nameSk);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		String idsPath = (String)attributes.get("idsPath");

		if (idsPath != null) {
			setIdsPath(idsPath);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long personalDataTypeId = (Long)attributes.get("personalDataTypeId");

		if (personalDataTypeId != null) {
			setPersonalDataTypeId(personalDataTypeId);
		}

		String tagName = (String)attributes.get("tagName");

		if (tagName != null) {
			setTagName(tagName);
		}

		Boolean isRoA = (Boolean)attributes.get("isRoA");

		if (isRoA != null) {
			setIsRoA(isRoA);
		}

		Boolean isRtP = (Boolean)attributes.get("isRtP");

		if (isRtP != null) {
			setIsRtP(isRtP);
		}

		String separatorBefore = (String)attributes.get("separatorBefore");

		if (separatorBefore != null) {
			setSeparatorBefore(separatorBefore);
		}

		String separatorAfter = (String)attributes.get("separatorAfter");

		if (separatorAfter != null) {
			setSeparatorAfter(separatorAfter);
		}

		Boolean isMerge = (Boolean)attributes.get("isMerge");

		if (isMerge != null) {
			setIsMerge(isMerge);
		}

		Boolean isLabel = (Boolean)attributes.get("isLabel");

		if (isLabel != null) {
			setIsLabel(isLabel);
		}

		Boolean isObject = (Boolean)attributes.get("isObject");

		if (isObject != null) {
			setIsObject(isObject);
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
	}

	@Override
	public PDRAttribute cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attribute ID of this pdr attribute.
	 *
	 * @return the attribute ID of this pdr attribute
	 */
	@Override
	public long getAttributeId() {
		return model.getAttributeId();
	}

	/**
	 * Returns the company ID of this pdr attribute.
	 *
	 * @return the company ID of this pdr attribute
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this pdr attribute.
	 *
	 * @return the create date of this pdr attribute
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this pdr attribute.
	 *
	 * @return the description of this pdr attribute
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the full name of this pdr attribute.
	 *
	 * @return the full name of this pdr attribute
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this pdr attribute.
	 *
	 * @return the group ID of this pdr attribute
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ids path of this pdr attribute.
	 *
	 * @return the ids path of this pdr attribute
	 */
	@Override
	public String getIdsPath() {
		return model.getIdsPath();
	}

	/**
	 * Returns the is label of this pdr attribute.
	 *
	 * @return the is label of this pdr attribute
	 */
	@Override
	public boolean getIsLabel() {
		return model.getIsLabel();
	}

	/**
	 * Returns the is merge of this pdr attribute.
	 *
	 * @return the is merge of this pdr attribute
	 */
	@Override
	public boolean getIsMerge() {
		return model.getIsMerge();
	}

	/**
	 * Returns the is object of this pdr attribute.
	 *
	 * @return the is object of this pdr attribute
	 */
	@Override
	public boolean getIsObject() {
		return model.getIsObject();
	}

	/**
	 * Returns the is ro a of this pdr attribute.
	 *
	 * @return the is ro a of this pdr attribute
	 */
	@Override
	public boolean getIsRoA() {
		return model.getIsRoA();
	}

	/**
	 * Returns the is rt p of this pdr attribute.
	 *
	 * @return the is rt p of this pdr attribute
	 */
	@Override
	public boolean getIsRtP() {
		return model.getIsRtP();
	}

	/**
	 * Returns the level of this pdr attribute.
	 *
	 * @return the level of this pdr attribute
	 */
	@Override
	public int getLevel() {
		return model.getLevel();
	}

	/**
	 * Returns the modified date of this pdr attribute.
	 *
	 * @return the modified date of this pdr attribute
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this pdr attribute.
	 *
	 * @return the mvcc version of this pdr attribute
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name cz of this pdr attribute.
	 *
	 * @return the name cz of this pdr attribute
	 */
	@Override
	public String getNameCz() {
		return model.getNameCz();
	}

	/**
	 * Returns the name en of this pdr attribute.
	 *
	 * @return the name en of this pdr attribute
	 */
	@Override
	public String getNameEn() {
		return model.getNameEn();
	}

	/**
	 * Returns the name sk of this pdr attribute.
	 *
	 * @return the name sk of this pdr attribute
	 */
	@Override
	public String getNameSk() {
		return model.getNameSk();
	}

	/**
	 * Returns the order of this pdr attribute.
	 *
	 * @return the order of this pdr attribute
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the parent ID of this pdr attribute.
	 *
	 * @return the parent ID of this pdr attribute
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the personal data type ID of this pdr attribute.
	 *
	 * @return the personal data type ID of this pdr attribute
	 */
	@Override
	public long getPersonalDataTypeId() {
		return model.getPersonalDataTypeId();
	}

	/**
	 * Returns the primary key of this pdr attribute.
	 *
	 * @return the primary key of this pdr attribute
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the separator after of this pdr attribute.
	 *
	 * @return the separator after of this pdr attribute
	 */
	@Override
	public String getSeparatorAfter() {
		return model.getSeparatorAfter();
	}

	/**
	 * Returns the separator before of this pdr attribute.
	 *
	 * @return the separator before of this pdr attribute
	 */
	@Override
	public String getSeparatorBefore() {
		return model.getSeparatorBefore();
	}

	/**
	 * Returns the tag name of this pdr attribute.
	 *
	 * @return the tag name of this pdr attribute
	 */
	@Override
	public String getTagName() {
		return model.getTagName();
	}

	/**
	 * Returns the user ID of this pdr attribute.
	 *
	 * @return the user ID of this pdr attribute
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this pdr attribute.
	 *
	 * @return the user name of this pdr attribute
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this pdr attribute.
	 *
	 * @return the user uuid of this pdr attribute
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this pdr attribute is is label.
	 *
	 * @return <code>true</code> if this pdr attribute is is label; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsLabel() {
		return model.isIsLabel();
	}

	/**
	 * Returns <code>true</code> if this pdr attribute is is merge.
	 *
	 * @return <code>true</code> if this pdr attribute is is merge; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsMerge() {
		return model.isIsMerge();
	}

	/**
	 * Returns <code>true</code> if this pdr attribute is is object.
	 *
	 * @return <code>true</code> if this pdr attribute is is object; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsObject() {
		return model.isIsObject();
	}

	/**
	 * Returns <code>true</code> if this pdr attribute is is ro a.
	 *
	 * @return <code>true</code> if this pdr attribute is is ro a; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsRoA() {
		return model.isIsRoA();
	}

	/**
	 * Returns <code>true</code> if this pdr attribute is is rt p.
	 *
	 * @return <code>true</code> if this pdr attribute is is rt p; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsRtP() {
		return model.isIsRtP();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attribute ID of this pdr attribute.
	 *
	 * @param attributeId the attribute ID of this pdr attribute
	 */
	@Override
	public void setAttributeId(long attributeId) {
		model.setAttributeId(attributeId);
	}

	/**
	 * Sets the company ID of this pdr attribute.
	 *
	 * @param companyId the company ID of this pdr attribute
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this pdr attribute.
	 *
	 * @param createDate the create date of this pdr attribute
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this pdr attribute.
	 *
	 * @param description the description of this pdr attribute
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the full name of this pdr attribute.
	 *
	 * @param fullName the full name of this pdr attribute
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the group ID of this pdr attribute.
	 *
	 * @param groupId the group ID of this pdr attribute
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ids path of this pdr attribute.
	 *
	 * @param idsPath the ids path of this pdr attribute
	 */
	@Override
	public void setIdsPath(String idsPath) {
		model.setIdsPath(idsPath);
	}

	/**
	 * Sets whether this pdr attribute is is label.
	 *
	 * @param isLabel the is label of this pdr attribute
	 */
	@Override
	public void setIsLabel(boolean isLabel) {
		model.setIsLabel(isLabel);
	}

	/**
	 * Sets whether this pdr attribute is is merge.
	 *
	 * @param isMerge the is merge of this pdr attribute
	 */
	@Override
	public void setIsMerge(boolean isMerge) {
		model.setIsMerge(isMerge);
	}

	/**
	 * Sets whether this pdr attribute is is object.
	 *
	 * @param isObject the is object of this pdr attribute
	 */
	@Override
	public void setIsObject(boolean isObject) {
		model.setIsObject(isObject);
	}

	/**
	 * Sets whether this pdr attribute is is ro a.
	 *
	 * @param isRoA the is ro a of this pdr attribute
	 */
	@Override
	public void setIsRoA(boolean isRoA) {
		model.setIsRoA(isRoA);
	}

	/**
	 * Sets whether this pdr attribute is is rt p.
	 *
	 * @param isRtP the is rt p of this pdr attribute
	 */
	@Override
	public void setIsRtP(boolean isRtP) {
		model.setIsRtP(isRtP);
	}

	/**
	 * Sets the level of this pdr attribute.
	 *
	 * @param level the level of this pdr attribute
	 */
	@Override
	public void setLevel(int level) {
		model.setLevel(level);
	}

	/**
	 * Sets the modified date of this pdr attribute.
	 *
	 * @param modifiedDate the modified date of this pdr attribute
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this pdr attribute.
	 *
	 * @param mvccVersion the mvcc version of this pdr attribute
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name cz of this pdr attribute.
	 *
	 * @param nameCz the name cz of this pdr attribute
	 */
	@Override
	public void setNameCz(String nameCz) {
		model.setNameCz(nameCz);
	}

	/**
	 * Sets the name en of this pdr attribute.
	 *
	 * @param nameEn the name en of this pdr attribute
	 */
	@Override
	public void setNameEn(String nameEn) {
		model.setNameEn(nameEn);
	}

	/**
	 * Sets the name sk of this pdr attribute.
	 *
	 * @param nameSk the name sk of this pdr attribute
	 */
	@Override
	public void setNameSk(String nameSk) {
		model.setNameSk(nameSk);
	}

	/**
	 * Sets the order of this pdr attribute.
	 *
	 * @param order the order of this pdr attribute
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the parent ID of this pdr attribute.
	 *
	 * @param parentId the parent ID of this pdr attribute
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the personal data type ID of this pdr attribute.
	 *
	 * @param personalDataTypeId the personal data type ID of this pdr attribute
	 */
	@Override
	public void setPersonalDataTypeId(long personalDataTypeId) {
		model.setPersonalDataTypeId(personalDataTypeId);
	}

	/**
	 * Sets the primary key of this pdr attribute.
	 *
	 * @param primaryKey the primary key of this pdr attribute
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the separator after of this pdr attribute.
	 *
	 * @param separatorAfter the separator after of this pdr attribute
	 */
	@Override
	public void setSeparatorAfter(String separatorAfter) {
		model.setSeparatorAfter(separatorAfter);
	}

	/**
	 * Sets the separator before of this pdr attribute.
	 *
	 * @param separatorBefore the separator before of this pdr attribute
	 */
	@Override
	public void setSeparatorBefore(String separatorBefore) {
		model.setSeparatorBefore(separatorBefore);
	}

	/**
	 * Sets the tag name of this pdr attribute.
	 *
	 * @param tagName the tag name of this pdr attribute
	 */
	@Override
	public void setTagName(String tagName) {
		model.setTagName(tagName);
	}

	/**
	 * Sets the user ID of this pdr attribute.
	 *
	 * @param userId the user ID of this pdr attribute
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this pdr attribute.
	 *
	 * @param userName the user name of this pdr attribute
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this pdr attribute.
	 *
	 * @param userUuid the user uuid of this pdr attribute
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected PDRAttributeWrapper wrap(PDRAttribute pdrAttribute) {
		return new PDRAttributeWrapper(pdrAttribute);
	}

}