'use strict';

/*
https://github.com/liferay/liferay-portal/blob/master/modules/apps/adaptive-media/adaptive-media-web/src/main/resources/META-INF/resources/adaptive_media/js/EditAdaptiveMedia.js
*/

import ClayAlert from '@clayui/alert'
import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import ClayDatePicker from '@clayui/date-picker';
import ClayEmptyState from '@clayui/empty-state';
import ClayForm, {ClayInput} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import ClaySticker from '@clayui/sticker';
import ClayUpperToolbar from '@clayui/upper-toolbar';
import {useFormik} from 'formik';
import {fetch, objectToFormData, openToast,} from 'frontend-js-web';
import React, {useContext, useEffect, useState} from "react";
import {Link, useNavigate, useParams} from 'react-router-dom';
import Select from 'react-select';

import {
    LabeledCheckbox,
    LabeledInput,
    LabelWrapper,
    SelectInput,
    Sheet,
    SheetSection
} from '../../components/Components';
import RichText from "../../components/RichText";
import UsersSelect from "../../components/UsersSelect";
import {AppContext} from "../../AppContext.es";
import NotFound from "../error/404.es";
import {useService} from "../../hooks/useService";
import GdprInfoView from "../../components/GdprInfoView";
import {lang} from "../../constants/lang.es";
import constants from "../../constants/constants.es";
import {sub} from "../../utils/lang.es";
import AttachmentsSidebar from "../../components/Attachments.es";

const scrollToTop = () => window.scrollTo({behavior: 'smooth', top: 0});

const spritemap = Liferay.ThemeDisplay.getPathThemeImages() + '/clay/icons.svg';

