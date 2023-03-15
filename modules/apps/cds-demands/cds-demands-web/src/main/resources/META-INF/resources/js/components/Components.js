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

const LabeledInput = (
    {
        className,
        disabled = false,
        error,
        helpMessage='',
        id,
        label,
        name,
        placeholder = '',
        required = false,
        symbol,
        value,
        ...props
    }
) => {
    return (
        <ErrorBoundary>
            <LabelWrapper
                className={className}
                disabled={disabled}
                error={error}
                helpMessage={helpMessage}
                label={label}
                required={required}
            >
                <ClayInput.Group>
                    {!!symbol &&
                    <ClayInput.GroupItem shrink prepend>
                        <ClayInput.GroupText>
                            <ClayIcon spritemap={spritemap} symbol={symbol}/>
                        </ClayInput.GroupText>
                    </ClayInput.GroupItem>
                    }
                    <ClayInput.GroupItem append>
                        <ClayInput
                            {...props}
                            className='form-control'
                            disabled={disabled}
                            id={id}
                            name={name}
                            placeholder={disabled && !placeholder ? value : placeholder}
                            value={value}
                        />
                    </ClayInput.GroupItem>
                </ClayInput.Group>
            </LabelWrapper>
        </ErrorBoundary>
    )
}

LabeledInput.propTypes = {
    className: PropTypes.string,
    disabled: PropTypes.bool,
    error: PropTypes.oneOfType([PropTypes.bool, PropTypes.string]),
    id: PropTypes.string,
    label: PropTypes.string.isRequired,
    name: PropTypes.string,
    placeholder: PropTypes.string,
    required: PropTypes.bool,
};

const LabelWrapper = (
    {
        children,
        className,
        disabled,
        error,
        helpMessage,
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
                {!!helpMessage && <HelpMessage message={helpMessage} /> }
            </label>
            {children}
            {typeof error === 'string' && <ErrorFeedback error={error}/>}
        </ClayForm.Group>
    );
}

const SelectInput = (
    {
        disabled,
        error,
        helpMessage,
        id,
        label,
        name,
        nullable,
        required,
        options= [],
        value,
        ...restProps
    }) => {
    const inputId = id || name;

    const _handleKeyDown = (event) => {
        if (event.key === 'Enter') {
            event.preventDefault();
        }
    };

    return (
        <ErrorBoundary>
            <LabelWrapper
                disabled={disabled}
                error={error}
                helpMessage={helpMessage}
                id={id}
                label={label}
                name={name}
                required={required}
            >
                <ClaySelect
                    {...restProps}
                    className="form-control"
                    id={inputId}
                    name={name}
                    disabled={disabled}
                    onKeyDown={_handleKeyDown}
                   // value={value}
                >
                    {(nullable || value === '') && (
                        <ClaySelect.Option key="nullableOption" label="" value="" selected={value === ''}/>
                    )}

                    {options.map(item => (
                        <ClaySelect.Option
                            key={item.value}
                            label={item.label}
                            value={item.value}
                            selected={value === item?.value}
                        />
                    ))}
                </ClaySelect>
            </LabelWrapper>
        </ErrorBoundary>
    );
};

SelectInput.propTypes = {
    disabled: PropTypes.bool,
    error: PropTypes.oneOfType([PropTypes.bool, PropTypes.string]),
    id: PropTypes.string,
    label: PropTypes.string.isRequired,
    name: PropTypes.string.isRequired,
    nullable: PropTypes.bool,
    required: PropTypes.bool,
    options: PropTypes.arrayOf(PropTypes.shape({
        value: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
        label: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
    })).isRequired,
    value: PropTypes.oneOfType([PropTypes.string, PropTypes.number]),
};

const RequiredMark = () => {
    return (
        <>
			<span className="inline-item-after reference-mark text-warning">
				<ClayIcon symbol="asterisk"/>
			</span>
            <span className="hide-accessible">
				{Liferay.Language.get('required')}
			</span>
        </>
    );
};


const Sheet = ({title, text, icon, ...props}) => (
    <ClayLayout.Sheet>
        {(title || text) &&
        <ClayLayout.SheetHeader>
            {title && <h2 className="sheet-title">{!!icon&&<ClayIcon symbol={icon}/>}{title}</h2>}
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


const SheetSection = ({title, icon, ...props}) =>
    (
        <ClayLayout.SheetSection>
            {title && <h3 className="sheet-subtitle">{!!icon&&<ClayIcon symbol={icon}/>}{title}</h3>}
            {props.children}
        </ClayLayout.SheetSection>

    )

const LabeledFieldView = (
    {
        displayType = "info",
        hideEmpty = false,
        label,
        symbol = null,
        value
    }) => {
    if (!value && hideEmpty) return;

    return (
        <div className={"col-auto"}>
            <LabelWrapper className=""
                          label={
                              <>{
                                  symbol &&
                                  <><ClayIcon symbol={symbol} spritemap={spritemap} size={"sm"}/>&nbsp;</>
                              }
                                  {label}:&nbsp;
                              </>}>
                {
                    (typeof (value) === 'object') &&
                    value.map((l,i) => (<ClayLabel key={i} displayType={displayType}>{l}</ClayLabel>))
                }
                {
                    (typeof (value) !== 'object') &&
                    <ClayLabel displayType={displayType}>{value}</ClayLabel>
                }
            </LabelWrapper>
        </div>
    );
}

const InfoCardSmall = (
    {
        children,
        colWidth = "",
        label = "",
        showEmpty = false,
        truncate = false
    }
) => {
    return (
        <>
            {(showEmpty || !!children) &&
            <div className={colWidth ? "col-md-" + colWidth : "col-md-auto"}>
                <ClayCard>
                    <ClayCard.Body>
                        <ClayCard.Description displayType="title">
                            {label}
                        </ClayCard.Description>
                        <ClayCard.Description truncate={truncate} displayType="text">
                            {children}
                        </ClayCard.Description>
                    </ClayCard.Body>
                </ClayCard>
            </div>
            }
        </>
    )
}

const LabeledToggle = (
    {
        label = "",
        error,
        ...props
    }
) => {

    return (
        <LabelWrapper
            label={label}
            error={error}
        >
            <div style={{display: "block"}}>
                <ClayToggle
                    {...props}
                    label={null}

                    symbol={{
                        off: "times",
                        on: "check"
                    }}
                />
            </div>
        </LabelWrapper>
    )
}

const LabeledCheckbox = (
    {
        error = null,
        helpMessage,
        label,
        name,
        required = false,
        ...props

    }) =>
    <LabelWrapper
        error={error}
        helpMessage={helpMessage}
        label={label}
        required={required}
        name={name}
    >
        <ClayCheckbox
            {...props}
            name={name}
        />
    </LabelWrapper>

export {
    ErrorFeedback,
    HelpMessage,
    LabelWrapper,
    RequiredMark,
    Sheet,
    SheetSection,
    SelectInput,
    LabeledFieldView,
    InfoCardSmall,
    LabeledToggle,
    LabeledInput,
    LabeledCheckbox
};