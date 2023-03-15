import React from 'react';

import Modal from './Modal.es';
import {useService} from "../hooks/useService";
import {services} from "../constants/constants.es";
import {lang} from "../constants/lang.es";
import {sub} from "../utils/lang.es";

export default function DeleteDelegation(
    {
        callback = () => {
        },
        delegation,
        role,
        setDelegation
    }) {

    const [deleteDelegation] = useService({
        service: services.delegations.deleteOne,
        params: {delegationId: 0},
        successCallback: (data) => {
            callback(data);
        },
        failureCallback: ({error, message, data}) => {
            console.warn(message)
        },
        successToastMessage: lang.delegationSuccessfullyDeleted
    })

    const handleDelete = (delegationId) => {
        deleteDelegation({delegationId: delegationId});
    }

    return (
        <>
            {(
                <Modal
                    body={sub(lang.confirmDeleteDelegation,
                        [role?.title, delegation?.delegatingUserName, delegation?.delegatedUserName])}
                    callback={() => {
                        handleDelete(delegation.delegationId);
                    }}
                    onClose={() => {
                        setDelegation(null);
                    }}
                    status="warning"
                    textPrimaryButton={lang.delete}
                    title={lang.deleteDelegation}
                    visible={!!delegation}
                />
            )}
        </>
    );
};