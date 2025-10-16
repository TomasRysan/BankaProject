package org.example.card;

import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BankAccount;

import java.util.HashMap;

public class PaymentCardFactory {

    PaymentCardNumberGenerator paymentCardNumberGenerator = new PaymentCardNumberGenerator();
    PaymentCardExpireCalculator paymentCardExpireCalculator = new PaymentCardExpireCalculator();
    PaymentCardCvvGenerator paymentCardCvvGenerator = new PaymentCardCvvGenerator();

    public PaymentCard create(String owner) {

        String expireDate = paymentCardExpireCalculator.FullExpire();
        String cardNumber = paymentCardNumberGenerator.generatePaymentCardNumber();
        String cvv = paymentCardCvvGenerator.generateCvvNumber();

        PaymentCard paymentCard = new PaymentCard(cardNumber, expireDate, cvv);
        paymentCard.setOwner(owner);
        return paymentCard;
    }

    public void linkCardToAccount(BankAccountWithPaymentCards account, PaymentCard paymentCard) {
        account.addPaymentCard(paymentCard);
        System.out.println("Payment Card is linked with Bank Account: " + account.getBankAccountNumber());
        System.out.println("Card Number: " + paymentCard.getCardNumber());
        System.out.println("CCV Code: " + paymentCard.getCvv());
    }

    public void addToBankAccount(BankAccount bankAccount, PaymentCard paymentCard, HashMap<BankAccount,PaymentCard> BankVCard) {

        BankVCard.put(bankAccount, paymentCard);
        System.out.println("Payment Card is linked with Bank Account");
        System.out.println(BankVCard.toString());
    }
}
