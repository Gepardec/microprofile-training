import mp from "../../mp.js";
import httpClient from '../../httpClient.js'

const displayData = (options, response) => {
    const {
        responseElement,
    } = options;
    let serverResponseText = `HTTP-Status: ${response.status}`;
    response.text()
        .then((text) => serverResponseText += `, Content: ${text}`)
        .finally(() => responseElement.innerText = serverResponseText);
};

const registerCallElementClickEventListener = (options) => {
    const {
        callElement,
        responseElement,
        timerElement,
    } = options;
    mp.registerClickListenerPreventDefault(callElement, (event) => {
        responseElement.innerText = "";
        const modal = mdb.Modal.getInstance(timerElement)
        modal.show();
        httpClient.post({
            uri: event.target.href,
            successCallback: (response) => displayData(options, response),
            failureCallback: (response) => displayData(options, response),
        }).finally(() => modal.hide());
    });
}

const init = (options) => {
    registerCallElementClickEventListener(options);
};

export default {
    init,
};
