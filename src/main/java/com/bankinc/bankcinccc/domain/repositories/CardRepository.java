package com.bankinc.bankcinccc.domain.repositories;

import com.bankinc.bankcinccc.domain.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CardRepository extends JpaRepository<Card, String> {
}
