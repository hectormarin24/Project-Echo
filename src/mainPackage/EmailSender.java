package mainPackage;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class EmailSender {
	private static final String user = "teamechocsus@gmail.com"; // mailer account
	private static final String password = "ynyr yhhs ylfx sxlr"; // this is the actual password
	private final String to;
	private final String subject;
	private final String text;
	
	public EmailSender(String to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	
	public void send() {
		String host = "smtp.gmail.com";
		String port = "587";
		
		Properties prpt = new Properties();
        prpt.put("mail.smtp.auth", "true");
        prpt.put("mail.smtp.starttls.enable", "true");
        prpt.put("mail.smtp.host", host);
        prpt.put("mail.smtp.port", port);
        
        Session session = Session.getInstance(prpt,
            new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);
		
            Transport.send(message);

            System.out.println("Message sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
}
