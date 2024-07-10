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
public class Card {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cardId;
    private String productId;
    private String holderName;
    private LocalDate expirationDate;
    private boolean isActive;
    private boolean isBlocked;
    private double balance;

    public Card(String cardId, String productId, String holderName, LocalDate expirationDate, boolean isActive, boolean isBlocked, double balance) {
        this.cardId = cardId;
        this.productId = productId;
        this.holderName = holderName;
        this.expirationDate = expirationDate;
        this.isActive = isActive;
        this.isBlocked = isBlocked;
        this.balance = balance;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
