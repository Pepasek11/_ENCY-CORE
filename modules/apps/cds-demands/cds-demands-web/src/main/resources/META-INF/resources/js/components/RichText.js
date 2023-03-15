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

import {ClassicEditor} from 'frontend-editor-ckeditor-web';
import React, {useEffect, useMemo, useRef} from 'react';

import {LabelWrapper} from "./Components";

const RichText = (
    {
        contents,
        editorConfig,
        error,
        id,
        label,
        name,
        onBlur,
        onChange,
//        onFocus,
        readOnly,
        required,
        visible,
        ...otherProps
    }) => {

    const editorRef = useRef();

    return (
        <LabelWrapper
            disabled={readOnly}
            error={error}
            id={id}
            label={label}
            name={name}
            required={required}
        >
            <ClassicEditor
                {...otherProps}
                contents={contents}
                editorConfig={editorConfig}
                id={id}
                name={name}
                onBlur={
                    (e) => {
                        onBlur({
                            target: {
                                name: name,
                                id: id,
                                outerHTML: ''
                            }
                        })
                    }
                }
                onChange={(content) => {
                    onChange(content);
                }}

                onSetData={({data: {dataValue: value}, editor: {mode}}) => {
                    if (mode === 'source') {
						onChange({target: {value}});
					}
				}}
                readOnly={readOnly}
                ref={editorRef}
                visible={visible}
            />

            <input name={name} type="hidden" value={contents}/>
        </LabelWrapper>
    );
};

export default RichText;