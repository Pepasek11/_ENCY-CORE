import {useCallback, useState} from 'react';
import {openToast,} from 'frontend-js-web';
import {lang} from "../constants/lang.es";

const useService = (
    {
        service = '',
        successCallback = (data) => data,
        failureCallback = () => {},
        params = {},
        successToastMessage=null,
    }) => {
    const [data, setData] = useState();


    const fetchData = useCallback((rtparams) => {
        Liferay.Service(
            service,
            {...params,...rtparams},
            function ({success=null, error, message, data}) {
                if (success === true) {
                    setData(data);
                    successCallback(data);
                    if(successToastMessage){
                        openToast({
                            message: successToastMessage || message ,
                            title: lang.success,
                            type: 'success'
                        })
                    }
                } else {
                    failureCallback({error, message, data})
                    openToast({
                        message: error || lang.somethingWentWrong,
                        title: message || lang.error,
                        type: 'danger'
                    })
                }
            }
        );
    });

    return [
        fetchData,
        data,
    ];
};

export {useService};