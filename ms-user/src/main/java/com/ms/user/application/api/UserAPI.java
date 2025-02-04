package com.ms.user.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.application.api.DTO.UserRequest;
import com.ms.user.application.api.DTO.UserResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/user")
public interface UserAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	UserResponse save (@RequestBody @Valid UserRequest userRequest);

}
