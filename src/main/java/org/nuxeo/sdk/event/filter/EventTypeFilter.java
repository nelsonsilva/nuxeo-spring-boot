package org.nuxeo.sdk.event.filter;

import org.nuxeo.sdk.event.EventType;
import org.nuxeo.sdk.dto.LogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * {@link EventFilter} that checks if an event is classified as a specific type.
 */
public class EventTypeFilter implements EventFilter<LogEntry> {

    public static final EventFilter<LogEntry> DOCUMENT_CREATED = EventTypeFilter.of(EventType.DOCUMENT_CREATED);
    public static final EventFilter<LogEntry> DOCUMENT_UPDATED = EventTypeFilter.of(EventType.DOCUMENT_UPDATED);
    public static final EventFilter<LogEntry> DOCUMENT_REMOVED = EventTypeFilter.of(EventType.DOCUMENT_REMOVED);
    public static final EventFilter<LogEntry> DOCUMENT_TRASHED = EventTypeFilter.of(EventType.DOCUMENT_TRASHED);
    public static final EventFilter<LogEntry> DOCUMENT_DELETED = DOCUMENT_REMOVED.or(DOCUMENT_TRASHED);

    private static final Logger LOGGER = LoggerFactory.getLogger(EventTypeFilter.class);

    private final String acceptedEventType;

    private EventTypeFilter(final String acceptedEventType) {
        this.acceptedEventType = Objects.requireNonNull(acceptedEventType);
    }

    /**
     * Create a {@link EventTypeFilter} for a specific event type.
     *
     * @param eventType given event type to be accepted by the filter
     * @return created {@link EventTypeFilter}
     */
    public static EventTypeFilter of(final EventType eventType) {
        return new EventTypeFilter(eventType.getType());
    }


    @Override
    public boolean test(LogEntry event) {
        LOGGER.debug("Checking filter for type {} and event {}", acceptedEventType, event);
        return acceptedEventType.equals(event.getEventId());
    }
}
