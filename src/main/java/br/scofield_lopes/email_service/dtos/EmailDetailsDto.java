package br.scofield_lopes.email_service.dtos;

import java.time.LocalDateTime;

import br.scofield_lopes.email_service.entities.Email;

public record EmailDetailsDto
(
		long id, 
		String mailFrom, 
		String mailTo, 
		String mailSubject, 
		String mailBody, 
		LocalDateTime mailSendAt
) {
	public EmailDetailsDto(Email emailModel) {
		this(emailModel.getId(), 
			 emailModel.getMailFrom(), 
			 emailModel.getMailTo(), 
			 emailModel.getMailSubject(), 
			 emailModel.getMailBody(),
			 emailModel.getSendAt());
	}
}
