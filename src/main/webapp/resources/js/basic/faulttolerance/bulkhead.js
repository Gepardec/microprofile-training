import httpClient from '../../httpClient.js'

const extractResponseData = (response, count) => {
    return response.text()
        .then((text) => {
                return {
                    call: count,
                    status: response.status,
                    text: text
                }
            }
        ).catch(() => {
            return {}
        });
}

const createResponseElement = (item) => {
    const element = document.createElement("div");
    element.classList.add("mb-1");
    element.innerText = `Call: ${item.call}, HTTP-Code: ${item.status}, Text: ${item.text}`
    return element;
}

const displayData = (responseContainer, data) => {
    data.map((item) => responseContainer.append(createResponseElement(item)));
}

const extractAndValidateInputNumber = (element, min) => {
    const inputElement = element.querySelector('input');
    const stringValue = inputElement.value;
    const value = parseInt(stringValue) || -1;
    if (value <= 0 || value < min) {
        element.focus();
        inputElement.value = "";
        alert(`Your ${inputElement.id} value is invalid. value: '${stringValue}', min: '${min}'`);
        inputElement.value = min;
        return -1;
    }

    return value;
};

const registerCallElementClickEventListener = (options) => {
    const {
        callerElement,
        countElement,
        timerElement,
        responseContainer,
        countMin,
    } = options;
    callerElement.addEventListener("click", (event) => {
        event.preventDefault();
        const parallelCount = extractAndValidateInputNumber(countElement, countMin);
        if (parallelCount !== -1) {
            responseContainer.innerHTML = null;
            const dialog = mdb.Modal.getInstance(timerElement);
            dialog.show();
            httpClient.postNTimes({
                uri: event.target.href,
                count: parallelCount,
                successCallback: (response, count) => extractResponseData(response, count),
                errorCallback: (response, count) => extractResponseData(response, count),
            }).then((data) => {
                displayData(responseContainer, data)
                dialog.hide()
            });
        }
    });
}

const init = (options) => {
    registerCallElementClickEventListener(options);
}

export default {
    init
}