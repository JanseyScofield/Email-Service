package br.scofield_lopes.email_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.scofield_lopes.email_service.dtos.EmailDto;
import br.scofield_lopes.email_service.dtos.ResponseSendEmailDto;
import br.scofield_lopes.email_service.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	private EmailService emailService;
	
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@PostMapping("send")
	public ResponseEntity<ResponseSendEmailDto> sendEmail(@RequestBody EmailDto data){
		return new ResponseEntity<ResponseSendEmailDto>(this.emailService.sendEmail(data), HttpStatus.CREATED);
	}
}
