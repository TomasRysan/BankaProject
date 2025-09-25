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

    public void addBalance(Double balance){
        this.balance += balance;
    }

    public void subtractBalance(Double balance) throws IllegalArgumentException {
        double subractBalance = this.balance - balance;

        if (subractBalance < 0){
            throw new IllegalArgumentException();
        }
        else if (subractBalance > 0){
            this.balance = subractBalance;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Vlozeno " + amount + " Kc. Novy zustatek: " + balance + " Kc");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Vybrano " + amount + " Kc. Novy zustatek: " + balance + " Kc");
        } else {
            System.out.println("Nedostatek prostredku nebo neplatna castka!");
        }
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
