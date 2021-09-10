package com.gepardec.training.microprofile;

public class ApplicationHttpStatusCode {

    public static final int CIRCUIT_OPEN = 490;

    public static final int BULKHEAD_REJECT = 491;

    public static final int INTENTIONAL_FAIL = 492;

    public static final int TOO_MANY_REQUESTS = 493;

    public static final int TOO_MANY_FAILURES_TRY_AGAIN_LATER = 494;

    private ApplicationHttpStatusCode() {
    }
}
