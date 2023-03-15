'use strict';
import ClayLabel from '@clayui/label';
import React from "react";

const nowarp={whiteSpace:'nowrap'}

const StateLabel = (
    {
        code,
        label,
    }) => {
    return (
        <ClayLabel
            displayType={code?"e3-"+code:"label-success"}
            style={nowarp}
        >
            {label}
        </ClayLabel>
    )

}

const TypeShortLabel = (
    {
        code,
        label,
    }) => {
    var shortlabel = label;
    switch (Number(code)) {
        case -1:shortlabel = Liferay.Language.get('out-of-cds-short');break;
        case 1:shortlabel = Liferay.Language.get('us-short');break;
        case 2:shortlabel = Liferay.Language.get('bs-short');break;
    }
    return (
        <ClayLabel
            displayType={code?"e3-type-"+code:"label-info"}
        >
            {shortlabel}
        </ClayLabel>
    )
}

const PriorityLabel= (
    {
        code,
        label,
    }) => {
    return (
        <ClayLabel
            displayType={code?"e3-priority-"+code:"label-warn"}
        >
            {label}
        </ClayLabel>
    )
}

export {StateLabel, TypeShortLabel};