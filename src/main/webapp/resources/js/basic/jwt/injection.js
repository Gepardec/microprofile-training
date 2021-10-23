import jwt from "../../jwt.js";

const register = (options) => {
    const {
        clickElementJwt,
        clickElementClaim,
        responseElement,
        sendToken
    } = options;

    jwt.registerClick({
        clickElement: clickElementJwt,
        responseElement: responseElement,
        sendToken: sendToken
    });

    jwt.registerClick({
        clickElement: clickElementClaim,
        responseElement: responseElement,
        sendToken: sendToken
    })
};

const init = (options) => {
    register(options);
};

export default {
    init
};