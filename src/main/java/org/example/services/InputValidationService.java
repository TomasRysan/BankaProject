package org.example.services;

import org.example.accounts.BaseBankAccount;

public class InputValidationService {

    public void DepositValidationService(BaseBankAccount account, Double balance) {

        if (balance >= 250000) {
            System.out.println("Balance is greater than 250000");
            System.out.println("WARNING - AML");
        } else {
            System.out.println("Balance is less than 250000");
        }
    }

}
