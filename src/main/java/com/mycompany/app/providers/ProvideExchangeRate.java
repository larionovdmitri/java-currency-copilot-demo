package com.mycompany.app.providers;

import java.math.BigDecimal;
import java.util.Map;

import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.CurrencyPair;

public interface ProvideExchangeRate {
    // Method to fetch exchange rates from an external API
    Map<CurrencyPair, BigDecimal> fetchExchangeRates();

    // Method to get the exchange rate between two currencies
    BigDecimal getRate(CurrencyWrapper base, CurrencyWrapper quote);
}