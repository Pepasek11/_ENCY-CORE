import {useCallback, useState} from 'react';
import {openToast,} from 'frontend-js-web';
import {lang} from "../constants/lang.es";

const defaultParams = {
    serviceContext:{
        userId:Liferay.ThemeDisplay.getUserId() //Inject user id so impersonation will work
    }
}

const useService = (
    {
        service = '',
        successCallback = (data) => data,
        failureCallback = () => {
        },
        params = {},
        successToastMessage = null,
        showSuccessToast = false,
        showFailToastMessage = true,
    }) => {
    const [data, setData] = useState();


    const fetchData = useCallback((rtparams) => {
        Liferay.Service(
            service,
            {...defaultParams, ...params, ...rtparams},
            function (response, xxx) {
                // Liferay direct response with data
                if (Array.isArray(response)) {
                    setData(response);
                    successCallback(response);
                    return;
                }

                // E3 Unhandled error
                if (response === undefined) {
                    response = {success: false}
                }
                ;

                //E3 encapsulated response
                const {
                    success = false,
                    error = lang.somethingWentWrong,
                    message = lang.error,
                    data = []
                } = response;

                if (success === true) {
                    setData(data);
                    successCallback(data);
                    if (successToastMessage || showSuccessToast) {
                        openToast({
                            message: successToastMessage || message,
                            title: lang.success,
                            type: 'success'
                        })
                    }
                } else {
                    failureCallback({error, message, data})
                    showFailToastMessage && openToast({
                        message: error,
                        title: message,
                        type: 'danger'
                    })
                }
            }
        );
    }, [service, params, successCallback, failureCallback]);

    return [
        fetchData,
        data,
    ];
};

export {useService};