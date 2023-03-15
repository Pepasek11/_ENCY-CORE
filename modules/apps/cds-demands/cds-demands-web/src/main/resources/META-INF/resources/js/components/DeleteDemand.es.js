import React from 'react';

import Modal from './Modal.es';
import {useService} from "../hooks/useService";
import constants from "../constants/constants.es";
import {lang} from "../constants/lang.es";
import {sub} from "../utils/lang.es";

export default function DeleteDemand(
    {
        callback = () => {
        },
        entry,
        setEntry
    }) {

    const [deleteRole] = useService({
        service:  constants.services.deleteentry,
        params: {primaryKey: 0},
        successCallback: (data) => {
            callback(data);
        },
        failureCallback: ({error, message, data}) => {
            console.warn(message)
        },
        successToastMessage: sub(lang.demand.successfullyDeleted,[entry?.title])
    },[entry])

    const handleDelete = (roleId) => {
        deleteRole({primaryKey: roleId});
    }

    return (
        <>
            {(
                <Modal
                    body={sub(lang.demand.confirmDelete,
                        [entry?.title])}
                    callback={() => {
                        handleDelete(entry?.demandId);
                    }}
                    onClose={() => {
                        setEntry(null);
                    }}
                    status="warning"
                    textPrimaryButton={lang.delete}
                    title={lang.demand.delete}
                    visible={!!entry}
                />
            )}
        </>
    );
};