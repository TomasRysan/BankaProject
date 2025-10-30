package org.example.services;

import jakarta.inject.Inject;
import org.example.accounts.BaseBankAccount;
import org.example.services.BankAccountService;
import org.example.card.PaymentCard;

public class BankAccountService {

    @Inject
    private InputValidationService inputValidationService;

    @Inject
    private AccountLogService logService;

    public void addBalance(BaseBankAccount account, Double amount) {
        double accountBalance = account.getBalance();

        accountBalance += amount;

        account.setBalance(accountBalance);
    }

    public void subtractBalance(BaseBankAccount account, Double amount) throws IllegalArgumentException {
        double newBalance = account.getBalance() - amount;

        if (newBalance < 0) {
            logService.logRejection(account.getBankAccountNumber(), "SUBTRACT_BALANCE", "Nedostatek prostredku");
            throw new IllegalArgumentException("Nedostatek prostredku");
        } else {
            account.setBalance(newBalance);
        }
    }

    public void deposit(BaseBankAccount account, double amount) {

        if (inputValidationService.DepositValidationService(account, amount) == false) {

            logService.logRejection(account.getBankAccountNumber(), "DEPOSIT", "Platba neprosla skrz platebni branu - AML");
            System.out.println("Vase platba neprosla skrz platebni branu - AML");

        } else {
            double oldBalance = account.getBalance();

            if (amount > 0) {
                account.setBalance(oldBalance + amount);

                logService.logTransaction(account.getBankAccountNumber(), "DEPOSIT", amount, oldBalance, account.getBalance());
                System.out.println("Vlozeno " + amount + " Kc. Novy zustatek: " + account.getBalance() + " Kc");
            } else {
                logService.logRejection(account.getBankAccountNumber(), "DEPOSIT", "Neplatna castka pro vklad");
                System.out.println("Neplatna castka pro vklad.");
            }
        }
    }


    public void withdraw (BaseBankAccount account, double amount) {
        double oldBalance = account.getBalance();

        if (amount > 0 && oldBalance >= amount) {
            account.setBalance(oldBalance - amount);

            logService.logTransaction(account.getBankAccountNumber(), "WITHDRAWAL_CASH", amount, oldBalance, account.getBalance());
            System.out.println("Vybrano " + amount + " Kc. Novy zustatek: " + account.getBalance() + " Kc");
        } else {
            String reason = (amount <= 0) ? "Neplatna castka" : "Nedostatek prostredku";
            logService.logRejection(account.getBankAccountNumber(), "WITHDRAWAL_CASH", reason);
            System.out.println("Nedostatek prostredku nebo neplatna castka!");
        }
    }

    public void withdrawByCard (BaseBankAccount account, PaymentCard card, double amount) {
        double oldBalance = account.getBalance();


        if (amount > 0 && oldBalance >= amount) {
            account.setBalance(oldBalance - amount);

            System.out.println("Proveden vyber kartou: " + card.getCardNumber());
            logService.logTransaction(account.getBankAccountNumber(), "WITHDRAWAL_CARD", amount, oldBalance, account.getBalance());
            System.out.println("Kartou vybrano " + amount + " Kc. Novy zustatek: " + account.getBalance() + " Kc");
        } else {
            String reason = (amount <= 0) ? "Neplatna castka" : "Nedostatek prostredku pro platbu kartou";
            logService.logRejection(account.getBankAccountNumber(), "WITHDRAWAL_CARD", reason);
            System.out.println("Platba kartou zamitnuta: " + reason);
        }
    }
}
