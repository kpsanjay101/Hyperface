package com.NotifEaze.NotifEaze.dto;

public class PushNotificationRequest {
	
	private String fcmToken;
    private String message;


	public PushNotificationRequest(String fcmToken, String message) {
        this.fcmToken = fcmToken;
        this.message = message;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
