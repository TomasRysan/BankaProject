package org.example.accounts;

import org.example.people.BankAccountOwner;
import org.example.customer.Customer;

public class BankAccountWithPaymentCards extends BaseBankAccount {

    public BankAccountWithPaymentCards(String uuid, String bankAccountNumber, Customer customer, double balance) {
        super(uuid, bankAccountNumber, customer, balance);
    }
}
