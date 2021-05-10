package org.nuxeo.sdk.event.filter;

import org.springframework.integration.core.GenericSelector;
import org.springframework.messaging.Message;

import java.util.Objects;

@FunctionalInterface
public interface EventFilter<T> extends GenericSelector<Message<T>>  {

    boolean test(T var1);

    default EventFilter<T> and(EventFilter<T> other) {
        Objects.requireNonNull(other);
        return (t) -> this.test(t) && other.test(t);
    }

    default EventFilter<T> negate() {
        return (t) -> !this.test(t);
    }

    default EventFilter<T> or(EventFilter<T> other) {
        Objects.requireNonNull(other);
        return (t) -> this.test(t) || other.test(t);
    }

    default boolean accept(Message<T> source) {
        return this.test((T) source.getPayload());
    }
}
