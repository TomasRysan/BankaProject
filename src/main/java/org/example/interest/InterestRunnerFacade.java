package org.example.interest;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.inject.Inject;
import org.example.accounts.AccountRepository;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.services.AccountLogService;
import org.example.services.BankAccountService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InterestRunnerFacade {

    @Inject
    public AccountRepository accountRepository;

    @Inject
    private InterestCalculator interestCalculator;

    @Inject
    private AccountLogService accountLogService;

    @Inject
    private BankAccountService bankAccountService;

    private ArrayList<SaveAccount> saveAccounts = new ArrayList<>();

    public void processAllInterest()
    {
        LocalDateTime currentTime = LocalDateTime.now();
        List<BaseBankAccount> allAccounts = accountRepository.getAccounts();
        for (BaseBankAccount baseBankAccount : allAccounts)
        {
            if (baseBankAccount instanceof SaveAccount saveAccount)
            {
                saveAccounts.add(saveAccount);
            }
        }



        for (SaveAccount account : saveAccounts) {
            System.out.println("Zpracovávám úrok pro spořicí účet: " + account.getBankAccountNumber());

            if (currentTime.isEqual(account.getNextInterestRun()) || currentTime.isAfter(account.getNextInterestRun()))
            {
                float interest = interestCalculator.calculate(account);
                bankAccountService.InterestDeposit(account, interest);
            }
            else
            {
                System.out.println("Dopocitani uroku bude v " + account.getNextInterestRun());
            }

        }



    }

}

