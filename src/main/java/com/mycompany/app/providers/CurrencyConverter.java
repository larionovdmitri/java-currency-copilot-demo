package com.mycompany.app.providers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.CurrencyPair;

public class CurrencyConverter {
    private ExchangeRateRequester rateRequester;

    public CurrencyConverter(ExchangeRateRequester rateRequester) {
        this.rateRequester = rateRequester;
    }

    public BigDecimal convert(BigDecimal amount, CurrencyPair currencyPair) {

        CurrencyWrapper fromCurrency = currencyPair.GetBase();
        CurrencyWrapper toCurrency = currencyPair.GetQuote();

        BigDecimal rate = rateRequester.getRate(fromCurrency, toCurrency);
        if (rate == null) {
            String pair = fromCurrency + "_" + toCurrency;
            throw new IllegalArgumentException("Exchange rate for " + pair + " not available.");
        }
        return rate.multiply(amount);
    }
}
