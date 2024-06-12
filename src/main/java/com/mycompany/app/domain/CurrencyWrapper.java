package com.mycompany.app.domain;

import java.util.Currency;
import java.util.Optional;

/**
 * CurrencyWrapper.
 * Using https://www.wikiwand.com/en/ISO_4217 with some custom currencies
 */
public enum CurrencyWrapper {
    // private CustomCurrency customCurrency;

    // Global currencies
    USD("United States Dollar", "USD"),
    EUR("Euro", "EUR"),
    GBP("British Pound Sterling", "GBP"),
    JPY("Japanese Yen", "JPY"),
    CNY("Chinese Yuan", "CNY"),
    INR("Indian Rupee", "INR"),
    BRL("Brazilian Real", "BRL"),
    RUB("Russian Ruble", "RUB"),
    KRW("South Korean Won", "KRW"),
    CAD("Canadian Dollar", "CAD"),
    AUD("Australian Dollar", "AUD"),
    CHF("Swiss Franc", "CHF"),
    SEK("Swedish Krona", "SEK"),
    NZD("New Zealand Dollar", "NZD"),
    MXN("Mexican Peso", "MXN"),
    SGD("Singapore Dollar", "SGD"),
    HKD("Hong Kong Dollar", "HKD"),
    NOK("Norwegian Krone", "NOK"),
    ZAR("South African Rand", "ZAR"),
    TRY("Turkish Lira", "TRY"),
    // Crypto
    BTC("Bitcoin", "BTC"),
    ETH("Ethereum", "ETH");

    private final String description;
    /**
     * Currency instance if the currency code is valid, otherwise null
     */
    private final Optional<Currency> currency;
    private final String code;

    // Process the currency code and save the description,
    // the code is optional since it might not be in the Java currency lis
    CurrencyWrapper(
            String description, String code) {
        this.description = description;
        this.currency = Optional.ofNullable(HandleCode(code));
        this.code = code;
    }

    // Handle the currency code and returns the currency instance or returns null if
    // the code is not valid
    // useful in case the currency code is not in the Java currency list
    Currency HandleCode(String code) {
        try {
            return Currency.getInstance(code);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * getByCode
     * @param code The currency code
     * @return An instance of CurrencyWrapper if the code is valid, otherwise null
     */
    public static CurrencyWrapper getByCode(String code) {
        for (CurrencyWrapper currency : values()) {
            if (currency.code.equals(code)) {
                return currency;
            }
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public Optional<Currency> getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

}