package com.gepardec.training.microprofile.basic.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import java.net.Socket;

@Liveness
@ApplicationScoped
public class DatabaseLivenessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Database");

        String hostName = "";  //insert the correct values to fix the healthcheck
        int port = 0;  //insert the correct values to fix the healthcheck

        if (pingServer(hostName, port)) {
            responseBuilder.up();
        } else {
            responseBuilder.down()
                    .withData("Error", "Socket Closed");
        }
        return responseBuilder.build();
    }

    private boolean pingServer(String dbhost, int port) {
        try (Socket socket = new Socket(dbhost, port)) {
            return socket.isConnected();
        } catch (Exception e) {
            return false;
        }
    }
}

