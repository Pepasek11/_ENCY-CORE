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

import ClayCard from '@clayui/card';
import {ClayInput} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import ClayProgressBar from '@clayui/progress-bar';
import axios from 'axios';
import {convertToFormData,} from 'data-engine-js-components-web';
import React, {useContext, useEffect, useState} from 'react';
import {AppContext} from "../AppContext.es";
import {dateToInternationalHuman} from "../utils/utils.es";
import {sub} from "../utils/lang.es";
import {ErrorBoundary} from "./ErrorBoundary.es";
import {openToast,} from 'frontend-js-web';
import constants from "../constants/constants.es";
import {lang} from "../constants/lang.es";

const dummyFunction = () => {
};

const CardItem = (
    {
        author,
        deleteCallback = dummyFunction,
        fileEntryId,
        fileEntryTitle,
        fileEntryURL,
        modified,
        canDelete
    }) => {


    const handleDeleteButtonClicked = () => {
        if (!confirm(sub(lang.attachments.deleteconfirmation, [fileEntryTitle]))) {
            return;
        }

        Liferay.Service(
            constants.services.attachments.deleteattachment,
            {
                fileEntryId: fileEntryId
            },
            function ({success, error, message, data}) {
                if (success === true) {
                    openToast({
                        message: sub(lang.attachments.deletesuccess, [fileEntryTitle]),
                        title: lang.success,
                        type: 'success',
                    });
                    deleteCallback();
                } else {
                    openToast({
                        message: message,
                        title: lang.error,
                        type: 'danger'
                    })
                }
            });
    }

    return (
        <ClayCard horizontal>
            <ClayCard.Body>
                <ClayCard.Row>
                    <div className="autofit-col autofit-col-expand">
                        <section className="autofit-section">
                            <ClayCard.Description displayType="title">
                                <a download={fileEntryTitle} href={fileEntryURL}
                                   title={fileEntryTitle}>{fileEntryTitle}</a>
                            </ClayCard.Description>
                            <ClayCard.Description displayType="subtitle">
                                {author}
                            </ClayCard.Description>
                            <ClayCard.Caption>
                                {modified}
                            </ClayCard.Caption>
                        </section>
                    </div>
                </ClayCard.Row>
                <ClayCard.Row>
                    <div className="card-col-field">
                        <a download={fileEntryTitle} href={fileEntryURL}>
                            <ClayIcon symbol="download"/>
                        </a>
                        {!!canDelete &&
                        <a onClick={(e) => handleDeleteButtonClicked()}>
                            <ClayIcon symbol="trash"/>
                        </a>
                        }
                    </div>
                </ClayCard.Row>
            </ClayCard.Body>
        </ClayCard>
    );
};

const UploadFile = (
    {
        id,
        message,
        name,
        onUploadSelectButtonClicked,
        placeholder,
        progress,
        readOnly,
    }) => {

    return (
        <div className="liferay-ddm-form-field-document-library">
            <ClayCard displayType="file">
                <ClayCard.Body>
                    <ClayCard.Row>
                        <div className="autofit-col autofit-col-expand">
                            <section className="autofit-section text-center">
                                <ClayInput.GroupItem append shrink>
                                    <label
                                        className={
                                            'btn btn-secondary select-button' +
                                            (readOnly ? ' disabled' : '')
                                        }
                                        htmlFor={`${name}fileUpload`}
                                    >
                                        <ClayIcon symbol="upload"/> {lang.attachments.selectFile}
                                    </label>

                                    <input
                                        className="input-file"
                                        disabled={readOnly}
                                        id={`${name}fileUpload`}
                                        onChange={onUploadSelectButtonClicked}
                                        type="file"
                                    />
                                </ClayInput.GroupItem>
                                {progress !== 0 && <ClayProgressBar value={progress}/>}
                            </section>
                        </div>
                    </ClayCard.Row>
                </ClayCard.Body>
            </ClayCard>

            {message && <div className="form-feedback-item">{message}</div>}
        </div>
    );
};

