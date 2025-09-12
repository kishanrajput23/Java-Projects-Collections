package com.abe762.loop_backend.shared.error.domain;

import java.time.Instant;

public final class NotAfterTimeException extends AssertionException {

    private NotAfterTimeException(String field, String message) {
        super(field, message);
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.NOT_AFTER_TIME;
    }

    public static NotAfterTimeExceptionValueBuilder strictlyNotAfter() {
        return new NotAfterTimeExceptionBuilder("must be strictly after");
    }

    public static NotAfterTimeExceptionValueBuilder notAfter() {
        return new NotAfterTimeExceptionBuilder("must be after");
    }

    public static final class NotAfterTimeExceptionBuilder
            implements NotAfterTimeExceptionValueBuilder, NotAfterTimeExceptionFieldBuilder, NotAfterTimeExceptionOtherBuilder {

        private final String hint;
        private Instant value;
        private String field;
        private Instant other;

        private NotAfterTimeExceptionBuilder(String hint) {
            this.hint = hint;
        }

        @Override
        public NotAfterTimeExceptionFieldBuilder value(Instant value) {
            this.value = value;

            return this;
        }

        @Override
        public NotAfterTimeExceptionOtherBuilder field(String field) {
            this.field = field;

            return this;
        }

        @Override
        public NotAfterTimeException other(Instant other) {
            this.other = other;

            return build();
        }

        private NotAfterTimeException build() {
            return new NotAfterTimeException(field, message());
        }

        private String message() {
            return "Time %s in \"%s\" %s %s but wasn't".formatted(value, field, hint, other);
        }
    }

    public interface NotAfterTimeExceptionValueBuilder {
        NotAfterTimeExceptionFieldBuilder value(Instant value);
    }

    public interface NotAfterTimeExceptionFieldBuilder {
        NotAfterTimeExceptionOtherBuilder field(String field);
    }

    public interface NotAfterTimeExceptionOtherBuilder {
        NotAfterTimeException other(Instant other);
    }
}
