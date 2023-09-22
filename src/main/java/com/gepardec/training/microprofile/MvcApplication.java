package com.gepardec.training.microprofile;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
@LoginConfig(authMethod = "MP-JWT", realmName = "microprofile")
public class MvcApplication extends Application {

}
