package com.bankinc.bankcinccc.domain.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

//import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Transaction {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transactionId;
    private String cardId;
    private LocalDate transactionDate;
    private double amount;
    private boolean isCancelled;

    public Transaction() {
        // Constructor vacío para JPA
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }
}
