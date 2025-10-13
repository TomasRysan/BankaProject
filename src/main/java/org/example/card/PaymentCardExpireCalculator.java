package org.example.card;

import java.time.LocalDate;
import java.util.Random;

public class PaymentCardExpireCalculator {

    public String calculateMonthExpire()
    {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        int month = rand.nextInt(12) + 1;
        if (month < 10){
            sb.append("0");
        }
        sb.append(month);
        return sb.toString();
    }

    public String calculateYearExpire()
    {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        LocalDate now = LocalDate.now();

        int currentYear = now.getYear();
        currentYear = currentYear % 100;

        int nextYear = rand.nextInt(3) + 3;
        int year = currentYear + nextYear;
        if (year < 10){
            sb.append("0");
            sb.append(year);
        }
        else  {
            sb.append(year);
        }
        return sb.toString();

    }

    public String FullExpire() {
        String month = calculateMonthExpire();
        String year = calculateYearExpire();

        System.out.println("Expire Date - " + month + "/" + year);
        return month + "/" + year;
    }


}
