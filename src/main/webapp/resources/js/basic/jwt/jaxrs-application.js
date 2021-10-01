import mp from "../../mp.js";
import httpClient from "../../httpClient.js";
import login from "../../login";

const registerCallElementClickEventListener = (options) => {
    const {
        clickElement,
        responseElement
    } = options;
    mp.registerClickListenerPreventDefault(clickElement, async (event) => {
        responseElement.innerHTML = '';
        const response = await httpClient.get({
            uri: event.target.href,
            token: login.token()
        });
        responseElement.innerHTML = `HTTP-Status: ${response.status}` + `, Content: ${await response.text()}`;
    });
};

const init = (options) => {
    registerCallElementClickEventListener(options);
};

export default {
    init
};