const registerOnLoad = (func) => {
    document.addEventListener("DOMContentLoaded", func);
};

const registerClickListenerPreventDefault = (element, func) => {
    element.addEventListener('click', async (event) => {
        event.preventDefault();
        func(event);
    });
};

export default {
    registerOnLoad,
    registerClickListenerPreventDefault
};
