const emptyFunction = (response) => {
    return response;
};

const buildQueryParameters = (parameterMap) => {
    const parameters = new URLSearchParams();
    parameterMap.forEach((value, key) => parameters.append(key, value));
    return parameters;
}

const buildFullUri = (options) => {
    const {
        uri,
        queryParameters = new Map(),
    } = options;
    return (queryParameters.size === 0) ? uri : `${uri}?${buildQueryParameters(queryParameters)}`;
};

const callAsync = (options) => {
    const {
        method,
        successCallback = emptyFunction,
        failureCallback = emptyFunction,
    } = options;
    return fetch(`${buildFullUri(options)}`, {
        method: method
    }).then((response) => {
        if (!response.ok) {
            return failureCallback(response);
        } else {
            return successCallback(response);
        }
    });
};

const callNTimesAsync = (options) => {
    const {
        uri,
        method,
        startCallback = emptyFunction,
        successCallback = emptyFunction,
        failureCallback = emptyFunction,
        errorCallback = emptyFunction,
        finallyCallback = emptyFunction,
        count,
    } = options;
    return Promise.all([...Array(count).keys()].map(count => {
        startCallback(count);
        return callAsync({
            uri: uri,
            method: method,
            successCallback: (response) => successCallback(response, count),
            failureCallback: (response) => failureCallback(response, count),
        }).catch((error) => errorCallback(error, count)).finally(() => finallyCallback(count));
    }));
};

const postBatch = (options) => {
    return callNTimesAsync({
        method: 'POST',
        ...options,
    });
};

const post = (options) => {
    return callAsync({
        method: 'POST',
        ...options,
    });
};

export default {
    postBatch,
    post,
}
