import {fetch} from 'frontend-js-web';
import {useCallback, useState} from 'react';

const useFetch = ({
                      callback = (data) => data,
                      params = {},
                      plainText = false,
                      url,
                      headers = {},
                      method = 'POST'
                  }) => {
    const [data, setData] = useState();

    const fetchURL = new URL(url, Liferay.ThemeDisplay.getPortalURL());

    Object.entries(params).map(([key, value]) => {
        if (value !== null && value !== undefined) {
            fetchURL.searchParams.append(key, value);
        }
    });

    const fetchData = useCallback(() => {
        fetch(fetchURL, {
            headers,
            method: method,
        }).then((response)=>{
            return plainText ?
                response.text() :
                response.json();
        }).then((data)=>{
            setData(data);
            callback(data);
        }).catch(() => {
            throw data;
        });
    }, [callback, url, plainText]);

    return {
        data,
        fetchData,
    };
};

export {useFetch};