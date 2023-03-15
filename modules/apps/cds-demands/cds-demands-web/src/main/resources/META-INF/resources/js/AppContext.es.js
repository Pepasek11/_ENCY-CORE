import React, {createContext, useEffect, useState} from 'react';

const AppContext = createContext({});

const AppContextProvider = ({children, ...context}) => {
    const [canCreateDemand, setCanCreateDemand] = useState(true);
/*
    useEffect(() => {
        client
            .request({
                query: hasListPermissionsQuery,
                variables: {
                    siteKey: context.siteKey,
                },
            })
            .then(({data: {messageBoardThreads}}) => {
                setCanCreateThread(
                    Boolean(messageBoardThreads.actions['create'])
                );
            });
    }, [context.siteKey]);
*/
    return (
        <AppContext.Provider
            value={{
                ...context,
                canCreateDemand,
            }}
        >
            {children}
        </AppContext.Provider>
    );
};

export {AppContext, AppContextProvider};
