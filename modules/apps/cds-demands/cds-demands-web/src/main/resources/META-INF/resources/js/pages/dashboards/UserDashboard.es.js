import React, {useContext} from 'react';
import ClayLayout from '@clayui/layout';
import {Box} from '@material-ui/core';
import {ErrorBoundary} from "../../components/ErrorBoundary.es";
import {SingleDomain} from "../../components/Cloudy.es";
import constants from "../../constants/constants.es";
import {DemandsTable} from "../../components/DemandsTable";
import {AppContext} from "../../AppContext.es";
import {lang} from "../../constants/lang.es";

export default function UserDashboard(props) {
    const context = useContext(AppContext);

    const columns = ["typeLabel", "title", "stateLabel", "spocName", "banName", "modifiedDate"];
    return (
        <section className="demands-section">
            <ClayLayout.ContainerFluid className={"demand-container"} view size={false}>
                <ClayLayout.Row>
                    <ClayLayout.Col xl={10} md={9} sm={12}>
                        <ErrorBoundary>
                            <Box pb={2}>
                                <DemandsTable
                                    id={"dtac"}
                                    title={lang.sections.myactionrequired}
                                    columns={columns}
                                    service={constants.services.demands.requiringuseraction}
                                    serviceparams={{"userId": Liferay.ThemeDisplay.getUserId()}}
                                />
                            </Box>
                            <Box pb={2}>
                                <DemandsTable
                                    id={"dtmy"}
                                    title={lang.sections.mydemands}
                                    columns={columns}
                                    service={constants.services.demands.userdemands}
                                    serviceparams={{userId: Liferay.ThemeDisplay.getUserId(), getLongClosed: true}}
                                />
                            </Box>
                        </ErrorBoundary>
                    </ClayLayout.Col>
                    <ClayLayout.Col md={3} xl={2} sm={12}>
                        <div>
                            <SingleDomain pb={2} domain={Number(context.userDomainId)}/>
                        </div>
                    </ClayLayout.Col>
                </ClayLayout.Row>
            </ClayLayout.ContainerFluid>
        </section>
    )
}