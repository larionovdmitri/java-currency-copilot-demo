package com.mycompany.app;

import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.User;
import com.mycompany.app.models.UserManager;
import com.mycompany.app.providers.CurrencyConverter;
import com.mycompany.app.providers.ExchangeRateRequester;

public class TestUtils {

    public static User createMockUser() {
        return new User.Builder("John", "Doe")
                .age(30)
                .phone("1234567890")
                .address("123 Main St")
                .nativeCurrency(CurrencyWrapper.USD)
                .build();
    }

    public static User createMockUserWithThreeCurrencyBalances() {
        User user = new User.Builder("John", "Doe")
                .age(30)
                .phone("1234567890")
                .address("123 Main St")
                .nativeCurrency(CurrencyWrapper.USD)
                .build();
        // Log user to console
        System.out.println(user);
        // Add 1 BTC to the user's balance
        user.addToBalance(CurrencyWrapper.BTC, 2);
        // Add 1000 USD to the user's balance
        user.addToBalance(CurrencyWrapper.USD, 1000);
        user.addToBalance(CurrencyWrapper.ETH, 5);
        // Log user to console
        System.out.println(user);
        return user;
    }

    public static CurrencyConverter createMockCurrencyConverter() {
        return new CurrencyConverter(new ExchangeRateRequester());
    }

    public static UserManager createMockUserManager(User mockUser) {
        UserManager manager = new UserManager();
        manager.addUser(mockUser);
        return manager;
    }
}
