import httpClient from '../../httpClient.js'
import mp from "../../mp.js";
import modalDialog from "../../modalDialog.js";
import inputNumber from "../../inputNumber.js";

const state = {
    timerDialog: null,
    initDialog: null,
    options: null,
};

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

const displayData = (data) => {
    const {
        responseContainer,
    } = state.options;
    data.map((item) => responseContainer.append(createResponseElement(item)));
}

const registerCallElementClickEventListener = () => {
    const {
        callerElement,
        responseContainer,
        countElement,
    } = state.options;
    mp.registerClickListenerPreventDefault(callerElement, (event) => {
        const parallelCount = parseInt(countElement.querySelector('input').value);
        responseContainer.innerHTML = null;
        state.timerDialog.show();
        httpClient.postBatch({
            uri: event.target.href,
            count: parallelCount,
            successCallback: (response, count) => extractResponseData(response, count),
            failureCallback: (response, count) => extractResponseData(response, count),
        }).then((data) => {
            displayData(data)
            state.timerDialog.hide()
        });
    });
}

const init = (options) => {
    const {
        timerElement,
        initDialogElement,
        countElement,
    } = options;
    state.options = options;
    state.timerDialog = modalDialog.create({
        element: timerElement,
    })
    state.initDialog = modalDialog.create({
        element: initDialogElement,
    })
    inputNumber.init(countElement);
    registerCallElementClickEventListener();
}

export default {
    init
}