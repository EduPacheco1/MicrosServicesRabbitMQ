package com.ms.email.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "TB_EMAILS")
public class Email implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private UUID userId;
	
	@Column
	private String emailFrom;
	
	@Column
	private String emailTo;
	
	@Column
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	@Column
	private LocalDateTime sendDataEmail;
	
	@Column
	private StatusEmail statusEmail;
	
}
