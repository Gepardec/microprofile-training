const state = {
    timer: null,
    seconds: 0,
};

const resetState = () => {
    state.timer = null;
    state.seconds = 0;
};

const onInterval = (options) => {
    const {
        timerTextElement,
    } = options;
    timerTextElement.innerText = (state.seconds++).toString();
};

const startInterval = (options) => {
    const {
        delayMillis,
    } = options;
    state.timer = setInterval(() => onInterval(options), delayMillis);
};

const stopInterval = (options) => {
    const {
        timerTextElement,
    } = options;
    if (state.timer) {
        clearInterval(state.timer);
    }
    timerTextElement.innerText = "0";
    resetState();
};

const registerHideMdbModal = (options) => {
    const {
        modalDialogElement,
    } = options;
    modalDialogElement.addEventListener("hide.mdb.modal", () => stopInterval(options));
};

const registerShowMdbModal = (options) => {
    const {
        modalDialogElement,
    } = options;
    modalDialogElement.addEventListener("show.mdb.modal", () => startInterval(options));
}

const init = (options) => {
    const {
        modalDialogElement,
    } = options;
    new mdb.Modal(modalDialogElement);
    registerShowMdbModal(options);
    registerHideMdbModal(options);
}

export default {
    init
}