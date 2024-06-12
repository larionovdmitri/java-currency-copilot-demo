package com.mycompany.app;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.User;
import com.mycompany.app.providers.CurrencyConverter;
import com.mycompany.app.providers.ExchangeRateRequester;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ExchangeRateRequester rateRequester = new ExchangeRateRequester();
        CurrencyConverter currencyConverter = new CurrencyConverter(rateRequester);
        // TODO Move to tests
        // Example user creation
        User user = new User.Builder("John", "Doe")
                .age(30)
                .phone("1234567890")
                .address("123 Main St")
                .nativeCurrency("USD")
                .build();

        // Convert 100 units of user's native currency to Bitcoin, native currency is
        // bitcoin convert to USD
        CurrencyWrapper userNativeCurrency = user.getNativeCurrency();
        CurrencyWrapper targetCurrency = CurrencyWrapper.BTC;

        if (userNativeCurrency.equals(targetCurrency)) {
            System.out.println("User's native currency is Bitcoin. Please convert to USD first.");
            return;
        }
        BigDecimal amount = BigDecimal.valueOf(99.99);
        double bitcoins = currencyConverter.convert(amount, userNativeCurrency, targetCurrency);

        System.out.println("100 units of " + userNativeCurrency + " is equivalent to " + bitcoins + " Bitcoins.");
    }
}
