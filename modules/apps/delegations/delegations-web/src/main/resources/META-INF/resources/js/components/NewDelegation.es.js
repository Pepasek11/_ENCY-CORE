import ClayLayout from '@clayui/layout';
import TextField from '@material-ui/core/TextField';

import {lang} from '../constants/lang.es'
import UsersSelect from "../components/UsersSelect";

import React, {useRef, useState} from 'react';
import {useService} from "../hooks/useService";
import {services} from "../constants/constants.es";
import Modal from "./Modal.es";

export default function NewDelegation(
    {
        showModal,
        roleId = 0,
        setShowModal = () => {
        },
        successCallback = () => {
        }
    }) {
    const [from, setFrom] = useState(null);
    const [to, setTo] = useState(null);
    const noteRef = useRef(null);

    const handleAdd = () => {
        if (!from || !to) return;
        addDelegation({
            delegatingUserId: from?.value ?? 0,
            delegatedUserId: to?.value ?? 0,
            note: noteRef?.current?.value ?? ''
        });
    }

    const [addDelegation] = useService({
            service: services.delegations.updateOne,
            params: {
                delegationId: 0,
                roleId: roleId,
                delegatingUserId: 0,
                delegatedUserId: 0,
                note: ''
            },
            successCallback: (data) => {
                setFrom(null);
                setTo(null);
                noteRef.current.value = "";
                successCallback(data);
            },
            failureCallback: ({message, data, error}) => {
                console.warn(message, error);
            }
        }
    );

    const modalBody =
        <>
            <ClayLayout.Row>
                <ClayLayout.Col size={6}>
                    <UsersSelect
                        id={"delegationFromId"}
                        label={lang.delegateFrom}
                        required={true}
                        isMulti={false}
                        onChange={(e) => {
                            setFrom(e)
                        }}
                    />
                </ClayLayout.Col>
                <ClayLayout.Col size={6}>
                    <UsersSelect
                        id={"delegationToId"}
                        label={lang.delegateTo}
                        required={true}
                        isMulti={false}
                        onChange={(e) => {
                            setTo(e)
                        }}
                    />
                </ClayLayout.Col>
            </ClayLayout.Row>
            <ClayLayout.Row>
                <ClayLayout.Col size={12}>
                    <TextField
                        label={lang.note}
                        fullWidth
                        multiline
                        placeholder={lang.notePlaceholder}
                        size={"small"}
                        variant="outlined"
                        inputRef={noteRef}
                    />
                </ClayLayout.Col>
            </ClayLayout.Row>
        </>

    return (
        <Modal
            body={modalBody}
            callback={() => {
                handleAdd();
            }}
            onClose={() => {
                setShowModal(false);
            }}
            primaryButtonDisabled={!to || !from}
            status="info"
            textPrimaryButton={lang.addDelegation}
            title={lang.newDelegation}
            visible={!!showModal}
        />
    );
}


