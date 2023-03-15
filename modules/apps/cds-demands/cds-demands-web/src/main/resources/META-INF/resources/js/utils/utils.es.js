import {useRef} from 'react';


export function dateStrToInternationalHuman(
    ISOString,
    localeKey = navigator.language
) {
    const date = new Date(ISOString);
    return dateToInternationalHuman(date, localeKey);
}

export function dateToInternationalHuman(
    date,
    localeKey = navigator.language
) {
    if(!date) {
        return '';
    }

    if(typeof date === 'string' || typeof date === 'number') {
        date = new Date(date);
    }

    const options = {
        day: 'numeric',
        hour: '2-digit',
        minute: '2-digit',
        month: 'short',
    };

    if (date.getFullYear() !== new Date().getFullYear()) {
        options.year = 'numeric';
    }

    const intl = new Intl.DateTimeFormat(localeKey, options);

    try {
        return intl.format(date);
    }catch (e){}
    return '';
}

export function dateStrToBriefInternationalHuman(
    ISOString,
    localeKey = navigator.language
) {
    const date = new Date(ISOString);
    return dateToBriefInternationalHuman(date, localeKey);
}

export function dateToBriefInternationalHuman(
    date,
    localeKey = navigator.language
) {
    if(!date) {
        return '';
    }

    if(typeof date === 'string'|| typeof date === 'number') {
        date = new Date(date);
    }

    const intl = new Intl.DateTimeFormat(localeKey, {
        day: '2-digit',
        month: '2-digit',
        year: 'numeric',
    });

    try {
        return intl.format(date);
    }catch (e){}
    return '';
}

export function getFullPath(path) {
    const href = window.location.href;
    const indexOf = href.indexOf('#');

    if (indexOf !== -1) {
        return href.substring(0, indexOf);
    }

    return href.substring(0, href.indexOf(path));
}

export function getBasePath(path) {
    const origin = window.location.origin.length;

    const href = window.location.href;
    const indexOf = href.indexOf('#');

    if (indexOf !== -1) {
        return href.substring(origin, indexOf);
    }

    return href.substring(origin, href.indexOf(path));
}

export const getInitials = (name = '') => name
    .replace(/\s+/, ' ')
    .split('(')
    .slice(0, 1)
    .join('')
    .split(' ')
    .slice(0, 2)
    .map((v) => v && v[0].toUpperCase())
    .join('');

