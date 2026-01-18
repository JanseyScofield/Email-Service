package br.scofield_lopes.email_service.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.scofield_lopes.email_service.dtos.EmailDto;
import br.scofield_lopes.email_service.dtos.ResponseSendEmailDto;
import br.scofield_lopes.email_service.enums.EmailStatus;

@Service
public class EmailService {
	
	private JavaMailSender emailSender;
	
	public EmailService(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}
	
	public ResponseSendEmailDto sendEmail(EmailDto data) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(data.mailFrom());
		message.setTo(data.mailTo());
		message.setSubject(data.mailSubject());
		message.setText(data.mailBody());		
		emailSender.send(message);
		return new ResponseSendEmailDto(EmailStatus.SENT, "E-mail to " + data.mailTo() + " has sent!");
	}
}
