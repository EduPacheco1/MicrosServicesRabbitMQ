package com.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.email.dtos.EmailRecordDTO;
import com.ms.email.model.Email;
import com.ms.email.service.EmailService;

@Component
public class EmailConsumer {

	private EmailService emailService;

	public EmailConsumer(EmailService emailService) {
		this.emailService = emailService;
	}

	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenEmailQueue(@Payload EmailRecordDTO emailRecordDTO) {
		var emailModel = new Email();
		BeanUtils.copyProperties(emailRecordDTO, emailModel);
		emailService.sendEmail(emailModel);
	}

}
