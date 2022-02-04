const emptyFunction = () => {
};

class Timer {

    constructor(options) {
        this.intervalId = null;
        this.options = options;
    }

    isRunning = () => {
        return this.intervalId != null;
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
            this.intervalId = setInterval(runFunction, delayMillis, runData);
        }
    };

    stop = () => {
        const {
            stopCallback = emptyFunction,
        } = this.options;
        if (this.isRunning()) {
            clearInterval(this.intervalId);
            this.intervalId = null;
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