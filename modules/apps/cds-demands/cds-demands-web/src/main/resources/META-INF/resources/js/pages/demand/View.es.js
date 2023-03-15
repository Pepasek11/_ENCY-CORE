'use strict';
import ClayAlert from '@clayui/alert'
import ClayButton, {ClayButtonWithIcon} from '@clayui/button';

import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import ClaySticker from '@clayui/sticker';
import ClayUpperToolbar from '@clayui/upper-toolbar';

import React, {useContext, useEffect, useState} from "react";
import {useNavigate, useParams} from 'react-router-dom';
import Comments from "../../components/Comments";
import {
    InfoCardSmall,
    LabeledFieldView,
    LabeledInput,
    LabeledToggle,
    Sheet,
    SheetSection
} from "../../components/Components";
import WFStepNav from "../../components/WFStepNav";
import WFActions from "../../components/WorkflowActions";
import {GouvernanceView} from "../../components/GouvernanceView";
import {dateToBriefInternationalHuman} from "../../utils/utils.es"
import {AppContext} from '../../AppContext.es';
import NotFound from "../error/404.es";
import {useService} from "../../hooks/useService";
import constants from "../../constants/constants.es";
import GdprInfoView from "../../components/GdprInfoView";
import {StateLabel} from "../../components/Labels.es";
import AttachmentsSidebar from "../../components/Attachments.es"
import DeleteDemand from "../../components/DeleteDemand.es";
import {lang} from "../../constants/lang.es";
import {sub} from "../../utils/lang.es";


