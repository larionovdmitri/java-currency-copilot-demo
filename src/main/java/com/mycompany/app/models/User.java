package com.mycompany.app.models;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.app.domain.CurrencyWrapper;

public class User {
    // guid FOR USER
    private String id;
    // Required parameters
    private final String firstName;
    private final String lastName;
    // Optional parameters
    private int age;
    private String phone;
    private String address;
    private CurrencyWrapper nativeCurrency;
    // Map of user's balances in different currencies
    private Map<CurrencyWrapper, Double> balances;

    public User(Builder builder) {
        this.id = java.util.UUID.randomUUID().toString();
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
        this.balances = new HashMap<>();
        this.setNativeCurrency(builder.nativeCurrency);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public CurrencyWrapper getNativeCurrency() {
        return nativeCurrency;
    }

    // Add to balance
    public boolean addToBalance(CurrencyWrapper currency, double amount) {
        double balance = getBalanceByCurrency(currency);
        double newBalance = amount;
        // If balance for this currency doesn't exist, create it
        if (balance > 0) {
            newBalance = balance + amount;
        }
        balances.put(currency, newBalance);
        return true;
    }

    // Deduct from balance
    public boolean deductFromBalance(CurrencyWrapper currency, double amount) {
        double balance = getBalanceByCurrency(currency);
        if (balance < amount) {
            // throw new IllegalArgumentException("Insufficient funds");
            return false;
        }
        double newBalance = balance - amount;
        // If new balance is zero, then remove the currency from the balances map,
        // otherwise add it to the balances map
        if (newBalance == 0) {
            balances.remove(currency);
        } else {
            balances.put(currency, newBalance);
        }
        return true;
    }

    /**
     * Get balance by currency
     * 
     * @param currency Currency to get balance for
     * @return Balance for the currency, 0.0 if currency doesn't exist
     */
    public double getBalanceByCurrency(CurrencyWrapper currency) {
        return balances.containsKey(currency) ? balances.get(currency) : 0.0;
    }

    public Map<CurrencyWrapper, Double> getBalances() {
        return balances;
    }

    public void setNativeCurrency(CurrencyWrapper nativeCurrency) {
        this.nativeCurrency = nativeCurrency;
        // If native currency isn't in balances map add it
        if (!balances.containsKey(nativeCurrency)) {
            // Add user's native currency to the balances map
            balances.put(nativeCurrency, 0.0);
        }
    }

    public static class Builder {
        // Required parameters
        private final String firstName;
        private final String lastName;
        // Optional parameters
        private int age = 0;
        private String phone = "";
        private String address = "";
        // User's native currency
        private CurrencyWrapper nativeCurrency = CurrencyWrapper.USD;

        // String representation of user with line breaks after each property
        @Override
        public String toString() {
            return "First Name: " + firstName + "\n" +
                    "Last Name: " + lastName + "\n" +
                    "Age: " + age + "\n" +
                    "Phone: " + phone + "\n" +
                    "Address: " + address + "\n" +
                    "Native Currency: " + nativeCurrency;
        }

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder nativeCurrency(CurrencyWrapper nativeCurrency) {
            this.nativeCurrency = nativeCurrency;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}