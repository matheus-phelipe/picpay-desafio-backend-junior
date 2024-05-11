package com.picpaysimples.dtos;

import com.picpaysimples.domain.wallet.WalletType;

import java.math.BigDecimal;

public record WalletDTO(String fullName, String cpf, BigDecimal balance, String email, String password, WalletType type) {
}
