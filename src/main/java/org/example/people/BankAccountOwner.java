package org.example.people;

import org.example.customer.Customer;

public class BankAccountOwner {
    private Customer customer;

    public BankAccountOwner() {
    }

    public BankAccountOwner(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}


