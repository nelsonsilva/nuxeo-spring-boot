package org.nuxeo.sdk.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Value
@ConfigurationProperties(prefix = "nuxeo.events")
public class NuxeoEventsProperties {
    /**
     * The topic to consume.
     */
    String topic = "nuxeo-audit-audit";

    /**
     * Folder with the Avro schema.
     */
    String schemaDirectory = "data/nuxeo/avro";
}
