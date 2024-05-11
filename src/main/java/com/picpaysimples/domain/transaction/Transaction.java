package com.picpaysimples.domain.transaction;

import com.picpaysimples.domain.wallet.Wallet;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="TRANSACTIONS")
@Table(name="TRANSACTIONS")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private Wallet payer;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private Wallet payee;

    private LocalDateTime createdAt;
}
