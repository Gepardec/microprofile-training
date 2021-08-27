package com.gepardec.training.microprofile.basic.health.playground;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
/*
@Liveness
@ApplicationScoped
public class DosLiveCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Dos");

        for (int i = 0; i < 100; i++) {
            try {
                callHealthCheck();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        responseBuilder.up();
        return responseBuilder.build();
    }

    private void callHealthCheck() throws IOException {
        //TODO: hardcoded values
        URL url = new URL("http://localhost:9990/health");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int result = con.getResponseCode();
    }
}
*/