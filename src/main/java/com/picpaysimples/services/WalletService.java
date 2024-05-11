package com.picpaysimples.services;

import com.picpaysimples.domain.wallet.Wallet;
import com.picpaysimples.domain.wallet.WalletType;
import com.picpaysimples.dtos.WalletDTO;
import com.picpaysimples.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public void validateTransaction(Wallet payer, BigDecimal amount) throws Exception{
            if(payer.getType().equals(WalletType.MERCHANT)){
                throw new Exception("User the type Merchant not authorized!");
            }

            if(payer.getBalance().compareTo(amount) < 0){
                throw new Exception("Wallet don't have balance!");
            }
    }

    public Wallet findUserById(Long id) throws Exception {
        return this.walletRepository.findById(id).orElseThrow(() -> new Exception("User don't find!"));
    }

    public void saveWallet(Wallet wallet){
        this.walletRepository.save(wallet);
    }

    public Wallet createWallet(WalletDTO data){
        Wallet newWallet = new Wallet(data);
        this.saveWallet(newWallet);

        return newWallet;
    }

    public List<Wallet> getAllWallets(){
        return this.walletRepository.findAll();
    }
}
