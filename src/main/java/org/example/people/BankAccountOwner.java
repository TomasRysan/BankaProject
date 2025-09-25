package org.example.people;

import org.example.customer.Customer;

public class BankAccountOwner {
    private final Customer customer;

    public BankAccountOwner(Customer customer) {
        this.customer = customer;
    }

    public String getOwnerName() {
        return customer.getFirstName() + " " + customer.getLastName();
    }

    public Customer setCustomer() {
        return customer;
    }
}

