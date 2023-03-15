import ClayBreadcrumb from '@clayui/breadcrumb';
import {ClayButtonWithIcon} from '@clayui/button';
import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import ClayTable from '@clayui/table';
import ClaySticker from '@clayui/sticker';
import ClayUpperToolbar from '@clayui/upper-toolbar';
import DeleteIcon from '@material-ui/icons/Delete';
import IconButton from '@material-ui/core/IconButton';

import React, {useContext, useEffect, useState} from 'react';
import {Link, useParams} from 'react-router-dom';
import {AppContext} from '../AppContext.es';
import {lang} from '../constants/lang.es'
import {sub} from '../utils/lang.es'
import {services} from "../constants/constants.es";
import {useService} from "../hooks/useService";
import NewDelegation from "../components/NewDelegation.es";
import {Sheet, SheetSection} from "../components/Components";
import DeleteDelegation from "../components/DeleteDelegation.es";

const Roles = ({props}) => {
    const params = useParams();
    const roleId = params?.roleId;

    if (!roleId) {
        return <h2>Not found. <Link to={'/'}>Return home</Link></h2>;
    }

    const context = useContext(AppContext);

    const [delegations, setDelegations] = useState([]);
    const [delegationToDelete, setDelegationToDelete] = useState(null);
    const [loading, setLoading] = useState(true);
    const [role, setRole] = useState(null);
    const [showAddModal, setShowAddModal] = useState(false);

    const [fetchRole] = useService({
        service: services.roles.getOne,
        params: {},
        successCallback: (data) => {
            setRole(data);
            setLoading(false);
        },
        failureCallback: ({error, message, data}) => {
            console.warn(message)
            setRole(null);
        }
    })

    const [fetchDelegations] = useService({
        service: services.delegations.getMany,
        params: {},
        successCallback: (data) => {
            setDelegations(data?.sort(function (a, b) {
                return ('' + a?.delegatingUserName).localeCompare(b?.delegatingUserName);
            }));
            setLoading(false);
        },
        failureCallback: ({error, message, data}) => {
            console.warn(message)
            setDelegations([]);
            setLoading(false);
        }
    })

    useEffect(() => {
        fetchRole({roleId: roleId});
        fetchDelegations({roleId: roleId})
    }, [context.groupId, roleId]);

    return (<>
            <ClayUpperToolbar>
                <ClayUpperToolbar.Item className="text-left" expand>
                    <ClaySticker displayType="info" size="xl">
                        <ClayIcon symbol="users"/>
                    </ClaySticker>
                    <label className="component-title">{sub(lang.delegationRoleX, [!!role ? role.title : ""])}</label>
                </ClayUpperToolbar.Item>
                <ClayUpperToolbar.Item>
                    <ClayButtonWithIcon
                        displayType="secondary"
                        onClick={() => setShowAddModal(true)}
                        small
                        symbol="plus"
                        title={lang.addDelegation}
                    />
                </ClayUpperToolbar.Item>
            </ClayUpperToolbar>
            <div className={"container-fluid container-fluid-max-xl"}>
                <ClayBreadcrumb
                    ellipsisBuffer={1}
                    items={[
                        {
                            active: false,
                            href: "#/",
                            label: lang.roles
                        }, {
                            active: true,
                            href: "#/delegations/role/" + roleId,
                            label: role?.title
                        }
                    ]}
                />
            </div>
            <ClayLayout.ContainerFluid view>
                <Sheet>

                    {!loading && (
                        <>
                            {(role && role.description &&
                                <SheetSection title={lang.description}>
                                    {role.description}
                                </SheetSection>
                            )}
                            <SheetSection title={lang.delegations}>
                                <ClayTable responsive striped mt={2}>
                                    <ClayTable.Head>
                                        <ClayTable.Row>
                                            <ClayTable.Cell expanded headingCell>{lang.delegateFrom}</ClayTable.Cell>
                                            <ClayTable.Cell expanded headingCell>{lang.delegateTo}</ClayTable.Cell>
                                            <ClayTable.Cell expanded headingCell>{lang.note}</ClayTable.Cell>
                                            <ClayTable.Cell headingCell>{lang.action}</ClayTable.Cell>
                                        </ClayTable.Row>
                                    </ClayTable.Head>
                                    <ClayTable.Body>
                                        {role && delegations && delegations.length > 0
                                        && delegations.map((delegation) => (
                                            <ClayTable.Row key={delegation?.delegationId}>
                                                <ClayTable.Cell>{delegation?.delegatingUserName}</ClayTable.Cell>
                                                <ClayTable.Cell>{delegation?.delegatedUserName}</ClayTable.Cell>
                                                <ClayTable.Cell>{delegation?.note}</ClayTable.Cell>
                                                <ClayTable.Cell align={"right"}>
                                                    <IconButton aria-label="delete" size="small"
                                                                onClick={() => setDelegationToDelete(delegation)}>
                                                        <DeleteIcon fontSize="small"/>
                                                    </IconButton>
                                                </ClayTable.Cell>
                                            </ClayTable.Row>
                                        )) ||
                                        <ClayTable.Row>
                                            <ClayTable.Cell colspan={4} align={"center"}>
                                                {"No delegations yet"}
                                            </ClayTable.Cell>
                                        </ClayTable.Row>
                                        }
                                    </ClayTable.Body>
                                </ClayTable>
                            </SheetSection>

                        </>
                    )}
                    {loading && <ClayLoadingIndicator/>}
                </Sheet>
            </ClayLayout.ContainerFluid>
            <NewDelegation
                showModal={showAddModal}
                roleId={roleId}
                successCallback={() => {
                    fetchDelegations({roleId: roleId})
                }}
                setShowModal={setShowAddModal}
            />
            <DeleteDelegation
                role={role}
                delegation={delegationToDelete}
                callback={() => fetchDelegations({roleId: roleId})}
                setDelegation={setDelegationToDelete}
            />
        </>
    );

}

export default Roles;