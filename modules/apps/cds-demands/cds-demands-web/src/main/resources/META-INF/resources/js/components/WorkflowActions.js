'use strict';
import ClayAlert from '@clayui/alert';
import ClayButton from '@clayui/button';
import ClayDropDown from '@clayui/drop-down';
import ClayForm, {ClayInput} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import ClaySticker from '@clayui/sticker';
import {useFormik} from 'formik';
import {openToast,} from 'frontend-js-web';
import React, {useContext, useState} from "react";
import {useNavigate} from 'react-router-dom';
import {AppContext} from "../AppContext.es";
import constants from "../constants/constants.es";
import Modal from "./Modal.es";
import {lang} from "../constants/lang.es";

const WFActions = (
    {
        actions,
        entryId,
        onSuccess,
        type = 'dropdown'
    }
) => {
    const [transitionName, setTransitionName] = useState('');

    const context = useContext(AppContext);
    const namespace = context?.namespace ?? '';
    const commentId = `${namespace}transitionComment`;
    const ajaxId = `${namespace}ajax`;
    const navigate = useNavigate();

    const formik = useFormik({
        initialValues: {
            [commentId]: "",
            [ajaxId]: true
        },
        onSubmit: (values) => {
           // console.log("submitting action for id=" + entryId)
            Liferay.Service(
                constants.services.workflowaction,
                {
                    entryId: entryId,
                    transitionName: transitionName,
                    comment: values[commentId],
                },
                function (obj) {
                    if (obj && obj?.success) {
                        openToast({
                            message: obj?.message,
                            title: lang.success,
                            type: 'success',
                        });
                        if (onSuccess) {
                            onSuccess();
                            navigate(constants.navigation.viewdemand + entryId);
                        } else {
                            navigate(constants.navigation.viewdemand + entryId);
                        }
                      //  console.log(obj);
                    } else {
                        openToast({
                            message: obj?.message ||
                                lang.unexpectedError,
                            title: Liferay.Language.get('error'),
                            type: 'danger',
                        });
                        navigate(constants.navigation.viewdemand + entryId);
                    }
                    setTransitionName('');
                    setFieldValue(commentId, '');
                }
            );
        }
    });


    const {
        errors,
        handleBlur,
        handleChange,
        setFieldValue,
        touched,
        values,
        handleSubmit,
    } = formik;

    return (
        <>
            {type === 'dropdown' ?
                <ActionsDropDown
                    actions={actions}
                    onTransitionClick={(name) => setTransitionName(name)}
                /> :
                <ActionsButtons
                    actions={actions}
                    onTransitionClick={(name) => setTransitionName(name)}
                />
            }

            <Modal
                title={lang.workflow.transitionComment}
                visible={!!transitionName}
                onClose={() => setTransitionName('')}
                status="info"
                callback={handleSubmit}
                textPrimaryButton={lang.ok}
                textSecondaryButton={lang.cancel}
                body={
                    <ClayForm onSubmit={formik.handleSubmit}>
                        <ClayInput
                            component="textarea"
                            id={commentId}
                            name={commentId}
                            placeholder={lang.comments.placeholder}
                            onBlur={handleBlur}
                            onChange={handleChange}
                            type="text"
                            value={values[commentId]}
                        />
                    </ClayForm>
                }
                size={'lg'}
            />
        </>
    );
}


const ActionsButtons = (
    {
        actions,
        onTransitionClick
    }) => {
    return (
        <>
            {(!actions || actions.length === 0) ?
                <div className="c-mt-3">
                    <ClayAlert displayType="info" variant="feedback">
                        {lang.workflow.noActions}
                    </ClayAlert>
                </div>
                : actions.map((item) => (
                    <ClayButton
                        key={item?.name}
                        onClick={() => onTransitionClick(item?.name)}
                        small borderless displayType={"secondary"}
                    >
                        <ClaySticker displayType={item?.cssIconColor?item?.cssIconColor:"info"} size={"sm"}>
                          <ClayIcon symbol={item?.cssIcon ? item?.cssIcon : 'arrow-start'} />
                        </ClaySticker>
                        {item.title}
                    </ClayButton>
                ))
            }

        </>
    );
}

const ActionsDropDown = (
    {
        actions,
        onTransitionClick
    }) => {
    const [active, setActive] = useState(false);

    return (
        <ClayDropDown
            active={active}
            hasLeftSymbols
            onActiveChange={setActive}
            menuElementAttrs={{
                //  className: 'my-custom-dropdown-menu',
                containerProps: {
                    className: 'dropdown-menu-react-portal-div',
                    id: 'dropdownMenuReactPortalDiv',
                },
            }}
            trigger=
                {
                    <ClayButton
                        displayType="secondary"
                        small
                        title={lang.workflow.actions}
                        type="button"
                    >
                            <span className="inline-item inline-item-before">
                                <ClayIcon symbol="workflow" size={"sm"}/>
                            </span>
                        {lang.workflow.actions}
                    </ClayButton>
                }
        >
            <ClayDropDown.ItemList>
                {
                    !!actions &&
                    actions.map((item) => (
                        <>
                            <ClayDropDown.Item
                                onClick={() => onTransitionClick(item?.name)}
                                key={item.name}
                                symbolLeft={item?.cssIcon ? item?.cssIcon : ''}
                            >
                                {item.title}
                            </ClayDropDown.Item>
                        </>
                    ))}
            </ClayDropDown.ItemList>
            {
                (!actions || actions.length === 0) &&
                <ClayDropDown.Caption>{lang.workflow.noActions}</ClayDropDown.Caption>
            }
        </ClayDropDown>
    )
}

export default WFActions;