const Main = (
    {
        allowGuestUsers = false,
        entryId,
        id,
        maximumSubmissionLimitReached,
        message,
        name,
        onBlur = dummyFunction,
        onChange,
        onFocus = dummyFunction,
        placeholder,
        readOnly,
        showUploadPermissionMessage,
        ...otherProps
    }) => {
    const context = useContext(AppContext);
    const portletNamespace = context.namespace;
    const guestUploadURL = context.urls.uploadAction;

    const [selectedFiles, setSelectedFiles] = useState([]);
    const [progress, setProgress] = useState(0);

    const isSignedIn = Liferay.ThemeDisplay.isSignedIn();

    const [attachments, setAttachments] = useState([]);

    const [loading, setLoading] = useState(true);

    useEffect(() => {
        if ((!allowGuestUsers && !isSignedIn) || showUploadPermissionMessage) {
            const ddmFormUploadPermissionMessage = document.querySelector(
                `.ddm-form-upload-permission-message`
            );

            if (ddmFormUploadPermissionMessage) {
                ddmFormUploadPermissionMessage.classList.remove('hide');
            }
        }
    }, [allowGuestUsers, isSignedIn, showUploadPermissionMessage]);

    useEffect(() => {
        getAttachments();
    }, [entryId]);


    const isExceededUploadRequestSizeLimit = (fileSize) => {
        let uploadRequestSizeLimit =
            Liferay.PropsValues.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE;

        if(context.maxAttachmentFileSize>0) {
            uploadRequestSizeLimit = Math.min(context.maxAttachmentFileSize,uploadRequestSizeLimit);
        }

        if (fileSize <= uploadRequestSizeLimit) {
            return false;
        }

        const errorMessage = Liferay.Util.sub(lang.attachments.filetoolagre,
            [Liferay.Util.formatStorage(uploadRequestSizeLimit)]
        );

        openToast({
            message: errorMessage,
            title: lang.error,
            type: 'danger'
        })

        return true;
    };

    const getFileUrl = (fileEntryId, fileName, uuid) => {
        return `${Liferay.ThemeDisplay.getPortalURL()}/documents/portlet_file_entry/${fileEntryId}/${Liferay.Util.escape(fileName)}/${uuid}`
    }

    const getAttachments = () => {
        if (entryId) {
            setLoading(true)
            Liferay.Service(
                constants.services.attachments.getattachments,
                {
                    entryId: entryId
                },
                function ({success, error, message, data}) {
                    if (success === true) {
                        setAttachments(data);
                    }
                    setLoading(false);
                }
            );
        }
    }

    const handleUploadSelectButtonClicked = (event) => {
        onFocus(event);

        const file = event.target.files[0];

        if (isExceededUploadRequestSizeLimit(file.size)) {
            onBlur(event);
            return;
        }

        const data = {
            [`${portletNamespace}file`]: file,
            [`${portletNamespace}resourcePrimKey`]: entryId,

        };

        axios
            .post(guestUploadURL, convertToFormData(data), {
                onUploadProgress: (event) => {
                    const progress = Math.round(
                        (event.loaded * 100) / event.total
                    );

                    setProgress(progress);

                },
            })
            .then((response) => {
                const {data: {success, error, message, file}, status} = response;

                if (success === true) {
                    openToast({
                        message: sub(lang.attachments.addedSuccessfully, [file?.title]),
                        title: lang.success,
                        type: 'success',
                    });
                } else {
                    openToast({
                        message: message,
                        title: lang.error,
                        type: 'danger',
                    });
                }

                setProgress(0);
            })
            .catch((e) => {
                setProgress(0);
                openToast({
                    message: e,
                    title: lang.error,
                    type: 'error',
                });
            })
            .finally(() => {
                onBlur(event);
                getAttachments();
            });
    };

    const handleFileSelection = (value, fileEntryId) => {
        if (selectedFiles.includes(fileEntryId)) {
            setSelectedFiles(selectedFiles.filter(i => i != fileEntryId));
        } else {
            selectedFiles.push(fileEntryId);
            setSelectedFiles(selectedFiles.concat([fileEntryId]));
        }
    }

    const hasCustomError =
        (!isSignedIn && !allowGuestUsers) ||
        maximumSubmissionLimitReached ||
        showUploadPermissionMessage;

    return (
        <ErrorBoundary>
            <div className="sidebar-header">
                <p className="component-title h4">{lang.attachments.attachments}</p>
            </div>
            <div className="sidebar-body">
                {/*
                {selectedFiles.length > 0 &&
                <ClayManagementToolbar>
                    <ClayResultsBar>
                        <ClayResultsBar.Item expand>
                            {sub(Liferay.Language.get('x-items-selected'), [selectedFiles.length])}
                        </ClayResultsBar.Item>
                        <ClayResultsBar.Item expand>
                            {sub(Liferay.Language.get('x-items-selected'), [selectedFiles.length])}
                        </ClayResultsBar.Item>
                    </ClayResultsBar>
                </ClayManagementToolbar>
                }
                */}
                <ClayLayout.Row>
                    <ClayLayout.Col size={12}>
                        <UploadFile
                            id={id}
                            className={"upload-card"}
                            message={message}
                            name={name}
                            onBlur={onBlur}
                            onFocus={onFocus}
                            onUploadSelectButtonClicked={(event) =>
                                handleUploadSelectButtonClicked(event)
                            }
                            placeholder={placeholder}
                            progress={progress}
                            readOnly={hasCustomError || progress > 0 ? true : readOnly}
                        />
                    </ClayLayout.Col>
                </ClayLayout.Row>

                <ClayLayout.Row>
                    <ClayLayout.Col size={12}>
                        {loading && <ClayLoadingIndicator/>}
                        {
                            attachments
                            && typeof (attachments) === 'object'
                            && attachments.map(({
                                                   modifiedDate,
                                                   extension,
                                                   fileName,
                                                   groupId,
                                                   userName,
                                                   uuid,
                                                   fileEntryId
                                               }) =>

                                <CardItem
                                    author={userName || "-"}
                                    canDelete={true}
                                    deleteCallback={() => {
                                        getAttachments();
                                    }}
                                    fileEntryId={fileEntryId}
                                    fileEntryTitle={fileName}
                                    fileEntryURL={getFileUrl(groupId, fileName, uuid)}
                                    modified={dateToInternationalHuman(modifiedDate)}
                                />
                            )
                        }
                    </ClayLayout.Col>
                </ClayLayout.Row>

            </div>
        </ErrorBoundary>
    );
};

Main.displayName = 'AttachmentsSidebar';

export default Main;