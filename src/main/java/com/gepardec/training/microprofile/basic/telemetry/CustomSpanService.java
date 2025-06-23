package com.gepardec.training.microprofile.basic.telemetry;

import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;

@ApplicationScoped
public class CustomSpanService {

    @Inject
    Logger logger;

    @WithSpan(value = "custom-span", kind = SpanKind.SERVER)
    public void produceCustomSpan(@SpanAttribute("time") String time) {
        logger.info("Producing custom span with time: " + time);
    }
}
