package org.example;

import org.example.accounts.*;
import org.example.card.PaymentCard;
import org.example.card.PaymentCardFactory;
import org.example.customer.Customer;
import org.example.data.GeneratorUUID;
import org.example.people.BankAccountOwner;
import org.example.serialization.BankAccountOwnerSerializationService;
import org.example.serialization.BankAccountXMLSerializationService;
import org.example.services.BankAccountService;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("c-123", "Tomas", "Rysan");

        System.out.println("== Test Bank Account ==");
        testBankAccount(customer);

        System.out.println("== Test Save Account ==");
        testSaveAccount(customer);

        System.out.println("== Test Student Account ==");
        testStudentAccount(customer);


        //Serializace
        BankAccountOwner owner = new BankAccountOwner(customer);
        BankAccountOwnerSerializationService ownerService = new BankAccountOwnerSerializationService();
        String ownerJson = ownerService.Serialization(owner);
        System.out.println(ownerJson);


        //Serializace do XML
        BankAccountOwner owner2 = new BankAccountOwner(customer);

        BankAccountXMLSerializationService xmlService = new BankAccountXMLSerializationService();

        String xml = xmlService.Serialization(owner);
        System.out.println("XML vystup:");
        System.out.println(xml);

        BankAccountOwner back = (BankAccountOwner) xmlService.Deserialization(xml);
        System.out.println("Nacteny objekt:");
        System.out.println(back.getCustomer().getFirstName() + " " + back.getCustomer().getLastName());


        //Generace Karetnich Udaju
        System.out.println("\nCard Holder: " + customer.getFirstName() + " " + customer.getLastName());
        BankAccountWithPaymentCards cardAccount = getBankAccountWithPaymentCards(customer);

        System.out.println("\nKontrola: Pocet karet na uctu " + cardAccount.getBankAccountNumber() + ": " + cardAccount.getPaymentCards().size());
        for (PaymentCard card : cardAccount.getPaymentCards()) {
            System.out.println(" - Karta: " + card.getCardNumber());
        }
    }

    private static BankAccountWithPaymentCards getBankAccountWithPaymentCards(Customer customer) {
        PaymentCardFactory paymentCardFactory = new PaymentCardFactory();


        ArrayList<BankAccountWithPaymentCards> BankAccountList = new ArrayList<>();
        HashMap<BankAccount,PaymentCard> BankVCard = new HashMap<>();

        GeneratorUUID gen = new GeneratorUUID();
        BankAccountWithPaymentCards cardAccount = new BankAccountWithPaymentCards(
                "bc-456",
                gen.generate(),
                customer,
                10000.0
        );

        PaymentCard card1 = paymentCardFactory.create(customer.getFirstName() + " " + customer.getLastName());
        paymentCardFactory.linkCardToAccount(cardAccount, card1);

        PaymentCard card2 = paymentCardFactory.create(customer.getFirstName() + " " + customer.getLastName());
        paymentCardFactory.linkCardToAccount(cardAccount, card2);
        return cardAccount;
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
            bankAccountService.deposit(studentAccount, 250000);

            System.out.println(studentAccount.getUuid() + ": " + studentAccount.getBankAccountNumber());
            System.out.println(studentAccount.getUuid() + ": Studentova skola je " + studentAccount.getSchool());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
