package org.example;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.StudentAccount;
import org.example.customer.Customer;
import org.example.accounts.SaveAccount;
import org.example.data.GeneratorUUID;
import org.example.services.BankAccountService;

public class Main {

    public static void main(String[] args) {


        Customer customer = new Customer("c-123", "Tomas", "Rysan");
        System.out.println(customer.getUuid() + ": " + customer.getFirstName() + " " + customer.getLastName());

        System.out.println("== Test Bank Account ==");
        testBankAccount(customer);

        System.out.println("== Test Save Account ==");
        testSaveAccount(customer);

        System.out.println("== Test Student Account ==");
        testStudentAccount(customer);

    }

    private static void testBankAccount(Customer customer)
    {
        GeneratorUUID gen = new GeneratorUUID();

        BaseBankAccount bankAccount = new BankAccount("b-412",gen.generate(),customer,0.0);

        try {
            System.out.println(bankAccount.getUuid() + ": " + bankAccount.getBankAccountNumber());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


    private static void testSaveAccount(Customer customer)
    {
        GeneratorUUID gen = new GeneratorUUID();

        SaveAccount saveAccount = new SaveAccount("s-123",gen.generate(),customer,0);

        try {
            System.out.println(saveAccount.getUuid() + ": " + saveAccount.getBankAccountNumber());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void testStudentAccount(Customer customer)
    {
        GeneratorUUID gen = new GeneratorUUID();
        BankAccountService bankAccountService = new BankAccountService();

        StudentAccount studentAccount = new StudentAccount("st-123",gen.generate(),customer,"Delta");

        try {
            bankAccountService.deposit(studentAccount, 5000);
            bankAccountService.withdraw(studentAccount, 5000);
            bankAccountService.withdraw(studentAccount, 1500);

            System.out.println(studentAccount.getUuid() + ": " + studentAccount.getBankAccountNumber());
            System.out.println(studentAccount.getUuid() + ": Studentova skola je " + studentAccount.getSchool());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


}

