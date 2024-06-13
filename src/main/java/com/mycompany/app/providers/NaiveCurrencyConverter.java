package com.mycompany.app.providers;

public class NaiveCurrencyConverter {

    // Constants for default exchange rates
    private static final double DEFAULT_USD_TO_EUR = 0.85;
    private static final double DEFAULT_EUR_TO_GBP = 0.89;
    private static final double DEFAULT_GBP_TO_USD = 1.39;

    // Instance variables for exchange rates
    private double usdToEur;
    private double eurToGbp;
    private double gbpToUsd;

    // Constructor with optional exchange rates
    public NaiveCurrencyConverter() {
        this(DEFAULT_USD_TO_EUR, DEFAULT_EUR_TO_GBP, DEFAULT_GBP_TO_USD);
    }

    public NaiveCurrencyConverter(double usdToEur, double eurToGbp, double gbpToUsd) {
        this.usdToEur = usdToEur;
        this.eurToGbp = eurToGbp;
        this.gbpToUsd = gbpToUsd;
    }

    // Method to convert USD to EUR
    public double convertUsdToEur(double amount) {
        return amount * usdToEur;
    }

    // Method to convert EUR to GBP
    public double convertEurToGbp(double amount) {
        return amount * eurToGbp;
    }

    // Method to convert GBP to USD
    public double convertGbpToUsd(double amount) {
        return amount * gbpToUsd;
    }

    // Main method to demonstrate conversions
    public static void main(String[] args) {
        NaiveCurrencyConverter converter = new NaiveCurrencyConverter();

        double usdAmount = 100.0;
        double eurAmount = converter.convertUsdToEur(usdAmount);
        System.out.println(usdAmount + " USD is " + eurAmount + " EUR");

        double eurToGbpAmount = 100.0;
        double gbpAmount = converter.convertEurToGbp(eurToGbpAmount);
        System.out.println(eurToGbpAmount + " EUR is " + gbpAmount + " GBP");

        double gbpToUsdAmount = 100.0;
        double usdConvertedAmount = converter.convertGbpToUsd(gbpToUsdAmount);
        System.out.println(gbpToUsdAmount + " GBP is " + usdConvertedAmount + " USD");

        // Using custom exchange rates
        NaiveCurrencyConverter customConverter = new NaiveCurrencyConverter(0.83, 0.88, 1.37);

        double customUsdAmount = 100.0;
        double customEurAmount = customConverter.convertUsdToEur(customUsdAmount);
        System.out.println(customUsdAmount + " USD is " + customEurAmount + " EUR with custom rate");

        double customEurToGbpAmount = 100.0;
        double customGbpAmount = customConverter.convertEurToGbp(customEurToGbpAmount);
        System.out.println(customEurToGbpAmount + " EUR is " + customGbpAmount + " GBP with custom rate");

        double customGbpToUsdAmount = 100.0;
        double customUsdConvertedAmount = customConverter.convertGbpToUsd(customGbpToUsdAmount);
        System.out.println(customGbpToUsdAmount + " GBP is " + customUsdConvertedAmount + " USD with custom rate");
    }
}