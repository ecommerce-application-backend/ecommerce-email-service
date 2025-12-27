package com.project.ecommerce_email_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailDto {
    private String toEmail;
    private String fromEmail;
    private String subject;
    private String body;
}
