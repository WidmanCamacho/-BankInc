package com.bankinc.bankcinccc.controllers.request;

public class BalanceRequest {
    private String cardId;
    private double balance;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
