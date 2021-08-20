const state = {
    failEachCount: 1,
    failAfterEachCount: 1,
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

const run = async (options) => {
    const {
        href,
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
            displayState(options);
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

const extractAndValidateInputNumber = (element, min) => {
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
    initElement.addEventListener('click', async (event) => {
            event.preventDefault();
            if (state.timerReference) {
                alert('Cannot initialize while running, please stop first');
                return;
            }
            if (extractAndValidateInputNumber(failEachCountElement, failEachCountMin) && extractAndValidateInputNumber(failAfterEachCountElement, failAfterEachCountMin)) {
                const failEachCountInputElement = failEachCountElement.querySelector('input');
                const failAfterEachCountInputElement = failAfterEachCountElement.querySelector('input');
                const searchParams = new URLSearchParams();
                searchParams.append(failEachCountInputElement.id, failEachCountInputElement.value);
                searchParams.append(failAfterEachCountInputElement.id, failAfterEachCountInputElement.value);
                await fetch(`${event.target.href}?` + searchParams, {
                    method: "POST"
                }).then((result) => {
                    if (!result.ok) {
                        alert('Endpoint initialization failed');
                    }
                });
                alert(`Endpoint successfully initialized with failEachCount: '${failEachCountInputElement.value}', failAfterEachCount: '${failAfterEachCountInputElement.value}'`);
            }
        }
    );
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
    callerElement.addEventListener('click', async (event) => {
        event.preventDefault();
        await stop(options);
        start({
            href: event.target.href,
            ...options,
        });
    });
};

const init = (options) => {
    displayState(options);
    registerStopElementClickEventListener(options);
    registerCallElementClickEventListener(options);
    registerInitElementClickEventListener(options);
};

export default {
    init
};
