package org.example.accounts;

import org.example.customer.Customer;

public class BaseBankAccount {

    private String uuid;

    private String bankAccountNumber;

    private Customer customer;

    private double balance;

    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



}
