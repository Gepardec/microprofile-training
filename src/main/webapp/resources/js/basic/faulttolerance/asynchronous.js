import httpClient from '../../httpClient.js'
import mp from "../../mp.js";

const registerCallElementClickEventListener = (options) => {
    const {
        clickElement,
        timeDialogElement,
    } = options;
    mp.registerClickListenerPreventDefault(clickElement, (event) => {
        const modal = mdb.Modal.getInstance(timeDialogElement)
        modal.show();
        httpClient.post({
            uri: event.target.href,
        }).finally(() => modal.hide());
    });
}

const init = (options) => {
    registerCallElementClickEventListener(options);
}

export default {
    init
}