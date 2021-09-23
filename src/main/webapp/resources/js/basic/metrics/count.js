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
        // countElement,
    } = state.options;
    mp.registerClickListenerPreventDefault(callerElement, (event) => {
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
    const {
        timerElement,
        initDialogElement,
        // countElement,
    } = options;
    state.options = options;
    state.timerDialog = modalDialog.create({
        element: timerElement,
    })
    state.initDialog = modalDialog.create({
        element: initDialogElement,
    })
    registerCallElementClickEventListener();
}

export default {
    init
}
