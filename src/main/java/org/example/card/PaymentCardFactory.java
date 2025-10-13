package org.example.card;

public class PaymentCardFactory {

    PaymentCardNumberGenerator paymentCardNumberGenerator = new PaymentCardNumberGenerator();
    PaymentCardExpireCalculator paymentCardExpireCalculator = new PaymentCardExpireCalculator();
    PaymentCardCvvGenerator paymentCardCvvGenerator = new PaymentCardCvvGenerator();

    public PaymentCard create(String owner) {

        String expireDate = paymentCardExpireCalculator.FullExpire();
        String cardNumber = paymentCardNumberGenerator.generatePaymentCardNumber();
        String cvv = paymentCardCvvGenerator.generateCvvNumber();

        return new PaymentCard(cardNumber, expireDate, cvv);
    }




}
