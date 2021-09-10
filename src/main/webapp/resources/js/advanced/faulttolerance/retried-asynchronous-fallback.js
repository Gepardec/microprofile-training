import httpClient from '../../httpClient.js'
import mp from "../../mp.js";

const state = {
    options: null,
};

const extractResponseData = (response) => {
    return response.text()
        .then((text) => {
                return {
                    status: response.status,
                    text: text
                }
            }
        );
}

const displayData = (response) => {
    const {
        responseElement,
    } = state.options;
    extractResponseData(response).then(result => responseElement.innerText = `HTTP-Status: ${result.status}, Response: ${result.text}`);
}

const registerCallElementClickEventListener = () => {
    const {
        clickElement,
    } = state.options;
    mp.registerClickListenerPreventDefault(clickElement, (event) => {
        httpClient.post({
            uri: event.target.href,
        }).then(displayData);
    });
};

const init = (options) => {
    const {timeDialogElement} = options;
    state.options = options;
    registerCallElementClickEventListener();
};

export default {
    init
};
