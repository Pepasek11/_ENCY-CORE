import React, {useContext, useEffect, useState} from 'react';
import ClayLayout from '@clayui/layout';
import {Box, IconButton, Tooltip} from '@material-ui/core';
import HistoryIcon from "@material-ui/icons/History";
import SupervisorAccountIcon from '@material-ui/icons/SupervisorAccount';
import {ErrorBoundary} from "../../components/ErrorBoundary.es";
import {MultiDomain} from "../../components/Cloudy.es";
import constants from "../../constants/constants.es";
import {DemandsTable} from "../../components/DemandsTable";
import {AppContext} from "../../AppContext.es";
import {makeStyles} from '@material-ui/core/styles';

import {lang} from "../../constants/lang.es";
import {sub} from "../../utils/lang.es";

const useStyles = makeStyles((theme) => ({
    formControl: {
        margin: 10,
        minWidth: 120,
    },
    selectEmpty: {
        marginTop: theme.spacing(2),
    },
}));

export default function DomainDashboard(props) {
    const classes = useStyles();

    const context = useContext(AppContext);
    const [allDrafts, setAllDraft] = useState(false);
    const [showOldClosed, setShowOldClosed] = useState(false);
    const [serviceParams, setServiceParams] = useState({
        userId: Liferay.ThemeDisplay.getUserId(),
        domainId: [],
        getLongClosed: showOldClosed,
        includeOthersDrafts: allDrafts
    })

    useEffect(() => {
        setServiceParams({
            ...serviceParams,
            domainId: domainFilter,
            getLongClosed: showOldClosed,
            includeOthersDrafts: allDrafts
        })
    }, [showOldClosed, allDrafts, domainFilter])

    const [domainFilter, setDomainFilter] = useState( [])
    const [domains, setDomains] = useState([])

    const columns = ["typeLabel", "domainName", "title", "stateLabel", "requestorName", "spocName", "banName", "modifiedDate"];

    const CustomToolbar = () => {
        return (
            <>
                <Tooltip title={lang.dashboards.showfinalstates}>
                    <IconButton onClick={() => setShowOldClosed(!showOldClosed)} color={showOldClosed ? "primary" : ""}>
                        <HistoryIcon/>
                    </IconButton>
                </Tooltip>
                <Tooltip title={lang.dashboards.showothersdrafts}>
                    <IconButton onClick={() => setAllDraft(!allDrafts)} color={allDrafts ? "primary" : ""}>
                        <SupervisorAccountIcon/>
                    </IconButton>
                </Tooltip>
            </>
        );
    }

    return (
        <section className="demands-section">
            <ClayLayout.ContainerFluid className={"demand-container"} view size={false}>
                <ClayLayout.Row>
                    <ClayLayout.Col size={12}>
                        <ErrorBoundary>
                            <Box pb={2}>
                                <DemandsTable
                                    id={"dt"}
                                    title={sub(lang.dashboards.domainxdemands, [context.userDomainId])}
                                    columns={columns}
                                    service={constants.services.demands.domaindemands}
                                    serviceparams={serviceParams}
                                    options={{
                                        customToolbar: () => {
                                            return (
                                                <CustomToolbar/>
                                            );
                                        },
                                        onFilterChange:(changedColumn, filterList, type, index)=>{
                                            if(changedColumn === 'domainName') {
                                                setDomainFilter(filterList[index].map(x=>parseInt(x)));
                                            }
                                        }

                                    }}
                                />
                            </Box>
                        </ErrorBoundary>
                    </ClayLayout.Col>
                </ClayLayout.Row>
                <ClayLayout.Row>
                    <ClayLayout.Col size={12}>
                        <div>
                            <MultiDomain
                                pb={2}
                                domains={domainFilter}
                                setDomainsCallback={(data) => setDomains(data)}
                            />
                        </div>
                    </ClayLayout.Col>
                </ClayLayout.Row>
            </ClayLayout.ContainerFluid>
        </section>
    )
}
