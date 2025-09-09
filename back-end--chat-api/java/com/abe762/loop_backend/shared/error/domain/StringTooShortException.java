package com.abe762.loop_backend.shared.error.domain;

import java.util.Map;

public final class StringTooShortException extends AssertionException {

    private final String minLength;
    private final String currentLength;

    private StringTooShortException(StringTooShortExceptionBuilder builder) {
        super(builder.field, builder.message());
        minLength = String.valueOf(builder.minLength);
        currentLength = String.valueOf(builder.value.length());
    }

    public static StringTooShortExceptionBuilder builder() {
        return new StringTooShortExceptionBuilder();
    }

    static final class StringTooShortExceptionBuilder {

        private String value;
        private int minLength;
        private String field;

        private StringTooShortExceptionBuilder() {}

        StringTooShortExceptionBuilder field(String field) {
            this.field = field;

            return this;
        }

        StringTooShortExceptionBuilder value(String value) {
            this.value = value;

            return this;
        }

        StringTooShortExceptionBuilder minLength(int minLength) {
            this.minLength = minLength;

            return this;
        }

        private String message() {
            return "The value \"%s\" in field \"%s\" must be at least %d long but was only %d".formatted(value, field, minLength, value.length());
        }

        public StringTooShortException build() {
            return new StringTooShortException(this);
        }
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.STRING_TOO_SHORT;
    }

    @Override
    public Map<String, String> parameters() {
        return Map.of("minLength", minLength, "currentLength", currentLength);
    }
}
