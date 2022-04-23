package com.romario.aulao.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.romario.aulao.domain.Pedido;

public interface EmailService {

	void sendOrderConfimationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	
	/*
	 * void sendOrderConfirmationHtmlEmail(Pedido obj);
	 * 
	 * 
	 * vo
	 //id sendHtmlEmail(MimeMessage msg);
	*/
}
