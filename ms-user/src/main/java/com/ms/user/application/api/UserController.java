package com.ms.user.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.ms.user.application.api.DTO.UserRequest;
import com.ms.user.application.api.DTO.UserResponse;
import com.ms.user.application.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class UserController implements UserAPI {
	
	private final UserService userService;

	@Override
	public UserResponse save(@Valid UserRequest userRequest) {
		UserResponse save = userService.save(userRequest);
		return save;
	}
	

}
