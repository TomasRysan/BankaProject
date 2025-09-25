package org.example.data;

import org.example.customer.Customer;

import java.util.Random;

public class GeneratorUUID {

    Random random = new Random();

    public String generate()
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++)
        {
            int number = random.nextInt(10);
            sb.append(number);
        }

        return sb.toString();

    }


}
