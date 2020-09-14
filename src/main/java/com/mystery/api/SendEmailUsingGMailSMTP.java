package com.mystery.api;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Value;

public class SendEmailUsingGMailSMTP {
	
	 @Value("${mail.smtpsetting}")
	 private String smtpsetting;

	public void forgotPassword(String email, String link, String emailfrom,String emailusername,String emailpassword) {
	// Recipient's email ID needs to be mentioned.
	String to = email;
	String emailBody = "To change your password, click the below link:" + link;
	// Sender's email ID needs to be mentioned
	String from = emailfrom;// change accordingly
	final String username = emailusername; // change accordingly
	final String password = emailpassword; // change accordingly\
	System.out.println("password"+emailpassword);
	String result = null;

	try {

		Properties props = System.getProperties();
		props.setProperty("mail.transport.protocol", "smtp");
		//props.setProperty("mail.host", "smtp.gmail.com");
		props.setProperty("mail.host", "smtp.zoho.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.debug", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session emailSession = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		emailSession.setDebug(true);
		Message msg = new MimeMessage(emailSession);

		msg.setFrom(new InternetAddress(username));
		InternetAddress[] toAddresses = { new InternetAddress(email) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject("Forgot Password");
		// msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(emailBody, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg);

		System.out.println("Successfully sent email");
		// result = "Successfully sent email";

	} catch (MessagingException e) {
		System.out.println("Unable to send email");
	}
}

}
