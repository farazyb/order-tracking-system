package com.example.order_service.order.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderNumberTest {

    @Test
    @DisplayName("Constructor should create OrderNumber for valid string")
    void constructor_withValidString_shouldCreateOrderNumber() {
        // given
        String validOrderNumber = "ORD-12345";

        // when
        OrderNumber orderNumber = new OrderNumber(validOrderNumber);

        // then
        assertThat(orderNumber).isNotNull();
        assertThat(orderNumber.orderNumber()).isEqualTo(validOrderNumber);
    }

    @Test
    @DisplayName("of() should create OrderNumber for valid string")
    void of_withValidString_shouldCreateOrderNumber() {
        // given
        String validOrderNumber = "ORD-12345";

        // when
        OrderNumber orderNumber = OrderNumber.of(validOrderNumber);

        // then
        assertThat(orderNumber).isNotNull();
        assertThat(orderNumber.orderNumber()).isEqualTo(validOrderNumber);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    @DisplayName("Constructor should throw exception for null or blank order number")
    void constructor_withNullOrBlankString_shouldThrowException(String invalidOrderNumber) {
        // when & then
        assertThatThrownBy(() -> new OrderNumber(invalidOrderNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Order number cannot be null or empty");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    @DisplayName("of() should throw exception for null or blank order number")
    void of_withNullOrBlankString_shouldThrowException(String invalidOrderNumber) {
        // when & then
        assertThatThrownBy(() -> OrderNumber.of(invalidOrderNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Order number cannot be null or empty");
    }

    @Test
    @DisplayName("Two OrderNumbers with same value should be equal and have same hashCode")
    void shouldBeEqualAndHaveSameHashCodeForSameValue() {
        // given
        String number = "ORD-54321";
        OrderNumber orderNumber1 = new OrderNumber(number);
        OrderNumber orderNumber2 = OrderNumber.of(number);

        // when & then
        assertThat(orderNumber1).isEqualTo(orderNumber2);
        assertThat(orderNumber1.hashCode()).isEqualTo(orderNumber2.hashCode());
    }

    @Test
    @DisplayName("Two OrderNumbers with different values should not be equal")
    void shouldNotBeEqualForDifferentValues() {
        // given
        OrderNumber orderNumber1 = new OrderNumber("ORD-111");
        OrderNumber orderNumber2 = new OrderNumber("ORD-222");

        // when & then
        assertThat(orderNumber1).isNotEqualTo(orderNumber2);
    }

    @Test
    @DisplayName("toString() should return correct string representation")
    void toString_shouldReturnCorrectRepresentation() {
        // given
        String number = "ORD-ABC";
        OrderNumber orderNumber = new OrderNumber(number);

        // when
        String stringRepresentation = orderNumber.toString();

        // then
        assertThat(stringRepresentation).isEqualTo("OrderNumber[orderNumber=ORD-ABC]");
    }
}