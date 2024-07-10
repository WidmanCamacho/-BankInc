package com.bankinc.bankcinccc.controllers.mapper;

import com.bankinc.bankcinccc.controllers.dtos.TransactionDto;
import org.mapstruct.factory.Mappers;
import com.bankinc.bankcinccc.domain.entities.Transaction;

public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    TransactionDto transactionEntityToTransactionDto(Transaction transaction);
    Transaction transactionDtoToTransactionEntity(TransactionDto transactionDto);

}
