const registerCallElementClickEventListener = (options) => {
    const {
        callElement,
        responseElement,
        timerElement,
    } = options;
    callElement.addEventListener("click", (event) => {
        event.preventDefault();
        responseElement.innerText = "";
        const modal = mdb.Modal.getInstance(timerElement)
        modal.show();
        fetch(event.target.href, {
            method: "POST",
        }).then((response) => {
            let serverResponseText = `HTTP-Status: ${response.status}`;
            response.text()
                .then((text) => serverResponseText += `, Content: ${text}`)
                .finally(() => responseElement.innerText = serverResponseText);
        }).finally(() => modal.hide());
    });
}

const init = (options) => {
    registerCallElementClickEventListener(options);
};

export default {
    init,
};
