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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CdsDemand}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemand
 * @generated
 */
public class CdsDemandWrapper
	extends BaseModelWrapper<CdsDemand>
	implements CdsDemand, ModelWrapper<CdsDemand> {

	public CdsDemandWrapper(CdsDemand cdsDemand) {
		super(cdsDemand);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("headId", getHeadId());
		attributes.put("demandId", getDemandId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("type", getType());
		attributes.put("priority", getPriority());
		attributes.put("requestedDelivery", getRequestedDelivery());
		attributes.put("isGDPR", isIsGDPR());
		attributes.put("gdprInfo", getGdprInfo());
		attributes.put("fiveTracks", getFiveTracks());
		attributes.put("requestorId", getRequestorId());
		attributes.put("requestorName", getRequestorName());
		attributes.put("requestedForId", getRequestedForId());
		attributes.put("requestedForName", getRequestedForName());
		attributes.put("contactId", getContactId());
		attributes.put("contactName", getContactName());
		attributes.put("domainId", getDomainId());
		attributes.put("domainName", getDomainName());
		attributes.put("banId", getBanId());
		attributes.put("banName", getBanName());
		attributes.put("spocId", getSpocId());
		attributes.put("spocName", getSpocName());
		attributes.put("usReasoning", getUsReasoning());
		attributes.put("usFrequencyOut", getUsFrequencyOut());
		attributes.put("usAccessDPM", isUsAccessDPM());
		attributes.put("usFolderDPM", getUsFolderDPM());
		attributes.put("usCreateFolderDPM", isUsCreateFolderDPM());
		attributes.put("usGestorFolderDPMId", getUsGestorFolderDPMId());
		attributes.put("usGestorFolderDPMName", getUsGestorFolderDPMName());
		attributes.put("usDPMNotificationMail", getUsDPMNotificationMail());
		attributes.put("bioeId", getBioeId());
		attributes.put("bioeStateId", getBioeStateId());
		attributes.put("bioeStateName", getBioeStateName());
		attributes.put("workEstimate", getWorkEstimate());
		attributes.put("acceptedWorkEstimate", getAcceptedWorkEstimate());
		attributes.put("expectedDelivery", getExpectedDelivery());
		attributes.put("acceptedDelivery", getAcceptedDelivery());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("urlTitle", getUrlTitle());
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

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long headId = (Long)attributes.get("headId");

		if (headId != null) {
			setHeadId(headId);
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

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer priority = (Integer)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		Date requestedDelivery = (Date)attributes.get("requestedDelivery");

		if (requestedDelivery != null) {
			setRequestedDelivery(requestedDelivery);
		}

		Boolean isGDPR = (Boolean)attributes.get("isGDPR");

		if (isGDPR != null) {
			setIsGDPR(isGDPR);
		}

		String gdprInfo = (String)attributes.get("gdprInfo");

		if (gdprInfo != null) {
			setGdprInfo(gdprInfo);
		}

		String fiveTracks = (String)attributes.get("fiveTracks");

		if (fiveTracks != null) {
			setFiveTracks(fiveTracks);
		}

		Long requestorId = (Long)attributes.get("requestorId");

		if (requestorId != null) {
			setRequestorId(requestorId);
		}

		String requestorName = (String)attributes.get("requestorName");

		if (requestorName != null) {
			setRequestorName(requestorName);
		}

		Long requestedForId = (Long)attributes.get("requestedForId");

		if (requestedForId != null) {
			setRequestedForId(requestedForId);
		}

		String requestedForName = (String)attributes.get("requestedForName");

		if (requestedForName != null) {
			setRequestedForName(requestedForName);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		Long domainId = (Long)attributes.get("domainId");

		if (domainId != null) {
			setDomainId(domainId);
		}

		String domainName = (String)attributes.get("domainName");

		if (domainName != null) {
			setDomainName(domainName);
		}

		Long banId = (Long)attributes.get("banId");

		if (banId != null) {
			setBanId(banId);
		}

		String banName = (String)attributes.get("banName");

		if (banName != null) {
			setBanName(banName);
		}

		Long spocId = (Long)attributes.get("spocId");

		if (spocId != null) {
			setSpocId(spocId);
		}

		String spocName = (String)attributes.get("spocName");

		if (spocName != null) {
			setSpocName(spocName);
		}

		String usReasoning = (String)attributes.get("usReasoning");

		if (usReasoning != null) {
			setUsReasoning(usReasoning);
		}

		Integer usFrequencyOut = (Integer)attributes.get("usFrequencyOut");

		if (usFrequencyOut != null) {
			setUsFrequencyOut(usFrequencyOut);
		}

		Boolean usAccessDPM = (Boolean)attributes.get("usAccessDPM");

		if (usAccessDPM != null) {
			setUsAccessDPM(usAccessDPM);
		}

		String usFolderDPM = (String)attributes.get("usFolderDPM");

		if (usFolderDPM != null) {
			setUsFolderDPM(usFolderDPM);
		}

		Boolean usCreateFolderDPM = (Boolean)attributes.get(
			"usCreateFolderDPM");

		if (usCreateFolderDPM != null) {
			setUsCreateFolderDPM(usCreateFolderDPM);
		}

		Long usGestorFolderDPMId = (Long)attributes.get("usGestorFolderDPMId");

		if (usGestorFolderDPMId != null) {
			setUsGestorFolderDPMId(usGestorFolderDPMId);
		}

		String usGestorFolderDPMName = (String)attributes.get(
			"usGestorFolderDPMName");

		if (usGestorFolderDPMName != null) {
			setUsGestorFolderDPMName(usGestorFolderDPMName);
		}

		String usDPMNotificationMail = (String)attributes.get(
			"usDPMNotificationMail");

		if (usDPMNotificationMail != null) {
			setUsDPMNotificationMail(usDPMNotificationMail);
		}

		String bioeId = (String)attributes.get("bioeId");

		if (bioeId != null) {
			setBioeId(bioeId);
		}

		Short bioeStateId = (Short)attributes.get("bioeStateId");

		if (bioeStateId != null) {
			setBioeStateId(bioeStateId);
		}

		String bioeStateName = (String)attributes.get("bioeStateName");

		if (bioeStateName != null) {
			setBioeStateName(bioeStateName);
		}

		Double workEstimate = (Double)attributes.get("workEstimate");

		if (workEstimate != null) {
			setWorkEstimate(workEstimate);
		}

		Double acceptedWorkEstimate = (Double)attributes.get(
			"acceptedWorkEstimate");

		if (acceptedWorkEstimate != null) {
			setAcceptedWorkEstimate(acceptedWorkEstimate);
		}

		Date expectedDelivery = (Date)attributes.get("expectedDelivery");

		if (expectedDelivery != null) {
			setExpectedDelivery(expectedDelivery);
		}

		Date acceptedDelivery = (Date)attributes.get("acceptedDelivery");

		if (acceptedDelivery != null) {
			setAcceptedDelivery(acceptedDelivery);
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

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
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
	public CdsDemand cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the accepted delivery of this cds demand.
	 *
	 * @return the accepted delivery of this cds demand
	 */
	@Override
	public Date getAcceptedDelivery() {
		return model.getAcceptedDelivery();
	}

	/**
	 * Returns the accepted work estimate of this cds demand.
	 *
	 * @return the accepted work estimate of this cds demand
	 */
	@Override
	public double getAcceptedWorkEstimate() {
		return model.getAcceptedWorkEstimate();
	}

	/**
	 * Returns the ban ID of this cds demand.
	 *
	 * @return the ban ID of this cds demand
	 */
	@Override
	public long getBanId() {
		return model.getBanId();
	}

	/**
	 * Returns the ban name of this cds demand.
	 *
	 * @return the ban name of this cds demand
	 */
	@Override
	public String getBanName() {
		return model.getBanName();
	}

	/**
	 * Returns the bioe ID of this cds demand.
	 *
	 * @return the bioe ID of this cds demand
	 */
	@Override
	public String getBioeId() {
		return model.getBioeId();
	}

	/**
	 * Returns the bioe state ID of this cds demand.
	 *
	 * @return the bioe state ID of this cds demand
	 */
	@Override
	public short getBioeStateId() {
		return model.getBioeStateId();
	}

	/**
	 * Returns the bioe state name of this cds demand.
	 *
	 * @return the bioe state name of this cds demand
	 */
	@Override
	public String getBioeStateName() {
		return model.getBioeStateName();
	}

	/**
	 * Returns the company ID of this cds demand.
	 *
	 * @return the company ID of this cds demand
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact ID of this cds demand.
	 *
	 * @return the contact ID of this cds demand
	 */
	@Override
	public long getContactId() {
		return model.getContactId();
	}

	/**
	 * Returns the contact name of this cds demand.
	 *
	 * @return the contact name of this cds demand
	 */
	@Override
	public String getContactName() {
		return model.getContactName();
	}

	/**
	 * Returns the create date of this cds demand.
	 *
	 * @return the create date of this cds demand
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the demand ID of this cds demand.
	 *
	 * @return the demand ID of this cds demand
	 */
	@Override
	public long getDemandId() {
		return model.getDemandId();
	}

	/**
	 * Returns the description of this cds demand.
	 *
	 * @return the description of this cds demand
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the domain ID of this cds demand.
	 *
	 * @return the domain ID of this cds demand
	 */
	@Override
	public long getDomainId() {
		return model.getDomainId();
	}

	/**
	 * Returns the domain name of this cds demand.
	 *
	 * @return the domain name of this cds demand
	 */
	@Override
	public String getDomainName() {
		return model.getDomainName();
	}

	/**
	 * Returns the expected delivery of this cds demand.
	 *
	 * @return the expected delivery of this cds demand
	 */
	@Override
	public Date getExpectedDelivery() {
		return model.getExpectedDelivery();
	}

	/**
	 * Returns the five tracks of this cds demand.
	 *
	 * @return the five tracks of this cds demand
	 */
	@Override
	public String getFiveTracks() {
		return model.getFiveTracks();
	}

	@Override
	public int[] getFiveTracksArray() {
		return model.getFiveTracksArray();
	}

	/**
	 * Returns the gdpr info of this cds demand.
	 *
	 * @return the gdpr info of this cds demand
	 */
	@Override
	public String getGdprInfo() {
		return model.getGdprInfo();
	}

	/**
	 * Returns the group ID of this cds demand.
	 *
	 * @return the group ID of this cds demand
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the head ID of this cds demand.
	 *
	 * @return the head ID of this cds demand
	 */
	@Override
	public long getHeadId() {
		return model.getHeadId();
	}

	/**
	 * Returns the is gdpr of this cds demand.
	 *
	 * @return the is gdpr of this cds demand
	 */
	@Override
	public boolean getIsGDPR() {
		return model.getIsGDPR();
	}

	/**
	 * Returns the modified date of this cds demand.
	 *
	 * @return the modified date of this cds demand
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this cds demand.
	 *
	 * @return the mvcc version of this cds demand
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this cds demand.
	 *
	 * @return the primary key of this cds demand
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority of this cds demand.
	 *
	 * @return the priority of this cds demand
	 */
	@Override
	public int getPriority() {
		return model.getPriority();
	}

	/**
	 * Returns the requested delivery of this cds demand.
	 *
	 * @return the requested delivery of this cds demand
	 */
	@Override
	public Date getRequestedDelivery() {
		return model.getRequestedDelivery();
	}

	/**
	 * Returns the requested for ID of this cds demand.
	 *
	 * @return the requested for ID of this cds demand
	 */
	@Override
	public long getRequestedForId() {
		return model.getRequestedForId();
	}

	/**
	 * Returns the requested for name of this cds demand.
	 *
	 * @return the requested for name of this cds demand
	 */
	@Override
	public String getRequestedForName() {
		return model.getRequestedForName();
	}

	/**
	 * Returns the requestor ID of this cds demand.
	 *
	 * @return the requestor ID of this cds demand
	 */
	@Override
	public long getRequestorId() {
		return model.getRequestorId();
	}

	/**
	 * Returns the requestor name of this cds demand.
	 *
	 * @return the requestor name of this cds demand
	 */
	@Override
	public String getRequestorName() {
		return model.getRequestorName();
	}

	/**
	 * Returns the spoc ID of this cds demand.
	 *
	 * @return the spoc ID of this cds demand
	 */
	@Override
	public long getSpocId() {
		return model.getSpocId();
	}

	/**
	 * Returns the spoc name of this cds demand.
	 *
	 * @return the spoc name of this cds demand
	 */
	@Override
	public String getSpocName() {
		return model.getSpocName();
	}

	/**
	 * Returns the state of this cds demand.
	 *
	 * @return the state of this cds demand
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the state by user ID of this cds demand.
	 *
	 * @return the state by user ID of this cds demand
	 */
	@Override
	public long getStateByUserId() {
		return model.getStateByUserId();
	}

	/**
	 * Returns the state by user name of this cds demand.
	 *
	 * @return the state by user name of this cds demand
	 */
	@Override
	public String getStateByUserName() {
		return model.getStateByUserName();
	}

	/**
	 * Returns the state by user uuid of this cds demand.
	 *
	 * @return the state by user uuid of this cds demand
	 */
	@Override
	public String getStateByUserUuid() {
		return model.getStateByUserUuid();
	}

	/**
	 * Returns the state date of this cds demand.
	 *
	 * @return the state date of this cds demand
	 */
	@Override
	public Date getStateDate() {
		return model.getStateDate();
	}

	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this cds demand.
	 *
	 * @return the title of this cds demand
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type of this cds demand.
	 *
	 * @return the type of this cds demand
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the url title of this cds demand.
	 *
	 * @return the url title of this cds demand
	 */
	@Override
	public String getUrlTitle() {
		return model.getUrlTitle();
	}

	/**
	 * Returns the us access dpm of this cds demand.
	 *
	 * @return the us access dpm of this cds demand
	 */
	@Override
	public boolean getUsAccessDPM() {
		return model.getUsAccessDPM();
	}

	/**
	 * Returns the us create folder dpm of this cds demand.
	 *
	 * @return the us create folder dpm of this cds demand
	 */
	@Override
	public boolean getUsCreateFolderDPM() {
		return model.getUsCreateFolderDPM();
	}

	/**
	 * Returns the us dpm notification mail of this cds demand.
	 *
	 * @return the us dpm notification mail of this cds demand
	 */
	@Override
	public String getUsDPMNotificationMail() {
		return model.getUsDPMNotificationMail();
	}

	/**
	 * Returns the user ID of this cds demand.
	 *
	 * @return the user ID of this cds demand
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this cds demand.
	 *
	 * @return the user name of this cds demand
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this cds demand.
	 *
	 * @return the user uuid of this cds demand
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the us folder dpm of this cds demand.
	 *
	 * @return the us folder dpm of this cds demand
	 */
	@Override
	public String getUsFolderDPM() {
		return model.getUsFolderDPM();
	}

	/**
	 * Returns the us frequency out of this cds demand.
	 *
	 * @return the us frequency out of this cds demand
	 */
	@Override
	public int getUsFrequencyOut() {
		return model.getUsFrequencyOut();
	}

	/**
	 * Returns the us gestor folder dpm ID of this cds demand.
	 *
	 * @return the us gestor folder dpm ID of this cds demand
	 */
	@Override
	public long getUsGestorFolderDPMId() {
		return model.getUsGestorFolderDPMId();
	}

	/**
	 * Returns the us gestor folder dpm name of this cds demand.
	 *
	 * @return the us gestor folder dpm name of this cds demand
	 */
	@Override
	public String getUsGestorFolderDPMName() {
		return model.getUsGestorFolderDPMName();
	}

	/**
	 * Returns the us reasoning of this cds demand.
	 *
	 * @return the us reasoning of this cds demand
	 */
	@Override
	public String getUsReasoning() {
		return model.getUsReasoning();
	}

	/**
	 * Returns the uuid of this cds demand.
	 *
	 * @return the uuid of this cds demand
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work estimate of this cds demand.
	 *
	 * @return the work estimate of this cds demand
	 */
	@Override
	public double getWorkEstimate() {
		return model.getWorkEstimate();
	}

	/**
	 * Returns <code>true</code> if this cds demand is is gdpr.
	 *
	 * @return <code>true</code> if this cds demand is is gdpr; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsGDPR() {
		return model.isIsGDPR();
	}

	/**
	 * Compares two object by significant values. Technical values (creation, modifiaction dates ...)
	 * are ignored
	 *
	 * @param that
	 * @return
	 */
	@Override
	public boolean isSubstantiallyEqual(
		cz.csob.ency.cds.demands.model.CdsDemand that) {

		return model.isSubstantiallyEqual(that);
	}

	/**
	 * Returns <code>true</code> if this cds demand is us access dpm.
	 *
	 * @return <code>true</code> if this cds demand is us access dpm; <code>false</code> otherwise
	 */
	@Override
	public boolean isUsAccessDPM() {
		return model.isUsAccessDPM();
	}

	/**
	 * Returns <code>true</code> if this cds demand is us create folder dpm.
	 *
	 * @return <code>true</code> if this cds demand is us create folder dpm; <code>false</code> otherwise
	 */
	@Override
	public boolean isUsCreateFolderDPM() {
		return model.isUsCreateFolderDPM();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the accepted delivery of this cds demand.
	 *
	 * @param acceptedDelivery the accepted delivery of this cds demand
	 */
	@Override
	public void setAcceptedDelivery(Date acceptedDelivery) {
		model.setAcceptedDelivery(acceptedDelivery);
	}

	/**
	 * Sets the accepted work estimate of this cds demand.
	 *
	 * @param acceptedWorkEstimate the accepted work estimate of this cds demand
	 */
	@Override
	public void setAcceptedWorkEstimate(double acceptedWorkEstimate) {
		model.setAcceptedWorkEstimate(acceptedWorkEstimate);
	}

	/**
	 * Sets the ban ID of this cds demand.
	 *
	 * @param banId the ban ID of this cds demand
	 */
	@Override
	public void setBanId(long banId) {
		model.setBanId(banId);
	}

	/**
	 * Sets the ban name of this cds demand.
	 *
	 * @param banName the ban name of this cds demand
	 */
	@Override
	public void setBanName(String banName) {
		model.setBanName(banName);
	}

	/**
	 * Sets the bioe ID of this cds demand.
	 *
	 * @param bioeId the bioe ID of this cds demand
	 */
	@Override
	public void setBioeId(String bioeId) {
		model.setBioeId(bioeId);
	}

	/**
	 * Sets the bioe state ID of this cds demand.
	 *
	 * @param bioeStateId the bioe state ID of this cds demand
	 */
	@Override
	public void setBioeStateId(short bioeStateId) {
		model.setBioeStateId(bioeStateId);
	}

	/**
	 * Sets the bioe state name of this cds demand.
	 *
	 * @param bioeStateName the bioe state name of this cds demand
	 */
	@Override
	public void setBioeStateName(String bioeStateName) {
		model.setBioeStateName(bioeStateName);
	}

	/**
	 * Sets the company ID of this cds demand.
	 *
	 * @param companyId the company ID of this cds demand
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact ID of this cds demand.
	 *
	 * @param contactId the contact ID of this cds demand
	 */
	@Override
	public void setContactId(long contactId) {
		model.setContactId(contactId);
	}

	/**
	 * Sets the contact name of this cds demand.
	 *
	 * @param contactName the contact name of this cds demand
	 */
	@Override
	public void setContactName(String contactName) {
		model.setContactName(contactName);
	}

	/**
	 * Sets the create date of this cds demand.
	 *
	 * @param createDate the create date of this cds demand
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the demand ID of this cds demand.
	 *
	 * @param demandId the demand ID of this cds demand
	 */
	@Override
	public void setDemandId(long demandId) {
		model.setDemandId(demandId);
	}

	/**
	 * Sets the description of this cds demand.
	 *
	 * @param description the description of this cds demand
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the domain ID of this cds demand.
	 *
	 * @param domainId the domain ID of this cds demand
	 */
	@Override
	public void setDomainId(long domainId) {
		model.setDomainId(domainId);
	}

	/**
	 * Sets the domain name of this cds demand.
	 *
	 * @param domainName the domain name of this cds demand
	 */
	@Override
	public void setDomainName(String domainName) {
		model.setDomainName(domainName);
	}

	/**
	 * Sets the expected delivery of this cds demand.
	 *
	 * @param expectedDelivery the expected delivery of this cds demand
	 */
	@Override
	public void setExpectedDelivery(Date expectedDelivery) {
		model.setExpectedDelivery(expectedDelivery);
	}

	@Override
	public void setFiveTracks(long[] tracks) {
		model.setFiveTracks(tracks);
	}

	/**
	 * Sets the five tracks of this cds demand.
	 *
	 * @param fiveTracks the five tracks of this cds demand
	 */
	@Override
	public void setFiveTracks(String fiveTracks) {
		model.setFiveTracks(fiveTracks);
	}

	/**
	 * Sets the gdpr info of this cds demand.
	 *
	 * @param gdprInfo the gdpr info of this cds demand
	 */
	@Override
	public void setGdprInfo(String gdprInfo) {
		model.setGdprInfo(gdprInfo);
	}

	/**
	 * Sets the group ID of this cds demand.
	 *
	 * @param groupId the group ID of this cds demand
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the head ID of this cds demand.
	 *
	 * @param headId the head ID of this cds demand
	 */
	@Override
	public void setHeadId(long headId) {
		model.setHeadId(headId);
	}

	/**
	 * Sets whether this cds demand is is gdpr.
	 *
	 * @param isGDPR the is gdpr of this cds demand
	 */
	@Override
	public void setIsGDPR(boolean isGDPR) {
		model.setIsGDPR(isGDPR);
	}

	/**
	 * Sets the modified date of this cds demand.
	 *
	 * @param modifiedDate the modified date of this cds demand
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this cds demand.
	 *
	 * @param mvccVersion the mvcc version of this cds demand
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this cds demand.
	 *
	 * @param primaryKey the primary key of this cds demand
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority of this cds demand.
	 *
	 * @param priority the priority of this cds demand
	 */
	@Override
	public void setPriority(int priority) {
		model.setPriority(priority);
	}

	/**
	 * Sets the requested delivery of this cds demand.
	 *
	 * @param requestedDelivery the requested delivery of this cds demand
	 */
	@Override
	public void setRequestedDelivery(Date requestedDelivery) {
		model.setRequestedDelivery(requestedDelivery);
	}

	/**
	 * Sets the requested for ID of this cds demand.
	 *
	 * @param requestedForId the requested for ID of this cds demand
	 */
	@Override
	public void setRequestedForId(long requestedForId) {
		model.setRequestedForId(requestedForId);
	}

	/**
	 * Sets the requested for name of this cds demand.
	 *
	 * @param requestedForName the requested for name of this cds demand
	 */
	@Override
	public void setRequestedForName(String requestedForName) {
		model.setRequestedForName(requestedForName);
	}

	/**
	 * Sets the requestor ID of this cds demand.
	 *
	 * @param requestorId the requestor ID of this cds demand
	 */
	@Override
	public void setRequestorId(long requestorId) {
		model.setRequestorId(requestorId);
	}

	/**
	 * Sets the requestor name of this cds demand.
	 *
	 * @param requestorName the requestor name of this cds demand
	 */
	@Override
	public void setRequestorName(String requestorName) {
		model.setRequestorName(requestorName);
	}

	/**
	 * Sets the spoc ID of this cds demand.
	 *
	 * @param spocId the spoc ID of this cds demand
	 */
	@Override
	public void setSpocId(long spocId) {
		model.setSpocId(spocId);
	}

	/**
	 * Sets the spoc name of this cds demand.
	 *
	 * @param spocName the spoc name of this cds demand
	 */
	@Override
	public void setSpocName(String spocName) {
		model.setSpocName(spocName);
	}

	/**
	 * Sets the state of this cds demand.
	 *
	 * @param state the state of this cds demand
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the state by user ID of this cds demand.
	 *
	 * @param stateByUserId the state by user ID of this cds demand
	 */
	@Override
	public void setStateByUserId(long stateByUserId) {
		model.setStateByUserId(stateByUserId);
	}

	/**
	 * Sets the state by user name of this cds demand.
	 *
	 * @param stateByUserName the state by user name of this cds demand
	 */
	@Override
	public void setStateByUserName(String stateByUserName) {
		model.setStateByUserName(stateByUserName);
	}

	/**
	 * Sets the state by user uuid of this cds demand.
	 *
	 * @param stateByUserUuid the state by user uuid of this cds demand
	 */
	@Override
	public void setStateByUserUuid(String stateByUserUuid) {
		model.setStateByUserUuid(stateByUserUuid);
	}

	/**
	 * Sets the state date of this cds demand.
	 *
	 * @param stateDate the state date of this cds demand
	 */
	@Override
	public void setStateDate(Date stateDate) {
		model.setStateDate(stateDate);
	}

	/**
	 * Sets the title of this cds demand.
	 *
	 * @param title the title of this cds demand
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type of this cds demand.
	 *
	 * @param type the type of this cds demand
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the url title of this cds demand.
	 *
	 * @param urlTitle the url title of this cds demand
	 */
	@Override
	public void setUrlTitle(String urlTitle) {
		model.setUrlTitle(urlTitle);
	}

	/**
	 * Sets whether this cds demand is us access dpm.
	 *
	 * @param usAccessDPM the us access dpm of this cds demand
	 */
	@Override
	public void setUsAccessDPM(boolean usAccessDPM) {
		model.setUsAccessDPM(usAccessDPM);
	}

	/**
	 * Sets whether this cds demand is us create folder dpm.
	 *
	 * @param usCreateFolderDPM the us create folder dpm of this cds demand
	 */
	@Override
	public void setUsCreateFolderDPM(boolean usCreateFolderDPM) {
		model.setUsCreateFolderDPM(usCreateFolderDPM);
	}

	/**
	 * Sets the us dpm notification mail of this cds demand.
	 *
	 * @param usDPMNotificationMail the us dpm notification mail of this cds demand
	 */
	@Override
	public void setUsDPMNotificationMail(String usDPMNotificationMail) {
		model.setUsDPMNotificationMail(usDPMNotificationMail);
	}

	/**
	 * Sets the user ID of this cds demand.
	 *
	 * @param userId the user ID of this cds demand
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this cds demand.
	 *
	 * @param userName the user name of this cds demand
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this cds demand.
	 *
	 * @param userUuid the user uuid of this cds demand
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the us folder dpm of this cds demand.
	 *
	 * @param usFolderDPM the us folder dpm of this cds demand
	 */
	@Override
	public void setUsFolderDPM(String usFolderDPM) {
		model.setUsFolderDPM(usFolderDPM);
	}

	/**
	 * Sets the us frequency out of this cds demand.
	 *
	 * @param usFrequencyOut the us frequency out of this cds demand
	 */
	@Override
	public void setUsFrequencyOut(int usFrequencyOut) {
		model.setUsFrequencyOut(usFrequencyOut);
	}

	/**
	 * Sets the us gestor folder dpm ID of this cds demand.
	 *
	 * @param usGestorFolderDPMId the us gestor folder dpm ID of this cds demand
	 */
	@Override
	public void setUsGestorFolderDPMId(long usGestorFolderDPMId) {
		model.setUsGestorFolderDPMId(usGestorFolderDPMId);
	}

	/**
	 * Sets the us gestor folder dpm name of this cds demand.
	 *
	 * @param usGestorFolderDPMName the us gestor folder dpm name of this cds demand
	 */
	@Override
	public void setUsGestorFolderDPMName(String usGestorFolderDPMName) {
		model.setUsGestorFolderDPMName(usGestorFolderDPMName);
	}

	/**
	 * Sets the us reasoning of this cds demand.
	 *
	 * @param usReasoning the us reasoning of this cds demand
	 */
	@Override
	public void setUsReasoning(String usReasoning) {
		model.setUsReasoning(usReasoning);
	}

	/**
	 * Sets the uuid of this cds demand.
	 *
	 * @param uuid the uuid of this cds demand
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work estimate of this cds demand.
	 *
	 * @param workEstimate the work estimate of this cds demand
	 */
	@Override
	public void setWorkEstimate(double workEstimate) {
		model.setWorkEstimate(workEstimate);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	public boolean isHead() {
		return model.isHead();
	}

	@Override
	public void populateVersionModel(CdsDemandVersion cdsDemandVersion) {
		model.populateVersionModel(cdsDemandVersion);
	}

	@Override
	protected CdsDemandWrapper wrap(CdsDemand cdsDemand) {
		return new CdsDemandWrapper(cdsDemand);
	}

}