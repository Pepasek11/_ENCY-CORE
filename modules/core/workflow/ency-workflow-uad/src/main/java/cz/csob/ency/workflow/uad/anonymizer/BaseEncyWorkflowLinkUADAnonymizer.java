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

package cz.csob.ency.workflow.uad.anonymizer;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.user.associated.data.anonymizer.DynamicQueryUADAnonymizer;

import cz.csob.ency.workflow.model.EncyWorkflowLink;
import cz.csob.ency.workflow.service.EncyWorkflowLinkLocalService;
import cz.csob.ency.workflow.uad.constants.EncyWorkflowUADConstants;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the ency workflow link UAD anonymizer.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link cz.csob.ency.workflow.uad.anonymizer.EncyWorkflowLinkUADAnonymizer}.
 * </p>
 *
 * @author Miroslav Čermák
 * @generated
 */
public abstract class BaseEncyWorkflowLinkUADAnonymizer
	extends DynamicQueryUADAnonymizer<EncyWorkflowLink> {

	@Override
	public void autoAnonymize(
			EncyWorkflowLink encyWorkflowLink, long userId, User anonymousUser)
		throws PortalException {

		if (encyWorkflowLink.getUserId() == userId) {
			encyWorkflowLink.setUserId(anonymousUser.getUserId());
			encyWorkflowLink.setUserName(anonymousUser.getFullName());

			autoAnonymizeAssetEntry(encyWorkflowLink, anonymousUser);
		}

		encyWorkflowLinkLocalService.updateEncyWorkflowLink(encyWorkflowLink);
	}

	@Override
	public void delete(EncyWorkflowLink encyWorkflowLink)
		throws PortalException {

		encyWorkflowLinkLocalService.deleteEncyWorkflowLink(encyWorkflowLink);
	}

	@Override
	public Class<EncyWorkflowLink> getTypeClass() {
		return EncyWorkflowLink.class;
	}

	protected void autoAnonymizeAssetEntry(
		EncyWorkflowLink encyWorkflowLink, User anonymousUser) {

		AssetEntry assetEntry = fetchAssetEntry(encyWorkflowLink);

		if (assetEntry != null) {
			assetEntry.setUserId(anonymousUser.getUserId());
			assetEntry.setUserName(anonymousUser.getFullName());

			assetEntryLocalService.updateAssetEntry(assetEntry);
		}
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return encyWorkflowLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return EncyWorkflowUADConstants.USER_ID_FIELD_NAMES_ENCY_WORKFLOW_LINK;
	}

	protected AssetEntry fetchAssetEntry(EncyWorkflowLink encyWorkflowLink) {
		return assetEntryLocalService.fetchEntry(
			EncyWorkflowLink.class.getName(),
			encyWorkflowLink.getWorkflowLinkId());
	}

	@Reference
	protected AssetEntryLocalService assetEntryLocalService;

	@Reference
	protected EncyWorkflowLinkLocalService encyWorkflowLinkLocalService;

}