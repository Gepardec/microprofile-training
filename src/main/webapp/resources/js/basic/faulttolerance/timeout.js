import mp from "../../mp.js";
import httpClient from '../../httpClient.js'
import modalDialog from "../../modalDialog.js";

const state = {
    timerDialog: null,
    options: null,
};

const displayData = (response) => {
    const {
        responseElement,
    } = state.options;
    let serverResponseText = `HTTP-Status: ${response.status}`;
    response.text()
        .then((text) => serverResponseText += `, Content: ${text}`)
        .finally(() => responseElement.innerText = serverResponseText);
};

const registerCallElementClickEventListener = () => {
    const {
        callElement,
        responseElement,
    } = state.options;
    mp.registerClickListenerPreventDefault(callElement, (event) => {
        responseElement.innerText = "";
        state.timerDialog.show();
        httpClient.post({
            uri: event.target.href,
            successCallback: displayData,
            failureCallback: displayData,
        }).finally(() => state.timerDialog.hide());
    });
}

const init = (options) => {
    const { timerElement } = options;
    state.options = options;
    state.timerDialog = modalDialog.create({
        element: timerElement,
    })
    registerCallElementClickEventListener();
};

export default {
    init,
};
