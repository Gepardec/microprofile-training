package com.gepardec.training.microprofile;

import org.eclipse.krazo.engine.ViewEngineConfig;
import org.eclipse.krazo.ext.thymeleaf.DefaultTemplateEngineProducer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.nio.charset.StandardCharsets;

/**
 * This specialized producer is used to configure the template engine.
 */
@ApplicationScoped
@Specializes
public class TemplateEngineProducer extends DefaultTemplateEngineProducer {

    @Inject
    private ServletContext servletContext;

    private TemplateEngine templateEngine;

    @PostConstruct
    void init() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(this.servletContext);
        resolver.setCacheable(false);
        resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(resolver);

        this.templateEngine = engine;
    }

    @Override
    @Produces
    @ViewEngineConfig
    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
}
