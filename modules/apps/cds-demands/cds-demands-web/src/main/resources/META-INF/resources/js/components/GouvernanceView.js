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

import React from 'react';
import PropTypes from 'prop-types';
import {lang} from "../constants/lang.es";

const spritemap = Liferay.ThemeDisplay.getPathThemeImages() + '/clay/icons.svg';

const GouvernanceView = (
    {data}
) => {
    return (
        <dl className="dl-horizontal gouvernance">
            {
                data.map((row,i) => {
                    return (
                        <GouvernanceRow key={i} data={row}/>
                    )
                })
            }
        </dl>
    )
}

const GouvernanceRow = (
    {data}
) => {

    return (
        <>
            {data &&
            <>
                <dt>{data?.label}</dt>
                <dd>{data?.link ? <a href={data.link}>{data?.value || '-'}</a> : data?.value || '-'}</dd>
                {data.delegations && typeof data.delegations === 'object' && data.delegations.length > 0 &&
                <>
                    <dt className={"delegations"}>{lang.demand.delegations}</dt>
                    <dd>{
                        /* @todo: overit zda index jako klic nebude delat problemy. Ale teoreticky jsou tyto data staticky tak by nemelo.  */
                        data?.delegations.map((delegation,i) => {
                            return <p key={i} className={"delegations"}>{delegation?.value}</p>
                        })
                    } </dd>
                </>
                }
            </>
            }
        </>
    )
}
GouvernanceRow.propTypes = {
    data: PropTypes.shape({
        label: PropTypes.node,
        value: PropTypes.node,
        link: PropTypes.string,
        delegations: PropTypes.arrayOf(
            PropTypes.shape({
                value: PropTypes.node
            })
        )
    })
}

export {GouvernanceView}