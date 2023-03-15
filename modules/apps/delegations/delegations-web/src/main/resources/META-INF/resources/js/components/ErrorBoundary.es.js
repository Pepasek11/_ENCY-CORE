import ClayAlert from '@clayui/alert';
import React from "react";

export class ErrorBoundary extends React.Component {
    constructor(props) {
        super(props);
        this.state = {hasError: false};
    }

    static getDerivedStateFromError(error) {
        return {error, hasError: true};
    }

    componentDidCatch(_error, _errorInfo) {}

    render() {
        if (this.state.hasError) {
            if (process.env.NODE_ENV === 'development') {
                console.error(this.state.error);
            }

            return (
                <>
                    <ClayAlert
                        autoClose={5000}
                        displayType="danger"
                        title="Error:"
                    >
                        Could not load the component
                    </ClayAlert>
                </>
            );
        }

        return this.props.children;
    }
}
