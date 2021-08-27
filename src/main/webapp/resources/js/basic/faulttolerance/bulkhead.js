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

const callApiNTimes = async (uri, callCount) => {
    const responses = await Promise.all([...Array(callCount).keys()].map(count => fetch(uri, {
        method: "POST",
    })));
    return await Promise.all(responses.map((response, index) => extractResponseData(response, index)));
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
    callerElement.addEventListener("click", async (event) => {
        event.preventDefault();
        const parallelCount = extractAndValidateInputNumber(countElement, countMin);
        if (parallelCount !== -1) {
            responseContainer.innerHTML = null;
            mdb.Modal.getInstance(timerElement).show();
            const data = await callApiNTimes(event.target.href, parallelCount);
            displayData(responseContainer, data)
            mdb.Modal.getInstance(timerElement).hide();
        }
    });
}

const init = (options) => {
    registerCallElementClickEventListener(options);
}

export default {
    init
}