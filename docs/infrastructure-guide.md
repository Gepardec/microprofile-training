# Infrastructure guide

This is the infrastructure guide which helps you to set up and run the infrastructure and to provide modifications to the infrastructure definition.

We use `docker-compose` for the infrastructure which has a good support on all platforms.

All applications define the following admin user.

* Username: `admin`  
* Password: `admin@123`

The following listed application are available.

| Application        | URL           | Task  |
| :------------- |:-------------| :-----------------|
| Keycloak      | http://localhost:18080/auth/                 | OpenId-Connect Server  |
| Postgres      | jdbc:postgresql://localhost:15432/mptraining | Database               |
| Grafana       | http://localhost:13000                       | Metric Frontend        |
| Prometheus    | http://localhost:19090                       | Metric Backend         |
| JaegerUI      | http://localhost:16686/search                | Tracing Backend          |

## Keycloak

Keycloak is used to secure the training application via MicroProfile JWT.

The resources of Keycloak are located at `/infrastructure/keycloak` and are:

1. `v<N>_realm-export.json`   
The exported keycloak configuration.  

! During the Export Keycloak replaces all secrets with `*`, which need to be added again. 

! The Export is only partial. Make sure you add the training-users manually to the exported json.

### Client Setup

* `client-id=training`  
The client id of the training application.
* `auth-baseUrl=http://localhost:18080/auth/`   
The base url where the client can reach Keycloak.


 