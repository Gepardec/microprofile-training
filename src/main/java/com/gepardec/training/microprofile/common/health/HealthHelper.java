package com.gepardec.training.microprofile.common.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.net.Socket;

@ApplicationScoped
public class HealthHelper {

    @Inject
    @ConfigProperty(name = "database.port")
    int databasePort;

    @Inject
    @ConfigProperty(name = "database.host")
    String databaseHost;

    public boolean healthCheckStateByName(String nameOfHealthCheck, Instance<HealthCheck> healthChecks) {
        return healthChecks
                .stream()
                .filter(check -> check.call().getName().contentEquals(nameOfHealthCheck))
                .anyMatch(check -> check.call().getStatus().equals(HealthCheckResponse.Status.UP));
    }

    public boolean databaseHealth() {
        try (Socket socket = new Socket(databaseHost, databasePort)) {
            return socket.isConnected();
        } catch (Exception e) {
            return false;
        }
    }
}
