package com.bankinc.bankcinccc.controllers;

import com.bankinc.bankcinccc.controllers.dtos.CardDto;
import com.bankinc.bankcinccc.controllers.mapper.CardMapper;
import com.bankinc.bankcinccc.controllers.request.BalanceRequest;
import com.bankinc.bankcinccc.domain.entities.Card;
import com.bankinc.bankcinccc.domain.services.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@Tag(name = "Card controller")
public class CardController {
    @Autowired
    private CardService cardService;

    @Operation(summary = "Get credit card number")
    @GetMapping("/card/{productId}/number")
    public String generateCardNumber(@PathVariable String productId) {
        return cardService.generateCardNumber(productId);
    }

    @Operation(summary = "Post activate credit card")
    @PostMapping("/card/enroll")
    public CardDto activateCard(@RequestBody String cardId) {
        return CardMapper.INSTANCE.carEntityToCardDto(cardService.activateCard(cardId));
    }

    @Operation(summary = "Delete credit card")
    @DeleteMapping("/card/{cardId}")
    public Boolean blockCard(@PathVariable String cardId) {
        return cardService.blockCard(cardId);
    }

    @Operation(summary = "Post credit card balance")
    @PostMapping("/card/balance")
    public Card rechargeBalance(@RequestBody BalanceRequest request) {
        return cardService.rechargeBalance(request.getCardId(), request.getBalance());
    }

    @Operation(summary = "Get credit card Id")
    @GetMapping("/card/balance/{cardId}")
    public double getBalance(@PathVariable String cardId) {
        return cardService.getBalance(cardId);
    }
}

