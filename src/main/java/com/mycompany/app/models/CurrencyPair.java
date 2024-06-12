package com.mycompany.app.models;

import java.util.Objects;

import com.mycompany.app.domain.CurrencyWrapper;

public class CurrencyPair {
    private final CurrencyWrapper base;
    private final CurrencyWrapper quote;

    public CurrencyPair(CurrencyWrapper base, CurrencyWrapper quote) {
        this.base = base;
        this.quote = quote;
    }
    /** Constructor that takes string codes creates currency wrappers */
    public CurrencyPair(String base, String quote) {
        this.base = CurrencyWrapper.getByCode(base);
        this.quote = CurrencyWrapper.getByCode(quote);
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