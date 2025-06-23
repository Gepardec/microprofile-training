import mp from "./mp.js";
import Keycloak from 'https://cdn.jsdelivr.net/npm/keycloak-js@26.1.4/+esm';

const keycloak = new Keycloak({
    url: 'http://localhost:8080',
    realm: 'microprofile',
    clientId: 'training'
});

const token = () => {
    return keycloak.token;
}

const initKeycloak = async (options) => {
    const {
        upnElement
    } = options;
    const authenticated = await keycloak.init({checkLoginIframe: false});
    if (authenticated) {
        upnElement.innerHTML = `You are logged in as <i>${keycloak.tokenParsed['upn']}</i>`;
    } else {
        await keycloak.login();
    }
}

const registerCallElementClickEventListener = (options) => {
    const {
        clickElement
    } = options;
    mp.registerClickListenerPreventDefault(clickElement, async () => {
        await keycloak.logout();
    });
}

const init = async (options) => {
    await initKeycloak(options);
    registerCallElementClickEventListener(options);
}

export default {
    init,
    token
}