package com.project.ecommerce_email_service.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ecommerce_email_service.dtos.SendEmailDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SendEmailEventConsumer {
    private ObjectMapper objectMapper;

    public SendEmailEventConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "sendEmail", groupId = "emailService")
    public void handleSendEmailEvent(String message) throws JsonProcessingException {
        SendEmailDto sendEmailDto = this.objectMapper.readValue(message, SendEmailDto.class);

        String to = sendEmailDto.getTo();
        String from = sendEmailDto.getFrom();
        String subject = sendEmailDto.getSubject();
        String body = sendEmailDto.getBody();
    }
}
