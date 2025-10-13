package org.example.card;

import java.util.Random;

public class PaymentCardNumberGenerator {


    public String generatePaymentCardNumber() {

        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 19; i++) {
            if (i % 5 == 0 & i != 1){
                sb.append("-");
            }
            else{
                sb.append(rand.nextInt(10));
            }
        }
        System.out.println("Card Number: " + sb.toString());
        return sb.toString();

    }

}
