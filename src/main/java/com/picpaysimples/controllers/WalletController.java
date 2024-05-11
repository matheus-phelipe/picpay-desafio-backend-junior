package com.picpaysimples.controllers;

import com.picpaysimples.domain.wallet.Wallet;
import com.picpaysimples.dtos.WalletDTO;
import com.picpaysimples.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Wallet> createWallet(@RequestBody WalletDTO wallet){
        Wallet newWallet = walletService.createWallet(wallet);
        return new ResponseEntity<>(newWallet, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Wallet>> getWallets(){
        List<Wallet> wallets = this.walletService.getAllWallets();
        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }
}
