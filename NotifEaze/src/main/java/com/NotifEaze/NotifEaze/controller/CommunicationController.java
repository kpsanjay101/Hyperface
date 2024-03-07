package com.NotifEaze.NotifEaze.controller;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.EmailRequest;
import com.NotifEaze.NotifEaze.dto.PushNotificationRequest;
import com.NotifEaze.NotifEaze.dto.SmsRequest;
import com.NotifEaze.NotifEaze.service.EmailService;
import com.NotifEaze.NotifEaze.service.PushNotificationService;
import com.NotifEaze.NotifEaze.service.SmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/communication")
public class CommunicationController {
	
	@Autowired
    private SmsService smsService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PushNotificationService pushNotificationService;
	
    @PostMapping("/send-sms")
    public ResponseEntity<BaseSmsResponse> sendSms(@RequestBody SmsRequest smsRequest) {
        BaseSmsResponse response = smsService.sendSms(smsRequest.getPhoneNumber(), smsRequest.getMessage());
        // Return the response
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/send-email")
    public ResponseEntity<BaseEmailResponse> sendEmail(@RequestBody EmailRequest emailRequest) {
       
        String to = emailRequest.getTo();
        String subject = emailRequest.getSubject();
        String body = emailRequest.getBody();

    
        BaseEmailResponse response = emailService.sendEmail(to, subject, body);

        // Return the response
        return new ResponseEntity<BaseEmailResponse>(response, HttpStatus.OK);
    }

    @PostMapping("/send-notification")
    public ResponseEntity<BasePushNotificationResponse> sendNotification(@RequestBody PushNotificationRequest pushNotificationRequest) {
 
        String fcmToken = pushNotificationRequest.getFcmToken();
        String message = pushNotificationRequest.getMessage();

      
        BasePushNotificationResponse response = pushNotificationService.sendNotification(fcmToken, message);

        // Return the response
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
