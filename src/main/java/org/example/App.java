package org.example;

import jakarta.inject.Inject;
import org.example.accounts.*;
import org.example.card.PaymentCard;
import org.example.customer.Customer;
import org.example.data.GeneratorUUID;
import org.example.factories.BankAccountFactory;
import org.example.factories.PaymentCardFactory;
import org.example.people.BankAccountOwner;
import org.example.serialization.BankAccountOwnerSerializationService;
import org.example.serialization.BankAccountXMLSerializationService;
import org.example.services.BankAccountService;

import java.util.ArrayList;
import java.util.HashMap;

public class App {

    @Inject
    private BankAccountService bankAccountService;

    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private PaymentCardFactory paymentCardFactory;

    @Inject
    private GeneratorUUID generatorUUID;

    public void run() {
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

        PaymentCardFactory paymentCardFactory = this.paymentCardFactory;
        paymentCardFactory.counterOfCardsToAccount(cardAccount, null);
    }

    private BankAccountWithPaymentCards getBankAccountWithPaymentCards(Customer customer) {
        PaymentCardFactory paymentCardFactory = this.paymentCardFactory;
        GeneratorUUID gen = this.generatorUUID;

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

    private void testBankAccount(Customer customer)
    {
        GeneratorUUID gen = this.generatorUUID;
        BaseBankAccount bankAccount = new BankAccount("b-412",gen.generate(),customer,0.0);

        try {
            System.out.println(bankAccount.getUuid() + ": " + bankAccount.getBankAccountNumber());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    private void testSaveAccount(Customer customer)
    {
        GeneratorUUID gen = this.generatorUUID;
        SaveAccount saveAccount = new SaveAccount("s-123",gen.generate(),customer,0);

        try {
            System.out.println(saveAccount.getUuid() + ": " + saveAccount.getBankAccountNumber());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void testStudentAccount(Customer customer)
    {
        BankAccountFactory bankAccountFactory = this.bankAccountFactory;
        BankAccountService bankAccountService = this.bankAccountService;


        StudentAccount studentAccount = bankAccountFactory.createStudentAccount(customer, "Delta");

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

