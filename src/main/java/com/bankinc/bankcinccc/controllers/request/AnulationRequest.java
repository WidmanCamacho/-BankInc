package com.bankinc.bankcinccc.controllers.request;

import java.util.UUID;

public class AnulationRequest {
    private String cardId;
    private UUID transactionId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }
}
