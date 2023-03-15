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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.version.VersionedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CdsDemand service. Represents a row in the &quot;CdsDemands_CdsDemand&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>cz.csob.ency.cds.demands.model.impl.CdsDemandModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>cz.csob.ency.cds.demands.model.impl.CdsDemandImpl</code>.
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemand
 * @generated
 */
@ProviderType
public interface CdsDemandModel
	extends BaseModel<CdsDemand>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel, VersionedModel<CdsDemandVersion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cds demand model instance should use the {@link CdsDemand} interface instead.
	 */

	/**
	 * Returns the primary key of this cds demand.
	 *
	 * @return the primary key of this cds demand
	 */
	@Override
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cds demand.
	 *
	 * @param primaryKey the primary key of this cds demand
	 */
	@Override
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this cds demand.
	 *
	 * @return the mvcc version of this cds demand
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this cds demand.
	 *
	 * @param mvccVersion the mvcc version of this cds demand
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this cds demand.
	 *
	 * @return the uuid of this cds demand
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this cds demand.
	 *
	 * @param uuid the uuid of this cds demand
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the head ID of this cds demand.
	 *
	 * @return the head ID of this cds demand
	 */
	@Override
	public long getHeadId();

	/**
	 * Sets the head ID of this cds demand.
	 *
	 * @param headId the head ID of this cds demand
	 */
	@Override
	public void setHeadId(long headId);

	/**
	 * Returns the demand ID of this cds demand.
	 *
	 * @return the demand ID of this cds demand
	 */
	public long getDemandId();

	/**
	 * Sets the demand ID of this cds demand.
	 *
	 * @param demandId the demand ID of this cds demand
	 */
	public void setDemandId(long demandId);

	/**
	 * Returns the title of this cds demand.
	 *
	 * @return the title of this cds demand
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this cds demand.
	 *
	 * @param title the title of this cds demand
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this cds demand.
	 *
	 * @return the description of this cds demand
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this cds demand.
	 *
	 * @param description the description of this cds demand
	 */
	public void setDescription(String description);

	/**
	 * Returns the type of this cds demand.
	 *
	 * @return the type of this cds demand
	 */
	public int getType();

	/**
	 * Sets the type of this cds demand.
	 *
	 * @param type the type of this cds demand
	 */
	public void setType(int type);

	/**
	 * Returns the priority of this cds demand.
	 *
	 * @return the priority of this cds demand
	 */
	public int getPriority();

	/**
	 * Sets the priority of this cds demand.
	 *
	 * @param priority the priority of this cds demand
	 */
	public void setPriority(int priority);

	/**
	 * Returns the requested delivery of this cds demand.
	 *
	 * @return the requested delivery of this cds demand
	 */
	public Date getRequestedDelivery();

	/**
	 * Sets the requested delivery of this cds demand.
	 *
	 * @param requestedDelivery the requested delivery of this cds demand
	 */
	public void setRequestedDelivery(Date requestedDelivery);

	/**
	 * Returns the is gdpr of this cds demand.
	 *
	 * @return the is gdpr of this cds demand
	 */
	public boolean getIsGDPR();

	/**
	 * Returns <code>true</code> if this cds demand is is gdpr.
	 *
	 * @return <code>true</code> if this cds demand is is gdpr; <code>false</code> otherwise
	 */
	public boolean isIsGDPR();

	/**
	 * Sets whether this cds demand is is gdpr.
	 *
	 * @param isGDPR the is gdpr of this cds demand
	 */
	public void setIsGDPR(boolean isGDPR);

	/**
	 * Returns the gdpr info of this cds demand.
	 *
	 * @return the gdpr info of this cds demand
	 */
	@AutoEscape
	public String getGdprInfo();

	/**
	 * Sets the gdpr info of this cds demand.
	 *
	 * @param gdprInfo the gdpr info of this cds demand
	 */
	public void setGdprInfo(String gdprInfo);

	/**
	 * Returns the five tracks of this cds demand.
	 *
	 * @return the five tracks of this cds demand
	 */
	@AutoEscape
	public String getFiveTracks();

	/**
	 * Sets the five tracks of this cds demand.
	 *
	 * @param fiveTracks the five tracks of this cds demand
	 */
	public void setFiveTracks(String fiveTracks);

	/**
	 * Returns the requestor ID of this cds demand.
	 *
	 * @return the requestor ID of this cds demand
	 */
	public long getRequestorId();

	/**
	 * Sets the requestor ID of this cds demand.
	 *
	 * @param requestorId the requestor ID of this cds demand
	 */
	public void setRequestorId(long requestorId);

	/**
	 * Returns the requestor name of this cds demand.
	 *
	 * @return the requestor name of this cds demand
	 */
	@AutoEscape
	public String getRequestorName();

	/**
	 * Sets the requestor name of this cds demand.
	 *
	 * @param requestorName the requestor name of this cds demand
	 */
	public void setRequestorName(String requestorName);

	/**
	 * Returns the requested for ID of this cds demand.
	 *
	 * @return the requested for ID of this cds demand
	 */
	public long getRequestedForId();

	/**
	 * Sets the requested for ID of this cds demand.
	 *
	 * @param requestedForId the requested for ID of this cds demand
	 */
	public void setRequestedForId(long requestedForId);

	/**
	 * Returns the requested for name of this cds demand.
	 *
	 * @return the requested for name of this cds demand
	 */
	@AutoEscape
	public String getRequestedForName();

	/**
	 * Sets the requested for name of this cds demand.
	 *
	 * @param requestedForName the requested for name of this cds demand
	 */
	public void setRequestedForName(String requestedForName);

	/**
	 * Returns the contact ID of this cds demand.
	 *
	 * @return the contact ID of this cds demand
	 */
	public long getContactId();

	/**
	 * Sets the contact ID of this cds demand.
	 *
	 * @param contactId the contact ID of this cds demand
	 */
	public void setContactId(long contactId);

	/**
	 * Returns the contact name of this cds demand.
	 *
	 * @return the contact name of this cds demand
	 */
	@AutoEscape
	public String getContactName();

	/**
	 * Sets the contact name of this cds demand.
	 *
	 * @param contactName the contact name of this cds demand
	 */
	public void setContactName(String contactName);

	/**
	 * Returns the domain ID of this cds demand.
	 *
	 * @return the domain ID of this cds demand
	 */
	public long getDomainId();

	/**
	 * Sets the domain ID of this cds demand.
	 *
	 * @param domainId the domain ID of this cds demand
	 */
	public void setDomainId(long domainId);

	/**
	 * Returns the domain name of this cds demand.
	 *
	 * @return the domain name of this cds demand
	 */
	@AutoEscape
	public String getDomainName();

	/**
	 * Sets the domain name of this cds demand.
	 *
	 * @param domainName the domain name of this cds demand
	 */
	public void setDomainName(String domainName);

	/**
	 * Returns the ban ID of this cds demand.
	 *
	 * @return the ban ID of this cds demand
	 */
	public long getBanId();

	/**
	 * Sets the ban ID of this cds demand.
	 *
	 * @param banId the ban ID of this cds demand
	 */
	public void setBanId(long banId);

	/**
	 * Returns the ban name of this cds demand.
	 *
	 * @return the ban name of this cds demand
	 */
	@AutoEscape
	public String getBanName();

	/**
	 * Sets the ban name of this cds demand.
	 *
	 * @param banName the ban name of this cds demand
	 */
	public void setBanName(String banName);

	/**
	 * Returns the spoc ID of this cds demand.
	 *
	 * @return the spoc ID of this cds demand
	 */
	public long getSpocId();

	/**
	 * Sets the spoc ID of this cds demand.
	 *
	 * @param spocId the spoc ID of this cds demand
	 */
	public void setSpocId(long spocId);

	/**
	 * Returns the spoc name of this cds demand.
	 *
	 * @return the spoc name of this cds demand
	 */
	@AutoEscape
	public String getSpocName();

	/**
	 * Sets the spoc name of this cds demand.
	 *
	 * @param spocName the spoc name of this cds demand
	 */
	public void setSpocName(String spocName);

	/**
	 * Returns the us reasoning of this cds demand.
	 *
	 * @return the us reasoning of this cds demand
	 */
	@AutoEscape
	public String getUsReasoning();

	/**
	 * Sets the us reasoning of this cds demand.
	 *
	 * @param usReasoning the us reasoning of this cds demand
	 */
	public void setUsReasoning(String usReasoning);

	/**
	 * Returns the us frequency out of this cds demand.
	 *
	 * @return the us frequency out of this cds demand
	 */
	public int getUsFrequencyOut();

	/**
	 * Sets the us frequency out of this cds demand.
	 *
	 * @param usFrequencyOut the us frequency out of this cds demand
	 */
	public void setUsFrequencyOut(int usFrequencyOut);

	/**
	 * Returns the us access dpm of this cds demand.
	 *
	 * @return the us access dpm of this cds demand
	 */
	public boolean getUsAccessDPM();

	/**
	 * Returns <code>true</code> if this cds demand is us access dpm.
	 *
	 * @return <code>true</code> if this cds demand is us access dpm; <code>false</code> otherwise
	 */
	public boolean isUsAccessDPM();

	/**
	 * Sets whether this cds demand is us access dpm.
	 *
	 * @param usAccessDPM the us access dpm of this cds demand
	 */
	public void setUsAccessDPM(boolean usAccessDPM);

	/**
	 * Returns the us folder dpm of this cds demand.
	 *
	 * @return the us folder dpm of this cds demand
	 */
	@AutoEscape
	public String getUsFolderDPM();

	/**
	 * Sets the us folder dpm of this cds demand.
	 *
	 * @param usFolderDPM the us folder dpm of this cds demand
	 */
	public void setUsFolderDPM(String usFolderDPM);

	/**
	 * Returns the us create folder dpm of this cds demand.
	 *
	 * @return the us create folder dpm of this cds demand
	 */
	public boolean getUsCreateFolderDPM();

	/**
	 * Returns <code>true</code> if this cds demand is us create folder dpm.
	 *
	 * @return <code>true</code> if this cds demand is us create folder dpm; <code>false</code> otherwise
	 */
	public boolean isUsCreateFolderDPM();

	/**
	 * Sets whether this cds demand is us create folder dpm.
	 *
	 * @param usCreateFolderDPM the us create folder dpm of this cds demand
	 */
	public void setUsCreateFolderDPM(boolean usCreateFolderDPM);

	/**
	 * Returns the us gestor folder dpm ID of this cds demand.
	 *
	 * @return the us gestor folder dpm ID of this cds demand
	 */
	public long getUsGestorFolderDPMId();

	/**
	 * Sets the us gestor folder dpm ID of this cds demand.
	 *
	 * @param usGestorFolderDPMId the us gestor folder dpm ID of this cds demand
	 */
	public void setUsGestorFolderDPMId(long usGestorFolderDPMId);

	/**
	 * Returns the us gestor folder dpm name of this cds demand.
	 *
	 * @return the us gestor folder dpm name of this cds demand
	 */
	@AutoEscape
	public String getUsGestorFolderDPMName();

	/**
	 * Sets the us gestor folder dpm name of this cds demand.
	 *
	 * @param usGestorFolderDPMName the us gestor folder dpm name of this cds demand
	 */
	public void setUsGestorFolderDPMName(String usGestorFolderDPMName);

	/**
	 * Returns the us dpm notification mail of this cds demand.
	 *
	 * @return the us dpm notification mail of this cds demand
	 */
	@AutoEscape
	public String getUsDPMNotificationMail();

	/**
	 * Sets the us dpm notification mail of this cds demand.
	 *
	 * @param usDPMNotificationMail the us dpm notification mail of this cds demand
	 */
	public void setUsDPMNotificationMail(String usDPMNotificationMail);

	/**
	 * Returns the bioe ID of this cds demand.
	 *
	 * @return the bioe ID of this cds demand
	 */
	@AutoEscape
	public String getBioeId();

	/**
	 * Sets the bioe ID of this cds demand.
	 *
	 * @param bioeId the bioe ID of this cds demand
	 */
	public void setBioeId(String bioeId);

	/**
	 * Returns the bioe state ID of this cds demand.
	 *
	 * @return the bioe state ID of this cds demand
	 */
	public short getBioeStateId();

	/**
	 * Sets the bioe state ID of this cds demand.
	 *
	 * @param bioeStateId the bioe state ID of this cds demand
	 */
	public void setBioeStateId(short bioeStateId);

	/**
	 * Returns the bioe state name of this cds demand.
	 *
	 * @return the bioe state name of this cds demand
	 */
	@AutoEscape
	public String getBioeStateName();

	/**
	 * Sets the bioe state name of this cds demand.
	 *
	 * @param bioeStateName the bioe state name of this cds demand
	 */
	public void setBioeStateName(String bioeStateName);

	/**
	 * Returns the work estimate of this cds demand.
	 *
	 * @return the work estimate of this cds demand
	 */
	public double getWorkEstimate();

	/**
	 * Sets the work estimate of this cds demand.
	 *
	 * @param workEstimate the work estimate of this cds demand
	 */
	public void setWorkEstimate(double workEstimate);

	/**
	 * Returns the accepted work estimate of this cds demand.
	 *
	 * @return the accepted work estimate of this cds demand
	 */
	public double getAcceptedWorkEstimate();

	/**
	 * Sets the accepted work estimate of this cds demand.
	 *
	 * @param acceptedWorkEstimate the accepted work estimate of this cds demand
	 */
	public void setAcceptedWorkEstimate(double acceptedWorkEstimate);

	/**
	 * Returns the expected delivery of this cds demand.
	 *
	 * @return the expected delivery of this cds demand
	 */
	public Date getExpectedDelivery();

	/**
	 * Sets the expected delivery of this cds demand.
	 *
	 * @param expectedDelivery the expected delivery of this cds demand
	 */
	public void setExpectedDelivery(Date expectedDelivery);

	/**
	 * Returns the accepted delivery of this cds demand.
	 *
	 * @return the accepted delivery of this cds demand
	 */
	public Date getAcceptedDelivery();

	/**
	 * Sets the accepted delivery of this cds demand.
	 *
	 * @param acceptedDelivery the accepted delivery of this cds demand
	 */
	public void setAcceptedDelivery(Date acceptedDelivery);

	/**
	 * Returns the group ID of this cds demand.
	 *
	 * @return the group ID of this cds demand
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this cds demand.
	 *
	 * @param groupId the group ID of this cds demand
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this cds demand.
	 *
	 * @return the company ID of this cds demand
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cds demand.
	 *
	 * @param companyId the company ID of this cds demand
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this cds demand.
	 *
	 * @return the user ID of this cds demand
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this cds demand.
	 *
	 * @param userId the user ID of this cds demand
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cds demand.
	 *
	 * @return the user uuid of this cds demand
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this cds demand.
	 *
	 * @param userUuid the user uuid of this cds demand
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this cds demand.
	 *
	 * @return the user name of this cds demand
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this cds demand.
	 *
	 * @param userName the user name of this cds demand
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this cds demand.
	 *
	 * @return the create date of this cds demand
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this cds demand.
	 *
	 * @param createDate the create date of this cds demand
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this cds demand.
	 *
	 * @return the modified date of this cds demand
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cds demand.
	 *
	 * @param modifiedDate the modified date of this cds demand
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the url title of this cds demand.
	 *
	 * @return the url title of this cds demand
	 */
	@AutoEscape
	public String getUrlTitle();

	/**
	 * Sets the url title of this cds demand.
	 *
	 * @param urlTitle the url title of this cds demand
	 */
	public void setUrlTitle(String urlTitle);

	/**
	 * Returns the state of this cds demand.
	 *
	 * @return the state of this cds demand
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this cds demand.
	 *
	 * @param state the state of this cds demand
	 */
	public void setState(String state);

	/**
	 * Returns the state by user ID of this cds demand.
	 *
	 * @return the state by user ID of this cds demand
	 */
	public long getStateByUserId();

	/**
	 * Sets the state by user ID of this cds demand.
	 *
	 * @param stateByUserId the state by user ID of this cds demand
	 */
	public void setStateByUserId(long stateByUserId);

	/**
	 * Returns the state by user uuid of this cds demand.
	 *
	 * @return the state by user uuid of this cds demand
	 */
	public String getStateByUserUuid();

	/**
	 * Sets the state by user uuid of this cds demand.
	 *
	 * @param stateByUserUuid the state by user uuid of this cds demand
	 */
	public void setStateByUserUuid(String stateByUserUuid);

	/**
	 * Returns the state by user name of this cds demand.
	 *
	 * @return the state by user name of this cds demand
	 */
	@AutoEscape
	public String getStateByUserName();

	/**
	 * Sets the state by user name of this cds demand.
	 *
	 * @param stateByUserName the state by user name of this cds demand
	 */
	public void setStateByUserName(String stateByUserName);

	/**
	 * Returns the state date of this cds demand.
	 *
	 * @return the state date of this cds demand
	 */
	public Date getStateDate();

	/**
	 * Sets the state date of this cds demand.
	 *
	 * @param stateDate the state date of this cds demand
	 */
	public void setStateDate(Date stateDate);

	@Override
	public CdsDemand cloneWithOriginalValues();

}