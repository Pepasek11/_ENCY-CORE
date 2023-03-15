import React, {useEffect, useState} from "react";
import AsyncSelect from "react-select/async";
import {LabelWrapper} from "./Components";


const UsersSelect = (
    {
        disabled,
        error,
        filterRoles='',
        id,
        isMulti,
        label,
        name,
        required,
        value,
        ref,
        ...otherProps
    }) => {

    const [page, setPage] = useState(1);
    const [options, setOptions] = useState([]);
    const [defaultOptions, setDefaultOptions] = useState([]);

    useEffect(
        () => {
            loadOptions('', (optns) => setDefaultOptions(optns));
        },
        [filterRoles]
    );

    const loadOptions = (search, callback) => {
        //console.log("load options " + search + "roles" + filterRoles);
        if ((search === null || search === '') && defaultOptions.length > 0) {
            callback(defaultOptions);
        } else {
            Liferay.Service(
                '/ency.usersdataprovider/search-users-for-select',
                {
                    roles: filterRoles,
                    searchQuery: search || '',
                    delta: 10,
                    page: page,
                    p_auth: Liferay.authToken,
                    formDate: Date.now()
                },
                function (obj) {
                    //todo handle result errors = obj==null || !obj.success
                    //todo requests timestamp ordering (do not load older request if newer was already processed)
                    const newoptns = obj?.data?.map(o => ({
                        label: o.text,
                        value: o.id
                    }));
                    //console.log("result of query:" + obj);
                    if (search === null || search === '') {
                        setDefaultOptions(newoptns)
                    }
                    callback(newoptns);
                    setOptions(newoptns);//todo je to nutny?
                }
            );
        }

    }

    return (
        <LabelWrapper
            disabled={disabled}
            error={error}
            id={id}
            label={label}
            name={name}
            required={required}
        >
            <AsyncSelect
                {...otherProps}
                className={"ency-select"}
                cacheOptions={false}
                defaultOptions={defaultOptions}
                disabled={disabled}
                id={id}
                name={name}
                isMulti={!!isMulti}
                 loadOptions={loadOptions}
                value={value}

            />
        </LabelWrapper>

    )
}

export default UsersSelect;


