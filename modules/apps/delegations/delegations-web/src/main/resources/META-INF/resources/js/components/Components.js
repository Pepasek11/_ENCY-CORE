/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import ClayCard from '@clayui/card';
import ClayForm, {ClayCheckbox, ClayInput, ClaySelect, ClayToggle} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import ClayLabel from '@clayui/label';
import ClayLayout from '@clayui/layout';
import ClayTooltip from '@clayui/tooltip';
import PropTypes from 'prop-types';

import classNames from 'classnames';
import React from 'react';
import {ErrorBoundary} from "./ErrorBoundary.es";

const spritemap = Liferay.ThemeDisplay.getPathThemeImages() + '/clay/icons.svg';

const ErrorFeedback = ({error}) => {
    return (
        <>
            {
                !!error &&
                <ClayForm.FeedbackGroup>
                    <ClayForm.FeedbackItem>
                        <ClayForm.FeedbackIndicator
                            spritemap={spritemap}
                            symbol="exclamation-full"
                        />
                        {error}
                    </ClayForm.FeedbackItem>
                </ClayForm.FeedbackGroup>
            }
        </>
    );
};

ErrorFeedback.propTypes = {
    error: PropTypes.string
};

const HelpMessage = ({message}) => {
    return (
        <>
            {!!message &&
            <span
                className="inline-item-after lfr-portal-tooltip tooltip-icon"
                title={message}
            >
			<ClayIcon symbol="question-circle-full"/>
		    </span>
            }
        </>
    );
};

HelpMessage.propTypes = {
    message: PropTypes.string
};

const LabelWrapper = (
    {
        children,
        className,
        disabled,
        error,
        id,
        label,
        name,
        required,
    }) => {
    const inputId = id || name;

    return (
        <ClayForm.Group className={classNames(className, (error ? 'has-error' : ''))}>
            <label className={disabled ? 'disabled' : ''} htmlFor={inputId}>
                {label}

                {required && <RequiredMark/>}
            </label>
            {children}
            {typeof error === 'string' && <ErrorFeedback error={error}/>}
        </ClayForm.Group>
    );
}

const RequiredMark = () => {
    return (
        <>
			<span className="inline-item-after reference-mark text-warning">
				<ClayIcon symbol="asterisk"/>
			</span>
            <span className="hide">
				{Liferay.Language.get('required')}
			</span>
        </>
    );
};


const Sheet = ({title, text, ...props}) => (
    <ClayLayout.Sheet>
        {(title || text) &&
        <ClayLayout.SheetHeader>
            {title && <h2 className="sheet-title">{title}</h2>}
            {text &&
            <div className="sheet-text">
                {text}
            </div>
            }
        </ClayLayout.SheetHeader>
        }
        {props.children}
    </ClayLayout.Sheet>
)


const SheetSection = ({title, ...props}) =>
    (
        <ClayLayout.SheetSection>
            {title && <h3 className="sheet-subtitle">{title}</h3>}
            {props.children}
        </ClayLayout.SheetSection>

    )



export {
    ErrorFeedback,
    HelpMessage,
    LabelWrapper,
    RequiredMark,
    Sheet,
    SheetSection,
};