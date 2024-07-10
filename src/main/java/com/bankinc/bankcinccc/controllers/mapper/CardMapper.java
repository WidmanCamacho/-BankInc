package com.bankinc.bankcinccc.controllers.mapper;

//import javax.persistence.*;


import com.bankinc.bankcinccc.controllers.dtos.CardDto;
import com.bankinc.bankcinccc.domain.entities.Card;
import org.mapstruct.factory.Mappers;

public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardDto carEntityToCardDto(Card card);
    Card carDtoToCarEntity(CardDto cardDto);

}

