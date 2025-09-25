package org.example.factories;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.customer.Customer;
import org.example.data.GeneratorUUID;

public class BankAccountFactory {

    GeneratorUUID generatorUUID = new GeneratorUUID();

    public BaseBankAccount createBaseBankAccount(String uuid, Customer customer, double balance) {
        String accountNumber = generatorUUID.generate();

        return new BaseBankAccount(uuid, accountNumber,customer, balance);
    }

    public SaveAccount createSaveBankAccount(String uuid, Customer customer, float interestRate) {
        String accountNumber = generatorUUID.generate();

        return new SaveAccount(uuid, accountNumber,customer, interestRate);
    }

    public StudentAccount createStudentAccount(String uuid, Customer customer, String school) {
        String accountNumber = generatorUUID.generate();

        return new StudentAccount(uuid, accountNumber,customer, school);
    }
}
