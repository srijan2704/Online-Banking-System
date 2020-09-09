package com.isb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SendEmail {

	@Autowired
	private MailSender mailSender;
	
	public void Mailer(String email, String info) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("isbBankCustomerService@gmail.com");
		message.setTo(email);
		message.setSubject("Donot Reply To This Mail");
		message.setText("Greetings, "+info);
		mailSender.send(message);
		System.out.println("Mail sent");
	}
}
