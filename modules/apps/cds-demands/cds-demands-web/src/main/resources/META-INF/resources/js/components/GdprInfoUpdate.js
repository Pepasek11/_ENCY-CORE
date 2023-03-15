'use strict';
import ClayAlert from '@clayui/alert';
import ClayButton from '@clayui/button';
import ClayForm from '@clayui/form';
import ClayLabel from '@clayui/label';
import ClayList from '@clayui/list';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import ClayTable from '@clayui/table';

import {useFormik} from 'formik';
import {openToast} from 'frontend-js-web';
import React, {useContext, useEffect, useState} from "react";
import Select from 'react-select';

import {AppContext} from "../AppContext.es";
import constants from "../constants/constants.es";
import Modal from "./Modal.es";
import {lang} from "../constants/lang.es";
import {LabeledInput, LabeledToggle, LabelWrapper} from "./Components"
import {ErrorBoundary} from "./ErrorBoundary.es";
import {sub} from "../utils/lang.es";

;

const GdprInfoUpdate = (
    {
        callback = () => {
        },
        canEdit = false,
        demandId=null,
        modalData={},
        setModalData = () => {
        },
    }
) => {
    const visible = modalData !== null;
    const edit = !!modalData?.gdprInfoId


    const [categoryOptions, setCategoryOptions] = useState([])
    const [reasoningOptions, setReasoningOptions] = useState([])

    const resourcePrimKeyId = `gdprInfoId`;
    const demandIdId = `demandId`;
    const titleId = `title`;
    const descriptionId = `description`;
    const isClientId = `isClient`;
    const isEmployeeId = `isEmployee`;
    const employeeCategoryId = `employeeCategory`;
    const employeeReasoningId = `employeeReasoning`;
    const clientCategoryId = `clientCategory`;
    const clientReasoningId = `clientReasoning`;

    useEffect(() => {
        Liferay.Service(
            constants.services.getcstcategoryoptions,
            {},
            function (obj) {
                if (obj && obj.success) {
                    setCategoryOptions(obj.data);
                }
            }
        );
        Liferay.Service(
            constants.services.getcstreasoningoptions,
            {},
            function (obj) {
                if (obj && obj.success) {
                    setReasoningOptions(obj.data);
                }
            }
        );
    }, [])

    const formik = useFormik({
        initialValues: {
            [resourcePrimKeyId]: modalData ? Number(modalData?.gdprInfoId) : 0,
            [demandIdId]: demandId,
            [titleId]: modalData ? modalData[titleId] : "",
            [descriptionId]: modalData ? modalData[descriptionId] : "",
            [isClientId]: modalData ? modalData[isClientId] : false,
            [isEmployeeId]: modalData ? modalData[isEmployeeId] : false,
            [clientCategoryId]: modalData ? modalData[clientCategoryId] : [],
            [clientReasoningId]: modalData ? modalData[clientReasoningId] : [],
            [employeeCategoryId]: modalData ? modalData[employeeCategoryId] : [],
            [employeeReasoningId]: modalData ? modalData[employeeReasoningId] : [],
        },
        enableReinitialize: true,
        onSubmit: (values) => {
            Liferay.Service(
                constants.services.gdprinfo.update,
                {
                    values: values,
                },
                function (obj) {
                    if (obj && obj?.success) {
                        openToast({
                            message: obj?.message,
                            title: lang.success,
                            type: 'success',
                        });
                        setModalData(null);
                        callback();
                    } else {
                        openToast({
                            message: obj?.message ||
                                Liferay.Language.get('an-unexpected-error-occurred'),
                            title: lang.error,
                            type: 'danger',
                        });
                    }
                }
            );
        },
        validate: (values) => {
            const errs = {};

            [
                {field: titleId, error: lang.gdprinfo.titleRequired},
                {field: descriptionId, error: lang.gdprinfo.descriptionRequired},
            ].forEach(({field, error}) => {
                if (!values[field]) {
                    errs[field] = error;
                }
            });

            return errs;
        }

    });


    const {
        errors,
        handleBlur,
        handleChange,
        setFieldValue,
        touched,
        values,
        handleSubmit,
    } = formik;

    if (!demandId || !visible) {
        return <></>;
    }

    return (
        <ErrorBoundary>
            <Modal
                title={edit?lang.gdprinfo.add:lang.gdprinfo.edit}
                visible={visible}
                onClose={() => setModalData(null)}
                status="info"
                callback={handleSubmit}
                textPrimaryButton={edit?lang.save:lang.add}
                textSecondaryButton={lang.cancel}
                body={
                    <ClayForm onSubmit={formik.handleSubmit}>
                        <input type={"hidden"} name={demandIdId} value={values[demandIdId]}/>
                        <input type={"hidden"} name={resourcePrimKeyId}
                               value={values[resourcePrimKeyId]}/>
                        <LabeledInput
                            error={touched[titleId] && errors[titleId]}
                            label={lang.gdprinfo.title}
                            type={"input"}
                            id={titleId}
                            name={titleId}
                            onBlur={handleBlur}
                            onChange={handleChange}
                            value={values[titleId]}
                            required={true}
                        />
                        <LabeledInput
                            error={touched[descriptionId] && errors[descriptionId]}
                            label={lang.gdprinfo.description}
                            component="textarea"
                            id={descriptionId}
                            name={descriptionId}
                            placeholder={lang.gdprinfo.descriptionplchldr}
                            onBlur={handleBlur}
                            onChange={handleChange}
                            value={values[descriptionId]}
                            required={true}
                        />
                        <LabeledToggle
                            label={lang.gdprinfo.isclient}
                            id={isClientId}
                            name={isClientId}
                            onBlur={handleBlur}
                            onChange={handleChange}
                            toggled={values[isClientId]}
                        />
                        {values[isClientId] &&
                        <>
                            <LabelWrapper
                                label={lang.gdprinfo.category}
                                error={touched[clientCategoryId] && errors[clientCategoryId]}
                                name={clientCategoryId}
                                required={false}
                            >
                                <Select
                                    className={"ency-select"}
                                    defaultValue={values[clientCategoryId]}
                                    id={clientCategoryId}
                                    inputName={clientCategoryId}
                                    isMulti
                                    onBlur={handleBlur}
                                    onChange={(e) => {
                                        setFieldValue(clientCategoryId, e);
                                    }}
                                    options={categoryOptions}
                                    value={values[clientCategoryId]}
                                />

                            </LabelWrapper>
                            <LabelWrapper
                                label={lang.gdprinfo.reasoning}
                                error={touched[clientReasoningId] && errors[clientReasoningId]}
                                name={clientReasoningId}
                                required={false}
                            >
                                <Select
                                    className={"ency-select"}
                                    defaultValue={values[clientReasoningId]}
                                    id={clientReasoningId}
                                    inputName={clientReasoningId}
                                    isMulti
                                    onBlur={handleBlur}
                                    onChange={(e) => {
                                        setFieldValue(clientReasoningId, e);
                                    }}
                                    options={reasoningOptions}
                                    value={values[clientReasoningId]}
                                />

                            </LabelWrapper>
                        </>
                        }
                        <LabeledToggle
                            label={lang.gdprinfo.isemployee}
                            id={isEmployeeId}
                            name={isEmployeeId}
                            onBlur={handleBlur}
                            onChange={handleChange}
                            toggled={values[isEmployeeId]}
                        />
                        {values[isEmployeeId] &&
                        <>
                            <LabelWrapper
                                label={lang.gdprinfo.category}
                                error={touched[employeeCategoryId] && errors[employeeCategoryId]}
                                name={employeeCategoryId}
                                required={false}
                            >
                                <Select
                                    className={"ency-select"}
                                    defaultValue={values[employeeCategoryId]}
                                    id={employeeCategoryId}
                                    inputName={employeeCategoryId}
                                    isMulti
                                    onBlur={handleBlur}
                                    onChange={(e) => {
                                        setFieldValue(employeeCategoryId, e);
                                    }}
                                    options={categoryOptions}
                                    value={values[employeeCategoryId]}
                                />

                            </LabelWrapper>
                            <LabelWrapper
                                label={lang.gdprinfo.reasoning}
                                error={touched[employeeReasoningId] && errors[employeeReasoningId]}
                                name={employeeReasoningId}
                                required={false}
                            >
                                <Select
                                    className={"ency-select"}
                                    defaultValue={values[employeeReasoningId]}
                                    id={employeeReasoningId}
                                    inputName={employeeReasoningId}
                                    isMulti
                                    onBlur={handleBlur}
                                    onChange={(e) => {
                                        setFieldValue(employeeReasoningId, e);
                                    }}
                                    options={reasoningOptions}
                                    value={values[employeeReasoningId]}
                                />

                            </LabelWrapper>
                        </>
                        }
                    </ClayForm>
                }
                size={'lg'}
            />

        </ErrorBoundary>
    );
}


export default GdprInfoUpdate;