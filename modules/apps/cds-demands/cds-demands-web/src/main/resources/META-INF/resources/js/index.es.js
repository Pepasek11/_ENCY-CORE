import React from 'react';

import App from './App.es';
import {ErrorBoundary} from './components/ErrorBoundary.es';

export default function (props) {
    return (
        <div className="demands-root">
            <ErrorBoundary>
                <App {...props} />
            </ErrorBoundary>
        </div>
    );
}