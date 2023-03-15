import ClayBreadcrumb from '@clayui/breadcrumb';
import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import ClayEmptyState from '@clayui/empty-state';
import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import ClayTable from '@clayui/table';
import ClaySticker from '@clayui/sticker';
import ClayUpperToolbar from '@clayui/upper-toolbar';

import IconButton from '@material-ui/core/IconButton';
import DeleteIcon from '@material-ui/icons/Delete';

import React, {useContext, useEffect, useState} from 'react';
import {Link, useNavigate} from 'react-router-dom';

import NewRole from '../components/NewRole.es'
import {AppContext} from '../AppContext.es';
import {lang} from '../constants/lang.es'
import {services} from "../constants/constants.es";
import {useService} from "../hooks/useService";
import DeleteRole from "../components/DeleteRole.es";

export default function Roles () {
    const navigate = useNavigate();

    const context = useContext(AppContext);
    const [showAddModal, setShowAddModal] = useState(false);

    const [loading, setLoading] = useState(true);
    const [roles, setRoles] = useState([]);
    const [roleToDelete, setRoleToDelete] = useState(null);

    const [fetchData] = useService({
        service: services.roles.getMany,
        params: {},
        successCallback: (data) => {
            setRoles(data);
            setLoading(false);
        },
        failureCallback: ({error, message, data}) => {
            console.warn(message)
            setRoles({});
            setLoading(false);
        }
    })

    useEffect(() => {
        fetchData({});
    }, [context.groupId]);

    return (<>
            <ClayUpperToolbar>
                <ClayUpperToolbar.Item className="text-left" expand>
                    <ClaySticker displayType="info" size="xl">
                        <ClayIcon symbol="users"/>
                    </ClaySticker>
                    <label className="component-title">{lang.delegationRoles}</label>
                </ClayUpperToolbar.Item>
                <ClayUpperToolbar.Item>
                    <ClayButtonWithIcon
                        displayType="secondary"
                        onClick={() => {
                            setShowAddModal(true)
                        }}
                        small
                        symbol="plus"
                        title={lang.addRole}
                    />
                </ClayUpperToolbar.Item>
            </ClayUpperToolbar>
            <div className={"container-fluid container-fluid-max-xl"}>
                <ClayBreadcrumb
                    ellipsisBuffer={1}
                    items={[
                        {
                            active: true,
                            href: "#/",
                            label: lang.roles
                        }
                    ]}
                />
            </div>
            <ClayLayout.ContainerFluid view>

                {!loading && (
                    <>
                        {(roles &&
                            roles.length > 0 &&
                            <ClayTable responsive striped>
                                <ClayTable.Head>
                                    <ClayTable.Row>
                                        <ClayTable.Cell headingCell>{lang.role}</ClayTable.Cell>
                                        <ClayTable.Cell headingCell>{lang.code}</ClayTable.Cell>
                                        <ClayTable.Cell expanded headingCell>{lang.description}</ClayTable.Cell>
                                        <ClayTable.Cell headingCell align={"right"}>{lang.action}</ClayTable.Cell>
                                    </ClayTable.Row>
                                </ClayTable.Head>
                                <ClayTable.Body>
                                    {roles.map((role) => (
                                        <ClayTable.Row key={role?.roleId}>
                                            <ClayTable.Cell headingTitle>
                                                <Link to={`/delegations/role/${role?.roleId}`}>
                                                    {role?.title}
                                                </Link>
                                            </ClayTable.Cell>
                                            <ClayTable.Cell>{role?.code}</ClayTable.Cell>
                                            <ClayTable.Cell>{role?.description}</ClayTable.Cell>
                                            <ClayTable.Cell align={"right"}>
                                                <IconButton aria-label="delete" size="small"
                                                            onClick={() => setRoleToDelete(role)}>
                                                    <DeleteIcon fontSize="small"/>
                                                </IconButton>
                                            </ClayTable.Cell>
                                        </ClayTable.Row>
                                    ))}
                                </ClayTable.Body>
                            </ClayTable>
                            || (
                                <ClayEmptyState
                                    title={lang.noRolesTitle}
                                >
                                    {(
                                        <ClayButton
                                            displayType="primary"
                                            onClick={() =>
                                                setShowAddModal(true)
                                            }
                                        >
                                            {lang.newRole}
                                        </ClayButton>
                                    )}
                                </ClayEmptyState>
                            ))}
                    </>
                )}

                <NewRole
                    callback={(data) => {
                        navigate('delegations/role/' + data?.roleId);
                    }}
                    showModal={showAddModal}
                    setShowModal={setShowAddModal}
                />
                <DeleteRole role={roleToDelete} callback={() => fetchData({})} setRole={setRoleToDelete}/>

            </ClayLayout.ContainerFluid>
            {loading && <ClayLoadingIndicator/>}
        </>
    );

}
