# Infrastructure guide

This is the infrastructure guid which helps you to set up and run the infrastructure and to provide modifications to the infrastructure definition.

We use `docker-compose` for the infrastructure which has a good support on all platforms.

All applications define the following admin user.

* Username: `admin`  
* Password: `admin@123`

The following listed application are available.

 Application        | URL           | Task  |
| :------------- |:-------------| :-----------------|
| Keycloak      | http://localhost:18080/auth/ | OpenId-Connect Server |
| Grafana       | http://localhost:13000       | Metric Frontend |
| Prometheus    | http://localhost:19090       | Metric Backend  |

## Keycloak

Keycloak is used to secure the training application via Microprofile JWT.

The resources of Keycloak are located at `/infrastructure/keycloak` and are:

1. `v<N>_realm-export.json`   
The exported keycloak configuration.  

! During the Export Keycloak replaces all secrets with `*`, which need to be added again. 

### Client Setup

* `client-id=training`  
The client id of the training application.
* `client-secret=0fecdfbd-67dc-4eba-8225-dea864692084`  
The client secret used by the client to authenticate.
* `auth-baseUrl=http://localhost:18080/auth/`   
The base url where the client can reach Keycloak.


 