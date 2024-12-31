package com.ms.user.application.service;

import org.springframework.stereotype.Service;

import com.ms.user.application.api.DTO.UserRequest;
import com.ms.user.application.api.DTO.UserResponse;
import com.ms.user.application.repository.UserRepository;
import com.ms.user.model.User;
import com.ms.user.producers.UserProducer;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserApplicationService implements UserService {
	
	private final UserRepository userRepository;
	
	private final UserProducer userProducer;
	
	@Transactional
	public UserResponse save(@Valid UserRequest userRequest) {
		User user = userRepository.save(new User(userRequest));
		userProducer.publishEmail(user);
		return UserResponse.builder().userId(user.getUserId()).build();
	}

}
