const registerCallElementClickEventListener = (options) => {
    const {
        callElement,
        responseElement,
    } = options;
    callElement.addEventListener("click", (event) => {
        event.preventDefault();
        responseElement.innerText = "";
        fetch(event.target.href, {
            method: "POST",
        }).then((response) => {
            let serverResponseText = `HTTP-Status: ${response.status}`;
            response.text()
                .then((text) => serverResponseText += `, Content: ${text}`)
                .finally(() => responseElement.innerText = serverResponseText);
        });
    });
};

const init = (options) => {
    registerCallElementClickEventListener(options);
};

export default {
    init,
}