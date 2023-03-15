import React, {useContext} from 'react';
import ClayEmptyState from '@clayui/empty-state';
import ClayButton from '@clayui/button';
import {AppContext} from "../../AppContext.es";
import {useNavigate} from 'react-router-dom';
import {lang} from "../../constants/lang.es";

const NotFound = () => {
    const context = useContext(AppContext);
    const navigate = useNavigate();

    return (
        <div className="questions-container row">
            <div className="c-mx-auto c-px-0 col-xl-10">
                <ClayEmptyState
                    description={lang.errors.notFoundDesc}
                    imgSrc={
                        context?.includeContextPath +
                        '/assets/empty_questions_list.png'
                    }
                    title={lang.errors.notFound}
                >
                    <ClayButton
                        displayType="primary"
                        onClick={() =>
                            navigate('/')
                        }
                    >
                        {lang.home}
                    </ClayButton>
                </ClayEmptyState>
            </div>
        </div>
    );
};

export default NotFound;