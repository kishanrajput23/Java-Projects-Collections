package servlet;


import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

class emailsender {

    public static void send(String to, String sub, String msg) {

        String host = "smtp.gmail.com";
        String from = "gursangeet@gmail.com";
        String epass = "sran1997";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true"); // added this line
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", epass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        // Get the default Session object.
        Session sessions = Session.getInstance(props, null);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(sessions);

            // Set sender
            message.setFrom(new InternetAddress("Senders_EMail_Id"));

            // Set recipient
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(sub);

            // set content and define type
            message.setContent(msg, "text/html; charset=utf-8");

            Transport transport = sessions.getTransport("smtp");
            transport.connect(host, from, epass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException mex) {
            System.out.println(mex.getLocalizedMessage());

        }
    }
}
