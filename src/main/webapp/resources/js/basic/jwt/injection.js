import mp from "../../mp.js";
import httpClient from "../../httpClient.js";
import login from "../../login.js";

const registerCallElementClickEventListener = (options) => {
    const {
        clickElementJwt,
        clickElementClaim,
        responseElement
    } = options;
    mp.registerClickListenerPreventDefault(clickElementJwt, async (event) => {
        responseElement.innerHTML = '';
        const response = await httpClient.get({
            uri: event.target.href,
            token: login.token()
        });
        responseElement.innerHTML = `HTTP-Status: ${response.status}` + `, Content: ${await response.text()}`;
    });
    mp.registerClickListenerPreventDefault(clickElementClaim, async (event) => {
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