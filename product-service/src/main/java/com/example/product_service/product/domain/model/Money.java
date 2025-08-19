package com.example.product_service.product.domain.model;

import lombok.Data;

@Data
public class Money {
    private final double value;
    private final String currency;

    public Money(double value, String currency) {
        if (value < 0) {
            throw new IllegalArgumentException("Money value cannot be negative");
        }
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency cannot be null or empty");
        }
        this.value = value;
        this.currency = currency;


    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match to add money");
        }
        return new Money(this.value + other.value, this.currency);
    }

    public Money subtract(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match to subtract money");
        }
        return new Money(this.value - other.value, this.currency);
    }

    public Money multiply(double multiplier) {
        return new Money(this.value * multiplier, this.currency);
    }

    public boolean isGreaterThan(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match for comparison");
        }
        return this.value > other.value;
    }

    public boolean isLessThan(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match for comparison");
        }
        return this.value < other.value;
    }

    public boolean isEqualTo(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match for comparison");
        }
        return Double.compare(this.value, other.value) == 0;

    }

    public static Money of(double value, String currency) {
        return new Money(value, currency);
    }

    public boolean isZero() {
        return this.value == 0.0;
    }


}
