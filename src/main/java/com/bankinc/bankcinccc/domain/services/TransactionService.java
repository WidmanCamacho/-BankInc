package com.bankinc.bankcinccc.domain.services;

import com.bankinc.bankcinccc.domain.entities.Card;
import com.bankinc.bankcinccc.domain.entities.Transaction;
import com.bankinc.bankcinccc.domain.repositories.CardRepository;
import com.bankinc.bankcinccc.domain.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CardRepository cardRepository;

    public Transaction makePurchase(String cardId, double amount) {
        Optional<Card> optionalCard = cardRepository.findById(cardId);
        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            if (!card.isActive() || card.isBlocked() || card.getBalance() < amount || card.getExpirationDate().isBefore(LocalDate.now())) {
                throw new RuntimeException("Invalid transaction");
            }
            card.setBalance(card.getBalance() - amount);
            cardRepository.save(card);
            Transaction transaction = new Transaction();
            transaction.setCardId(cardId);
            transaction.setTransactionDate(LocalDate.now());
            transaction.setAmount(amount);
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Card not found");
        }
    }

    public Optional<Transaction> getTransaction(UUID transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public void annulTransaction(String cardId, UUID transactionId) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            if (!transaction.isCancelled() && transaction.getTransactionDate().isAfter(LocalDate.now().minusDays(1))) {
                Card card = cardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Card not found"));
                card.setBalance(card.getBalance() + transaction.getAmount());
                transaction.setCancelled(true);
                cardRepository.save(card);
                transactionRepository.save(transaction);
            } else {
                throw new RuntimeException("Transaction cannot be annulled");
            }
        } else {
            throw new RuntimeException("Transaction not found");
        }
    }
}
