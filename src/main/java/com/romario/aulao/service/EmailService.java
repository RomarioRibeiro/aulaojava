package com.romario.aulao.service;

import org.springframework.mail.SimpleMailMessage;

import com.romario.aulao.domain.Cliente;
import com.romario.aulao.domain.Pedido;

public interface EmailService {

	void sendOrderConfimationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
	
	/*
	 * void sendOrderConfirmationHtmlEmail(Pedido obj);
	 * 
	 * 
	 * vo
	 //id sendHtmlEmail(MimeMessage msg);
	*/
}
