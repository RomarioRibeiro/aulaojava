package com.romario.aulao.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

import com.romario.aulao.domain.Cliente;
import com.romario.aulao.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {
	
	
	@Value("${default.sender}")
	private String sander;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendOrderConfimationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
		
	}

	private SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sander);
		sm.setSubject("Pedido confirmado! Codigo: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	@Override
	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(cliente, newPass);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(cliente.getEmail());
		sm.setFrom(sander);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}
	
	/*
	 * protected String htmlFromTemplatePedido(Pedido obj) { Context context = new
	 * Context(); context.setVariable("pedido", obj); return
	 * templateEngine.process("email/confirmacaoPedido", context); }
	 */

	/*
	 * @Override public void sendOrderConfirmationHtmlEmail(Pedido obj) { try {
	 * MimeMessage mm = prepareMimeMessageFromPedido(obj); sendHtmlEmail(mm); }
	 * catch (MessagingException e) { sendOrderConfimationEmail(obj); } } protected
	 * MimeMessage prepareMimeMessageFromPedido(Pedido obj) throws
	 * MessagingException { MimeMessage mimeMessage =
	 * javaMailSender.createMimeMessage(); MimeMessageHelper mmh = new
	 * MimeMessageHelper(mimeMessage, true); mmh.setTo(obj.getCliente().getEmail());
	 * mmh.setFrom(sander); mmh.setSubject("Pedido confirmado! Código: " +
	 * obj.getId()); mmh.setSentDate(new Date(System.currentTimeMillis()));
	 * mmh.setText(htmlFromTemplatePedido(obj), true); return mimeMessage; }
	 */
}
