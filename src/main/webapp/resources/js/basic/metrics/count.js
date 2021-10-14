import httpClient from '../../httpClient.js'
import mp from "../../mp.js";
import modalDialog from "../../modalDialog.js";

const state = {
    timerDialog: null,
    initDialog: null,
    options: null,
};

const displayData = (response) => {
    const {
        responseElement,
    } = state.options;
    response.text()
        .then((text) => responseElement.innerText = `${text}`);
};

const registerCallElementClickEventListener = () => {
    const {
        callerElement,
        responseElement,
    } = state.options;
    mp.registerClickListenerPreventDefault(callerElement, (event) => {
        responseElement.innerText = "";
        httpClient.post({
            uri: event.target.href,
            successCallback: displayData,
            failureCallback: displayData,
        });
    });
}

const init = (options) => {
    state.options = options;
    registerCallElementClickEventListener();
}

export default {
    init
}
