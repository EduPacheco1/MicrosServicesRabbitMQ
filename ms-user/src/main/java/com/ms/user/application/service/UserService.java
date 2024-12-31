package com.ms.user.application.service;

import com.ms.user.application.api.DTO.UserRequest;
import com.ms.user.application.api.DTO.UserResponse;

import jakarta.validation.Valid;

public interface UserService {

	UserResponse save(@Valid UserRequest userRequest);

}
