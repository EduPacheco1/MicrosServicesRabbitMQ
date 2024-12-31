package com.ms.user.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.user.model.User;

public interface UserSpringDataJpaRepository extends JpaRepository<User, UUID> {

}
