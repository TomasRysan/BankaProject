package org.example.card;

public class PaymentCard {

    private String cardNumber;

    private String cvv;

    private String owner;

    private String fullExpire;

    public PaymentCard(String cvv, String owner, String cardNumber) {
        this.cvv = cvv;

        this.owner = owner;
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getOwner() {
        return owner;
    }


    public String getCvv() {
        return cvv;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public void setFullExpire(String fullExpire) {
        this.fullExpire = fullExpire;
    }

    public String getFullExpire() {
        return fullExpire;
    }

    public PaymentCard(String fullExpire) {
        this.fullExpire = fullExpire;
    }


    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
