const state = {
    timerReference: null,
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
    state.timerReference = null;
    state.count = 0;
    state.intentionalFailedCount = 0;
    state.successCount = 0;
}

const displayState = (responseContainer) => {
    responseContainer.innerHTML = `Call: ${state.count} </br> Success: ${state.successCount} </br> IntentionalFail: ${state.intentionalFailedCount} </br> CircuitOpenFail: ${state.circuitOpenFailedCount} </br> otherFail: ${state.otherFailedCount}`;
}

const run = async (options) => {
    const {
        href,
        responseContainer,
    } = options;
    const response = await fetch(href, {
        method: "POST",
    }).finally(() => state.count += 1);
    await response.text()
        .then((text) => {
            if (response.status === statusCodes.intentionalFail) {
                state.intentionalFailedCount += 1;
            } else if (response.status === statusCodes.circuitOpen) {
                state.circuitOpenFailedCount += 1;
            } else if (response.status === 200) {
                state.successCount += 1;
            } else {
                state.otherFailedCount += 1;
            }
            console.log(state);
        }).finally(() => {
            displayState(responseContainer);
        }).catch((error) => {
            state.intentionalFailedCount += 1;
            console.log(error);
        });
};

const stop = async (options) => {
    if (state.timerReference) {
        clearInterval(state.timerReference);
        resetState();
        const {
            stopElement,
        } = options;
        await fetch(stopElement.href, {
            method: "POST",
        }).finally(() => console.log('Reset call state on server'))
    }
};

const start = async (options) => {
    const { delayMillis } = options;
    if (state.timerReference) {
        await stop(options);
    }
    state.timerReference = setInterval(run, delayMillis, options);
};

const registerStopElementClickEventListener = (options) => {
    const {
        stopElement,
    } = options;
    stopElement.addEventListener('click', async (event) => {
        event.preventDefault();
        await stop(options);
    });
};

const registerCallElementClickEventListener = (options) => {
    const {
        callerElement
    } = options;
    callerElement.addEventListener('click', (event) => {
        event.preventDefault();
        start({
            href: event.target.href,
            ...options,
        });
    });
};

const init = (options) => {
    registerStopElementClickEventListener(options);
    registerCallElementClickEventListener(options);
};

export default {
    init
};
