const registerCallElementClickEventListener = (options) => {
    const {
        clickElement,
        timeDialogElement,
    } = options;
    clickElement.addEventListener("click", (event) => {
        event.preventDefault();
        const modal = mdb.Modal.getInstance(timeDialogElement)
        modal.show();
        fetch(event.target.href, {
            method: "POST",
        }).finally(() => modal.hide());
    });
}

const init = (options) => {
    registerCallElementClickEventListener(options);
}

export default {
    init
}