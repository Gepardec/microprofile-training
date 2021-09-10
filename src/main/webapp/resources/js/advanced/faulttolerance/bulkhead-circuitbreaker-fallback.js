import httpClient from '../../httpClient.js'
import timer from "../../timer.js";
import mp from "../../mp.js";
import httpCodes from "../../../applicationHttpCodes.js";

const state = {
    timer: null,
    options: null,
    count: 0,
    intentionalFailedCount: 0,
    circuitOpenFailedCount: 0,
    bulkheadRejectCount: 0,
    tooManyFailuresTryAgainLaterCount: 0,
    tooManyRequestCount: 0,
    otherFailedCount: 0,
    successCount: 0,
}

const resetState = () => {
    state.count = 0;
    state.intentionalFailedCount = 0;
    state.successCount = 0;
    state.circuitOpenFailedCount = 0;
    state.bulkheadRejectCount = 0;
    state.tooManyFailuresTryAgainLaterCount = 0;
    state.tooManyRequestCount = 0;
}

const displayState = () => {
    const {
        responseContainer,
    } = state.options;
    responseContainer.innerHTML = `
Batch-Count: ${state.count} </br> 
Success: ${state.successCount} </br> 
IntentionalFail: ${state.intentionalFailedCount} </br> 
CircuitOpen: ${state.circuitOpenFailedCount} </br> 
BulkheadReject: ${state.bulkheadRejectCount} </br>
TooManyFailures: ${state.tooManyFailuresTryAgainLaterCount} </br>
TooMayRequest: ${state.tooManyRequestCount} </br>
OtherFail: ${state.otherFailedCount} </br>`;
}

const run = (options) => {
    const {
        callerElement,
        parallelCount,
        href,
    } = options;
    httpClient.postBatch({
        uri: href,
        count: parallelCount,
        successCallback: () => state.successCount += 1,
        failureCallback: (response, count) => {
            if (response.status === httpCodes.codes.intentionalFail) {
                state.intentionalFailedCount += 1;
            } else if (response.status === httpCodes.codes.circuitOpen) {
                state.circuitOpenFailedCount += 1;
            } else if (response.status === httpCodes.codes.bulkheadReject) {
                state.bulkheadRejectCount += 1;
            } else if (response.status === httpCodes.codes.tooManyFailuresTryAgainLater) {
                state.tooManyFailuresTryAgainLaterCount += 1;
            } else if (response.status === httpCodes.codes.tooManyRequest) {
                state.tooManyRequestCount += 1;
            } else {
                state.otherFailedCount += 1;
            }
        },
    }).then((data) => {
        state.count += 1;
        displayState();
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
        startCallback: resetState,
    });
    displayState();
    registerStopElementClickEventListener();
    registerCallElementClickEventListener();
};

export default {
    init
};
