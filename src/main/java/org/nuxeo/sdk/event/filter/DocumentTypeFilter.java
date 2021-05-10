package org.nuxeo.sdk.event.filter;

import org.nuxeo.sdk.dto.LogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * {@link EventFilter} that checks if an event is related to a node with an specific type.
 */
public class DocumentTypeFilter implements EventFilter<LogEntry> {

    private static final Logger log = LoggerFactory.getLogger(DocumentTypeFilter.class);

    private final String acceptedDocumentType;

    private DocumentTypeFilter(final String acceptedDocumentType) {
        this.acceptedDocumentType = Objects.requireNonNull(acceptedDocumentType);
    }

    /**
     * Obtain a {@link DocumentTypeFilter} for a specific type.
     *
     * @param acceptedDocumentType given type name to be accepted by the filter.
     * @return created {@link DocumentTypeFilter}
     */
    public static DocumentTypeFilter of(final String acceptedDocumentType) {
        return new DocumentTypeFilter(acceptedDocumentType);
    }

    @Override
    public boolean test(final LogEntry event) {
        log.debug("Checking filter for node type {} and event {}", acceptedDocumentType, event);
        return acceptedDocumentType.equals(event.getDocType());
    }
}
