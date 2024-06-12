package com.mycompany.app.model;

import static org.junit.Assert.*;
import org.junit.Test;

import com.mycompany.app.models.CurrencyPair;

public class CurrencyPairTest {

    @Test
    public void testEquality() {
        CurrencyPair pair1 = new CurrencyPair("USD", "EUR");
        CurrencyPair pair2 = new CurrencyPair("USD", "EUR");
        assertTrue(pair1.equals(pair2));
    }

    @Test
    public void testNonEquality() {
        CurrencyPair pair1 = new CurrencyPair("USD", "EUR");
        CurrencyPair pair2 = new CurrencyPair("GBP", "EUR");
        assertFalse(pair1.equals(pair2));
    }

    @Test
    public void testNullEquality() {
        CurrencyPair pair = new CurrencyPair("USD", "EUR");
        assertFalse(pair.equals(null));
    }

    @Test
    public void testDifferentObjectType() {
        CurrencyPair pair = new CurrencyPair("USD", "EUR");
        Object other = new Object();
        assertFalse(pair.equals(other));
    }

    @Test
    public void safelyHandlesIncorrectParameters() {
        CurrencyPair pair = new CurrencyPair("USD", "USD");
        assertEquals(CurrencyPair.DEFAULT_BASE, pair.GetBase().getCode());
        assertEquals(CurrencyPair.DEFAULT_QUOTE, pair.GetQuote().getCode());
    }
}
