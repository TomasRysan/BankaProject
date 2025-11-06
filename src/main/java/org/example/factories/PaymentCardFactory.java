package org.example.factories;

import jakarta.inject.Inject;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.card.PaymentCard;
import org.example.card.PaymentCardCvvGenerator;
import org.example.card.PaymentCardExpireCalculator;
import org.example.card.PaymentCardNumberGenerator;



public class PaymentCardFactory {

    @Inject
    private PaymentCardNumberGenerator paymentCardNumberGenerator;

    @Inject
    private PaymentCardCvvGenerator paymentCardCvvGenerator;

    @Inject
    private PaymentCardExpireCalculator paymentCardExpireCalculator;


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
        System.out.println("Payment Card " + paymentCard.getCardNumber()+ " is linked with " + account.getBankAccountNumber() + " Bank Account");
        System.out.println("---------------------------");
    }

    public void counterOfCardsToAccount(BankAccountWithPaymentCards account, PaymentCard paymentCard) {
        System.out.println("\nKontrola: Pocet karet na uctu " + account.getBankAccountNumber() + ": " + account.getPaymentCards().size());
        for (PaymentCard card : account.getPaymentCards()) {
            System.out.println(" - Karta: " + card.getCardNumber());
        }
    }
}