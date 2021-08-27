const registerOnLoad = (func) => {
    document.addEventListener("DOMContentLoaded", func);
};

export default {
    registerOnLoad,
};
