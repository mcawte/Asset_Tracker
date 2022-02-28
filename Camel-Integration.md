# Mini-Project: Integration using Camel
The aim of this mini project is to learn more about common integration patterns and this will be achieved through the popular Java-based framework - Camel.

## File Component
Some systems may output data as files to be stored on disk. A common example may be that parts of legacy systems are not yet be ready to migrate their data over from proprietary formats (e.g. CSV, XLXS, XML) to a more structure and manageable form like being persisted in a database.

`POST asset -> api -> file system -> camel app -> database`

### Steps:
- Extend the existing `API` to allow the ability to store `Assets` as files on disk.
- Create a `camel-based` application (on `spring-boot` or `quarkus`) that picks up the files and logs out information about the Asset. Then store this information in the database without hitting the API.

## Message Routing
Payloads will often be processed differently based on their content, which can be achieved in Camel's form of [conditional routing](https://camel.apache.org/components/3.11.x/eips/content-based-router-eip.html)

### Steps:
- Extend your camel application to process a subset of assets based on a condition e.g. with a latitude only in the northern hemisphere
- Send the other subset of assets to a separate route that logs out the details and prevents further processing

## Messaging

`POST asset -> api -> messaging -> camel app -> database`

### Steps:
- Setup your applications and supporting infrastructure to run from `docker-compose` so it is easy to spin up in a local environment.
- Refactor your `API` and `Camel App` to communicate through a messaging service rather than through a file system. Feel free to choose either queue-based messaging like [ActiveMQ](https://activemq.apache.org/), [RabbitMQ](https://www.rabbitmq.com/) OR topic based messaging like [Kafka](https://kafka.apache.org/)