package com.mycompany.app.domain;

import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyEnumTest {

    @Test
    void testCurrencyHasCodeAndDescription() {
        CurrencyWrapper currency = CurrencyWrapper.USD;
        assertEquals("USD", currency.getCode());
        assertEquals("United States Dollar", currency.getDescription());
    }

    @Test
    void supportsBtc() {
        CurrencyWrapper currency = CurrencyWrapper.BTC;
        assertEquals("BTC", currency.getCode());
        assertEquals("Bitcoin", currency.getDescription());
    }

    @Test
    public void canGetByCode() {
        CurrencyWrapper currency = CurrencyWrapper.getByCode("USD");
        assertEquals("USD", currency.getCode());
        assertEquals("United States Dollar", currency.getDescription());
    }

}