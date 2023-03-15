'use strict';
import ClayAlert from '@clayui/alert';
import ClayButton from '@clayui/button';
import ClayLabel from '@clayui/label';
import ClayList from '@clayui/list';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import ClayTable from '@clayui/table';
import {openToast} from 'frontend-js-web';
import React, {useEffect, useState} from "react";
import constants from "../constants/constants.es";
import {lang} from "../constants/lang.es";
import {ErrorBoundary} from "./ErrorBoundary.es";
import {sub} from "../utils/lang.es";
import GdprInfoUpdate from "./GdprInfoUpdate";

;

const GdprInfoView = (
    {
        canEdit = false,
        demandId,
        visible = true
    }
) => {
    if (!demandId || !visible) {
        return <></>;
    }

    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [modalData, setModalData] = useState(null);

    function fetchData() {
        setLoading(true);
        Liferay.Service(
            constants.services.gdprinfo.get,
            {
                demandId: demandId
            },
            function (obj) {
                if (obj && obj.success) {
                    setData(obj.data);
                } else {
                    setData([]);
                    openToast({
                        message: obj?.message || lang.somethingWentWrong,
                        title: lang.error,
                        type: 'danger'
                    })
                }
                setLoading(false);
            }
        );
    }


    function deleteRecord(id, title) {
        if (!confirm(sub(lang.gdprinfo.confirmDeleteX, [title]))) {
            return;
        }

        Liferay.Service(
            constants.services.gdprinfo.delete,
            {
                entryId: id
            },
            function (obj) {
                if (obj && obj.success) {
                    setData(data.filter(value => value.gdprInfoId !== id));
                    openToast({
                        message: obj?.message || lang.success,
                        title: lang.success,
                        type: 'success'
                    })
                } else {
                    openToast({
                        message: obj?.message || lang.somethingWentWrong,
                        title: lang.error,
                        type: 'danger'
                    })
                }
            }
        );
    }

    useEffect(() => {
        fetchData();
    }, [demandId])

    return (
        <ErrorBoundary>
            {loading &&
            <ClayLoadingIndicator/>
            }
            {!loading && !data &&
            <ClayAlert displayType={"warning"} title={lang.warn}>{lang.gdprinfo.emptywarning}</ClayAlert>
            }
            {!loading && data &&
            <ClayList>
                {
                    data.map(row =>
                        <div key={row?.gdprInfoId}>
                            <ClayList.Header>{row?.title || `GDPR Info #${row.gdprInfoId}`}</ClayList.Header>
                            <ClayList.Item flex>
                                <ClayList.ItemField expand>
                                    <ClayTable borderless borderedColumns={false} responsiveSize={"sm"}>
                                        <tbody>
                                        <ClayTable.Row>
                                            <ClayTable.Cell expanded headingTitle columnTextAlignment={"end"}>
                                                {lang.description}
                                            </ClayTable.Cell>
                                            <ClayTable.Cell expanded>
                                                <div dangerouslySetInnerHTML={{__html: row.description}}/>
                                            </ClayTable.Cell>
                                        </ClayTable.Row>

                                        <ClayTable.Row>
                                            <ClayTable.Cell headingTitle columnTextAlignment={"end"}>
                                                {lang.gdprinfo.isclient}
                                            </ClayTable.Cell>
                                            <ClayTable.Cell expanded>
                                                <YesNoLabel value={row?.isClient}/>
                                            </ClayTable.Cell>
                                        </ClayTable.Row>
                                        {!!row?.isClient &&
                                        <>
                                            <FieldItems items={row?.clientCategory}
                                                        label={lang.gdprinfo.category}/>
                                            <FieldItems items={row?.clientReasoning}
                                                        label={lang.gdprinfo.reasoning}/>
                                        </>
                                        }

                                        <ClayTable.Row>
                                            <ClayTable.Cell headingTitle columnTextAlignment={"end"}>
                                                {lang.gdprinfo.isemployee}
                                            </ClayTable.Cell>
                                            <ClayTable.Cell expanded>
                                                <YesNoLabel value={row?.isEmployee}/>
                                            </ClayTable.Cell>
                                        </ClayTable.Row>
                                        {!!row?.isEmployee &&
                                        <>
                                            <FieldItems items={row?.employeeCategory}
                                                        label={lang.gdprinfo.category}/>
                                            <FieldItems items={row?.employeeReasoning}
                                                        label={lang.gdprinfo.reasoning}/>
                                        </>
                                        }
                                        </tbody>
                                    </ClayTable>
                                </ClayList.ItemField>
                                {canEdit &&
                                <ClayList.ItemField>
                                    <ClayList.QuickActionMenu>
                                        <ClayList.QuickActionMenu.Item
                                            onClick={() => deleteRecord(row?.gdprInfoId, row?.title)}
                                            symbol="trash"
                                        />

                                        <ClayList.QuickActionMenu.Item
                                            onClick={() => {
                                                setModalData(row);
                                            }}
                                            symbol="pencil"
                                        />
                                    </ClayList.QuickActionMenu>
                                </ClayList.ItemField>
                                }
                            </ClayList.Item>
                        </div>
                    )
                }

            </ClayList>
            }
            <ClayButton
                displayType={"secondary"}
                onClick={() => {
                    setModalData({})
                }}
                small
            >{lang.gdprinfo.add}</ClayButton>

            <GdprInfoUpdate
                callback={() => {
                    fetchData()
                }}
                demandId={demandId}
                canEdit={true}
                modalData={modalData}
                setModalData={setModalData}/>

        </ErrorBoundary>
    );
}

const FieldItems = (
    {
        label = "",
        items = []
    }) => {
    if (!items || items.length == 0) {
        return null;
    }
    return (
        <ClayTable.Row>
            <ClayTable.Cell headingCell columnTextAlignment={"end"}>{label}</ClayTable.Cell>
            <ClayTable.Cell expanded>
                {items?.map((item) => (
                    <ClayLabel key={item.label} displayType={"secondary"}>{item.label}</ClayLabel>
                ))}
            </ClayTable.Cell>
        </ClayTable.Row>
    )
}

const YesNoLabel = ({value = ""}) => {
    return <>
        {!!value ?
            <ClayLabel displayType={"info"}>{lang.yes}</ClayLabel> :
            <ClayLabel displayType={"danger"}>{lang.no}</ClayLabel>
        }
    </>
}

export default GdprInfoView;