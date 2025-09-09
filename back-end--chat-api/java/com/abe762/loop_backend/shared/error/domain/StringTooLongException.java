package com.abe762.loop_backend.shared.error.domain;

import java.util.Map;

public final class StringTooLongException extends AssertionException {

    private final String maxLength;
    private final String currentLength;

    private StringTooLongException(StringTooLongExceptionBuilder builder) {
        super(builder.field, builder.message());
        maxLength = String.valueOf(builder.maxLength);
        currentLength = String.valueOf(builder.value.length());
    }

    public static StringTooLongExceptionBuilder builder() {
        return new StringTooLongExceptionBuilder();
    }

    static final class StringTooLongExceptionBuilder {

        private String value;
        private int maxLength;
        private String field;

        private StringTooLongExceptionBuilder() {}

        StringTooLongExceptionBuilder field(String field) {
            this.field = field;

            return this;
        }

        StringTooLongExceptionBuilder value(String value) {
            this.value = value;

            return this;
        }

        StringTooLongExceptionBuilder maxLength(int maxLength) {
            this.maxLength = maxLength;

            return this;
        }

        private String message() {
            return "The value \"%s\" in field \"%s\" must be at most %d long but was %d".formatted(value, field, maxLength, value.length());
        }

        public StringTooLongException build() {
            return new StringTooLongException(this);
        }
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.STRING_TOO_LONG;
    }

    @Override
    public Map<String, String> parameters() {
        return Map.of("maxLength", maxLength, "currentLength", currentLength);
    }
}
