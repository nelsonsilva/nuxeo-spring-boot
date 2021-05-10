package org.nuxeo.sdk.dto;

import java.util.Date;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
public class LogEntry {

    @JsonProperty("entity-type")
    protected String entityType;

    private long id;

    private String principalName;

    private String eventId;

    private Date eventDate;

    private Date logDate;

    private String docUUID;

    private String docType;

    private String docPath;

    private String category;

    private String comment;

    private String docLifeCycle;

    private String repositoryId;

    private Map<String, Object> extended;

}
