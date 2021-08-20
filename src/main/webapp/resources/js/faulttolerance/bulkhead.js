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

const init = (options) => {
    const {
        callerElement,
        countElement,
        responseContainer,
        beforeCallback = () => {
        },
        afterCallback = () => {
        }
    } = options;
    callerElement.addEventListener("click", async (event) => {
        event.preventDefault();
        const countInputElement = countElement.querySelector('input');
        const parallelCount = parseInt(countInputElement.value) || -1;
        if (parallelCount <= 0) {
            countInputElement.focus();
            countInputElement.value = "";
            alert(`Your parallel Count is invalid. parallelCount: '${countInputElement.value}'`);
            countInputElement.value = "2";
            return;
        }
        responseContainer.innerHTML = null;
        beforeCallback();
        const data = await callApiNTimes(event.target.href, parallelCount);
        displayData(responseContainer, data)
        afterCallback();
    });
}

export default {
    init
}