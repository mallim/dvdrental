# Libraries Used
* Spring Boot 3.1
* Lombok 1.18.20
* MapStruct 1.5.5.Final
* Spring Doc Open API - Swagger Replacement

# Commands

To run Swagger UI:

```
http://localhost:8080/swagger-ui/index.html 
```

To run the monitoring tools:

```bash
docker compose -f docker-compose-monitoring.yml up -d
```

# References
* https://github.com/lhsamad/dvdrental - source code example
* https://github.com/NajeebArif/netclick - source code example
* https://refactorfirst.com/spring-boot-prometheus-grafana - prometheus and grafana monitoring tutorial
* https://github.com/aballaci/springboot-jpa-sakila - promtheus and grafana monitoring source code example with helm and kubernetes