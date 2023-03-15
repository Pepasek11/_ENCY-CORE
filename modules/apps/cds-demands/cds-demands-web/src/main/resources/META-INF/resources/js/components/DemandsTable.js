import ClayLabel from '@clayui/label';
import {openToast,} from 'frontend-js-web';
import MUIDataTable from "mui-datatables";
import React, {useEffect, useMemo, useState} from 'react';
import {Link, useSearchParams} from 'react-router-dom';
import {ErrorBoundary} from "./ErrorBoundary.es";
import {StateLabel, TypeShortLabel} from "./Labels.es";
import {dateToBriefInternationalHuman, dateToInternationalHuman} from "../utils/utils.es"
import constants from "../constants/constants.es";
import ClayLoadingIndicator from '@clayui/loading-indicator';

export const DemandsTable = (
    {
        columns,
        id,
        options = {},
        service,
        serviceparams = {},
        ...props
    }) => {
    const [data, setData] = useState([])
    const [loading, setLoading] = useState(true);

    const [searchParams, setSearchParams] = useSearchParams();

    const columnDefs = [
        {
            name: "typeLabel",
            label: Liferay.Language.get('cdsdemand-type'),
            options: {
                filter: true,
                filterType: 'checkbox',
                sort: true,
                customBodyRenderLite: (dataIndex) => {
                    return (<TypeShortLabel label={data[dataIndex]?.typeLabel} code={data[dataIndex]?.type}/>)
                },
            }
        }, {
            name: "title",
            label: Liferay.Language.get('cdsdemand-title'),
            options: {
                filter: false,
                sort: true,
                customBodyRenderLite: (dataIndex) => {
                    let demandId = data[dataIndex]?.demandId;
                    let title = data[dataIndex]?.title;
                    return <Link to={`${constants.navigation.viewdemand}${demandId}`}>{title}</Link>;
                },
            }
        }, {
            name: "titledomain",
            label: Liferay.Language.get('cdsdemand-title-with-domain'),
            options: {
                filter: false,
                sort: true,
                customBodyRenderLite: (dataIndex) => {
                    let demandId = data[dataIndex]?.demandId;
                    let title = data[dataIndex]?.title;
                    let domainId = data[dataIndex]?.domainId;
                    return (
                        <>
                            {!!domainId && <ClayLabel displayType={'secondary'}>{domainId}</ClayLabel>}
                            <Link to={`${constants.navigation.viewdemand}${demandId}`}>{title}</Link>
                        </>
                    );
                },
            }
        },
        {
            name: "stateLabel",
            label: Liferay.Language.get('cdsdemand-state'),
            options: {
                filter: true,
                filterType: 'multiselect',
                sort: true,
                customBodyRenderLite: (dataIndex) => {
                    return <StateLabel
                        code={data[dataIndex]?.state}
                        label={data[dataIndex]?.stateLabel}
                    />;
                },
            }
        },
        {
            name: "domainName",
            label: Liferay.Language.get('cdsdemand-domainname'),
            options: {
                filter: true,
                sort: true,
                filterType: 'multiselect',
            }
        },
        {
            name: "domainId",
            label: Liferay.Language.get('cdsdemand-domainid'),
            options: {
                filter: false,
                sort: true,
                filterType: 'multiselect',
            }
        },
        {
            name: "spocName",
            label: Liferay.Language.get('cdsdemand-spocname'),
            options: {
                filter: true,
                sort: true,
                filterType: 'multiselect',
            }
        },
        {
            name: "banName",
            label: Liferay.Language.get('cdsdemand-banname'),
            options: {
                filter: true,
                sort: true,
                filterType: 'multiselect',
            }
        },
        {
            name: "requestorName",
            label: Liferay.Language.get('cdsdemand-requestor'),
            options: {
                filter: true,
                sort: true,
                filterType: 'multiselect',
            }
        },
        {
            name: "requestedForName",
            label: Liferay.Language.get('cdsdemand-requestedfor'),
            options: {
                filter: true,
                sort: true,
                filterType: 'multiselect',
            }
        },
        {
            name: "contactName",
            label: Liferay.Language.get('cdsdemand-contact'),
            options: {
                filter: true,
                sort: true,
                filterType: 'multiselect',
            }
        },
        {
            name: "modifiedDate",
            label: Liferay.Language.get('cdsdemand-modifieddate'),
            options: {
                filter: false,
                sort: true,
                customBodyRenderLite: (dataIndex) => {
                    let modifiedDate = data[dataIndex]?.modifiedDate;
                    return (
                        <span title={dateToInternationalHuman(new Date(modifiedDate))}>
                            {dateToBriefInternationalHuman(new Date(modifiedDate))}
                        </span>
                    );
                },
            }
        }
    ];

    const usecolumns = useMemo(() => {
        return columnDefs.map(def => {
            return {...def, options: {...def.options, display: columns.includes(def.name)}};
        });
    }, [columns, data])

    const useoptions = useMemo(() => {
        return {
            onChangeRowsPerPage: (n) => {
                searchParams.set(`${id}delta`, n);
                setSearchParams(searchParams);
            },
            onChangePage: (n) => {
                searchParams.set(`${id}page`, n);
                setSearchParams(searchParams);
            },
            page: searchParams.get(`${id}page`) ?? 0,
            print: false,
            rowsPerPage: searchParams.get(`${id}delta`) ?? 25,
            rowsPerPageOptions: [10, 25, 50, 100, -1],
            selectableRows: 'none',
            setTableProps: () => {
                return {
                    size: 'small',
                };
            },
            sortOrder: {
                name: 'modifiedDate',
                direction: 'desc'
            },
            ...options,
        }
    }, [options]);

    useEffect(() => {
        setLoading(true);
        Liferay.Service(
            service,
            serviceparams,
            function ({success, data, message, error, exception}) {
                if (success === true) {
                    setData(data ?? []);
                } else {
                    openToast({
                        message: message ?? error ?? exception ?? lang.unexpectedError,
                        title: lang.error,
                        type: 'error',
                    });
                    setData({});
                }
                setLoading(false);
            }
        );
    }, [serviceparams, service])

    return (
        <ErrorBoundary>
            <>
                {loading &&
                <div style={{position: 'absolute', top: '1.5erm', left: '50%'}}>
                    <ClayLoadingIndicator size={"sm"} style={{width: '50%', height: '50%'}}/>
                </div>}
                <MUIDataTable
                    {...props}
                    data={data}
                    id={id}
                    columns={usecolumns}
                    options={useoptions}
                />
            </>
        </ErrorBoundary>
    )
}
