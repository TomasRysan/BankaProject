package org.example.services;

public class AccountLogService {


    public AccountLogService() {


    }

    public void logTransaction(String accountNumber, String type, double amount, double oldBalance, double newBalance) {
        System.out.println("--- LOG: Transakce zaznamenana ---");
        System.out.println("Ucet: " + accountNumber);
        System.out.println("Typ: " + type);
        System.out.println("Castka: " + amount + " Kc");
        System.out.println("Predchozi zustatek: " + oldBalance + " Kc");
        System.out.println("Novy zustatek: " + newBalance + " Kc");
        System.out.println("---------------------------------");
    }

    public void logRejection(String accountNumber, String type, String reason) {
        System.out.println("--- LOG: Transakce zamitnuta ---");
        System.out.println("Ucet: " + accountNumber);
        System.out.println("Typ: " + type);
        System.out.println("Duvod: " + reason);
        System.out.println("---------------------------------");
    }
}