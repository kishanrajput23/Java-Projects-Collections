package com.abe762.loop_backend.shared.error.domain;

import java.util.Map;

public final class NumberValueTooHighException extends AssertionException {

    private final String max;
    private final String value;

    private NumberValueTooHighException(NumberValueTooHighExceptionBuilder builder) {
        super(builder.field, builder.message());
        max = builder.maxValue;
        value = builder.value;
    }

    public static NumberValueTooHighExceptionBuilder builder() {
        return new NumberValueTooHighExceptionBuilder();
    }

    public static class NumberValueTooHighExceptionBuilder {

        private String field;
        private String maxValue;
        private String value;

        public NumberValueTooHighExceptionBuilder field(String field) {
            this.field = field;

            return this;
        }

        public NumberValueTooHighExceptionBuilder maxValue(String maxValue) {
            this.maxValue = maxValue;

            return this;
        }

        public NumberValueTooHighExceptionBuilder value(String value) {
            this.value = value;

            return this;
        }

        public String message() {
            return new StringBuilder()
                    .append("Value of field \"")
                    .append(field)
                    .append("\" must be at most ")
                    .append(maxValue)
                    .append(" but was ")
                    .append(value)
                    .toString();
        }

        public NumberValueTooHighException build() {
            return new NumberValueTooHighException(this);
        }
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.NUMBER_VALUE_TOO_HIGH;
    }

    @Override
    public Map<String, String> parameters() {
        return Map.of("max", max, "value", value);
    }
}
