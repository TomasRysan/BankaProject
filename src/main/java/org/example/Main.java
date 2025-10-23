package org.example;

import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.BankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.card.PaymentCard;
import org.example.customer.Customer;
import org.example.people.BankAccountOwner;
import org.example.serialization.BankAccountOwnerSerializationService;
import org.example.serialization.BankAccountXMLSerializationService;
import org.example.services.BankAccountService;
import org.example.factories.PaymentCardFactory;
import org.example.data.GeneratorUUID; // Už se nepoužívá pro inicializaci, jen pro typ

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static Container container;

    public static void main(String[] args) {
        container = new Container();

        Customer customer = new Customer("c-123", "Tomas", "Rysan");

        System.out.println("== Test Bank Account ==");
        testBankAccount(customer);

        System.out.println("== Test Save Account ==");
        testSaveAccount(customer);

        System.out.println("== Test Student Account ==");
        testStudentAccount(customer);


        BankAccountOwner owner = new BankAccountOwner(customer);
        BankAccountOwnerSerializationService ownerService = new BankAccountOwnerSerializationService();
        String ownerJson = ownerService.Serialization(owner);
        System.out.println(ownerJson);


        BankAccountXMLSerializationService xmlService = new BankAccountXMLSerializationService();

        String xml = xmlService.Serialization(owner);
        System.out.println("XML vystup:");
        System.out.println(xml);

        BankAccountOwner back = (BankAccountOwner) xmlService.Deserialization(xml);
        System.out.println("Nacteny objekt:");
        System.out.println(back.getCustomer().getFirstName() + " " + back.getCustomer().getLastName());


        System.out.println("\nCard Holder: " + customer.getFirstName() + " " + customer.getLastName());
        BankAccountWithPaymentCards cardAccount = getBankAccountWithPaymentCards(customer);

        PaymentCardFactory paymentCardFactory = container.getPaymentCardFactory();
        paymentCardFactory.counterOfCardsToAccount(cardAccount, null);

    }


    private static BankAccountWithPaymentCards getBankAccountWithPaymentCards(Customer customer) {

        PaymentCardFactory paymentCardFactory = container.getPaymentCardFactory();
        GeneratorUUID gen = container.getGeneratorUUID();

        ArrayList<BankAccountWithPaymentCards> BankAccountList = new ArrayList<>();
        HashMap<BankAccount,PaymentCard> BankVCard = new HashMap<>();

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
        // ZÍSKÁNÍ GENERÁTORU Z KONTEJNERU!
        GeneratorUUID gen = container.getGeneratorUUID();
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
        // ZÍSKÁNÍ GENERÁTORU Z KONTEJNERU!
        GeneratorUUID gen = container.getGeneratorUUID();
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
        // ZÍSKÁNÍ GENERÁTORU A SLUŽBY Z KONTEJNERU!
        GeneratorUUID gen = container.getGeneratorUUID();
        BankAccountService bankAccountService = container.getBankAccountService();

        StudentAccount studentAccount = new StudentAccount("st-123",gen.generate(),customer,"Delta");

        try {
            // Používáme injektovanou službu
            bankAccountService.deposit(studentAccount, 5000);
            bankAccountService.withdraw(studentAccount, 5000);
            bankAccountService.withdraw(studentAccount, 1500);
            bankAccountService.deposit(studentAccount, 250000);


            studentAccount.deposit(5000);
            studentAccount.withdraw(5000);
            studentAccount.withdraw(1500);
            studentAccount.deposit(250000);


            System.out.println(studentAccount.getUuid() + ": " + studentAccount.getBankAccountNumber());
            System.out.println(studentAccount.getUuid() + ": Studentova skola je " + studentAccount.getSchool());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}