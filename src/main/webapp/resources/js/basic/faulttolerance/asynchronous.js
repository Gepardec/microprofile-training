import httpClient from '../../httpClient.js'

const registerCallElementClickEventListener = (options) => {
    const {
        clickElement,
        timeDialogElement,
    } = options;
    clickElement.addEventListener("click", (event) => {
        event.preventDefault();
        const modal = mdb.Modal.getInstance(timeDialogElement)
        modal.show();
        httpClient.post({
            uri: event.target.href,
        }).finally(() => modal.hide()).finally(()=> console.log('Call is done'));
    });
}

const init = (options) => {
    registerCallElementClickEventListener(options);
}

export default {
    init
}