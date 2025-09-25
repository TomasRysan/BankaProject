package org.example.services;

import org.example.accounts.BaseBankAccount;

public class BankAccountService {

    InputValidationService inputValidationService = new InputValidationService();

    public void addBalance(BaseBankAccount account, Double amount) {
        double accountBalance = account.getBalance();

        inputValidationService.DepositValidationService(account, amount);

        accountBalance += amount;

        account.setBalance(accountBalance);

    }

    public void subtractBalance(BaseBankAccount account, Double amount) throws IllegalArgumentException {
        double newBalance = account.getBalance() - amount;

        if (newBalance < 0) {
            throw new IllegalArgumentException("Nedostatek prostredku");
        } else {
            account.setBalance(newBalance); // i 0 je platné
        }
    }

    public void deposit(BaseBankAccount account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Vlozeno " + amount + " Kc. Novy zustatek: " + account.getBalance() + " Kc");
        } else {
            System.out.println("Neplatna castka pro vklad.");
        }
    }

    public void withdraw(BaseBankAccount account, double amount) {
        if (amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Vybrano " + amount + " Kc. Novy zustatek: " + account.getBalance() + " Kc");
        } else {
            System.out.println("Nedostatek prostredku nebo neplatná castka!");
        }
    }
}
