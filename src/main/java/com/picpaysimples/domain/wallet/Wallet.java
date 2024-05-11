package com.picpaysimples.domain.wallet;

import com.picpaysimples.dtos.WalletDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="WALLETS")
@Table(name="WALLETS")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@NoArgsConstructor
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

    public Wallet(WalletDTO data) {
        this.fullName = data.fullName();
        this.balance = data.balance();
        this.cpf = data.cpf();
        this.password = data.password();
        this.email = data.email();
        this.type = data.type();
    }
}
