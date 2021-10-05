import jwt from "./jwt.js";

const register = (options) => {
    const {
        clickElementJwt,
        clickElementClaim,
        responseElement
    } = options;

    jwt.registerClick({
        clickElement: clickElementJwt,
        responseElement: responseElement
    });

    jwt.registerClick({
        clickElement: clickElementClaim,
        responseElement: responseElement
    })
};

const init = (options) => {
    register(options);
};

export default {
    init
};