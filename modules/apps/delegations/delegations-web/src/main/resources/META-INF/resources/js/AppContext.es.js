import React, {createContext, useEffect, useState} from 'react';

const AppContext = createContext({});

const AppContextProvider = ({children, ...context}) => {
    const [canCreateDemand, setCanCreateDemand] = useState(true);

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
