package org.example.interest;

import jakarta.inject.Inject;
import org.example.accounts.SaveAccount;

public class InterestCalculator {

    @Inject
    private SaveAccount saveAccount;


    public float calculate(float interestRate, float balance, SaveAccount saveAccount) {



        float interest;
        interestRate = 0.04F;
        float balance_ = (float) saveAccount.getBalance();

        interest = balance*(interestRate/365)*31;



        return interestRate;
    }
}
