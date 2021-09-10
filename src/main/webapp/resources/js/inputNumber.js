const update = (element) => {
    const input = mdb.Input.getInstance(element);
    if (input) {
        input.update();
    }
};

const registerBlurEventListener = (element) => {
    element.querySelector('input').addEventListener('blur', (event) => {
        const valueAsInt = parseInt(event.target.value) || -1;
        const min = parseInt(event.target.getAttribute("min"))
        if (valueAsInt === -1) {
            event.target.value = (min) ? min : '';
            update(element);
        }
    });
};

const init = (element) => {
    let input = mdb.Input.getInstance(element);
    if (!input) {
        input = new mdb.Input(element);
    }
    input.init();
    registerBlurEventListener(element);
};

export default {
    init,
    update,
}