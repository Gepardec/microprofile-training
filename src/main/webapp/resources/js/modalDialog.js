class ModalDialog {
    constructor(dialog) {
        this.dialog = dialog;
    };

    show = () => {
        this.dialog.show();
    };

    hide = () => {
        this.dialog.hide();
    };
};

const registerShowEventListener = (options) => {
    const { element, showCallback } = options;
    element.addEventListener("show.mdb.modal", showCallback);
};

const registerHideEventListener = (options) => {
    const { element, hideCallback } = options;
    element.addEventListener("hide.mdb.modal", hideCallback);
};

const init = (options) => {
    const { element, showCallback, hideCallback } = options;
    if (!mdb.Modal.getInstance(element)) {
        new mdb.Modal(element);
    }
    if (showCallback) {
        registerShowEventListener(options);
    }
    if (hideCallback) {
        registerHideEventListener(options);
    }
};

const create = (options) => {
    const { element } = options;
    init(options);
    const dialog = mdb.Modal.getInstance(element);
    return new ModalDialog(dialog);
}

export default {
    init,
    create,
}