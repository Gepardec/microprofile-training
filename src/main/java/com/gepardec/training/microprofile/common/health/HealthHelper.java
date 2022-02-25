package com.gepardec.training.microprofile.common.health;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class HealthHelper {

    @Inject
    @ConfigProperty(name = "database.port")
    private int databasePort;

    @Inject
    @ConfigProperty(name = "database.host")
    private String databaseHost;

    @Inject
    @Liveness
    private Instance<HealthCheck> livenessChecks;

    @Inject
    @Readiness
    private Instance<HealthCheck> readinessChecks;

    public List<Pair<String, String>> getLivenessChecks() {
        return livenessChecks
                .stream()
                .map(HealthCheck::call)
                .map(this::map)
                .collect(Collectors.toList());
    }

    public List<Pair<String, String>> getReadinessChecks() {
        return readinessChecks
                .stream()
                .map(HealthCheck::call)
                .map(this::map)
                .collect(Collectors.toList());
    }

    public boolean databaseHealth() {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(databaseHost, databasePort), 1000);
            return socket.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    private Pair<String, String> map(final HealthCheckResponse healthCheckResponse) {
        return Pair.of(healthCheckResponse.getName(), healthCheckResponse.getStatus().name());
    }
}
