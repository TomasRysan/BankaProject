package org.example.card;

import java.util.Random;

public class PaymentCardCvvGenerator {

    public String generateCvvNumber() {
        Random rand = new Random();

        StringBuilder cvvNumber = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            cvvNumber.append(rand.nextInt(10));
        }
        System.out.println("CCV - " + cvvNumber.toString());
        return cvvNumber.toString();
    }



}
