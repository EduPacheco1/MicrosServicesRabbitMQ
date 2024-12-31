package com.ms.user.infra;

import org.springframework.stereotype.Repository;

import com.ms.user.application.repository.UserRepository;
import com.ms.user.model.User;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserInfraRepository implements UserRepository {

	private final UserSpringDataJpaRepository userSpringDataJpaRepository;
	@Override
	public User save(User user) {
		userSpringDataJpaRepository.save(user);
		return user;
	}

}
