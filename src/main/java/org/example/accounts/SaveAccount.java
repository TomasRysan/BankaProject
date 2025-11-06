package org.example.accounts;

import jakarta.inject.Inject;
import org.example.customer.Customer;

import java.time.LocalDateTime;

public class SaveAccount extends BaseBankAccount {

    private float interestRate = 0.04f;
    private LocalDateTime NextInterestRun;

    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, float balance, float annualInterestRate) {
        super(uuid, bankAccountNumber, customer, balance);
        this.interestRate = annualInterestRate;
        this.NextInterestRun = LocalDateTime.now().plusMinutes(5);
    }

    public float getInterestRate() {
        return interestRate;
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    public LocalDateTime getNextInterestRun() {
        return NextInterestRun;
    }
}
