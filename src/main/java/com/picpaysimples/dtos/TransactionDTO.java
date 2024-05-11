package com.picpaysimples.dtos;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, Long payerID, Long payeeID) {

}
