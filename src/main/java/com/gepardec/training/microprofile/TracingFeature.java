package com.gepardec.training.microprofile;

import io.opentracing.Tracer;
import io.opentracing.contrib.jaxrs2.server.OperationNameProvider;
import io.opentracing.contrib.jaxrs2.server.ServerSpanDecorator;
import io.opentracing.contrib.jaxrs2.server.ServerTracingDynamicFeature;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

/**
 * We setup the server-tracing-feature manually, so we can register our decorators.
 * We use the Tracer provided and configured by the underlying smallrye-opentracing subsystem.
 */
@Provider
@ApplicationScoped
public class TracingFeature implements DynamicFeature {

    @Inject
    private Instance<ServerSpanDecorator> spanDecorators;

    @Inject
    private Tracer tracer;

    private ServerTracingDynamicFeature serverTracingDynamicFeature;

    @PostConstruct
    void init() {
        serverTracingDynamicFeature = new ServerTracingDynamicFeature.Builder(tracer)
                .withOperationNameProvider(OperationNameProvider.ClassNameOperationName.newBuilder())
                .withJoinExistingActiveSpan(true)
                // Register all CDI available ServerSpanDecorator implementations
                .withDecorators(spanDecorators.stream().collect(Collectors.toList()))
                .build();
    }

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        serverTracingDynamicFeature.configure(resourceInfo, context);
    }
}
