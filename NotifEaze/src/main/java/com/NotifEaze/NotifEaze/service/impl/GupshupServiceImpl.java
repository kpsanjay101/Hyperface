package com.NotifEaze.NotifEaze.service.impl;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.service.EmailService;
import com.NotifEaze.NotifEaze.service.PushNotificationService;
import com.NotifEaze.NotifEaze.service.SmsService;

public class GupshupServiceImpl implements EmailService, PushNotificationService,SmsService{

	@Override
	public BaseSmsResponse sendSms(String phoneNumber, String message) {
		String messageId = generateUniqueMessageId();
	    String providerResponse = GupshupMock.SMS_MOCKED_RESPONSES.get("MessageId1");

	    boolean success = true; 
	    String responseMessage = "SMS sent successfully";

	    return new BaseSmsResponse(success, responseMessage);
	}

	@Override
	public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
		String statusResponse = GupshupMock.SMS_DELIVERY_STATUS_MOCKED_RESPONSES.get(messageId);


        boolean delivered = "Success".equalsIgnoreCase(statusResponse); 
        String statusMessage = statusResponse; 

        return new SmsDeliveryStatus(delivered, statusMessage);
	}

	@Override
	public BasePushNotificationResponse sendNotification(String fcmToken, String message) {
		String notificationId = generateUniqueNotificationId();
        String pushNotificationResponse = GupshupMock.PN_MOCKED_RESPONSES.get("FCMToken1");

        
        boolean success = true; 
        String responseMessage = "Notification sent successfully"; 

        return new BasePushNotificationResponse(success, responseMessage);
	}

	@Override
	public BaseEmailResponse sendEmail(String to, String subject, String body) {
		String emailId = generateUniqueEmailId();
        String emailResponse = GupshupMock.EMAIL_MOCKED_RESPONSES.get("Email1");

        
        boolean success = true; 
        String responseMessage = "Email sent successfully"; 

        return new BaseEmailResponse(success, responseMessage);
	}
	
	private String generateUniqueMessageId() {
	    return "MessageId_" + System.currentTimeMillis();
	}
	
	 private String generateUniqueEmailId() {
	        return "EmailId_" + System.currentTimeMillis();
	    }
	
	private String generateUniqueNotificationId() {
        return "NotificationId_" + System.currentTimeMillis();
    }

}
