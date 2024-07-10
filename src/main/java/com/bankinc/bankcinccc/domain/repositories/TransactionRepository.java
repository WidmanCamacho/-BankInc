package com.bankinc.bankcinccc.domain.repositories;

import com.bankinc.bankcinccc.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
