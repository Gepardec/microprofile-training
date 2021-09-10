import modalDialog from "../modalDialog.js";
import timer from "../timer.js";

const state = {
    options: null,
    timer: null,
    seconds: 0,
};

const reset = () => {
    const {
        timerTextElement,
    } = state.options;
    state.seconds = 0;
    timerTextElement.innerText = "0";
};

const onInterval = () => {
    const {
        timerTextElement,
    } = state.options;
    timerTextElement.innerText = (state.seconds++).toString();
};

const init = (options) => {
    const {
        modalDialogElement,
        delayMillis,
    } = options;
    state.options = options;
    state.timer = timer.create({
        delayMillis: delayMillis,
        runFunction: () => onInterval(options),
    });
    modalDialog.init({
        element: modalDialogElement,
        showCallback: () => {
            reset(options);
            state.timer.start();
        },
        hideCallback: () => state.timer.stop(),
    });
}

export default {
    init
}