import ClayIcon from '@clayui/icon';
import ClayLink from '@clayui/link';
import ClaySticker from '@clayui/sticker';
import ClayNavigationBar from '@clayui/navigation-bar';
import React, {useContext} from 'react';
import {useLocation, useNavigate, useParams, useSearchParams} from 'react-router-dom';

import {AppContext} from '../AppContext.es';
import constants from "../constants/constants.es";
import {lang} from "../constants/lang.es";
//import {historyPushWithSlug} from '../utils/utils.es';

//export default withRouter(({history, location}) => {
const NavigationBar = () => {
    const context = useContext(AppContext) || {};
    const navigate = useNavigate();
    const location = useLocation();
    const params = useParams();

    const [searchParams, setSearchParams] = useSearchParams();

    const dashboard =
        (
            params &&
            params?.dashboard
        ) ||
        searchParams.get('dashboard');

    const isActive = (value) => location.pathname === value;

    return (
        <section className="demands-section demands-section-nav">
            <div className="demands-container row">
                <div className="align-items-center col d-flex justify-content-between">

                    <ClayNavigationBar inverted>
                        <ClayNavigationBar.Item>
                            <div className={"app-title"}>
                                <ClaySticker displayType="unstyled" size="lg">
                                    <ClayIcon symbol="shopping-cart"/>
                                </ClaySticker>
                                {Liferay.Language.get('cds-demands')}
                            </div>
                        </ClayNavigationBar.Item>
                        <ClayNavigationBar.Item
                            active={
                                isActive(constants.navigation.userdashboard) ||
                                isActive(constants.navigation.home)
                            }
                            onClick={() =>
                                navigate(
                                    dashboard
                                        ? constants.navigation.userdashboard
                                        : constants.navigation.home
                                )
                            }
                        >
                            <ClayLink
                                className="nav-link"
                                displayType="secondary"
                            >
                                {lang.dashboards.userDashboard}
                            </ClayLink>
                        </ClayNavigationBar.Item>
                        <ClayNavigationBar.Item
                            active={isActive(constants.navigation.domaindashboard)}
                            onClick={() =>
                                navigate(constants.navigation.domaindashboard)
                            }
                        >
                            <ClayLink
                                className="nav-link"
                                displayType="secondary"
                            >
                                {lang.dashboards.domainDashboard}
                            </ClayLink>
                        </ClayNavigationBar.Item>
                        <ClayNavigationBar.Item
                            active={isActive(constants.navigation.cdsdashboard)}
                            onClick={() =>
                                navigate(constants.navigation.cdsdashboard)
                            }
                            className={!context?.isCdsUser ? "hide" : ""}
                        >
                            <ClayLink
                                className="nav-link"
                                displayType="secondary"
                            >
                                {lang.dashboards.cdsDashboard}
                            </ClayLink>
                        </ClayNavigationBar.Item>

                        <ClayNavigationBar.Item
                            className={
                                Liferay.ThemeDisplay.isSignedIn()
                                    ? 'ml-md-auto'
                                    : 'd-none'
                            }
                            onClick={() =>
                                navigate(constants.navigation.newdemand)
                            }
                        >
                            <ClayLink
                                className="nav-link add-link"
                                displayType="unstyled"
                            >
                                <ClayIcon symbol={"plus"}/>
                                {lang.demand.addNew}
                            </ClayLink>
                        </ClayNavigationBar.Item>
                    </ClayNavigationBar>

                </div>
            </div>
        </section>
    );
};

export default NavigationBar;