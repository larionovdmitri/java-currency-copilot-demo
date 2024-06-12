package com.mycompany.app.models;

import java.util.Objects;

import com.mycompany.app.domain.CurrencyWrapper;

public class CurrencyPair {

    public static final CurrencyWrapper DEFAULT_BASE = CurrencyWrapper.USD;
    public static final CurrencyWrapper DEFAULT_QUOTE = CurrencyWrapper.BTC;

    private final CurrencyWrapper base;
    private final CurrencyWrapper quote;

    public CurrencyPair(CurrencyWrapper base, CurrencyWrapper quote) {
        boolean isValid = ValidateThatCurrenciesAreDifferent(base, quote);
        if (isValid == true) {
            this.base = base;
            this.quote = quote;
        } else {
            this.base = DEFAULT_BASE;
            this.quote = DEFAULT_QUOTE;
        }
    }

    private boolean ValidateThatCurrenciesAreDifferent(CurrencyWrapper base, CurrencyWrapper quote) {
        if (base == quote) {
            return false;
        }
        return true;
    }

    /** Constructor that takes string codes creates currency wrappers */
    public CurrencyPair(String base, String quote) {
        this.base = CurrencyWrapper.getByCode(base);
        this.quote = CurrencyWrapper.getByCode(quote);
    }

    public CurrencyWrapper GetBase() {
        return base;
    }

    public CurrencyWrapper GetQuote() {
        return quote;
    }

    // Implement equals() and hashCode() to ensure CurrencyPair works correctly as a
    // key in a HashMap
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CurrencyPair that = (CurrencyPair) o;
        return base == that.base && quote == that.quote;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, quote);
    }
}