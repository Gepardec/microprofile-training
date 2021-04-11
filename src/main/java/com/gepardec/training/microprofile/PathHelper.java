package com.gepardec.training.microprofile;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@ApplicationScoped
@Named
public class PathHelper {

    @Inject
    private HttpServletRequest servletRequest;

    public boolean isOnPage(String page) {
        return servletRequest.getPathInfo().endsWith(page);
    }

}
