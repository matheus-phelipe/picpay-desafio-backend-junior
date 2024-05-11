package com.picpaysimples.services;

import com.picpaysimples.domain.wallet.Wallet;
import com.picpaysimples.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(Wallet wallet, String message) throws Exception {
       /*link don't work
        String email = wallet.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);
        ResponseEntity<String> response =
               restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificationRequest, String.class);
        if(!response.getStatusCode().equals(HttpStatus.OK)){
            System.out.println("Erro ao enviar notificacao");
            throw new Exception("Service of notification don't work!");
        }*/
    }
}
