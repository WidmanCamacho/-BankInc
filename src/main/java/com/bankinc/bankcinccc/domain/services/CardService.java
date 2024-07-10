package com.bankinc.bankcinccc.domain.services;

import com.bankinc.bankcinccc.domain.constans.Constant;
import com.bankinc.bankcinccc.domain.entities.Card;
import com.bankinc.bankcinccc.domain.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public String generateCardNumber(String productId) {
        try{
            return (productId + String.format("%010d", (long) (Math.random() * 1_000_000_0000L)));
        }
        catch (Exception ex){
            throw new RuntimeException("The following exception has occurred: " + ex.getMessage());
        }
    }

    public Card activateCard(String cardId) {
        try{
            Optional<Card> optionalCard = cardRepository.findById(cardId);
            if (optionalCard.isPresent()) {
                Card card = optionalCard.get();
                card.setActive(true);
                return cardRepository.save(card);
            } else {
                throw new RuntimeException("Card not found");
            }
        }
        catch (Exception ex){
            throw new RuntimeException("The following exception has occurred: " + ex.getMessage());
        }
    }

    public Boolean blockCard(String cardId) {
        try{
            Optional<Card> optionalCard = cardRepository.findById(cardId);
            if (optionalCard.isPresent()) {
                Card card = optionalCard.get();
                card.setBlocked(true);
                cardRepository.save(card);

                return true;
            } else {
                throw new RuntimeException("Card not found");
            }
        }
        catch (Exception ex){
            throw new RuntimeException("The following exception has occurred: " + ex.getMessage());
        }
    }

    public Card rechargeBalance(String cardId, double amount) {
        try{
            Optional<Card> optionalCard = cardRepository.findById(cardId);
            if (optionalCard.isPresent()) {
                Card card = optionalCard.get();
                card.setBalance(card.getBalance() + amount);
                return cardRepository.save(card);
            } else {
                throw new RuntimeException("Card not found");
            }
        }
        catch (Exception ex){
            throw new RuntimeException("The following exception has occurred: " + ex.getMessage());
        }
    }

    public double getBalance(String cardId) {
        try{
            Optional<Card> optionalCard = cardRepository.findById(cardId);
            return optionalCard.map(Card::getBalance).orElseThrow(() -> new RuntimeException("Card not found"));
        }
        catch (Exception ex){
            throw new RuntimeException("The following exception has occurred: " + ex.getMessage());
        }
    }
}
