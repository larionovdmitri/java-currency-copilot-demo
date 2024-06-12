package com.mycompany.app.models;

import com.mycompany.app.domain.CurrencyWrapper;

public class User {
    // Required parameters
    private final String firstName;
    private final String lastName;
    // Optional parameters
    private int age;
    private String phone;
    private String address;
    private CurrencyWrapper nativeCurrency;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
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

        public Builder nativeCurrency(String string) {
            this.nativeCurrency = CurrencyWrapper.valueOf(string);
            return this;
        }
    }
}