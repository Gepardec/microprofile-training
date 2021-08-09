#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE keycloak;
    GRANT ALL PRIVILEGES ON DATABASE keycloak TO admin;

    CREATE DATABASE mptraining;
    GRANT ALL PRIVILEGES ON DATABASE mptraining TO admin;
EOSQL