package com.gepardec.training.microprofile.basic.health.playground;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.Socket;

/*
@Liveness
@ApplicationScoped
public class DosDatabaseLiveCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Database");
        //TODO: hardcoded values
        String hostName = "localhost";
        Integer port = 19090;
        try {
            for (int i = 0; i < 1000000000; i++) {
                pingServer(hostName, port);
            }
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
 */

