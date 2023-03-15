package cz.csob.ency.cds.demands.web.internal.upload;
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


import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UploadFileEntryHandler;
import cz.csob.ency.cds.demands.configuration.CdsDemandsConfiguration;
import cz.csob.ency.cds.demands.constants.CdsDemandConstants;
import cz.csob.ency.cds.demands.model.CdsDemand;
import cz.csob.ency.cds.demands.service.CdsDemandLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component(service = CdsDemandUploadFileEntryHandler.class)
public class CdsDemandUploadFileEntryHandler implements UploadFileEntryHandler {
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandUploadFileEntryHandler.class);

    @Override
    public FileEntry upload(UploadPortletRequest uploadPortletRequest)
            throws IOException, PortalException {

        // _log.warn("in upload");
        File file = null;

        try (InputStream inputStream = uploadPortletRequest.getFileAsStream(
                "file")) {

            long entryId = ParamUtil.getLong(
                    uploadPortletRequest, "resourcePrimKey");

            file = FileUtil.createTempFile(inputStream);

            String fileName = uploadPortletRequest.getFileName("file");

            _uploadValidator.validateFileSize(file, fileName);

            _uploadValidator.validateFileExtension(fileName);

            ThemeDisplay themeDisplay =
                    (ThemeDisplay) uploadPortletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);

            long groupId = themeDisplay.getScopeGroupId();
            long defaultUserId = themeDisplay.getDefaultUserId();
            long userId = themeDisplay.getUserId();

            Folder folder =
                    _ddsDemandLocalService.getAttachmentsFolder(defaultUserId, groupId, entryId);

            return addFileEntry(
                    entryId, userId, groupId, folder.getFolderId(), file, fileName,
                    MimeTypesUtil.getContentType(file, fileName), themeDisplay);
        } finally {
            FileUtil.delete(file);
        }

    }

    protected FileEntry addFileEntry(
            long entryId, long userId, long groupId, long folderId, File file,
            String fileName, String mimeType, ThemeDisplay themeDisplay)
            throws PortalException {

        /*
        @todo permissions
        if (!DDMFormInstancePermission.contains(
                themeDisplay.getPermissionChecker(), entryId,
                DDMActionKeys.ADD_FORM_INSTANCE_RECORD)) {

            throw new PrincipalException.MustHavePermission(
                    themeDisplay.getPermissionChecker(),
                    DDMFormInstance.class.getName(), entryId,
                    DDMActionKeys.ADD_FORM_INSTANCE_RECORD);
        }
         */

        String uniqueFileName = PortletFileRepositoryUtil.getUniqueFileName(
                groupId, folderId, fileName);

        //_log.warn("to finish");
        return PortletFileRepositoryUtil.addPortletFileEntry(
                groupId, userId, CdsDemand.class.getName(), 0,
                CdsDemandConstants.SERVICE_NAME, folderId, file, uniqueFileName,
                mimeType, false);
    }
    @Reference
    private CdsDemandLocalService _ddsDemandLocalService;
    @Reference
    private CdsDemandUploadValidator _uploadValidator;

}