const View = () => {
    const context = useContext(AppContext);
    const navigate = useNavigate();
    const params = useParams();

    const [entry, setEntry] = useState(null);
    const [entryToDelete, setEntryToDelete] = useState(null);
    const [meta, setMeta] = useState(null);
    const [entryFound, setEntryFound] = useState(true);
    const [loading, setLoading] = useState(true);
    const [lid, setLid] = useState(0);
    const [sidebar, setSidebar] = useState(null);

    const namespace = context.namespace ?? '';
    const entryId = params.entryId;

    const sidebarStyle = {
        height: '100%',
        minHeight: '450px',
        width: '320px',
    }

    const [fetchData] = useService({
        service: constants.services.getextendedcdsdemand,
        params: {primaryKey: entryId},
        successCallback: ({entry, meta}) => {
            setEntry(entry);
            setMeta(meta);
            setLoading(false);
            setLid(lid + 1);
            setEntryFound(true);
        },
        failureCallback: ({error, message, data}) => {
            console.warn(data)
            setEntry(null);
            setMeta(null);
            setLoading(false);
            setEntryFound(false);
        }
    })

    useEffect(() => {
        try {
            setLoading(true)
            fetchData({});
        } catch (e) {
            setEntryFound(false);
        }
    }, [entryId, context?.siteKey]);


    useEffect(() => {
        document.title = sub(lang.demand.demandx, [(entry && entry?.title) || '#' + entryId]);
    }, [entry, entryId]);

    if (!entryId || !entryFound) {
        return (<NotFound/>)
    }

    return (
        <section className="demands-section">
            {loading && <ClayLoadingIndicator/>}
            {!loading && entryFound &&
            <>
                <div className={"component-tbar subnav-tbar-light tbar"}>
                    <div className={"container-fluid"}>
                        <div className={"tbar-nav"}>
                            <ClayUpperToolbar.Item className="text-left">
                                <ClaySticker displayType="success" size="md">
                                    <ClayIcon symbol="shopping-cart"/>
                                </ClaySticker>
                                <label className="component-title">{sub(lang.demand.demandx, [entry?.title])}:</label>
                            </ClayUpperToolbar.Item>
                            <ClayUpperToolbar.Item className="text-left" expand>
                                <StateLabel label={entry?.stateLabel} code={entry?.state}/>
                            </ClayUpperToolbar.Item>
                            <ClayUpperToolbar.Item>
                                <ClayButton.Group>
                                    {!!meta?.canEdit &&
                                    <ClayButtonWithIcon
                                        onClick={() => {
                                            navigate(constants.navigation.editdemand + entryId)
                                        }}
                                        small borderless
                                        symbol={"pencil"}
                                        title={lang.edit}
                                    />
                                    }
                                    {!!meta?.canDelete &&
                                    <ClayButtonWithIcon
                                        displayType="secondary"
                                        onClick={() => setEntryToDelete(entry)}
                                        small borderless
                                        symbol={"trash"}
                                        title={lang.delete}
                                    />
                                    }
                                    <ClayButtonWithIcon
                                        displayType="secondary"
                                        onClick={() => setSidebar(
                                            sidebar === constants.sidebar.comments ?
                                                null : constants.sidebar.comments
                                        )}
                                        small borderless
                                        title={lang.comments.comments}
                                        symbol="comments"
                                    />
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
                        </div>
                    </div>
                </div>


                <div className={"sidenav-container sidenav-right " + (sidebar ? "open" : "closed")}>
                    <div className={"info-panel sidenav-menu-slider"} style={sidebarStyle}>
                        <div className="sidebar sidebar-light sidenav-menu">
                            {sidebar === constants.sidebar.comments &&
                            <Comments
                                entryId={entry?.demandId}
                                className={"cz.csob.ency.cds.demands.model.CdsDemand"}
                                lid={lid}
                            />}

                            {sidebar === constants.sidebar.attachments &&
                            <AttachmentsSidebar
                                id={`${namespace}file`}
                                name={`${namespace}file`}
                                entryId={entryId}
                            />}

                        </div>
                    </div>
                    <div className={"sidenav-content"}>
                        <ClayLayout.ContainerFluid view size={false}>
                            <ClayLayout.Row className={"c-mb-3"}>
                                <ClayLayout.Col xl={"12"} md={"12"} sm={"0"}>
                                    <WFStepNav entry={entry}/>
                                </ClayLayout.Col>
                            </ClayLayout.Row>
                            <ClayLayout.Row>
                                <ClayLayout.Col md={"8"} sm={"12"} xl={"9"}>
                                    <Sheet>
                                        <SheetSection title={lang.sections.general} icon={"info-circle-open"}>
                                            {
                                                entry?.state === constants.states.NAVRH &&
                                                <ClayAlert displayType="warning" title={lang.warn}>
                                                    {lang.demand.draftWarn}
                                                </ClayAlert>
                                            }
                                            <ClayLayout.ContentRow padded float>
                                                <LabeledFieldView
                                                    displayType={"success"}
                                                    label={lang.fields.type}

                                                    symbol={"shopping-cart"}
                                                    value={entry?.typeLabel}
                                                />
                                                <LabeledFieldView
                                                    displayType={"warning"}
                                                    label={lang.fields.priority}

                                                    symbol={"bolt"}
                                                    value={entry?.priorityLabel}
                                                />
                                                <LabeledFieldView
                                                    displayType={"info"}
                                                    label={lang.fields.requesteddelivery}

                                                    symbol={"calendar"}
                                                    value={entry?.requestedDeliveryLabel}
                                                />
                                                <LabeledFieldView
                                                    displayType={"info"}
                                                    label={lang.fields.isgdpr}

                                                    symbol={"anonymize"}
                                                    value={entry?.isGDPR ?
                                                        lang.yes :
                                                        lang.no}
                                                />
                                                <LabeledFieldView
                                                    displayType={"info"}
                                                    label={lang.fields.fivetracks}

                                                    symbol={"plus-squares"}
                                                    value={entry?.fiveTracksLabels}
                                                />

                                            </ClayLayout.ContentRow>
                                        </SheetSection>
                                    </Sheet>
                                    <Sheet>
                                        <SheetSection title={lang.fields.description} icon={"paragraph"}>
                                            <div dangerouslySetInnerHTML={{__html: entry?.description}}/>
                                        </SheetSection>
                                    </Sheet>

                                    {
                                        Number(entry?.type) === 1 &&
                                        <Sheet>
                                            <SheetSection title={lang.sections.ultraspeed} icon={"time"}>
                                                <LabeledInput
                                                    disabled={true}
                                                    label={lang.fields.usReasoning}
                                                    symbol={"info-circle"}
                                                    value={entry?.usReasoning}
                                                    required={true}
                                                />
                                                <ClayLayout.Row>
                                                    <ClayLayout.Col md={"auto"}>
                                                        <LabeledInput
                                                            disabled={true}
                                                            label={lang.fields.usFrequencyOut}
                                                            symbol={"calendar"}
                                                            value={entry?.usFrequencyOutLabel}/>
                                                    </ClayLayout.Col>
                                                    <ClayLayout.Col md="auto">
                                                        <LabeledToggle
                                                            label={lang.fields.usAccessDPM}
                                                            disabled
                                                            toggled={!!entry?.usAccessDPM}
                                                        />
                                                    </ClayLayout.Col>
                                                    {!!entry?.usFolderDPM && <>
                                                        <ClayLayout.Col md="auto">
                                                            <LabeledInput
                                                                disabled={true}
                                                                label={lang.fields.usFolderDPM}
                                                                symbol={"folder"}
                                                                value={entry?.usFolderDPM}/>
                                                        </ClayLayout.Col>
                                                        <ClayLayout.Col md="auto">
                                                            <LabeledInput
                                                                disabled={true}
                                                                label={lang.fields.usDPMNotificationMail}
                                                                symbol={"envelope-closed"}
                                                                value={entry?.usDPMNotificationMail}/>
                                                        </ClayLayout.Col>
                                                    </>}
                                                    <ClayLayout.Col md="auto">
                                                        <LabeledToggle
                                                            label={lang.fields.usCreateFolderDPM}
                                                            disabled
                                                            toggled={!!entry?.usCreateFolderDPM}
                                                        />
                                                    </ClayLayout.Col>
                                                    {!!entry?.usCreateFolderDPM && <>
                                                        <ClayLayout.Col md="auto">
                                                            <LabeledInput
                                                                disabled={true}
                                                                label={lang.fields.usGestorFolderDPM}
                                                                symbol={"user"}
                                                                value={entry?.usGestorFolderDPMName}/>
                                                        </ClayLayout.Col>
                                                    </>}
                                                </ClayLayout.Row>
                                            </SheetSection>
                                        </Sheet>
                                    }
                                    {entry?.bioeId &&
                                    <Sheet>
                                        <SheetSection title={lang.sections.bioe} icon={"squares"}>
                                            <div className={"row"}>
                                                <InfoCardSmall
                                                    label={lang.fields.bioeid}
                                                >{entry?.bioeId}</InfoCardSmall>
                                                <InfoCardSmall
                                                    label={lang.fields.bioestatename}
                                                >{entry?.bioeStateName}</InfoCardSmall>
                                                <InfoCardSmall
                                                    label={lang.fields.workestimate}
                                                >{entry?.workEstimate}</InfoCardSmall>
                                                {
                                                    !!entry?.acceptedWorkEstimate &&
                                                    entry?.acceptedWorkEstimate !== entry?.workEstimate &&
                                                    <InfoCardSmall
                                                        label={lang.fields.acceptedworkestimate}
                                                    >{entry?.acceptedWorkEstimate}</InfoCardSmall>
                                                }
                                                <InfoCardSmall
                                                    label={lang.fields.expecteddelivery}
                                                >{dateToBriefInternationalHuman(entry?.expectedDelivery)}</InfoCardSmall>
                                                {
                                                    !!entry?.acceptedDelivery &&
                                                    entry?.acceptedDelivery !== entry?.expectedDelivery &&
                                                    <InfoCardSmall
                                                        label={lang.fields.accepteddelivery}
                                                    >{dateToBriefInternationalHuman(entry?.acceptedDelivery, navigator.language)}
                                                    </InfoCardSmall>
                                                }
                                            </div>
                                        </SheetSection>
                                    </Sheet>
                                    }
                                    {(entry?.isGDPR || context?.isLorm || context?.isEncyAdmin) &&
                                    <Sheet>
                                        <SheetSection title={lang.sections.gdprInfo} icon={"anonymize"}>
                                            <GdprInfoView
                                                canEdit={true}
                                                demandId={entry?.demandId}
                                                visible={entry?.isGDPR || context?.isLorm || context?.isEncyAdmin}
                                            />
                                        </SheetSection>
                                    </Sheet>
                                    }
                                </ClayLayout.Col>
                                <ClayLayout.Col md={"4"} sm={"12"} xl={"3"}>
                                    <Sheet>
                                        <SheetSection title={lang.sections.actions} icon={"workflow"}>
                                            <WFActions
                                                actions={entry?.workflowTransitions}
                                                entryId={entryId}
                                                onSuccess={() => {
                                                    fetchData();
                                                }}
                                                type={'buttons'}
                                            />
                                        </SheetSection>
                                    </Sheet>
                                    <Sheet>
                                        <SheetSection title={lang.sections.governance} icon={"users"}>
                                            <GouvernanceView data={[
                                                {
                                                    label: lang.fields.domainName,
                                                    value: entry?.domainName
                                                }, {
                                                    label: lang.fields.requestor,
                                                    value: entry?.requestorName
                                                }, {
                                                    label: lang.fields.requestedfor,
                                                    value: entry?.requestedForName
                                                }, {
                                                    label: lang.fields.contact,
                                                    value: entry?.contactName
                                                }, {
                                                    label: lang.fields.spoc,
                                                    value: entry?.spocName,
                                                    delegations: entry?.spocDelegations ?? []
                                                }, {
                                                    label: lang.fields.ban,
                                                    value: entry?.banName,
                                                    delegations: entry?.banDelegations ?? []
                                                }
                                            ]}/>
                                        </SheetSection>
                                    </Sheet>
                                </ClayLayout.Col>
                            </ClayLayout.Row>
                            <DeleteDemand
                                callback={() => navigate(constants.navigation.home)}
                                entry={entryToDelete}
                                setEntry={setEntryToDelete}
                            />
                        </ClayLayout.ContainerFluid>
                    </div>
                </div>
            </>
            }
        </section>
    )
}
export default View;