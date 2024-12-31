package com.ms.email.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.model.Email;
import com.ms.email.model.StatusEmail;
import com.ms.email.repository.EmailRepository;

import jakarta.transaction.Transactional;

@Service
public class EmailService {

	private final EmailRepository emailRepository;

	private final JavaMailSender emailSender;

	public EmailService(EmailRepository emailRepository, JavaMailSender eMailSender) {
		this.emailRepository = emailRepository;
		this.emailSender = eMailSender;
	}

	@Value("${spring.mail.username}")
	private String emailFrom;

	@Transactional
	public Email sendEmail(Email email) {
		try {
			email.setSendDataEmail(LocalDateTime.now());
			email.setEmailFrom(emailFrom);

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			emailSender.send(message);

			email.setStatusEmail(StatusEmail.SEND);
		} catch (MailException e) {
			email.setStatusEmail(StatusEmail.ERROR);
		}
			return emailRepository.save(email);
	}
}
