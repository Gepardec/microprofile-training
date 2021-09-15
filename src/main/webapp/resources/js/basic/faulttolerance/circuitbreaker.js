import httpClient from '../../httpClient.js'
import timer from "../../timer.js";
import mp from "../../mp.js";
import modalDialog from "../../modalDialog.js";
import inputNumber from "../../inputNumber.js";

const state = {
    timer: null,
    initDialog: null,
    options: null,
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

const showInitDialog = (message) => {
    const { initDialogContentElement } = state.options;
    initDialogContentElement.innerText = message;
    state.initDialog.show();
}

const resetState = () => {
    state.count = 0;
    state.intentionalFailedCount = 0;
    state.successCount = 0;
    state.circuitOpenFailedCount = 0;
    state.failEachCount = 1;
    state.failAfterEachCount = 1;
}

const displayState = () => {
    const {
        responseContainer,
    } = state.options;
    responseContainer.innerHTML = `Call: ${state.count} </br> Success: ${state.successCount} </br> IntentionalFail: ${state.intentionalFailedCount} </br> CircuitOpenFail: ${state.circuitOpenFailedCount} </br> otherFail: ${state.otherFailedCount}`;
}

const run = () => {
    const {
        callerElement,
    } = state.options;
    httpClient.post({
        uri: callerElement.href,
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
        displayState();
    });
};

const timerStopCallback = async () => {
    const { stopElement } = state.options;
    await httpClient.post({
        uri: stopElement.href,
        failureCallback: () => alert('Endpoint reset failed'),
    });
};

const registerInitElementClickEventListener = () => {
    const {
        failEachCountElement,
        failAfterEachCountElement,
        initElement,
    } = state.options;
    mp.registerClickListenerPreventDefault(initElement, (event) => {
            if (state.timer.isRunning()) {
                showInitDialog('Cannot initialize while running, please stop first');
                return;
            }
            const failEachCountInputElement = failEachCountElement.querySelector('input');
            const failAfterEachCountInputElement = failAfterEachCountElement.querySelector('input');
            httpClient.post({
                uri: event.target.href,
                queryParameters: new Map([
                    [failEachCountInputElement.id, failEachCountInputElement.value],
                    [failAfterEachCountInputElement.id, failAfterEachCountInputElement.value]
                ]),
                successCallback: () => showInitDialog(`Endpoint successfully initialized with failEachCount: '${failEachCountInputElement.value}', failAfterEachCount: '${failAfterEachCountInputElement.value}'`),
                failureCallback: () => showInitDialog('Endpoint initialization failed'),
            });
        }
    );
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
        initDialogElement,
        delayMillis,
        callerElement,
        failEachCountElement,
        failAfterEachCountElement,
    } = options;
    state.options = options;
    state.initDialog = modalDialog.create({
        element: initDialogElement,
    })
    state.timer = timer.create({
        delayMillis: delayMillis,
        runFunction: run,
        runData: {
            href: callerElement.href,
            ...options
        },
        startCallback: resetState,
        stopCallback: timerStopCallback,
    });
    inputNumber.init(failEachCountElement);
    inputNumber.init(failAfterEachCountElement);
    displayState();
    registerStopElementClickEventListener();
    registerCallElementClickEventListener();
    registerInitElementClickEventListener();
};

export default {
    init
};
