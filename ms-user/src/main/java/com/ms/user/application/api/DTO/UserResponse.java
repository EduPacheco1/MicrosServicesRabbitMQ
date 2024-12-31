package com.ms.user.application.api.DTO;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {

	private UUID userId;
}
