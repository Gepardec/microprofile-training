package com.gepardec.training.microprofile.advanced.config;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@RequestScoped
public class PropertyDao {

    @Resource(lookup = "java:jboss/datasources/PostgreSQLDS")
    private DataSource dataSource;

    private static PreparedStatement createStatement(String key, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT p.value FROM property p WHERE KEY = ?");
        statement.setString(1, key);
        return statement;
    }

    public Set<String> findPropertyNames() {
        Set<String> propertyNames = new HashSet<>();
        try (Connection connection = createConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT p.key FROM property p ORDER BY p.key")) {
            while (resultSet.next()) {
                propertyNames.add(resultSet.getString("KEY"));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("An error occurred loading the database properties", e);
        }
        return propertyNames;
    }

    public String findProperty(String key) {
        try (Connection connection = createConnection();
                PreparedStatement statement = createStatement(key, connection);
                ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getString("VALUE");
            }

        } catch (SQLException e) {
            throw new IllegalStateException("An error occurred loading a database property", e);
        }
        return null;
    }

    private Connection createConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
