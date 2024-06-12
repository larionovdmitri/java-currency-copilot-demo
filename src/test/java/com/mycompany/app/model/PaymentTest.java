package com.mycompany.app.model;

import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.Payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class PaymentTest {
    private Payment payment;
    private CurrencyWrapper paymentCurrency = CurrencyWrapper.USD;
    // Static amount for testing purposes
    public static double amount = 100.0;

    @BeforeEach
    public void setUp() {
        payment = new Payment(amount, paymentCurrency);
    }

    @Test
    public void testGetCurrencyStr() {
        // Arrange
        String code = paymentCurrency.getCode();
        String paymentCurrencyCode = payment.getCurrencyStr();
        // Assert
        assertEquals(code, paymentCurrencyCode);
    }
}