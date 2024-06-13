package com.mycompany.app.providers;

import java.math.BigDecimal;
import java.util.*;

import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.CurrencyPair;

public class ApiExchangeRateProvider implements ProvideExchangeRate {

    @Override
    public Map<CurrencyPair, BigDecimal> fetchExchangeRates() {
        // For now just simulate an api call and return a mock exchange rate
        // Use API services like https://exchangeratesapi.io/ to get real exchange rates
        // or https://www.xe.com/currencyconverter/convert/?Amount=1&From=USD&To=BTC
        Map<CurrencyPair, BigDecimal> rates = new HashMap<CurrencyPair, BigDecimal>();
        // Rates are in terms of 1 unit of base currency to quote currency
        rates.put(new CurrencyPair(CurrencyWrapper.USD, CurrencyWrapper.BTC), new BigDecimal("0.0000143556"));
        rates.put(new CurrencyPair(CurrencyWrapper.USD, CurrencyWrapper.ETH), new BigDecimal("0.000274894"));
        //BTC
        rates.put(new CurrencyPair(CurrencyWrapper.BTC, CurrencyWrapper.USD), new BigDecimal("69600.00"));
        rates.put(new CurrencyPair(CurrencyWrapper.BTC, CurrencyWrapper.ETH), new BigDecimal("19.00"));

        //From eth to usd
        rates.put(new CurrencyPair(CurrencyWrapper.ETH, CurrencyWrapper.USD), new BigDecimal("3635.00"));
        rates.put(new CurrencyPair(CurrencyWrapper.ETH, CurrencyWrapper.BTC), new BigDecimal("0.00005263"));
        return rates;

    }

    @Override
    public BigDecimal getRate(CurrencyWrapper base, CurrencyWrapper quote) {
        Map<CurrencyPair, BigDecimal> rates = fetchExchangeRates();
        return rates.get(new CurrencyPair(base, quote));
    }
}