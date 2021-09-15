import httpClient from '../../httpClient.js'
import mp from "../../mp.js";
import modalDialog from "../../modalDialog.js";

const state = {
    timerDialog: null,
    options: null,
};

const registerCallElementClickEventListener = () => {
    const {
        clickElement,
    } = state.options;
    mp.registerClickListenerPreventDefault(clickElement, (event) => {
        state.timerDialog.show();
        httpClient.post({
            uri: event.target.href,
        }).finally(() => state.timerDialog.hide());
    });
};

const init = (options) => {
    const { timeDialogElement } = options;
    state.options = options;
    state.timerDialog = modalDialog.create({
        element: timeDialogElement,
    })
    registerCallElementClickEventListener();
};

export default {
    init
};
