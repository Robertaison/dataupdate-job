# dataupdate-job

#### Is a Java Web API that is responsible for check updates about specifics datas from CPF.

### *Technologies:*

- Java 11
- Spring
- Lombok
- RabbitMQ
- Postgres
- Swagger

### Instructions
- First we must launch the infrastructure of enviroment
```
Run this command to launc all dependencies togheter:
docker-compose -f mongo.yaml -f mysql.yaml -f postgres.yaml -f rabbit.yaml up -d

Or you can launch each one at once:
Example: docker-compose -f mongo.yaml
```

- Second launch de project and access [swagger](https://localhost:8080/swagger-ui.html) to do a post
```
It's necessary do a post to build rabbit infrastructure necessary to other services can be lauched
```


##### API Documentation *(By swagger, the apllication must be running)*
> [dataupdate-job](https://localhost:8080/swagger-ui.html)


