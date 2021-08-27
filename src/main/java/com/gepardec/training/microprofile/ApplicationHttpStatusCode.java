package com.gepardec.training.microprofile;

public class ApplicationHttpStatusCode {

    public static final int CIRCUIT_OPEN = 490;

    public static final int BULKHEAD_REJECT = 491;

    public static final int INTENTIONAL_FAIL = 492;

    private ApplicationHttpStatusCode() {
    }
}
