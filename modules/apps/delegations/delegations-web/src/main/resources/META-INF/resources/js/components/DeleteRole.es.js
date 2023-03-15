import React from 'react';

import Modal from './Modal.es';
import {useService} from "../hooks/useService";
import {services} from "../constants/constants.es";
import {lang} from "../constants/lang.es";
import {sub} from "../utils/lang.es";

export default function DeleteRole(
    {
        callback = () => {
        },
        role,
        setRole
    }) {

    const [deleteRole] = useService({
        service: services.roles.deleteOne,
        params: {roleId: 0},
        successCallback: (data) => {
            callback(data);
        },
        failureCallback: ({error, message, data}) => {
            console.warn(message)
        },
        successToastMessage: lang.roleSuccessfullyDeleted
    },[])

    const handleDelete = (roleId) => {
        deleteRole({roleId: roleId});
    }

    return (
        <>
            {(
                <Modal
                    body={sub(lang.confirmDeleteRole,
                        [role?.title])}
                    callback={() => {
                        handleDelete(role.roleId);
                    }}
                    onClose={() => {
                        setRole(null);
                    }}
                    status="warning"
                    textPrimaryButton={lang.delete}
                    title={lang.deleteRole}
                    visible={!!role}
                />
            )}
        </>
    );
};