package com.gepardec.training.microprofile.basic.health.playground;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.Socket;

@Readiness
@ApplicationScoped
public class DatabaseLiveCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Database");
        //TODO: hardcoded values
        String hostName = "localhost";
        Integer port = 19090;
        try {
            pingServer(hostName, port);
            responseBuilder.up();
        } catch (Exception e) {
            responseBuilder.down()
                           .withData("error", e.getMessage());
        }
        return responseBuilder.build();
    }

    private void pingServer(String dbhost, int port) throws IOException {
        Socket socket = new Socket(dbhost, port);
        socket.close();
    }
}

