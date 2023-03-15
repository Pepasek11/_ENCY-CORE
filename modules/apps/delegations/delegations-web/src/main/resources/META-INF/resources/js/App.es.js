import React from 'react';
import {HashRouter as Router, Route, Routes} from 'react-router-dom';

import useLazy from './hooks/useLazy.es';
import {AppContextProvider} from './AppContext.es';
import {Provider} from '@clayui/core';

const spritemap = Liferay.ThemeDisplay.getPathThemeImages() + '/clay/icons.svg';

export default function App(props) {
    const Component = useLazy();

    const packageName = props.npmResolvedPackageName;

    return (
        <AppContextProvider {...props}>
            <Provider spritemap={spritemap}>
                <Router basename={""}>
                    <Routes>
                        <Route
                            path="/"
                            exact
                            element={<Component
                                module={`${packageName}/js/pages/Roles.es`}
                                props={props}/>}
                        />
                        <Route path="delegations/role">
                            <Route
                                path=":roleId"
                                exact
                                element={<Component
                                    module={`${packageName}/js/pages/Role.es`}
                                    props={props}/>}/>
                            <Route path="*" element={<h3>404 Not found</h3>}/>
                        </Route>
                        <Route path={"*"} element={<h3>404 Not found</h3>}/>
                    </Routes>
                </Router>
            </Provider>
        </AppContextProvider>
    )
}
