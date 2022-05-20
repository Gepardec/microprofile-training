package com.gepardec.training.microprofile;

import jakarta.ws.rs.core.MultivaluedMap;

public final class HeaderHelper {

    private HeaderHelper() {
        // nop
    }

    public static boolean isJsHttpClientRequest(final MultivaluedMap<String, String> headers) {
        return headers != null && headers.get("X-HttpClient-Training") != null;
    }
}
