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
### Post example
- Trace Data
```
[
  {
    "cpf": "40203683865",
    "lastQueryAtBureauOfCredit": {
      "name": "serasa",
      "date": "2020-02-06T16:59:11.332"
    },
    "lastCreditCardPaymentData": {
      "companyName": "oi",
      "amount": "R$50,00",
      "card": "xxxxxxxx6304",
      "issuerBank": "itau",
      "dateTime": "2020-02-06T16:59:11.332"
    },
    "financialMovementList": [
      {
        "amount": "R$500,00",
        "type": "payment",
        "dateTime": "2020-02-06T16:59:11.332"
      },
      {
        "amount": "R$4000,00",
        "type": "receivement",
        "dateTime": "2020-02-06T16:59:11.332"
      }
    ],
    "updatedAt": "2020-02-06T16:59:11.332"
  }
]
```
- Sensitive Data
```
[
  {
    "cpf": "40203683865",
    "customerName": "Robertson Douza",
    "address": "Rua Gavião Peixoto",
    "debts": [
      {
        "creditorName": "Creditor",
        "creditorDocument": "588945-54684-6523205-54654",
        "currentDebitAmount": "R$200000,00",
        "initialDebitAmount": "R$15000,00",
        "initialData": "2018-02-06T16:59:11.332"
      }
    ],
    "updatedAt": "2020-02-06T16:59:11.332"
  }
]
```
- Score Data
```
[
  {
    "cpf": "40203683865",
    "customerAge": "26",
    "address": "Rua Gavião Peixoto",
    "sourceOfIncome": "R$5000,00",
    "properties": [
      {
        "propertyName": "Casa própria",
        "propertyDocument": "588945-54684-6523205-54654",
        "propertyEvaluatedPrice": "R$200000,00"
      }
    ],
    "updatedAt": "2018-02-06T16:59:11.332"
  }
]
```

##### API Documentation *(By swagger, the apllication must be running)*
> [dataupdate-job](https://localhost:8080/swagger-ui.html)


