package com.gepardec.training.microprofile;

import org.apache.commons.lang3.StringUtils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

@ApplicationScoped
@Named
public class PathHelper {

    @Inject
    private HttpServletRequest servletRequest;

    public boolean isOnPage(String page) {
        return servletRequest.getPathInfo().endsWith(page);
    }

    public boolean isOnSubpage(String page) {
        return servletRequest.getPathInfo().contains(page);
    }

    public String basePath() {
        return servletRequest.getServletContext().getContextPath() + "/api";
    }

    public String resourcePath() {
        return servletRequest.getServletContext().getContextPath() + "/resources";
    }

    public String buildPath(String path) {
        if (StringUtils.isBlank(path)) {
            return "#";
        } else if (path.startsWith("#") || path.startsWith("http")) {
            return path;
        }
        return basePath() + path;
    }

    public String buildResourcePath(String path) {
        return resourcePath() + path;
    }

}
