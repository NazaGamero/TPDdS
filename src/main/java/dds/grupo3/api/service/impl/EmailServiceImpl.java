package dds.grupo3.api.service.impl;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import dds.grupo3.api.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	@Override
	public void enviarMensaje(String destinatario, String texto) {

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");

		String remitente = "mihuellaapp2022@gmail.com";
		String password = "zxcnzdxudkgljanm";

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remitente, password);
			}
		});
		Message message = prepareMessage(session,remitente,destinatario,texto);
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private static Message prepareMessage(Session session, String myAccount,String recipient,String texto) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipients(
					Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject("Notificacion Mi Huella App");
			message.setText(texto);
			return message;
		}
		catch (Exception exception){
			Logger.getLogger(EmailServiceImpl.class.getName()).log(Level.SEVERE,null,exception);
		}
		return null;
	}

}

