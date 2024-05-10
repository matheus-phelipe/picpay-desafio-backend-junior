package com.picpaysimples.domain.wallet;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="WALLETS")
@Table(name="WALLETS")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String password;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private WalletType type;
}
