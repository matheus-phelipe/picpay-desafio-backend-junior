package com.picpaysimples.services;

import com.picpaysimples.domain.transaction.Transaction;
import com.picpaysimples.domain.wallet.Wallet;
import com.picpaysimples.dtos.TransactionDTO;
import com.picpaysimples.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
//import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private WalletService walletService;
    @Autowired
    private TransactionRepository transactionRepository;
    private NotificationService notificationService;

      /*link don't work
      @Autowired
      private RestTemplate restTemplate;*/

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        Wallet walletPayer = this.walletService.findUserById(transaction.payerID());
        Wallet walletPayee = this.walletService.findUserById(transaction.payeeID());

        this.walletService.validateTransaction(walletPayer, transaction.value());

        boolean isAuthorized = this.authorizeTransaction(walletPayer, transaction.value());
        if(!isAuthorized){
            throw new Exception("Transaction not authorized!");
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value());
        newTransaction.setPayer(walletPayer);
        newTransaction.setPayee(walletPayee);
        newTransaction.setCreatedAt(LocalDateTime.now());

        walletPayer.setBalance(walletPayer.getBalance().subtract(transaction.value()));
        walletPayee.setBalance(walletPayee.getBalance().add(transaction.value()));

        this.transactionRepository.save(newTransaction);
        this.walletService.saveWallet(walletPayer);
        this.walletService.saveWallet(walletPayee);

//        this.notificationService.sendNotification(walletPayer, "Transação realizada com sucesso!");
//        this.notificationService.sendNotification(walletPayee, "Transação recebida com sucesso!");

        return newTransaction;
    }

    public boolean authorizeTransaction(Wallet payer, BigDecimal value){
        /*Link don't work
        ResponseEntity<Map> response =
        restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);
        if(response.getStatusCode().equals(HttpStatus.OK)){
            String message = (String) response.getBody().get("message");
            return message.equalsIgnoreCase("Autorizado");
        }else{
            return false;
        }*/

        return true;
    }
}
