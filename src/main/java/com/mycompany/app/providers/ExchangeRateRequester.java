package com.mycompany.app.providers;

import java.math.BigDecimal;

import com.mycompany.app.domain.CurrencyWrapper;

public class ExchangeRateRequester {
    // Instatiates and uses ApiExchangeRateProvider
    public BigDecimal getRate(CurrencyWrapper base, CurrencyWrapper quote) {
        ProvideExchangeRate provider = new ApiExchangeRateProvider();
        return provider.getRate(base, quote);
    }
}
