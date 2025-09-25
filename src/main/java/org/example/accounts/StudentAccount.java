package org.example.accounts;

import org.example.customer.Customer;

public class StudentAccount extends BaseBankAccount {

    private String school;

    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, String school) {
        super(uuid, bankAccountNumber, customer, 0);
        this.school = school;
    }

    public StudentAccount(String uuid, String bankAccountNumber, Customer customer) {
        super(uuid, bankAccountNumber, customer, 0);
    }

    public String getSchool() {
        return school;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 2000) {
            System.out.println("Student nemuze vybrat vice nez 2000 Kc najednou!");
        } else {
            super.withdraw(amount); //
        }
    }
}

