package com.abe762.loop_backend.shared.error.domain;

import java.util.Map;

public class TooManyElementsException extends AssertionException {

    private final String maxSize;
    private final String currentSize;

    public TooManyElementsException(TooManyElementsExceptionBuilder builder) {
        super(builder.field, builder.message());
        maxSize = String.valueOf(builder.maxSize);
        currentSize = String.valueOf(builder.size);
    }

    public static TooManyElementsExceptionBuilder builder() {
        return new TooManyElementsExceptionBuilder();
    }

    public static class TooManyElementsExceptionBuilder {

        private String field;
        private int maxSize;
        private int size;

        public TooManyElementsExceptionBuilder field(String field) {
            this.field = field;

            return this;
        }

        public TooManyElementsExceptionBuilder maxSize(int maxSize) {
            this.maxSize = maxSize;

            return this;
        }

        public TooManyElementsExceptionBuilder size(int size) {
            this.size = size;

            return this;
        }

        private String message() {
            return new StringBuilder()
                    .append("Size of collection \"")
                    .append(field)
                    .append("\" must be at most ")
                    .append(maxSize)
                    .append(" but was ")
                    .append(size)
                    .toString();
        }

        public TooManyElementsException build() {
            return new TooManyElementsException(this);
        }
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.TOO_MANY_ELEMENTS;
    }

    @Override
    public Map<String, String> parameters() {
        return Map.of("maxSize", maxSize, "currentSize", currentSize);
    }
}