package com.gepardec.training.microprofile;

import org.eclipse.microprofile.metrics.annotation.*;

import jakarta.enterprise.inject.Stereotype;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Counted(name = "counted")
//TODO: fix @Metered(name = "metered")
@Timed(name = "timed")
//TODO: fix @SimplyTimed(name = "simply-timed")
//TODO: fix @ConcurrentGauge(name = "concurrent-gauge")
public @interface TrainingMetric {

}
