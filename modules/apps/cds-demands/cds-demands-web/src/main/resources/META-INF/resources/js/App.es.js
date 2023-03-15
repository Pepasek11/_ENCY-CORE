import React from 'react';
import {HashRouter as Router, Route, Routes} from 'react-router-dom';

import useLazy from './hooks/useLazy.es';
import {AppContextProvider} from './AppContext.es';
import {getFullPath} from './utils/utils.es';
import {Provider} from '@clayui/core';
import NavigationBar from './pages/NavigationBar.es';
import NotFound from "./pages/error/404.es";
import UserDashboard from "./pages/dashboards/UserDashboard.es";

const spritemap = Liferay.ThemeDisplay.getPathThemeImages() + '/clay/icons.svg';

export default function App(props) {
    redirectForNotifications(props);

    const Component = useLazy();

    const packageName = props.npmResolvedPackageName;

    let path = props.historyRouterBasePath || '';

    if (path && location.pathname.includes(path)) {
        path = location.pathname.slice(
            0,
            location.pathname.indexOf(path) + path.length
        );
    }

    const refreshSession = () => {
        var URL_BASE = themeDisplay.getPathMain() + '/portal/';
        Liferay.Util.fetch(URL_BASE + 'extend_session');
    }

    setTimeout(refreshSession, 1000 * 60);


    return (
        <AppContextProvider {...props}>
            <Provider spritemap={spritemap}>
                <Router basename={path}>
                    <NavigationBar/>

                    <Routes>
                        <Route
                            path="/"
                            exact
                            element={<UserDashboard {...props}/>}
                        />

                        <Route
                            path="dashboard/user"
                            exact
                            element={<Component
                                module={`${packageName}/js/pages/dashboards/UserDashboard.es`}
                                props={props}/>}
                        />
                        <Route
                            path="dashboard/domain"
                            exact
                            element={<Component
                                module={`${packageName}/js/pages/dashboards/DomainDashboard.es`}
                                props={props}/>}
                        />
                        <Route
                            path="dashboard/cds"
                            exact
                            element={<Component
                                module={`${packageName}/js/pages/dashboards/CdsDashboard.es`}
                                props={props}/>}
                        />
                        <Route path="demand/view">
                            <Route
                                path=":entryId"
                                exact
                                element={<Component
                                    module={`${packageName}/js/pages/demand/View.es`}
                                    props={props}/>}/>
                            <Route path="*" element={<NotFound/>}/>
                        </Route>
                        <Route
                            path="demand/edit/:entryId"
                            element={<Component
                                module={`${packageName}/js/pages/demand/Edit.es`}
                                props={props}/>}/>
                        <Route
                            path="demand/new"
                            exact
                            element={<Component
                                module={`${packageName}/js/pages/demand/Edit.es`}
                                props={{isNew: true, ...props}}/>}/>
                        <Route path={"*"} element={<h2>hups</h2>}/>
                    </Routes>
                </Router>
            </Provider>
        </AppContextProvider>
    )
}

function redirectForNotifications(props) {
    if (window.location.search && !props.historyRouterBasePath) {
        const urlSearchParams = new URLSearchParams(window.location.search);

        const redirectTo = urlSearchParams.get('redirectTo');
        if (redirectTo) {
            window.history.replaceState(
                {},
                document.title,
                getFullPath() + decodeURIComponent(redirectTo)
            );
        }
    }
}