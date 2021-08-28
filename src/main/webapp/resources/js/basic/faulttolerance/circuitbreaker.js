import httpClient from '../../httpClient.js'
import timer from "../../timer.js";
import mp from "../../mp.js";

const state = {
    failEachCount: 1,
    failAfterEachCount: 1,
    count: 0,
    intentionalFailedCount: 0,
    circuitOpenFailedCount: 0,
    otherFailedCount: 0,
    successCount: 0,
}

const statusCodes = {
    intentionalFail: 492,
    circuitOpen: 490,
}

const resetState = () => {
    state.count = 0;
    state.intentionalFailedCount = 0;
    state.successCount = 0;
    state.circuitOpenFailedCount = 0;
    state.failEachCount = 1;
    state.failAfterEachCount = 1;
}

const displayState = (options) => {
    const {
        responseContainer,
    } = options;
    responseContainer.innerHTML = `Call: ${state.count} </br> Success: ${state.successCount} </br> IntentionalFail: ${state.intentionalFailedCount} </br> CircuitOpenFail: ${state.circuitOpenFailedCount} </br> otherFail: ${state.otherFailedCount}`;
}

const run = (options) => {
    const {
        href,
    } = options;
    httpClient.post({
        uri: href,
        successCallback: () => state.successCount += 1,
        failureCallback: (response) => {
            if (response.status === statusCodes.intentionalFail) {
                state.intentionalFailedCount += 1;
            } else if (response.status === statusCodes.circuitOpen) {
                state.circuitOpenFailedCount += 1;
            } else {
                state.otherFailedCount += 1;
            }
        },
    }).finally(() => {
        state.count += 1;
        displayState(options);
    });
};

const timerStopCallback = async (options) => {
    const { stopElement } = options;
    await httpClient.post({
        uri: stopElement.href,
        failureCallback: () => alert('Endpoint reset failed'),
    });
};

const validateInputNumber = (element, min) => {
    const inputElement = element.querySelector('input');
    const stringValue = inputElement.value;
    const value = parseInt(stringValue) || -1;
    if (value <= 0 || value < min) {
        element.focus();
        inputElement.value = "";
        alert(`Your ${inputElement.id} value is invalid. value: '${stringValue}', min: '${min}'`);
        inputElement.value = min;
        return false;
    }

    return true;
};

const registerInitElementClickEventListener = (options) => {
    const {
        failEachCountElement,
        failAfterEachCountElement,
        initElement,
        failEachCountMin,
        failAfterEachCountMin,
    } = options;
    mp.registerClickListenerPreventDefault(initElement, (event) => {
            if (timer.isRunning()) {
                alert('Cannot initialize while running, please stop first');
                return;
            }
            if (validateInputNumber(failEachCountElement, failEachCountMin) && validateInputNumber(failAfterEachCountElement, failAfterEachCountMin)) {
                const failEachCountInputElement = failEachCountElement.querySelector('input');
                const failAfterEachCountInputElement = failAfterEachCountElement.querySelector('input');
                httpClient.post({
                    uri: event.target.href,
                    queryParameters: new Map([
                        [failEachCountInputElement.id, failEachCountInputElement.value],
                        [failAfterEachCountInputElement.id, failAfterEachCountInputElement.value]
                    ]),
                    successCallback: () => alert(`Endpoint successfully initialized with failEachCount: '${failEachCountInputElement.value}', failAfterEachCount: '${failAfterEachCountInputElement.value}'`),
                    failureCallback: () => alert('Endpoint initialization failed')
                });
            }
        }
    );
};

const registerStopElementClickEventListener = (options) => {
    const {
        stopElement,
    } = options;
    mp.registerClickListenerPreventDefault(stopElement, (event) => timer.stop());
};

const registerCallElementClickEventListener = (options) => {
    const {
        callerElement
    } = options;
    mp.registerClickListenerPreventDefault(callerElement, async (event) => timer.start());
};

const init = (options) => {
    const { delayMillis, callerElement } = options;
    timer.init({
        delayMillis: delayMillis,
        runFunction: run,
        runData: {
            href: callerElement.href,
            ...options
        },
        startCallback: resetState,
        stopCallback: () => timerStopCallback(options),
    });
    displayState(options);
    registerStopElementClickEventListener(options);
    registerCallElementClickEventListener(options);
    registerInitElementClickEventListener(options);
};

export default {
    init
};
