package org.example.accounts;

import org.example.card.PaymentCard;
import org.example.customer.Customer;

import java.util.ArrayList;

public class BankAccountWithPaymentCards extends BaseBankAccount {

    private ArrayList<PaymentCard> paymentCards;

    public BankAccountWithPaymentCards(String uuid, String bankAccountNumber, Customer customer, double balance) {
        super(uuid, bankAccountNumber, customer, balance);
        this.paymentCards = new ArrayList<>();
    }

    public ArrayList<PaymentCard> getPaymentCards() {
        return paymentCards;
    }

    public void addPaymentCard(PaymentCard paymentCard) {
        this.paymentCards.add(paymentCard);
    }
}
