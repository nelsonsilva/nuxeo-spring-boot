# Nuxeo Event SDK - Spring Integration Auto Configuration

Quick prototype of a Spring boot autoconfiguration for Nuxeo / Sprint Integration heavily based on [Alfresco's OOP SDK](https://docs.alfresco.com/content-services/latest/develop/oop-sdk/) 

## Usage

This depends on a running Kafka/Nuxeo deployment so first thing is to get it up and running:

```docker-compose up```

Then you should be able to run the application:

```mvn spring-boot:run```

The application should connect to the Kafka topic and log some document events.