const EditDemand = ({
                        isNew,
                    }) => {

    const context = useContext(AppContext);
    const navigate = useNavigate();

    const [entry, setEntry] = useState({});
    const [meta, setMeta] = useState({});
    const [errorMessage, setErrorMessage] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);
    const [sidebar, setSidebar] = useState(null);

    const namespace = context.namespace ?? '';
    const params = useParams();

    const entryId = params.entryId;
    if (!entryId && !isNew) {
        return (<NotFound/>)
    }

    const [fetchData] = useService({
        service: constants.services.getextendedcdsdemand,
        params: {primaryKey: entryId ?? 0},
        successCallback: ({entry, meta}) => {
            setEntry(entry);
            setMeta(meta);
            resetForm({values: getFormValues(entry), touched: []});
            setError(null);
            setLoading(false);
        },
        failureCallback: ({error, message, data}) => {
            console.warn(error, message, data)
            setEntry({});
            setMeta({});
            setLoading(false);
            resetForm({values: getFormValues(entry), touched: []});
        }
    })

    useEffect(() => {
        try {
            fetchData();
        } catch (e) {
            setError({
                message: Liferay.Language.get(
                    'the-link-you-followed-may-be-broken-or-the-question-no-longer-exists'
                ),
                title: Liferay.Language.get(
                    'the-demand-is-not-found'
                )
            })
        }
    }, [entryId, context.siteKey]);


    useEffect(() => {
        if (isNew) {
            document.title = Liferay.Language.get('new-cds-demand')
        } else {
            document.title = (entry && entry.title) || Liferay.Language.get('cds-demand') + ' ' + entryId;
        }
    }, [entry, entryId]);


    const resourcePrimKeyId = `${namespace}resourcePrimKey`;
    const titleId = `${namespace}title`;
    const typeId = `${namespace}type`;
    const priorityId = `${namespace}priority`;
    const requestedDeliveryId = `${namespace}requestedDelivery`;
    const descriptionId = `${namespace}description`;
    const fiveTracksId = `${namespace}fiveTracks`;

    const usFrequencyOutId = `${namespace}usFrequencyOut`;
    const usReasoningId = `${namespace}usReasoning`;
    const usAccessDPMId = `${namespace}usAccessDPM`;
    const usFolderDPMId = `${namespace}usFolderDPM`;
    const usDPMNotificationMailId = `${namespace}usDPMNotificationMail`;
    const usCreateFolderDPMId = `${namespace}usCreateFolderDPM`;
    const usGestorFolderDPMIdId = `${namespace}usGestorFolderDPMId`;
    const usGestorFolderDPMNameId = `${namespace}usGestorFolderDPMName`;

    const requestorIdId = `${namespace}requestorId`;
    const requestorNameId = `${namespace}requestorName`;
    const requestedForIdId = `${namespace}requestedForId`;
    const requestedForNameId = `${namespace}requestedForName`;
    const contactIdId = `${namespace}contactId`;
    const contactNameId = `${namespace}contactName`;
    const domainNameId = `${namespace}domainName`;
    const domainIdId = `${namespace}domainId`;
    const banIdId = `${namespace}banId`;
    const banNameId = `${namespace}banName`;
    const spocIdId = `${namespace}spocId`;
    const spocNameId = `${namespace}spocName`;
    const isGDPRId = `${namespace}isGDPR`;
    const gdprInfoId = `${namespace}gdprInfo`;

    const today = new Date();

    const spocOptionsId = 'tmp_spocOptions';
    const banOptionsId = 'tmp_banOptions';
    const requestedForOptionsId = `tmp_requestedForOptions`;
    const contactOptionsId = `tmp_contactOptions`;
    const usGestorFolderDPMOptionsId = 'tmp_usGestorFolderDPMOptions';

    const sidebarStyle = {
        height: '100%',
        minHeight: '450px',
        width: '320px',
    }

    const getFormValues = (e) => ({
        [resourcePrimKeyId]: e ? e?.demandId : 0,

        [titleId]: e ? e?.title : '',
        [typeId]: (e && e?.type > 0) ? e?.type : 2,
        [priorityId]: (e && e?.priority > 0) ? e?.priority : 3,
        [requestedDeliveryId]: e ? e?.requestedDelivery : 0,
        [descriptionId]: e ? e?.description : '',
        [fiveTracksId]: e ? e?.fiveTracks : [],

        [usFrequencyOutId]: (e && e?.usFrequencyOut > 0) ? e?.usFrequencyOut : 1,
        [usReasoningId]: e ? e?.usReasoning : '',
        [usAccessDPMId]: e ? e?.usAccessDPM : false,
        [usFolderDPMId]: e ? e?.usFolderDPM : '',
        [usDPMNotificationMailId]: e ? e?.usDPMNotificationMail : '',
        [usCreateFolderDPMId]: e ? e?.usCreateFolderDPM : false,
        [usGestorFolderDPMIdId]: e ? e?.usGestorFolderDPMId : 0,
        [usGestorFolderDPMNameId]: e ? e?.usGestorFolderDPMName : '',
        [usGestorFolderDPMOptionsId]: !!(e?.usGestorFolderDPMId) ? {
            label: e?.usGestorFolderDPMName,
            value: e?.usGestorFolderDPMId
        } : {},

        [requestorIdId]: e ? e?.requestorId : Liferay.ThemeDisplay.getUserId(),
        [requestorNameId]: e ? e?.requestorName : Liferay.ThemeDisplay.getUserName(),
        [requestedForIdId]: e ? e?.requestedForId : 0,
        [requestedForNameId]: e ? e?.requestedForName : '',
        [requestedForOptionsId]: !!(e?.requestedForId) ? {
            label: e?.requestedForName,
            value: e?.requestedForId
        } : {},
        [contactIdId]: e ? e?.contactId : 0,
        [contactNameId]: e ? e?.contactName : '',
        [contactOptionsId]: !!(e?.contactId) ? {
            label: e?.contactName,
            value: e?.contactId
        } : {},
        [domainNameId]: e ? e?.domainName : '',
        [domainIdId]: e ? e?.domainId : '',
        [banOptionsId]: !!(e?.banId) ? {label: e?.banName, value: e?.banId} : {},
        [banIdId]: e ? e?.banId : 0,
        [banNameId]: e ? e?.banName : '',
        [spocIdId]: e ? e?.spocId : 0,
        [spocNameId]: e ? e?.spocName : '',
        [spocOptionsId]: !!(e?.spocId) ? {label: e?.spocName, value: e?.spocId} : {},
        [isGDPRId]: e ? e?.isGDPR : false,
        [gdprInfoId]: e ? e?.gdprInfo : {}
    });

    const formik = useFormik({
        initialValues: getFormValues(entry),

        enableReinitialize: true,

        onSubmit: (values) => {
            fetch(isNew ? context?.urls?.addDemandAction : context?.urls?.updateDemandAction, {
                body: objectToFormData(values),
                method: 'POST',
            })
                .then((response) => response.json())
                .then(({message, success}) => {
                    if (success) {
                        openToast({
                            message,
                            title: lang.success,
                            type: 'success',
                        });

                        navigate(`${constants.navigation.viewdemand}${values[resourcePrimKeyId]}`);
                    } else {
                        setErrorMessage(message);
                        openToast({
                            message,
                            title: lang.error,
                            type: 'error',
                        });
                        scrollToTop();
                    }
                })
                .catch(() => {
                    openToast({
                        message: lang.unexpectedError,
                        title: lang.error,
                        type: 'danger',
                    });
                });
        },

        validate: (values) => {
            const errs = {};

            [
                {field: titleId, error: lang.errors.requiredtitle},
                {field: typeId, error: lang.errors.requiredtype},
                {field: descriptionId, error: lang.errors.requireddescription},
                {field: priorityId, error: lang.errors.requiredpriority},
                {field: requestedDeliveryId, error: lang.errors.requiredrequesteddelivery},
                {field: banIdId, error: lang.errors.requiredban},
                {field: spocIdId, error: lang.errors.requiredspoc},
            ].forEach(({field, error}) => {
                if (!values[field]) {
                    errs[field] = error;
                }
            });

            [
                {field: titleId, error: lang.errors.toolongtitle},
                {field: usReasoningId, error: lang.errors.toolongreasoning}
            ].forEach(({field, error}) => {
                if (values[field]?.length > 500) {
                    errs[field] = error;
                }
            });

            if (Number(values[typeId]) == 1) {
                [
                    {field: usReasoningId, error: lang.errors.requiredusreasoning},
                    {field: usFrequencyOutId, error: lang.errors.requiredusfrequencyout},
                ].forEach(({field, error}) => {
                    if (!values[field]) {
                        errs[field] = error;
                    }
                });
            }

            if (!values[usFolderDPMId] && values[usAccessDPMId]) {
                errs[usFolderDPMId] = lang.errors.requiredUsFolderDPM;
            }

            if (!values[usGestorFolderDPMIdId] && values[usCreateFolderDPMId]) {
                errs[usGestorFolderDPMIdId] = lang.errors.requiredUsGestorFolderDPM;
            }

            if (!values[fiveTracksId] || values[fiveTracksId].length === 0) {
                errs[fiveTracksId] = lang.errors.requiredFiveTracks;
            }

            if (values[requestedDeliveryId]) {
                const now = new Date();
                const fieldDate = new Date(values[requestedDeliveryId]);

                if (now.valueOf() >= fieldDate.valueOf()) {
                    errs[requestedDeliveryId] = lang.errors.deliveryInPast;
                }
            }
            return errs;
        },
    });


    const {
        errors,
        handleBlur,
        handleChange,
        setFieldValue,
        touched,
        values,
        resetForm,
    } = formik;

    const refreshGovernance = () => {
        // console.log("refreshing")
        var requestorId = Number(values[requestedForIdId]) || Number(values[requestorIdId]);

        if (!requestorId) return;

        Liferay.Service({
                [constants.services.demands.getrequestorinfo]:
                    {
                        userId: requestorId
                    }
            },
            function (obj) {
                if (obj === undefined) {
                    return
                }

                var spocId;
                var spocName;
                var banId;
                var banName;

                if (Number(values[typeId]) === 1) {
                    spocId = obj?.spoc_us_id;
                    spocName = obj?.spoc_us_name || obj?.spoc_id;
                    banId = obj?.ban_us_id;
                    banName = obj?.ban_us_name || obj?.ban_us_id;
                } else {
                    spocId = obj?.spoc_id;
                    spocName = obj?.spoc_name || obj?.spoc_id;
                    banId = obj?.ban_id;
                    banName = obj?.ban_name || obj?.ban_id;
                }

                setFieldValue(banIdId, banId);
                setFieldValue(banNameId, banName);
                setFieldValue(banOptionsId, {label: banName, value: banId})

                setFieldValue(spocIdId, spocId);
                setFieldValue(spocNameId, spocName);
                setFieldValue(spocOptionsId, {label: spocName, value: spocId})

                setFieldValue(domainNameId, obj?.bod || lang.unknown);
                setFieldValue(domainIdId, obj?.bod_id || 0);

                openToast({
                    message: lang.demand.gouvernanceUpdated,
                    title: lang.info,
                    type: 'info',
                });
            }, {
                function(obj) {
                    console.log(obj)
                }
            }
        );
    }

    useEffect(
        () => {
            if ((!values[spocIdId] && !values[banIdId]) || touched[requestedForIdId] || touched[typeId]) {
                refreshGovernance();
            }
        },
        [values[typeId], values[requestorIdId], values[requestedForIdId]]
    );

    useEffect(() => {
        document.title = isNew ?
            lang.demand.new :
            sub(lang.demand.demandx, [(entry && entry?.title) || +'#' + entryId])
    }, [loading, values[titleId]])

    return (
        <section className="demands-section">
            {loading && <ClayLoadingIndicator/>}
            {error && (
                <div className="questions-container row">
                    <div className="c-mx-auto c-px-0 col-xl-10">
                        <ClayEmptyState
                            description={error.message}
                            imgSrc={
                                context.includeContextPath +
                                '/assets/empty_questions_list.png'
                            }
                            title={error.title}
                        >
                            <ClayButton
                                displayType="primary"
                                onClick={() =>
                                    navigate('/')
                                }
                            >{lang.home}
                            </ClayButton>
                        </ClayEmptyState>
                    </div>
                </div>
            )}
            {!loading && !error &&
            <ClayForm onSubmit={formik.handleSubmit}>
                <div className={"component-tbar subnav-tbar-light tbar"}>
                    <div className={"container-fluid"}>
                        <div className={"tbar-nav"}>
                            <ClayUpperToolbar.Item className="text-left">
                                <ClaySticker displayType="success" size="md">
                                    <ClayIcon spritemap={spritemap} symbol="shopping-cart"/>
                                </ClaySticker>
                            </ClayUpperToolbar.Item>

                            <ClayUpperToolbar.Item className="text-left" expand>
                                <label className="component-title">{
                                    isNew ?
                                        lang.demand.new :
                                        sub(lang.demand.editDemandX, [entry.title])}</label>
                            </ClayUpperToolbar.Item>
                            <ClayUpperToolbar.Item>

                                <ClayButton.Group>
                                    <ClayButtonWithIcon
                                        displayType="secondary"
                                        onClick={() => setSidebar(
                                            sidebar === constants.sidebar.attachments ?
                                                null : constants.sidebar.attachments
                                        )}
                                        small borderless
                                        title={lang.attachments.attachments}
                                        symbol="paperclip"
                                    />
                                </ClayButton.Group>
                            </ClayUpperToolbar.Item>
                            <ClayUpperToolbar.Item>
                                <SaveCancelButtons entryId={entryId} isSubmitting={formik.isSubmitting} isNew={isNew}/>
                            </ClayUpperToolbar.Item>
                        </div>
                    </div>
                </div>

                <div className={"sidenav-container sidenav-right " + (sidebar ? "open" : "closed")}>
                    <div className={"info-panel sidenav-menu-slider"} style={sidebarStyle}>
                        <div className="sidebar sidebar-light sidenav-menu">
                            {sidebar === constants.sidebar.attachments &&
                            <AttachmentsSidebar
                                id={`${namespace}file`}
                                name={`${namespace}file`}
                                entryId={values[resourcePrimKeyId]}
                            />}

                        </div>
                    </div>
                    <div className={"sidenav-content"}>

                        <input id={resourcePrimKeyId} hidden value={values[resourcePrimKeyId]} onChange={()=>{}}/>

                        <ClayLayout.ContainerFluid view>
                            {errorMessage && (
                                <ClayAlert displayType="danger">{errorMessage}</ClayAlert>
                            )}

                            <ClayLayout.Row justify="center">
                                <ClayLayout.Col xl={8} md={8} sm={12}>
                                    <Sheet>
                                        <SheetSection title={lang.sections.general} icon={"info-circle-open"}>
                                            <LabeledInput
                                                error={touched[titleId] && errors[titleId]}
                                                label={lang.fields.title}
                                                name={titleId}
                                                onBlur={handleBlur}
                                                onChange={handleChange}
                                                required
                                                value={values[titleId]}
                                            />

                                            <ClayLayout.Row>
                                                <ClayLayout.Col md="4">
                                                    <SelectInput
                                                        error={touched[typeId] && errors[typeId]}
                                                        helpMessage={lang.demand.typeHelp}
                                                        id={typeId}
                                                        label={lang.fields.type}
                                                        name={typeId}
                                                        onBlur={handleBlur}
                                                        onChange={(e) => {
                                                            touched[typeId] = true;
                                                            setFieldValue(typeId, e.target.value);
                                                            //    refreshGovernance();
                                                        }}
                                                        options={context?.selectoptions?.type}
                                                        value={values[typeId]}
                                                    />
                                                </ClayLayout.Col>
                                                <ClayLayout.Col md="4">
                                                    <SelectInput
                                                        error={touched[priorityId] && errors[priorityId]}
                                                        helpMessage={lang.demand.priorityHelp}
                                                        id={priorityId}
                                                        label={lang.fields.priority}
                                                        name={priorityId}
                                                        onBlur={handleBlur}
                                                        onChange={handleChange}
                                                        options={context?.selectoptions?.priority}
                                                        value={values[priorityId]}
                                                    />
                                                </ClayLayout.Col>
                                                <ClayLayout.Col md="4">
                                                    <LabelWrapper
                                                        error={touched[requestedDeliveryId] && errors[requestedDeliveryId]}
                                                        id={requestedDeliveryId}
                                                        label={lang.fields.requesteddelivery}
                                                        required
                                                    >
                                                        <ClayDatePicker
                                                            dateFormat="yyyy-MM-dd"
                                                            firstDayOfWeek={1}
                                                            id={requestedDeliveryId}
                                                            name={requestedDeliveryId}
                                                            onBlur={handleBlur}
                                                            onChange={(value) => {
                                                                setFieldValue(requestedDeliveryId, Date.parse(value));
                                                            }
                                                            }
                                                            onValueChange={(value) => {
                                                                setFieldValue(requestedDeliveryId, Date.parse(value));
                                                            }}

                                                            placeholder="YYYY-MM-DD"
                                                            value={
                                                                values[requestedDeliveryId] ?
                                                                    (new Date(values[requestedDeliveryId])).toISOString().substring(0, 10) :
                                                                    (today.toISOString().substring(0, 10))
                                                            }
                                                            years={{
                                                                end: today.getFullYear() + 10,
                                                                start: today.getFullYear() - 2,
                                                            }}
                                                        />
                                                    </LabelWrapper>
                                                </ClayLayout.Col>
                                            </ClayLayout.Row>
                                            <RichText
                                                contents={values[descriptionId]}
                                                error={touched[descriptionId] && errors[descriptionId]}
                                                id={descriptionId}
                                                label={lang.fields.description}
                                                name={descriptionId}
                                                onBlur={handleBlur}
                                                // onSetData={handleChange}
                                                onChange={(v) => {
                                                    setFieldValue(descriptionId, v)
                                                }}
                                                required
                                            />

                                        </SheetSection>
                                    </Sheet>
                                    {
                                        Number(values[typeId]) === 1 &&
                                        <Sheet>
                                            <SheetSection title={lang.sections.ultraspeed} icon={"time"}>
                                                <SelectInput
                                                    error={touched[usFrequencyOutId] && errors[usFrequencyOutId]}
                                                    id={usFrequencyOutId}
                                                    label={lang.fields.usFrequencyOut}
                                                    name={usFrequencyOutId}
                                                    onBlur={handleBlur}
                                                    onChange={handleChange}
                                                    options={context?.selectoptions?.frequency}
                                                    value={values[usFrequencyOutId]}

                                                />
                                                <LabeledInput
                                                    error={touched[usReasoningId] && errors[usReasoningId]}
                                                    label={lang.fields.usReasoning}
                                                    name={usReasoningId}
                                                    onBlur={handleBlur}
                                                    onChange={handleChange}
                                                    required
                                                    value={values[usReasoningId]}
                                                />
                                                <ClayLayout.Row>
                                                    <ClayLayout.Col md="4">
                                                        <LabeledCheckbox
                                                            error={touched[usAccessDPMId] && errors[usAccessDPMId]}
                                                            label={lang.fields.usAccessDPM}
                                                            name={usAccessDPMId}
                                                            checked={values[usAccessDPMId]}
                                                            id={usAccessDPMId}
                                                            onChange={(event) => {
                                                                setFieldValue(
                                                                    usAccessDPMId,
                                                                    event.target.checked
                                                                );
                                                            }}
                                                        />
                                                    </ClayLayout.Col>
                                                    <ClayLayout.Col md="8">
                                                        {
                                                            values[usAccessDPMId] &&
                                                            <>
                                                                <LabeledInput
                                                                    error={touched[usFolderDPMId] && errors[usFolderDPMId]}
                                                                    label={lang.fields.usFolderDPM}
                                                                    name={usFolderDPMId}
                                                                    onBlur={handleBlur}
                                                                    onChange={handleChange}
                                                                    required={(Number(values[typeId]) === 1 && values[usAccessDPMId])}
                                                                    value={values[usFolderDPMId]}
                                                                />
                                                                <LabeledInput
                                                                    error={touched[usDPMNotificationMailId] && errors[usDPMNotificationMailId]}
                                                                    helpMessage={lang.demand.usDPMNotificationMailHelp}
                                                                    label={lang.fields.usDPMNotificationMail}
                                                                    name={usDPMNotificationMailId}
                                                                    onBlur={handleBlur}
                                                                    onChange={handleChange}
                                                                    value={values[usDPMNotificationMailId]}
                                                                />
                                                            </>
                                                        }
                                                    </ClayLayout.Col>
                                                </ClayLayout.Row>
                                                <ClayLayout.Row>
                                                    <ClayLayout.Col md="4">
                                                        <LabeledCheckbox
                                                            error={touched[usCreateFolderDPMId] && errors[usCreateFolderDPMId]}
                                                            helpMessage={lang.demand.uscreatefolderdmpHelp}
                                                            label={lang.fields.usCreateFolderDPM}
                                                            name={usCreateFolderDPMId}
                                                            checked={values[usCreateFolderDPMId]}
                                                            id={usCreateFolderDPMId}
                                                            onBlur={handleBlur}
                                                            onChange={(event) => {
                                                                setFieldValue(
                                                                    usCreateFolderDPMId,
                                                                    event.target.checked
                                                                );
                                                            }}
                                                        />
                                                    </ClayLayout.Col>
                                                    <ClayLayout.Col md="8">
                                                        {/* Folder gestor for field*/}
                                                        {
                                                            values[usCreateFolderDPMId] &&
                                                            <UsersSelect
                                                                error={touched[usGestorFolderDPMIdId] && errors[usGestorFolderDPMIdId]}
                                                                label={lang.fields.usGestorFolderDPM}
                                                                filterRoles={''}
                                                                id={usGestorFolderDPMIdId}
                                                                isClearable
                                                                isMulti={false}
                                                                name={usGestorFolderDPMIdId}
                                                                onBlur={handleBlur}
                                                                onChange={(val) => {
                                                                    setFieldValue(usGestorFolderDPMOptionsId, val ?? {});
                                                                    setFieldValue(usGestorFolderDPMIdId, val?.value ?? 0);
                                                                    setFieldValue(usGestorFolderDPMNameId, val?.label ?? '');
                                                                }}
                                                                required={true}
                                                                value={values[usGestorFolderDPMOptionsId]}
                                                            />

                                                        }

                                                    </ClayLayout.Col>
                                                </ClayLayout.Row>

                                            </SheetSection>
                                        </Sheet>
                                    }
                                    <Sheet>
                                        <SheetSection title={lang.sections.gdprInfo} icon={"anonymize"}>
                                            <LabeledCheckbox
                                                label={lang.fields.isgdpr}
                                                name={isGDPRId}
                                                checked={values[isGDPRId]}
                                                id={isGDPRId}
                                                onBlur={handleBlur}
                                                onChange={(event) => {
                                                    setFieldValue(
                                                        isGDPRId,
                                                        event.target.checked
                                                    );
                                                }}
                                            />
                                            <GdprInfoView
                                                canEdit={true}
                                                demandId={entry?.demandId}
                                                visible={!!values[isGDPRId]}
                                            />
                                        </SheetSection>
                                    </Sheet>
                                </ClayLayout.Col>
                                <ClayLayout.Col xl={4} md={4} sm={12}>
                                    <Sheet>
                                        <SheetSection title={Liferay.Language.get('strategic-tracks')}
                                                      icon={"categories"}>

                                            <LabelWrapper
                                                label={lang.fields.fivetracks}
                                                error={touched[fiveTracksId] && errors[fiveTracksId]}
                                                name={fiveTracksId}
                                                required={true}
                                            >
                                                <Select
                                                    className={"ency-select"}
                                                    defaultValue={
                                                        context?.selectoptions?.fivetracks.filter(
                                                            o => {
                                                                return values[fiveTracksId] ?
                                                                    values[fiveTracksId].includes(o.value) :
                                                                    false
                                                            })}
                                                    id={fiveTracksId}
                                                    inputName={fiveTracksId}
                                                    isMulti
                                                    onBlur={handleBlur}
                                                    onChange={(e, x) => {
                                                        setFieldValue(fiveTracksId, e.map(o => o.value));
                                                    }}
                                                    options={context?.selectoptions?.fivetracks}
                                                    value={context?.selectoptions?.fivetracks.filter(
                                                        o => {
                                                            return values[fiveTracksId] ?
                                                                values[fiveTracksId].includes(o.value) :
                                                                false
                                                        })}

                                                />
                                            </LabelWrapper>
                                        </SheetSection>
                                    </Sheet>
                                    <Sheet>
                                        <SheetSection title={lang.sections.governance} icon={"users"}>
                                            {/* Department field*/}
                                            <LabelWrapper
                                                label={lang.fields.department}
                                            >
                                                <ClayForm.Group>
                                                    <ClayInput.Group>
                                                        <ClayInput.GroupItem shrink prepend>
                                                            <ClayInput.GroupText>
                                                                <ClayIcon symbol="organizations" size="md"/>
                                                            </ClayInput.GroupText>
                                                        </ClayInput.GroupItem>
                                                        <ClayInput.GroupItem append>
                                                            <ClayInput placeholder={values[domainNameId]} type="text"
                                                                       disabled={true}/>
                                                            <ClayInput placeholder={values[domainIdId]} type="hidden"/>
                                                        </ClayInput.GroupItem>
                                                    </ClayInput.Group>
                                                </ClayForm.Group>
                                            </LabelWrapper>

                                            <LabelWrapper
                                                label={lang.fields.requestor}
                                            >
                                                <ClayForm.Group>
                                                    <ClayInput.Group>
                                                        <ClayInput.GroupItem shrink prepend>
                                                            <ClayInput.GroupText>
                                                                <ClayIcon spritemap={spritemap} symbol="user"
                                                                          size="md"/>
                                                            </ClayInput.GroupText>
                                                        </ClayInput.GroupItem>
                                                        <ClayInput.GroupItem append>
                                                            <ClayInput placeholder={values[requestorNameId]} type="text"
                                                                       disabled={true}/>
                                                        </ClayInput.GroupItem>
                                                    </ClayInput.Group>
                                                </ClayForm.Group>
                                            </LabelWrapper>

                                            {/* Requested for field*/}
                                            <UsersSelect
                                                error={touched[requestedForIdId] && errors[requestedForIdId]}
                                                he
                                                label={lang.fields.requestedfor}
                                                required={false}
                                                filterRoles={''}
                                                helpMessage={lang.demand.requestedForHelp}
                                                id={requestedForIdId}
                                                isClearable
                                                isMulti={false}
                                                name={requestedForIdId}
                                                onBlur={handleBlur}
                                                onChange={(val) => {
                                                    touched[requestedForIdId] = true;
                                                    setFieldValue(requestedForOptionsId, val ?? {});
                                                    setFieldValue(requestedForIdId, val?.value ?? 0);
                                                    setFieldValue(requestedForNameId, val?.label ?? '');
                                                }}
                                                value={values[requestedForOptionsId]}
                                            />

                                            {/* Contact field*/}
                                            <UsersSelect
                                                error={touched[contactIdId] && errors[contactIdId]}
                                                filterRoles={''}
                                                helpMessage={lang.demand.contactHelp}
                                                id={contactIdId}
                                                isClearable
                                                isMulti={false}
                                                label={lang.fields.contact}
                                                name={contactIdId}
                                                onBlur={handleBlur}
                                                onChange={(val) => {
                                                    setFieldValue(contactOptionsId, val ?? {});
                                                    setFieldValue(contactIdId, val?.value ?? 0);
                                                    setFieldValue(contactNameId, val?.label ?? '');
                                                }}
                                                required={false}
                                                value={values[contactOptionsId]}
                                            />


                                            {/* SPOC field*/}
                                            <UsersSelect
                                                error={touched[spocIdId] && errors[spocIdId]}
                                                filterRoles={'0002_GS_ACDSENCYDEMANDSPOC'}
                                                helpMessage={lang.demand.spocHelp}
                                                id={spocIdId}
                                                isClearable
                                                isMulti={false}
                                                label={lang.fields.spoc}
                                                name={spocIdId}
                                                onBlur={handleBlur}
                                                onChange={(val) => {
                                                    setFieldValue(spocOptionsId, val ?? {});
                                                    setFieldValue(spocIdId, val?.value ?? 0);
                                                    setFieldValue(spocNameId, val?.label ?? '');
                                                }}
                                                required={true}
                                                value={values[spocOptionsId]}
                                            />

                                            {/* BAN field*/}
                                            <UsersSelect
                                                error={touched[banIdId] && errors[banIdId]}
                                                filterRoles={'0002_GS_ACDSENCYBICDSINTERNAL'}
                                                helpMessage={lang.demand.banHelp}
                                                id={banIdId}
                                                isClearable
                                                isMulti={false}
                                                label={lang.fields.ban}
                                                name={banIdId}
                                                onBlur={handleBlur}
                                                onChange={(val) => {
                                                    setFieldValue(banOptionsId, val ?? {});
                                                    setFieldValue(banIdId, val?.value ?? 0);
                                                    setFieldValue(banNameId, val?.label ?? '');
                                                }}
                                                required={true}
                                                value={values[banOptionsId]}
                                            />

                                        </SheetSection>
                                    </Sheet>
                                </ClayLayout.Col>
                            </ClayLayout.Row>
                            <ClayLayout.Row className={"c-mt-2"}>
                                <ClayLayout.Col size={12}>
                                    <div className="sheet-footer">
                                        <SaveCancelButtons
                                            entryId={entryId}
                                            isSubmitting={formik.isSubmitting}
                                            isNew={isNew}/>
                                    </div>
                                </ClayLayout.Col>
                            </ClayLayout.Row>
                        </ClayLayout.ContainerFluid>
                    </div>
                </div>
            </ClayForm>
            }
        </section>

    );
}

const SaveCancelButtons = (
    {
        entryId = 0,
        isNew = false,
        isSubmitting = false,
    }) => {
    let navigate = useNavigate();

    return (
        <ClayButton.Group>
            <ClayButton
                disabled={isSubmitting}
                displayType="primary"
                small
                title={Liferay.Language.get('submit')}
                type="submit"
            >
                            <span className="inline-item inline-item-before">
                            <ClayIcon symbol="disk"/>
                            </span>
                {Liferay.Language.get('save')}
            </ClayButton>
            <Link
                className="btn btn-sm btn-secondary"
                to={isNew ? -1 : `${constants.navigation.viewdemand}${entryId}`}
            >
                            <span className="inline-item inline-item-before">
                            <ClayIcon symbol="times-small"/>
                            </span>
                {Liferay.Language.get('cancel')}
            </Link>
        </ClayButton.Group>
    );
}


export default EditDemand;


