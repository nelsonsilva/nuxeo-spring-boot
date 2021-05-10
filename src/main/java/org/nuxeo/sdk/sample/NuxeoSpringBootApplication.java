package org.nuxeo.sdk.sample;

import org.nuxeo.sdk.event.EventChannels;
import org.nuxeo.sdk.event.filter.DocumentTypeFilter;
import org.nuxeo.sdk.event.filter.EventTypeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageHandlingException;

@SpringBootApplication
public class NuxeoSpringBootApplication {

    private static final Logger log = LoggerFactory.getLogger(NuxeoSpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NuxeoSpringBootApplication.class, args);
    }

    @Bean
    public IntegrationFlow logError() {
        return IntegrationFlows.from(EventChannels.ERROR).handle(t -> {
            log.info("Error: {}", t.getPayload().toString());
            MessageHandlingException exception = (MessageHandlingException) t.getPayload();
            exception.printStackTrace();
        }).get();
    }

    @Bean
    public IntegrationFlow logDocumentCreated() {
        return IntegrationFlows.from(EventChannels.LOG)
                .filter(EventTypeFilter.DOCUMENT_CREATED)
                .handle(t -> log.info("Document created: {}", t.getPayload().toString()))
                .get();
    }

    @Bean
    public IntegrationFlow logFolderCreated() {
        return IntegrationFlows.from(EventChannels.LOG)
                .filter(EventTypeFilter.DOCUMENT_CREATED.and(DocumentTypeFilter.of("Folder")))
                .handle(t -> log.info("A new folder has been created! - Event: {}", t.getPayload().toString()))
                .get();
    }

    @Bean
    public IntegrationFlow logFolderDeleted() {
        return IntegrationFlows.from(EventChannels.LOG)
                .filter(EventTypeFilter.DOCUMENT_DELETED.and(DocumentTypeFilter.of("Folder")))
                .handle(t -> log.info("A folder has been deleted! - Event: {}", t.getPayload().toString()))
                .get();
    }
}
