package org.example;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.StudentAccount;
import org.example.customer.Customer;
import org.example.accounts.SaveAccount;

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

        BaseBankAccount bankAccount = new BankAccount("b-412","BA1234567890",customer,0.0);

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

        SaveAccount saveAccount = new SaveAccount("s-123","SA1234567890",customer,0);

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
        StudentAccount studentAccount = new StudentAccount("st-123","ST1234567890",customer,"Delta");

        try {
            studentAccount.deposit(5000);
            studentAccount.withdraw(2500);
            studentAccount.withdraw(1500);

            System.out.println(studentAccount.getUuid() + ": " + studentAccount.getBankAccountNumber());
            System.out.println(studentAccount.getUuid() + ": Studentova skola je " + studentAccount.getSchool());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


}

