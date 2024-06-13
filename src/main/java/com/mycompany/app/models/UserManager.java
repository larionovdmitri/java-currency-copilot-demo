package com.mycompany.app.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.providers.CurrencyConverter;
import com.mycompany.app.providers.ExchangeRateRequester;

public class UserManager {
    private List<User> users;
    private CurrencyConverter currencyConverter;

    public UserManager() {
        ExchangeRateRequester rateRequester = new ExchangeRateRequester();
        this.currencyConverter = new CurrencyConverter(rateRequester);
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public boolean removeUser(User user) {
        return this.users.remove(user);
    }

    public boolean acceptPayment(String userId, Payment payment) {
        Optional<User> user = users.stream().filter(u -> u.getId().equals(userId)).findFirst();
        if (user.isPresent()) {
            user.get().addToBalance(payment.getCurrencyWrapper(), payment.getAmount());
            return true;
        }
        return false;
    }

    /** Function that returns null or user base on a user id string */
    public User getUserById(String userId) {
        Optional<User> user = users.stream().filter(u -> u.getId().equals(userId)).findFirst();
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    // Get new worth of user in a specific currency
    public BigDecimal getNetWorth(String userId, CurrencyWrapper currency) {
        // Save sum of networth in the currency
        BigDecimal netWorth = null;
        User user = getUserById(userId);
        if (user != null) {
            Map<CurrencyWrapper, Double> balances = user.getBalances();
            netWorth = calculateNetWorth(currency, balances);
        }
        return netWorth;
    }

    public BigDecimal calculateNetWorth(CurrencyWrapper currency, Map<CurrencyWrapper, Double> balances) {
        double netWorth = 0.0;
        for (Map.Entry<CurrencyWrapper, Double> entry : balances.entrySet()) {
            CurrencyWrapper currencyWrapper = entry.getKey();
            double amount = entry.getValue();
            CurrencyPair pairToConvert = new CurrencyPair(currencyWrapper, currency);
            BigDecimal amountBigDec = BigDecimal.valueOf(amount);
            BigDecimal convertedAmount = currencyConverter.convert(
                    amountBigDec, pairToConvert);
            netWorth += convertedAmount.doubleValue();
        }
        return BigDecimal.valueOf(netWorth);
    }
}