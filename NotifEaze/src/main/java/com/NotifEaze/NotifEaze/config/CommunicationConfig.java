package com.NotifEaze.NotifEaze.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.NotifEaze.NotifEaze.service.EmailService;
import com.NotifEaze.NotifEaze.service.PushNotificationService;
import com.NotifEaze.NotifEaze.service.SmsService;
import com.NotifEaze.NotifEaze.service.impl.GupshupServiceImpl;
import com.NotifEaze.NotifEaze.service.impl.KayleraServiceImpl;

@Configuration
public class CommunicationConfig {

 @Value("${communication.vendor}")
 private String communicationVendor; // Add a property in application.properties

 @Bean
 public SmsService smsService() {
     // Based on the configuration, return the appropriate implementation
     if ("gupshup".equalsIgnoreCase(communicationVendor)) {
         return new GupshupServiceImpl();
     } else if ("kaylera".equalsIgnoreCase(communicationVendor)) {
         return new KayleraServiceImpl();
     }
     // Add more vendors as needed
     return null; // or throw an exception for unknown vendors
 }

 @Bean
 public EmailService emailService() {
	 if ("gupshup".equalsIgnoreCase(communicationVendor)) {
         return new GupshupServiceImpl();
     } else if ("kaylera".equalsIgnoreCase(communicationVendor)) {
         return new KayleraServiceImpl();
     }
     // Add more vendors as needed
     return null;
 }

 @Bean
 public PushNotificationService pushNotificationService() {
	 if ("gupshup".equalsIgnoreCase(communicationVendor)) {
         return new GupshupServiceImpl();
     } else if ("kaylera".equalsIgnoreCase(communicationVendor)) {
         return new KayleraServiceImpl();
     }
     // Add more vendors as needed
     return null;
 }
}

