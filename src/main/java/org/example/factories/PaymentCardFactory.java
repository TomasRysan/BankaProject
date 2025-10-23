package org.example.factories;

import org.example.accounts.BankAccountWithPaymentCards;
import org.example.card.PaymentCard;
import org.example.card.PaymentCardCvvGenerator;
import org.example.card.PaymentCardExpireCalculator;
import org.example.card.PaymentCardNumberGenerator;

public class PaymentCardFactory {

    private final PaymentCardNumberGenerator paymentCardNumberGenerator;
    private final PaymentCardCvvGenerator paymentCardCvvGenerator;
    private final PaymentCardExpireCalculator paymentCardExpireCalculator;

    public PaymentCardFactory(PaymentCardNumberGenerator numberGenerator, PaymentCardCvvGenerator cvvGenerator, PaymentCardExpireCalculator  expireCalculator)
        {
            this.paymentCardNumberGenerator = numberGenerator;
            this.paymentCardCvvGenerator = cvvGenerator;
            this.paymentCardExpireCalculator = expireCalculator;
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
