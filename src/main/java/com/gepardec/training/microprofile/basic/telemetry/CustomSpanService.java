package com.gepardec.training.microprofile.basic.telemetry;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;

@ApplicationScoped
public class CustomSpanService {

    @Inject
    Logger logger;

    public void produceCustomSpan(String time) {
        logger.info("Producing custom span with time: " + time);
    }
}
