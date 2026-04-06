package punto_4_1.main;

import punto_4_1.interfaces.Mensajero;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender implements Mensajero {
    private final String from;
    private final String username;
    private final String password;
    private final String host;

    public EmailSender(String from, String username, String password, String host) {
        this.from = from;
        this.username = username;
        this.password = password;
        this.host = host;
    }

    @Override
    public void enviarMensaje(String to, String subject, String text) {
        // configure SMTP details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // create the mail Session object
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // create a MimeMessage object
            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(from));
            // set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // set email subject field
            message.setSubject(subject);
            // set the content of the email message
            message.setText(text);

            // send the email message
            Transport.send(message);

            System.out.println("Email Message Sent Successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
