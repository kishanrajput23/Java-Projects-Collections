package com.abe762.loop_backend.shared.error.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;


public final class Assert {

    private Assert() {}


    public static void notNull(String field, Object input) {
        if (input == null) {
            throw MissingMandatoryValueException.forNullValue(field);
        }
    }


    public static void notBlank(String field, String input) {
        Assert.field(field, input).notBlank();
    }

    public static void notEmpty(String field, Collection<?> collection) {
        field(field, collection).notEmpty();
    }


    public static void notEmpty(String field, Map<?, ?> map) {
        notNull(field, map);

        if (map.isEmpty()) {
            throw MissingMandatoryValueException.forEmptyValue(field);
        }
    }

    public static StringAsserter field(String field, String input) {
        return new StringAsserter(field, input);
    }


    public static IntegerAsserter field(String field, Integer input) {
        return new IntegerAsserter(field, input);
    }


    public static LongAsserter field(String field, Long input) {
        return new LongAsserter(field, input);
    }


    public static FloatAsserter field(String field, Float input) {
        return new FloatAsserter(field, input);
    }


    public static DoubleAsserter field(String field, Double input) {
        return new DoubleAsserter(field, input);
    }

       public static BigDecimalAsserter field(String field, BigDecimal input) {
        return new BigDecimalAsserter(field, input);
    }


    public static <T> CollectionAsserter<T> field(String field, Collection<T> input) {
        return new CollectionAsserter<>(field, input);
    }


    public static <T> ArrayAsserter<T> field(String field, T[] input) {
        return new ArrayAsserter<>(field, input);
    }


    public static InstantAsserter field(String field, Instant input) {
        return new InstantAsserter(field, input);
    }


    public static final class StringAsserter {

        private final String field;
        private final String value;

        private StringAsserter(String field, String value) {
            this.field = field;
            this.value = value;
        }

        public StringAsserter notNull() {
            Assert.notNull(field, value);

            return this;
        }


        public StringAsserter notBlank() {
            notNull();

            if (value.isBlank()) {
                throw MissingMandatoryValueException.forBlankValue(field);
            }

            return this;
        }


        public StringAsserter minLength(int length) {
            if (length <= 0 && value == null) {
                return this;
            }

            notNull();

            if (value.length() < length) {
                throw StringTooShortException.builder().field(field).value(value).minLength(length).build();
            }

            return this;
        }


        public StringAsserter maxLength(int length) {
            if (value == null) {
                return this;
            }

            if (value.length() > length) {
                throw StringTooLongException.builder().field(field).value(value).maxLength(length).build();
            }

            return this;
        }
    }


    public static final class IntegerAsserter {

        private final String field;
        private final Integer value;

        private IntegerAsserter(String field, Integer value) {
            this.field = field;
            this.value = value;
        }


        public IntegerAsserter positive() {
            return min(0);
        }


        public IntegerAsserter min(int minValue) {
            notNull(field, value);

            if (value.intValue() < minValue) {
                throw NumberValueTooLowException.builder().field(field).minValue(String.valueOf(minValue)).value(String.valueOf(value)).build();
            }

            return this;
        }


        public IntegerAsserter max(int maxValue) {
            notNull(field, value);

            if (value.intValue() > maxValue) {
                throw NumberValueTooHighException.builder().field(field).maxValue(String.valueOf(maxValue)).value(String.valueOf(value)).build();
            }

            return this;
        }
    }


    public static final class LongAsserter {

        private final String field;
        private final Long value;

        private LongAsserter(String field, Long value) {
            this.field = field;
            this.value = value;
        }


        public LongAsserter positive() {
            return min(0);
        }


        public LongAsserter min(long minValue) {
            notNull(field, value);

            if (value.longValue() < minValue) {
                throw NumberValueTooLowException.builder().field(field).minValue(String.valueOf(minValue)).value(String.valueOf(value)).build();
            }

            return this;
        }


        public LongAsserter max(long maxValue) {
            notNull(field, value);

            if (value.longValue() > maxValue) {
                throw NumberValueTooHighException.builder().field(field).maxValue(String.valueOf(maxValue)).value(String.valueOf(value)).build();
            }

            return this;
        }
    }


    public static final class FloatAsserter {

        private final String field;
        private final Float value;

        private FloatAsserter(String field, Float value) {
            this.field = field;
            this.value = value;
        }


