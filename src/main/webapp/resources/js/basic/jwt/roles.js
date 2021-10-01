import jwt from "./jwt.js";

const register = (options) => {
    jwt.registerClick(options);
};

const init = (options) => {
    register(options)
};

export default {
    init
};