package com.example.product_service.product.domain.model;

import lombok.Data;

import java.math.BigDecimal;


public record Money(BigDecimal amount, String currency) {


    public Money(BigDecimal amount, String currency) {
        if (amount == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency cannot be null or empty");
        }
        this.amount = amount;
        this.currency = currency;


    }

    public static Money of(BigDecimal value, String currency) {
        return new Money(value, currency);
    }


}
