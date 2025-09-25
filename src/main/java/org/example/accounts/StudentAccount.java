package org.example.accounts;


import org.example.customer.Customer;
import org.example.services.BankAccountService;


public class StudentAccount extends BaseBankAccount {

    BankAccountService bankAccountService = new BankAccountService();

    private String school;

    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, String school) {
        super(uuid, bankAccountNumber, customer, 0);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }
}