        public FloatAsserter positive() {
            return min(0);
        }


        public FloatAsserter strictlyPositive() {
            return over(0);
        }


        public FloatAsserter min(float minValue) {
            notNull(field, value);

            if (value.floatValue() < minValue) {
                throw tooLow(minValue);
            }

            return this;
        }


        public FloatAsserter over(float floor) {
            notNull(field, value);

            if (value.floatValue() <= floor) {
                throw tooLow(floor);
            }

            return this;
        }

        private NumberValueTooLowException tooLow(float floor) {
            return NumberValueTooLowException.builder().field(field).minValue(String.valueOf(floor)).value(String.valueOf(value)).build();
        }


        public FloatAsserter max(float maxValue) {
            notNull(field, value);

            if (value.floatValue() > maxValue) {
                throw tooHigh(maxValue);
            }

            return this;
        }


        public FloatAsserter under(float ceil) {
            notNull(field, value);

            if (value.floatValue() >= ceil) {
                throw tooHigh(ceil);
            }

            return this;
        }

        private NumberValueTooHighException tooHigh(float ceil) {
            return NumberValueTooHighException.builder().field(field).maxValue(String.valueOf(ceil)).value(String.valueOf(value)).build();
        }
    }


    public static final class DoubleAsserter {

        private final String field;
        private final Double value;

        private DoubleAsserter(String field, Double value) {
            this.field = field;
            this.value = value;
        }


        public DoubleAsserter positive() {
            return min(0);
        }


        public DoubleAsserter strictlyPositive() {
            return over(0);
        }


        public DoubleAsserter min(double minValue) {
            notNull(field, value);

            if (value.doubleValue() < minValue) {
                throw tooLow(minValue);
            }

            return this;
        }


        public DoubleAsserter over(double floor) {
            notNull(field, value);

            if (value.doubleValue() <= floor) {
                throw tooLow(floor);
            }

            return this;
        }

        private NumberValueTooLowException tooLow(double floor) {
            return NumberValueTooLowException.builder().field(field).minValue(String.valueOf(floor)).value(String.valueOf(value)).build();
        }


        public DoubleAsserter max(double maxValue) {
            notNull(field, value);

            if (value.doubleValue() > maxValue) {
                throw tooHigh(maxValue);
            }

            return this;
        }


        public DoubleAsserter under(double ceil) {
            notNull(field, value);

            if (value.doubleValue() >= ceil) {
                throw tooHigh(ceil);
            }

            return this;
        }

        private NumberValueTooHighException tooHigh(double ceil) {
            return NumberValueTooHighException.builder().field(field).maxValue(String.valueOf(ceil)).value(String.valueOf(value)).build();
        }
    }


    public static final class BigDecimalAsserter {

        private final String field;
        private final BigDecimal value;

        private BigDecimalAsserter(String field, BigDecimal value) {
            this.field = field;
            this.value = value;
        }

        public BigDecimalAsserter positive() {
            return min(0);
        }


        public BigDecimalAsserter strictlyPositive() {
            return over(0);
        }


        public BigDecimalAsserter min(long minValue) {
            return min(new BigDecimal(minValue));
        }


        public BigDecimalAsserter min(BigDecimal minValue) {
            notNull();
            Assert.notNull("minValue", minValue);

            if (value.compareTo(minValue) < 0) {
                throw tooLow(minValue);
            }

            return this;
        }


        public BigDecimalAsserter over(long floor) {
            return over(new BigDecimal(floor));
        }


        public BigDecimalAsserter over(BigDecimal floor) {
            notNull();
            Assert.notNull("floor", floor);

            if (value.compareTo(floor) <= 0) {
                throw tooLow(floor);
            }

            return this;
        }

        private NumberValueTooLowException tooLow(BigDecimal floor) {
            return NumberValueTooLowException.builder().field(field).minValue(String.valueOf(floor)).value(value.toPlainString()).build();
        }


        public BigDecimalAsserter max(long maxValue) {
            return max(new BigDecimal(maxValue));
        }


        public BigDecimalAsserter max(BigDecimal maxValue) {
            notNull();
            Assert.notNull("maxValue", maxValue);

            if (value.compareTo(maxValue) > 0) {
                throw tooHigh(maxValue);
            }

            return this;
        }


        public BigDecimalAsserter under(long ceil) {
            return under(new BigDecimal(ceil));
        }


