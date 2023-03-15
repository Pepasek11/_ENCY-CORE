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

package cz.csob.ency.cds.demands.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import cz.csob.ency.cds.demands.model.CdsDemandVersion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CdsDemandVersion in entity cache.
 *
 * @author Miroslav Čermák
 * @generated
 */
public class CdsDemandVersionCacheModel
	implements CacheModel<CdsDemandVersion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CdsDemandVersionCacheModel)) {
			return false;
		}

		CdsDemandVersionCacheModel cdsDemandVersionCacheModel =
			(CdsDemandVersionCacheModel)object;

		if (cdsDemandVersionId ==
				cdsDemandVersionCacheModel.cdsDemandVersionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cdsDemandVersionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(101);

		sb.append("{cdsDemandVersionId=");
		sb.append(cdsDemandVersionId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", demandId=");
		sb.append(demandId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", type=");
		sb.append(type);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", requestedDelivery=");
		sb.append(requestedDelivery);
		sb.append(", isGDPR=");
		sb.append(isGDPR);
		sb.append(", gdprInfo=");
		sb.append(gdprInfo);
		sb.append(", fiveTracks=");
		sb.append(fiveTracks);
		sb.append(", requestorId=");
		sb.append(requestorId);
		sb.append(", requestorName=");
		sb.append(requestorName);
		sb.append(", requestedForId=");
		sb.append(requestedForId);
		sb.append(", requestedForName=");
		sb.append(requestedForName);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", contactName=");
		sb.append(contactName);
		sb.append(", domainId=");
		sb.append(domainId);
		sb.append(", domainName=");
		sb.append(domainName);
		sb.append(", banId=");
		sb.append(banId);
		sb.append(", banName=");
		sb.append(banName);
		sb.append(", spocId=");
		sb.append(spocId);
		sb.append(", spocName=");
		sb.append(spocName);
		sb.append(", usReasoning=");
		sb.append(usReasoning);
		sb.append(", usFrequencyOut=");
		sb.append(usFrequencyOut);
		sb.append(", usAccessDPM=");
		sb.append(usAccessDPM);
		sb.append(", usFolderDPM=");
		sb.append(usFolderDPM);
		sb.append(", usCreateFolderDPM=");
		sb.append(usCreateFolderDPM);
		sb.append(", usGestorFolderDPMId=");
		sb.append(usGestorFolderDPMId);
		sb.append(", usGestorFolderDPMName=");
		sb.append(usGestorFolderDPMName);
		sb.append(", usDPMNotificationMail=");
		sb.append(usDPMNotificationMail);
		sb.append(", bioeId=");
		sb.append(bioeId);
		sb.append(", bioeStateId=");
		sb.append(bioeStateId);
		sb.append(", bioeStateName=");
		sb.append(bioeStateName);
		sb.append(", workEstimate=");
		sb.append(workEstimate);
		sb.append(", acceptedWorkEstimate=");
		sb.append(acceptedWorkEstimate);
		sb.append(", expectedDelivery=");
		sb.append(expectedDelivery);
		sb.append(", acceptedDelivery=");
		sb.append(acceptedDelivery);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", urlTitle=");
		sb.append(urlTitle);
		sb.append(", state=");
		sb.append(state);
		sb.append(", stateByUserId=");
		sb.append(stateByUserId);
		sb.append(", stateByUserName=");
		sb.append(stateByUserName);
		sb.append(", stateDate=");
		sb.append(stateDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CdsDemandVersion toEntityModel() {
		CdsDemandVersionImpl cdsDemandVersionImpl = new CdsDemandVersionImpl();

		cdsDemandVersionImpl.setCdsDemandVersionId(cdsDemandVersionId);
		cdsDemandVersionImpl.setVersion(version);

		if (uuid == null) {
			cdsDemandVersionImpl.setUuid("");
		}
		else {
			cdsDemandVersionImpl.setUuid(uuid);
		}

		cdsDemandVersionImpl.setDemandId(demandId);

		if (title == null) {
			cdsDemandVersionImpl.setTitle("");
		}
		else {
			cdsDemandVersionImpl.setTitle(title);
		}

		if (description == null) {
			cdsDemandVersionImpl.setDescription("");
		}
		else {
			cdsDemandVersionImpl.setDescription(description);
		}

		cdsDemandVersionImpl.setType(type);
		cdsDemandVersionImpl.setPriority(priority);

		if (requestedDelivery == Long.MIN_VALUE) {
			cdsDemandVersionImpl.setRequestedDelivery(null);
		}
		else {
			cdsDemandVersionImpl.setRequestedDelivery(
				new Date(requestedDelivery));
		}

		cdsDemandVersionImpl.setIsGDPR(isGDPR);

		if (gdprInfo == null) {
			cdsDemandVersionImpl.setGdprInfo("");
		}
		else {
			cdsDemandVersionImpl.setGdprInfo(gdprInfo);
		}

		if (fiveTracks == null) {
			cdsDemandVersionImpl.setFiveTracks("");
		}
		else {
			cdsDemandVersionImpl.setFiveTracks(fiveTracks);
		}

		cdsDemandVersionImpl.setRequestorId(requestorId);

		if (requestorName == null) {
			cdsDemandVersionImpl.setRequestorName("");
		}
		else {
			cdsDemandVersionImpl.setRequestorName(requestorName);
		}

		cdsDemandVersionImpl.setRequestedForId(requestedForId);

		if (requestedForName == null) {
			cdsDemandVersionImpl.setRequestedForName("");
		}
		else {
			cdsDemandVersionImpl.setRequestedForName(requestedForName);
		}

		cdsDemandVersionImpl.setContactId(contactId);

		if (contactName == null) {
			cdsDemandVersionImpl.setContactName("");
		}
		else {
			cdsDemandVersionImpl.setContactName(contactName);
		}

		cdsDemandVersionImpl.setDomainId(domainId);

		if (domainName == null) {
			cdsDemandVersionImpl.setDomainName("");
		}
		else {
			cdsDemandVersionImpl.setDomainName(domainName);
		}

		cdsDemandVersionImpl.setBanId(banId);

		if (banName == null) {
			cdsDemandVersionImpl.setBanName("");
		}
		else {
			cdsDemandVersionImpl.setBanName(banName);
		}

		cdsDemandVersionImpl.setSpocId(spocId);

		if (spocName == null) {
			cdsDemandVersionImpl.setSpocName("");
		}
		else {
			cdsDemandVersionImpl.setSpocName(spocName);
		}

		if (usReasoning == null) {
			cdsDemandVersionImpl.setUsReasoning("");
		}
		else {
			cdsDemandVersionImpl.setUsReasoning(usReasoning);
		}

		cdsDemandVersionImpl.setUsFrequencyOut(usFrequencyOut);
		cdsDemandVersionImpl.setUsAccessDPM(usAccessDPM);

		if (usFolderDPM == null) {
			cdsDemandVersionImpl.setUsFolderDPM("");
		}
		else {
			cdsDemandVersionImpl.setUsFolderDPM(usFolderDPM);
		}

		cdsDemandVersionImpl.setUsCreateFolderDPM(usCreateFolderDPM);
		cdsDemandVersionImpl.setUsGestorFolderDPMId(usGestorFolderDPMId);

		if (usGestorFolderDPMName == null) {
			cdsDemandVersionImpl.setUsGestorFolderDPMName("");
		}
		else {
			cdsDemandVersionImpl.setUsGestorFolderDPMName(
				usGestorFolderDPMName);
		}

		if (usDPMNotificationMail == null) {
			cdsDemandVersionImpl.setUsDPMNotificationMail("");
		}
		else {
			cdsDemandVersionImpl.setUsDPMNotificationMail(
				usDPMNotificationMail);
		}

		if (bioeId == null) {
			cdsDemandVersionImpl.setBioeId("");
		}
		else {
			cdsDemandVersionImpl.setBioeId(bioeId);
		}

		cdsDemandVersionImpl.setBioeStateId(bioeStateId);

		if (bioeStateName == null) {
			cdsDemandVersionImpl.setBioeStateName("");
		}
		else {
			cdsDemandVersionImpl.setBioeStateName(bioeStateName);
		}

		cdsDemandVersionImpl.setWorkEstimate(workEstimate);
		cdsDemandVersionImpl.setAcceptedWorkEstimate(acceptedWorkEstimate);

		if (expectedDelivery == Long.MIN_VALUE) {
			cdsDemandVersionImpl.setExpectedDelivery(null);
		}
		else {
			cdsDemandVersionImpl.setExpectedDelivery(
				new Date(expectedDelivery));
		}

		if (acceptedDelivery == Long.MIN_VALUE) {
			cdsDemandVersionImpl.setAcceptedDelivery(null);
		}
		else {
			cdsDemandVersionImpl.setAcceptedDelivery(
				new Date(acceptedDelivery));
		}

		cdsDemandVersionImpl.setGroupId(groupId);
		cdsDemandVersionImpl.setCompanyId(companyId);
		cdsDemandVersionImpl.setUserId(userId);

		if (userName == null) {
			cdsDemandVersionImpl.setUserName("");
		}
		else {
			cdsDemandVersionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cdsDemandVersionImpl.setCreateDate(null);
		}
		else {
			cdsDemandVersionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cdsDemandVersionImpl.setModifiedDate(null);
		}
		else {
			cdsDemandVersionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (urlTitle == null) {
			cdsDemandVersionImpl.setUrlTitle("");
		}
		else {
			cdsDemandVersionImpl.setUrlTitle(urlTitle);
		}

		if (state == null) {
			cdsDemandVersionImpl.setState("");
		}
		else {
			cdsDemandVersionImpl.setState(state);
		}

		cdsDemandVersionImpl.setStateByUserId(stateByUserId);

		if (stateByUserName == null) {
			cdsDemandVersionImpl.setStateByUserName("");
		}
		else {
			cdsDemandVersionImpl.setStateByUserName(stateByUserName);
		}

		if (stateDate == Long.MIN_VALUE) {
			cdsDemandVersionImpl.setStateDate(null);
		}
		else {
			cdsDemandVersionImpl.setStateDate(new Date(stateDate));
		}

		cdsDemandVersionImpl.resetOriginalValues();

		return cdsDemandVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cdsDemandVersionId = objectInput.readLong();

		version = objectInput.readInt();
		uuid = objectInput.readUTF();

		demandId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		type = objectInput.readInt();

		priority = objectInput.readInt();
		requestedDelivery = objectInput.readLong();

		isGDPR = objectInput.readBoolean();
		gdprInfo = objectInput.readUTF();
		fiveTracks = objectInput.readUTF();

		requestorId = objectInput.readLong();
		requestorName = objectInput.readUTF();

		requestedForId = objectInput.readLong();
		requestedForName = objectInput.readUTF();

		contactId = objectInput.readLong();
		contactName = objectInput.readUTF();

		domainId = objectInput.readLong();
		domainName = objectInput.readUTF();

		banId = objectInput.readLong();
		banName = objectInput.readUTF();

		spocId = objectInput.readLong();
		spocName = objectInput.readUTF();
		usReasoning = objectInput.readUTF();

		usFrequencyOut = objectInput.readInt();

		usAccessDPM = objectInput.readBoolean();
		usFolderDPM = objectInput.readUTF();

		usCreateFolderDPM = objectInput.readBoolean();

		usGestorFolderDPMId = objectInput.readLong();
		usGestorFolderDPMName = objectInput.readUTF();
		usDPMNotificationMail = objectInput.readUTF();
		bioeId = objectInput.readUTF();

		bioeStateId = objectInput.readShort();
		bioeStateName = objectInput.readUTF();

		workEstimate = objectInput.readDouble();

		acceptedWorkEstimate = objectInput.readDouble();
		expectedDelivery = objectInput.readLong();
		acceptedDelivery = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		urlTitle = objectInput.readUTF();
		state = objectInput.readUTF();

		stateByUserId = objectInput.readLong();
		stateByUserName = objectInput.readUTF();
		stateDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(cdsDemandVersionId);

		objectOutput.writeInt(version);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(demandId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(type);

		objectOutput.writeInt(priority);
		objectOutput.writeLong(requestedDelivery);

		objectOutput.writeBoolean(isGDPR);

		if (gdprInfo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gdprInfo);
		}

		if (fiveTracks == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fiveTracks);
		}

		objectOutput.writeLong(requestorId);

		if (requestorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestorName);
		}

		objectOutput.writeLong(requestedForId);

		if (requestedForName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestedForName);
		}

		objectOutput.writeLong(contactId);

		if (contactName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactName);
		}

		objectOutput.writeLong(domainId);

		if (domainName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(domainName);
		}

		objectOutput.writeLong(banId);

		if (banName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(banName);
		}

		objectOutput.writeLong(spocId);

		if (spocName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spocName);
		}

		if (usReasoning == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(usReasoning);
		}

		objectOutput.writeInt(usFrequencyOut);

		objectOutput.writeBoolean(usAccessDPM);

		if (usFolderDPM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(usFolderDPM);
		}

		objectOutput.writeBoolean(usCreateFolderDPM);

		objectOutput.writeLong(usGestorFolderDPMId);

		if (usGestorFolderDPMName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(usGestorFolderDPMName);
		}

		if (usDPMNotificationMail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(usDPMNotificationMail);
		}

		if (bioeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bioeId);
		}

		objectOutput.writeShort(bioeStateId);

		if (bioeStateName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bioeStateName);
		}

		objectOutput.writeDouble(workEstimate);

		objectOutput.writeDouble(acceptedWorkEstimate);
		objectOutput.writeLong(expectedDelivery);
		objectOutput.writeLong(acceptedDelivery);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (urlTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(urlTitle);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeLong(stateByUserId);

		if (stateByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stateByUserName);
		}

		objectOutput.writeLong(stateDate);
	}

	public long cdsDemandVersionId;
	public int version;
	public String uuid;
	public long demandId;
	public String title;
	public String description;
	public int type;
	public int priority;
	public long requestedDelivery;
	public boolean isGDPR;
	public String gdprInfo;
	public String fiveTracks;
	public long requestorId;
	public String requestorName;
	public long requestedForId;
	public String requestedForName;
	public long contactId;
	public String contactName;
	public long domainId;
	public String domainName;
	public long banId;
	public String banName;
	public long spocId;
	public String spocName;
	public String usReasoning;
	public int usFrequencyOut;
	public boolean usAccessDPM;
	public String usFolderDPM;
	public boolean usCreateFolderDPM;
	public long usGestorFolderDPMId;
	public String usGestorFolderDPMName;
	public String usDPMNotificationMail;
	public String bioeId;
	public short bioeStateId;
	public String bioeStateName;
	public double workEstimate;
	public double acceptedWorkEstimate;
	public long expectedDelivery;
	public long acceptedDelivery;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String urlTitle;
	public String state;
	public long stateByUserId;
	public String stateByUserName;
	public long stateDate;

}