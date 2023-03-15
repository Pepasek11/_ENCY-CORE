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

package cz.csob.ency.workflow.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.workflow.exception.InvalidEncyWorkflowLinkException;
import cz.csob.ency.workflow.util.WorkflowHelperUtils;
import cz.csob.ency.workflow.model.EncyWorkflow;
import cz.csob.ency.workflow.model.EncyWorkflowLink;
import cz.csob.ency.workflow.service.EncyWorkflowLocalService;
import cz.csob.ency.workflow.service.base.EncyWorkflowLinkLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * @author Miroslav Čermák
 */
@Component(
        property = "model.class.name=cz.csob.ency.workflow.model.EncyWorkflowLink",
        service = AopService.class
)
public class EncyWorkflowLinkLocalServiceImpl
        extends EncyWorkflowLinkLocalServiceBaseImpl {

    private static final Log _log = LogFactoryUtil.getLog(
            EncyWorkflowLinkLocalServiceImpl.class);

    /**
     * Adds new workflow link, if there isn't yet.
     *
     * @param groupId
     * @param companyId
     * @param userId
     * @param targetClassName
     * @param folderClassName
     * @param folderPk
     * @param workflowClassName
     * @return
     * @throws InvalidEncyWorkflowLinkException
     */
    @Override
    public EncyWorkflowLink addWorkflowLink(
            long groupId, long companyId, long userId, String targetClassName, String folderClassName,
            long folderPk, String workflowClassName)
            throws InvalidEncyWorkflowLinkException {

        if (Validator.isBlank(workflowClassName)) {
            throw new InvalidEncyWorkflowLinkException(
                    "Workflow Class name can not be empty.");
        }

        EncyWorkflow workflowEntry =
                _encyWorkflowLocalService.fetchEncyWorkflow(workflowClassName);

        if (Validator.isNull(workflowEntry)) {
            throw new InvalidEncyWorkflowLinkException(
                    "Workflow " + workflowClassName + " could not be found.");
        }

        return addWorkflowLink(
                groupId, companyId, userId, targetClassName, folderClassName,
                folderPk, workflowEntry.getWorkflowId());

    }

    /**
     * Adds new workflow link, if there isn't yet.
     *
     * @param groupId
     * @param companyId
     * @param userId
     * @param targetClassName
     * @param folderClassName
     * @param folderPk
     * @param workflowId
     * @return
     * @throws InvalidEncyWorkflowLinkException
     */
    @Override
    public EncyWorkflowLink addWorkflowLink(
            long groupId, long companyId, long userId, String targetClassName,
            String folderClassName, long folderPk, long workflowId)
            throws InvalidEncyWorkflowLinkException {

        if (workflowId <= 0) {
            throw new InvalidEncyWorkflowLinkException("Invalid workflow id " + workflowId);
        }

        EncyWorkflowLink link =
                fetchWorkflowLink(groupId, companyId, targetClassName, folderClassName, folderPk);

        if (link != null) {
            // Link is already registered, check that it is for same workflow.
            if (workflowId == link.getWorkflowId()) {
                return link;
            }

            throw new InvalidEncyWorkflowLinkException("Trying to redefine existing link.");
        }

        if (Validator.isBlank(targetClassName)) {
            throw new InvalidEncyWorkflowLinkException("Target Class name can not be empty.");
        }

        if ((!Validator.isBlank(folderClassName) && folderPk == 0)
                || (Validator.isBlank(folderClassName) && folderPk != 0)) {
            throw new InvalidEncyWorkflowLinkException(
                    "Folder class name and folder id must be both set or be both unset.");
        }

        link = create();

        link.setCompanyId(companyId);
        link.setGroupId(groupId);
        link.setClassName(targetClassName);
        link.setFolderClassName(folderClassName);
        link.setFolderPK(folderPk);

        link.setCreateDate(new Date());
        link.setModifiedDate(new Date());
        link.setUserId(userId);
        link.setUserName(WorkflowHelperUtils.getUserName(userId));

        link.setWorkflowId(workflowId);

        EncyWorkflowLink updatedLink =
                encyWorkflowLinkPersistence.update(link);

        return updatedLink;
    }

    @Override
    public EncyWorkflowLink create() {
        long id = counterLocalService.increment(EncyWorkflowLink.class.getName());
        return encyWorkflowLinkPersistence.create(id);
    }

    /**
     * Fetch workflow definition for given parameters.
     *
     * @param groupId         WD applicable for given group. 0 for all groups
     * @param companyId       WD applicable for given company. 0 for all comapnies
     * @param className       WD applicable  for given model defind by className.
     *                        Class Name is mandatory as we do not allow workflow for all models.
     * @param folderClassName WD applicable for entries in folder defined by @folderClassName and @folderPK
     * @param folderPk
     * @return
     */
    public EncyWorkflowLink fetchWorkflowLink(
            long groupId, long companyId, String className, String folderClassName, long folderPk) {

        List<EncyWorkflowLink> links = encyWorkflowLinkPersistence.findByG_C_C_F_F(
                new long[]{0, groupId},
                new long[]{0, companyId},
                className,
                new String[]{null, folderClassName},
                new long[]{0, folderPk}
        );

        if (links.size() == 0) {
            return null;
        }

        EncyWorkflowLink link = null;

        // find most specific definition
        for (EncyWorkflowLink _link : links) {
            if(link == null) {
                link = _link;
                continue;
            }

            if (_link.getGroupId() == 0) {
                continue;
            }
            if (link.getGroupId() == 0) {
                link = _link;
                continue;
            }
            if (_link.getCompanyId() == 0) {
                continue;
            }
            if (link.getCompanyId() == 0) {
                link = _link;
                continue;
            }
            if (Validator.isBlank(_link.getFolderClassName())
                    && _link.getFolderPK() == 0) {
                continue;
            }
            if (Validator.isBlank(link.getFolderClassName())
                    && link.getFolderPK() == 0) {
                link = _link;
                continue;
            }
        }

        return link;
    }

    @Reference
    private EncyWorkflowLocalService _encyWorkflowLocalService;
}