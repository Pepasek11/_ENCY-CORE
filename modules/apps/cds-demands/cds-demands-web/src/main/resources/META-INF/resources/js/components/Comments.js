'use strict';
import ClayButton from '@clayui/button';
import ClayCard from '@clayui/card';
import ClayForm, {ClayInput} from '@clayui/form';
import ClayLayout from '@clayui/layout';
import ClayList from '@clayui/list';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import {useFormik} from 'formik';
import React, {useEffect, useState} from "react";
import {ErrorBoundary} from "../components/ErrorBoundary.es";
import constants from "../constants/constants.es";
import {dateToInternationalHuman} from "../utils/utils.es";
import {useService} from "../hooks/useService";
import {lang} from "../constants/lang.es";

import AddCommentIcon from '@material-ui/icons/AddComment';
import IconButton from '@material-ui/core/IconButton';
const Comments = (
    {
        className,
        entryId,
        lid = 0,
        ref = {}
    }) => {

    const [comments, setComments] = useState([]);
    const [loadingComments, setLoadingComments] = useState(true);
    const [showAddForm, setShowAddForm] = useState(false);
    const commentBodyId = 'commentBody';

    const [fetchComments] = useService({
        service: constants.services.getcomments,
        params: {
            groupId: Liferay.ThemeDisplay.getSiteGroupId(),
            className: className,
            classPK: entryId,
            start: -1,
            end: -1
        },
        successCallback: (data) => {
            setComments(data ?? []);
            setLoadingComments(false)
        },
        failureCallback:()=>{
            setLoadingComments(false)
        },
        showSuccessToast: false,
        showFailToastMessage: false,

    });

    useEffect(() => {
        ref.current = this
    }, [ref])

    useEffect(() => {
            loadComments();
        }, [lid]
    )

    const loadComments = () => {
        if (!entryId) return;
        setLoadingComments(true);
        fetchComments({});
    }

    const formik = useFormik({
        initialValues: {
            [commentBodyId]: ""
        },
        onSubmit: (values) => {
            Liferay.Service(
                '/ency.commentmanagerjsonws/add-comment',
                {
                    groupId: Liferay.ThemeDisplay.getSiteGroupId(),
                    className: 'cz.csob.ency.cds.demands.model.CdsDemand',
                    classPK: entryId,
                    body: values[commentBodyId]
                },
                function (obj) {
                    // console.log(obj);
                    loadComments();
                    setFieldValue(commentBodyId, "");
                    setShowAddForm(false);
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
    } = formik;


    return (
        <ErrorBoundary>
            <div className="sidebar-header">
                <div className="autofit-float autofit-padded-no-gutters-x autofit-row">
                    <div className="autofit-col autofit-col-expand component-title h4">{lang.comments.comments}</div>
                    <div className="autofit-col autofit-col-end">
                    <IconButton
                        color={showAddForm?"default":"primary"}
                        aria-label={lang.comments.add}
                        onClick={() => setShowAddForm(!showAddForm)}>
                        <AddCommentIcon  size={"small"}/>
                    </IconButton>
                    </div>
                </div>
            </div>
            <div className="sidebar-body">
                {showAddForm &&
                <ClayForm onSubmit={formik.handleSubmit}>
                    <ClayLayout.Row>
                        <ClayLayout.ContentCol expand className={"c-p-2"}>
                            <ClayInput
                                component="textarea"
                                id={commentBodyId}
                                name={commentBodyId}
                                placeholder={lang.comments.placeholder}
                                onBlur={handleBlur}
                                onChange={handleChange}
                                type="text"
                                value={values[commentBodyId]}
                            />
                        </ClayLayout.ContentCol>
                    </ClayLayout.Row>
                    <ClayLayout.Row>
                        <ClayLayout.ContentCol className={"c-p-2"}>
                            <ClayButton displayType="secondary" small onClick={() => setShowAddForm(false)}>
                                {lang.cancel}
                            </ClayButton>
                        </ClayLayout.ContentCol>
                        <ClayLayout.ContentCol expand/>
                        <ClayLayout.ContentCol className={"c-p-2"}>
                            <ClayButton
                                displayType="primary" small
                                title={lang.comments.add}
                                type="submit"
                            >
                                {lang.comments.add}
                            </ClayButton>
                        </ClayLayout.ContentCol>
                    </ClayLayout.Row>
                </ClayForm>
                }
                <ClayList>
                    {
                        comments && comments.map(comment => (<CommentCard comment={comment}/>))
                    }
                    {loadingComments && <ClayLoadingIndicator/>}
                </ClayList>
            </div>
        </ErrorBoundary>
    );

}

const CommentCard = (
    {
        comment
    }) => {

    return (
        <ClayCard>
            <ClayCard.Body>
                <ClayCard.Row>
                    <div className="autofit-col autofit-col-expand">
                        <section className="autofit-section">
                            <ClayCard.Description displayType="title">
                                {comment?.userName ? comment?.userName : "System"}
                            </ClayCard.Description>
                            <ClayCard.Description truncate={false} displayType="text">
                                {comment?.body}
                            </ClayCard.Description>
                            <ClayCard.Description displayType="subtitle text-right">
                                {dateToInternationalHuman(new Date(comment?.createDate))}
                            </ClayCard.Description>
                        </section>
                    </div>
                </ClayCard.Row>
            </ClayCard.Body>
        </ClayCard>
    )
}

export default Comments;