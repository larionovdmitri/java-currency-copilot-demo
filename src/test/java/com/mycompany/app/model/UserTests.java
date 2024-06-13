package com.mycompany.app.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.User;

public class UserTests {
    private User user;
    private final CurrencyWrapper defaultCurrency = CurrencyWrapper.USD;

    @BeforeEach
    public void setUp() {
        user = new User.Builder("John", "Doe")
                .nativeCurrency(defaultCurrency).build();
    }

    @Test
    public void userHasDefaultNativeCurrency() {
        assertEquals(
                defaultCurrency, user.getNativeCurrency(),
                "Default native currency should be USD");
    }

    @Test
    public void userHasZeroBalanceOnCreation() {

        Double balances = user.getBalanceByCurrency(defaultCurrency);

        // Assert that the balance is zero
        assertEquals(
                0.0, balances, 0.0,
                "New User Balance should be zero");
    }
}