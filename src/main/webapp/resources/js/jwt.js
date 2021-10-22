import mp from "./mp.js";
import httpClient from "./httpClient.js";
import login from "./login.js";

const registerClick = (options) => {
    const {
        clickElement,
        responseElement,
        sendToken
    } = options;
    mp.registerClickListenerPreventDefault(clickElement, async (event) => {
        responseElement.innerHTML = '';
        const response = await httpClient.get({
            uri: event.target.href,
            token: sendToken ? login.token() : undefined
        });
        responseElement.innerHTML = `HTTP-Status: ${response.status}` + `, Content: ${await response.text()}`;
    });
}

export default {
    registerClick
};

