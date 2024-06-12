package com.mycompany.app.providers;

import java.util.*;

import com.mycompany.app.domain.CurrencyWrapper;
import com.mycompany.app.models.Payment;
import com.mycompany.app.models.User;

public class PaymentProcessor {
    private List<Payment> payments;

    // Processing payments involves adding the payment to a list which is processed
    // in an event loop later
    public void processPayment(double amount, User user) {
        System.out.println("Processing payment of " + amount + " for user " + user);
        Payment payment = new Payment(amount, CurrencyWrapper.USD);
        addPayment(payment);
    }

    private void addPayment(Payment payment) {
        if (payments == null) {
            payments = new ArrayList<>();
        }
        payments.add(payment);
    }
}
