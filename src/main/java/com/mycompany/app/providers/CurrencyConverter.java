package com.mycompany.app.providers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.domain.CurrencyWrapper;

public class CurrencyConverter {
    private ExchangeRateRequester rateRequester;

    public CurrencyConverter(ExchangeRateRequester rateRequester) {
        this.rateRequester = rateRequester;
        // updateRates();
    }

    // private void updateRates() {
    // exchangeRates = rateRequester.getRate();
    // }

    public double convert(BigDecimal amount, CurrencyWrapper fromCurrency, CurrencyWrapper toCurrency) {
        BigDecimal rate = rateRequester.getRate(fromCurrency, toCurrency);
        if (rate == null) {
            String pair = fromCurrency + "_" + toCurrency;
            throw new IllegalArgumentException("Exchange rate for " + pair + " not available.");
        }
        // Convert double to BigDecimal
        return rate.multiply(amount).doubleValue();
    }

    // TODO Move to test class
    public static void main(String[] args) {
        // CurrencyConverter converter = new CurrencyConverter(new
        // ExchangeRateRequester());

        // try {
        // double usdToEur = converter.convert(100, "USD", "EUR");
        // System.out.println("100 USD is " + usdToEur + " EUR");
        // double eurToGbp = converter.convert(50, "EUR", "GBP");
        // System.out.println("50 EUR is " + eurToGbp + " GBP");
        // double gbpToUsd = converter.convert(30, "GBP", "USD");
        // System.out.println("30 GBP is " + gbpToUsd + " USD");
        // } catch (IllegalArgumentException e) {
        // System.out.println(e.getMessage());
        // }
    }
}
