package com.abe762.loop_backend.shared.error.domain;

import java.util.Map;

public final class NumberValueTooLowException extends AssertionException {

    private final String min;
    private final String value;

    private NumberValueTooLowException(NumberValueTooLowExceptionBuilder builder) {
        super(builder.field, builder.message());
        min = builder.minValue;
        value = builder.value;
    }

    public static NumberValueTooLowExceptionBuilder builder() {
        return new NumberValueTooLowExceptionBuilder();
    }

    public static class NumberValueTooLowExceptionBuilder {

        private String field;
        private String minValue;
        private String value;

        public NumberValueTooLowExceptionBuilder field(String field) {
            this.field = field;

            return this;
        }

        public NumberValueTooLowExceptionBuilder minValue(String minValue) {
            this.minValue = minValue;

            return this;
        }

        public NumberValueTooLowExceptionBuilder value(String value) {
            this.value = value;

            return this;
        }

        public String message() {
            return new StringBuilder()
                    .append("Value of field \"")
                    .append(field)
                    .append("\" must be at least ")
                    .append(minValue)
                    .append(" but was ")
                    .append(value)
                    .toString();
        }

        public NumberValueTooLowException build() {
            return new NumberValueTooLowException(this);
        }
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.NUMBER_VALUE_TOO_LOW;
    }

    @Override
    public Map<String, String> parameters() {
        return Map.of("min", min, "value", value);
    }
}
