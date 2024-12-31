package com.ms.user.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms.user.application.api.DTO.EmailDTO;
import com.ms.user.model.User;

@Component
public class UserProducer {

	final RabbitTemplate rabbitTemplate;

	public UserProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Value("${broker.queue.email.name}")
	private String routingKey;

	public void publishEmail(User user) {
		var emailDTO = new EmailDTO();
		emailDTO.setUserId(user.getUserId());
		emailDTO.setEmailTo(user.getEmail());
		emailDTO.setSubject("Cadastro realizado com sucesso!");
		emailDTO.setText(user.getName() + ", seja bem vindo(a)! \nAgradecemos seu cadastro! ");

		rabbitTemplate.convertAndSend("", routingKey, emailDTO);

	}

}
