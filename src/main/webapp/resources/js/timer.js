const emptyFunction = () => {
};

const state = {
    timer: null,
    options: null,
};

const isRunning = () => {
    return state.timer != null;
};

const start = () => {
    const {
        delayMillis,
        startCallback = emptyFunction,
        runFunction = emptyFunction,
        runData = {},
    } = state.options;
    if (!state.timer) {
        startCallback();
        state.timer = setInterval(runFunction, delayMillis, runData);
    }
};

const stop = () => {
    const {
        stopCallback = emptyFunction,
    } = state.options;
    if (state.timer) {
        clearInterval(state.timer);
        state.timer = null;
        stopCallback();
    }
};

const restart = () => {
    stop();
    start();
}

const init = (options) => {
    state.options = options;
};

export default {
    init,
    start,
    stop,
    restart,
    isRunning,
}