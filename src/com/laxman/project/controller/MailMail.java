package com.laxman.project.controller;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
 
public class MailMail{
	private MailSender mailSender;
 
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
 
	public void sendMail(String from, String[] receivers, String subject, String msg) {
 
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(from);
		message.setTo(receivers);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);	
	}
}