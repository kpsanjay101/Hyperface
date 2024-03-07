package com.NotifEaze.NotifEaze.service;

import org.springframework.stereotype.Service;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
@Service
public interface EmailService {
    BaseEmailResponse sendEmail(String to, String subject, String body);
}
