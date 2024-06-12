package com.mycompany.app.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
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
        assertEquals("Default native currency should be USD", defaultCurrency, user.getNativeCurrency());
    }

    @Test
    public void userHasZeroBalanceOnCreation() {

        Double balances = user.getBalance(defaultCurrency);

        // Assert that the balance is zero
        assertEquals("New User Balance should be zero", 0.0, balances, 0.0);
    }
}