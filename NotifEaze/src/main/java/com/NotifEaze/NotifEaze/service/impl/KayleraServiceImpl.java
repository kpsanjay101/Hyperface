package com.NotifEaze.NotifEaze.service.impl;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.NotifEaze.NotifEaze.service.EmailService;
import com.NotifEaze.NotifEaze.service.PushNotificationService;
import com.NotifEaze.NotifEaze.service.SmsService;

public class KayleraServiceImpl implements EmailService, PushNotificationService, SmsService{

	@Override
	public BaseSmsResponse sendSms(String phoneNumber, String message) {
		String messageId = generateUniqueMessageId();
        String providerResponse = KayleraMock.SMS_MOCKED_RESPONSES.get("123456");
      
        boolean success = true; 
        String responseMessage = "SMS sent successfully";

        return new BaseSmsResponse(success, responseMessage);
	}

	@Override
	public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
		String statusResponse = KayleraMock.SMS_MOCKED_RESPONSES.get(messageId);

        
        boolean delivered = "Success".equals(statusResponse); 
        String statusMessage = "Delivery status checked"; 

        return new SmsDeliveryStatus(delivered, statusMessage);
	}

	@Override
	public BasePushNotificationResponse sendNotification(String fcmToken, String message) {
		String notificationId = generateUniqueNotificationId();
        String pushNotificationResponse = KayleraMock.PN_MOCKED_RESPONSES.get("FCMToken1");

        boolean success = true; 
        String responseMessage = "Notification sent successfully"; 

        return new BasePushNotificationResponse(success, responseMessage);
	}

	@Override
	public BaseEmailResponse sendEmail(String to, String subject, String body) {
		String emailId = generateUniqueEmailId();
        String emailResponse = KayleraMock.EMAIL_MOCKED_RESPONSES.get("Email1");

        // For a more realistic scenario, you would interact with the actual Kaylera API here
        // Example: KayleraApiResponse apiResponse = kayleraApi.sendEmail(to, subject, body);

        // Use the response from the actual API or the mock response
        boolean success = true; // Change based on the actual response
        String responseMessage = "Email sent successfully"; // Change based on the actual response

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