        public BigDecimalAsserter under(BigDecimal ceil) {
            notNull();
            Assert.notNull("ceil", ceil);

            if (value.compareTo(ceil) >= 0) {
                throw tooHigh(ceil);
            }

            return this;
        }

        private NumberValueTooHighException tooHigh(BigDecimal ceil) {
            return NumberValueTooHighException.builder().field(field).maxValue(String.valueOf(ceil)).value(value.toPlainString()).build();
        }


        public BigDecimalAsserter notNull() {
            Assert.notNull(field, value);

            return this;
        }
    }


    public static final class CollectionAsserter<T> {

        private final String field;
        private final Collection<T> value;

        private CollectionAsserter(String field, Collection<T> value) {
            this.field = field;
            this.value = value;
        }


        public CollectionAsserter<T> notNull() {
            Assert.notNull(field, value);

            return this;
        }


        public CollectionAsserter<T> notEmpty() {
            notNull();

            if (value.isEmpty()) {
                throw MissingMandatoryValueException.forEmptyValue(field);
            }

            return this;
        }


        public CollectionAsserter<T> maxSize(int maxSize) {
            if (maxSize <= 0 && value == null) {
                return this;
            }

            notNull();

            if (value.size() > maxSize) {
                throw TooManyElementsException.builder().field(field).maxSize(maxSize).size(value.size()).build();
            }

            return this;
        }


        public CollectionAsserter<T> noNullElement() {
            if (value == null) {
                return this;
            }

            if (value.stream().anyMatch(Objects::isNull)) {
                throw new NullElementInCollectionException(field);
            }

            return this;
        }
    }


    public static final class ArrayAsserter<T> {

        private final String field;
        private final T[] value;

        private ArrayAsserter(String field, T[] value) {
            this.field = field;
            this.value = value;
        }


        public ArrayAsserter<T> notNull() {
            Assert.notNull(field, value);

            return this;
        }


        public ArrayAsserter<T> notEmpty() {
            notNull();

            if (value.length == 0) {
                throw MissingMandatoryValueException.forEmptyValue(field);
            }

            return this;
        }


        public ArrayAsserter<T> maxSize(int maxSize) {
            if (maxSize <= 0 && value == null) {
                return this;
            }

            notNull();

            if (value.length > maxSize) {
                throw TooManyElementsException.builder().field(field).maxSize(maxSize).size(value.length).build();
            }

            return this;
        }


        public ArrayAsserter<T> noNullElement() {
            if (value == null) {
                return this;
            }

            if (Stream.of(value).anyMatch(Objects::isNull)) {
                throw new NullElementInCollectionException(field);
            }

            return this;
        }
    }


    public static final class InstantAsserter {

        private static final String OTHER_FIELD_NAME = "other";

        private final String field;
        private final Instant value;

        private InstantAsserter(String field, Instant value) {
            this.field = field;
            this.value = value;
        }


        public InstantAsserter inFuture() {
            return afterOrAt(Instant.now());
        }


        public InstantAsserter after(Instant other) {
            notNull();
            Assert.notNull(OTHER_FIELD_NAME, other);

            if (value.compareTo(other) <= 0) {
                throw NotAfterTimeException.strictlyNotAfter().value(value).field(field).other(other);
            }

            return this;
        }


        public InstantAsserter afterOrAt(Instant other) {
            notNull();
            Assert.notNull(OTHER_FIELD_NAME, other);

            if (value.compareTo(other) < 0) {
                throw NotAfterTimeException.notAfter().value(value).field(field).other(other);
            }

            return this;
        }


        public InstantAsserter inPast() {
            return beforeOrAt(Instant.now());
        }


        public InstantAsserter before(Instant other) {
            notNull();
            Assert.notNull(OTHER_FIELD_NAME, other);

            if (value.compareTo(other) >= 0) {
                throw NotBeforeTimeException.strictlyNotBefore().value(value).field(field).other(other);
            }

            return this;
        }


        public InstantAsserter beforeOrAt(Instant other) {
            notNull();
            Assert.notNull(OTHER_FIELD_NAME, other);

            if (value.compareTo(other) > 0) {
                throw NotBeforeTimeException.notBefore().value(value).field(field).other(other);
            }

            return this;
        }


        public InstantAsserter notNull() {
            Assert.notNull(field, value);

            return this;
        }
    }
}