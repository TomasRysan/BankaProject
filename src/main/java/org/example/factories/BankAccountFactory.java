package org.example.factories;

import jakarta.inject.Inject;
import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.customer.Customer;
import org.example.data.GeneratorUUID;
import org.example.services.AccountLogService;

public class BankAccountFactory {

    @Inject
    private AccountLogService logger;

    @Inject
    private GeneratorUUID generatorUUID;

    public BaseBankAccount createBaseBankAccount(String uuid, Customer customer, double balance) {
        String accountNumber = generatorUUID.generate();

        return new BankAccount(uuid, accountNumber, customer, balance);
    }

    public SaveAccount createSaveBankAccount(String uuid, Customer customer,float initialBalance, float interestRate) {
        String accountNumber = generatorUUID.generate();

        return new SaveAccount(uuid, accountNumber, customer, initialBalance, interestRate);
    }

    public StudentAccount createStudentAccount(Customer customer, String school) {
        String uuid = this.generatorUUID.generate();
        String bankAccountNumber = "st-" + uuid;

        return new StudentAccount(uuid, bankAccountNumber, customer, school, this.logger);
    }
}
