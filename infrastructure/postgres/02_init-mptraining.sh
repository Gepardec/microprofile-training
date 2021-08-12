#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "mptraining" <<-EOSQL
CREATE TABLE property
(
    id bigint
        constraint property_pk
            primary key,
    key varchar,
    value varchar
);

CREATE UNIQUE INDEX property_key_uindex
    ON property (key);

CREATE SEQUENCE seq_property START 1;

INSERT INTO property(key, value, id) VALUES ('db.key1', 'Value 1 from DB', nextval('seq_property')) ON CONFLICT DO NOTHING;
INSERT INTO property(key, value, id) VALUES ('db.key2', 'Value 2 from DB', nextval('seq_property')) ON CONFLICT DO NOTHING;
INSERT INTO property(key, value, id) VALUES ('db.key3', 'Value 3 from DB', nextval('seq_property')) ON CONFLICT DO NOTHING;


EOSQL
