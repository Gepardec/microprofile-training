const emptyFunction = () => {
};

class Timer {

    constructor(options) {
        this.timer = null;
        this.options = options;
    }

    isRunning = () => {
        return this.timer != null;
    };

    start = () => {
        const {
            delayMillis,
            startCallback = emptyFunction,
            runFunction = emptyFunction,
            runData = {},
        } = this.options;
        if (!this.isRunning()) {
            startCallback();
            this.timer = setInterval(runFunction, delayMillis, runData);
        }
    };

    stop = () => {
        const {
            stopCallback = emptyFunction,
        } = this.options;
        if (this.isRunning()) {
            clearInterval(this.timer);
            this.timer = null;
            stopCallback();
        }
    };

    restart = () => {
        this.stop();
        this.start();
    }
}

const create = (options) => {
    return new Timer(options);
};

export default {
    create,
}