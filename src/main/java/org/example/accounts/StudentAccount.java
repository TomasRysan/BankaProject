package org.example.accounts;

import org.example.customer.Customer;
import org.example.services.AccountLogService;

public class StudentAccount extends BaseBankAccount {

    private String school;
    private static final AccountLogService logService = new AccountLogService();

    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, String school) {
        super(uuid, bankAccountNumber, customer, 0.0);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Vklad musí být kladný.");
        }

        double oldBalance = this.balance;

        this.balance += amount;
        logService.logTransaction(this.getBankAccountNumber(), "DEPOSIT", amount,oldBalance, this.balance);
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Výběr musí být kladný.");
        }
        if (this.balance < amount) {
            throw new Exception("Nedostatečný zůstatek.");
        }

        double oldBalance = this.balance;
        this.balance -= amount;
        logService.logTransaction(this.getBankAccountNumber(), "WITHDRAWAL", amount,oldBalance, this.balance);
    }
}
