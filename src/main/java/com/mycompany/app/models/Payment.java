package com.mycompany.app.models;

import com.mycompany.app.domain.CurrencyWrapper;

/**
 * IPayment interface should specify the enumeration value of the currency as
 * well as the amount
 * Currency is a required field and must be one of the values in the Currency
 * enum
 * 
 * @author Dmitri Larionov
 * @version 1.0
 * @since 06/07/2024
 */
interface IPayment {
    public double getAmount();

    public String getCurrencyStr();

    public CurrencyWrapper getCurrencyWrapper();
}

public class Payment implements IPayment {
    private double amount;
    private CurrencyWrapper currency;

    public Payment(double amount, CurrencyWrapper currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrencyStr() {
        return currency.toString();
    }

    public CurrencyWrapper getCurrencyWrapper() {
        return currency;
    }

}
