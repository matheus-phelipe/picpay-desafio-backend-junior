package com.picpaysimples.repositories;

import com.picpaysimples.domain.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findWalletByCpf(String cpf);
}
