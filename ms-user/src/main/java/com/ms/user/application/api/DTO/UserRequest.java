package com.ms.user.application.api.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserRequest {
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
}
