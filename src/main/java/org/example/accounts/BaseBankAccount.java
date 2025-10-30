package org.example.accounts;

import org.example.customer.Customer;

import java.util.ArrayList;

public abstract class BaseBankAccount {

    private String uuid;
    private String bankAccountNumber;
    private Customer customer;
    protected double balance; // Změna z private na protected

    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
    }

    public String getUuid() {
        return uuid;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }
}
