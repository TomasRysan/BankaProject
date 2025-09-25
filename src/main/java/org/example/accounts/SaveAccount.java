package org.example.accounts;

import org.example.customer.Customer;

public class SaveAccount extends BaseBankAccount {

    private float interestRate;

    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, float interestRate) {
        super(uuid,bankAccountNumber,customer, 0);

        this.interestRate = interestRate;
    }

    public SaveAccount(String uuid, String bankAccountNumber, Customer customer){
        this(uuid,bankAccountNumber,customer, 0);
    }

    public float getInterestRate() {
        return interestRate;
    }


}
