import httpClient from '../../httpClient.js'
import mp from "../../mp.js";

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
    } = options;
    mp.registerClickListenerPreventDefault(callElement, (event) => {
        responseElement.innerText = "";
        httpClient.post({
            uri: event.target.href,
            successCallback: (response) => displayData(options, response),
            failureCallback: (response) => displayData(options, response),
        });
    });
};

const init = (options) => {
    registerCallElementClickEventListener(options);
};

export default {
    init,
}