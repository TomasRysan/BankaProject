package org.example.interest;

import jakarta.inject.Inject;
import org.example.accounts.SaveAccount;
import org.example.services.AccountLogService;

import java.time.LocalDateTime;

public class InterestCalculator {

    @Inject
    private SaveAccount saveAccount;

    @Inject
    private AccountLogService accountLogService;

    public float calculate(SaveAccount saveAccount) {
        LocalDateTime currentTime = LocalDateTime.now();

        float interest;
        float interestRate = 0.04F;
        float balance_ = (float) saveAccount.getBalance();

        interest = balance_*(interestRate/365)*31;

        return interest;
    }

}
