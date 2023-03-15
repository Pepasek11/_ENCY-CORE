import Box from '@material-ui/core/Box';
import TextField from '@material-ui/core/TextField';
import ClayForm from '@clayui/form';
import React, {useRef, useState} from 'react';
import {sub} from '../utils/lang.es';
import {useService} from "../hooks/useService";
import {services} from "../constants/constants.es";
import {lang} from "../constants/lang.es";
import Modal from "./Modal.es";

export default function NewRole(
    {
        callback = () => {
        },
        setShowModal = () => {
        },
        showModal = false,
    }) {
    const [errors, setErrors] = useState(null);
    const roleName = useRef(null);
    const roleCode = useRef(null);
    const roleDescription = useRef(null);

    const [createNewRole] = useService({
            service: services.roles.updateOne,
            params: {},
            successCallback: (data) => {
                callback(data);
            },
            failureCallback: ({message, data, error}) => {
                console.warn(message, error);
            }
        }
    );

    const handleAdd = () => {
        if (validate()) {
            createNewRole({
                roleId: 0,
                code: roleCode?.current?.value ?? '',
                title: roleName?.current?.value ?? '',
                description: roleDescription?.current?.value ?? ''
            });
        }
    };

    const validate = () => {
        let errs = {};
        let ok = true;

        if (!roleName.current.value || roleName.current.value.length === 0) {
            errs.name = sub(lang.errors.fieldEmpty, [lang.roleName]);
            ok = false;
        }
        const hyphens = /^[a-z0-9_-]+$/ig;
        if (!roleCode.current.value || roleCode.current.value.length === 0) {
            errs.code = sub(lang.errors.fieldEmpty, [lang.roleCode]);
            ok = false
        } else if (!hyphens.test(roleCode.current.value)) {
            errs.code = sub(lang.errors.codeBadCharacters,
                [lang.code, '- _']
            );
            ok = false;
        }
        setErrors(ok ? null : errs);
        return ok;
    }

    const modalBody = <ClayForm>
        <TextField
            error={!!errors?.name}
            fullWidth
            helperText={!!errors?.name ? errors.name : lang.roleNameDescription}
            id="roleName"
            inputRef={roleName}
            label={lang.roleName}
            onBlur={validate}
            onChange={validate}
            placeholder={lang.roleNamePlaceholder}
            required
            size={"small"}
            variant="outlined"
        />
        <Box mt={2}>
            <TextField
                error={!!errors?.code}
                fullWidth
                helperText={!!errors?.code ? errors.code : lang.roleCodeDescription}
                id="roleCode"
                inputRef={roleCode}
                label={lang.roleCode}
                onBlur={validate}
                onChange={validate}
                placeholder={lang.roleCodePlaceholder}
                required
                size={"small"}
                variant="outlined"
            />
        </Box>
        <Box mt={2}>
            <TextField
                id="roleDescription"
                inputRef={roleDescription}
                label={lang.note}
                fullWidth
                multiline
                placeholder={lang.descriptionPlaceholder}
                size={"small"}
                variant="outlined"
            />
        </Box>
    </ClayForm>

    return (
        <>
            <Modal
                body={modalBody}
                callback={() => {
                    handleAdd();
                }}
                onClose={() => {
                    setShowModal(false);
                }}
                primaryButtonDisabled={!!errors || !roleName?.current?.value}
                status="info"
                textPrimaryButton={lang.addRole}
                title={lang.newRole}
                visible={!!showModal}
            />
        </>
    );
};