import httpClient from '../../httpClient.js'
import timer from "../../timer.js";
import mp from "../../mp.js";

const state = {
    timer: null,
    options: null,
}

const displayData = (response) => {
    const {
        responseElement,
    } = state.options;
    response.text()
        .then((text) => responseElement.innerText = `${text}`);
}

const run = () => {
    const {
        callerElement,
    } = state.options;
    httpClient.post({
        uri: callerElement.href,
        successCallback: displayData,
        failureCallback: displayData,
    });
};

const registerStopElementClickEventListener = () => {
    const {
        stopElement,
    } = state.options;
    mp.registerClickListenerPreventDefault(stopElement, state.timer.stop);
};

const registerCallElementClickEventListener = () => {
    const {
        callerElement
    } = state.options;
    mp.registerClickListenerPreventDefault(callerElement, state.timer.start);
};

const init = (options) => {
    const {
        delayMillis,
        callerElement,
    } = options;
    state.options = options;
    state.timer = timer.create({
        delayMillis: delayMillis,
        runFunction: run,
        runData: {
            href: callerElement.href,
            ...options
        },
    });
    registerStopElementClickEventListener();
    registerCallElementClickEventListener();
};

export default {
    init
};
