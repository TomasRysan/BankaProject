package org.example.card;

public class PaymentCard {

    private String cardNumber;
    private String cvv;
    private String owner;
    private String fullExpire;

    public PaymentCard(String cardNumber, String fullExpire, String cvv) {
        this.cardNumber = cardNumber;
        this.fullExpire = fullExpire;
        this.cvv = cvv;
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

    public String getFullExpire() {
        return fullExpire;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setFullExpire(String fullExpire) {
        this.fullExpire = fullExpire;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
