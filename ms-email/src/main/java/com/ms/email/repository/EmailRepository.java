package com.ms.email.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.email.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {

}
