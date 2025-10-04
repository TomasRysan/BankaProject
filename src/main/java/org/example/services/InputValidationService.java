package org.example.services;

import org.example.accounts.BaseBankAccount;

public class InputValidationService {

    public boolean DepositValidationService(BaseBankAccount account, Double balance) {

        if (balance >= 250000) {
            System.out.println("Vklad je vyssi nez 250000 Kc");
            System.out.println("WARNING - AML");

            return false;
        } else {
            System.out.println("Vklad prosel přes AML - 250000 Kc");

            return true;
        }
    }

}
