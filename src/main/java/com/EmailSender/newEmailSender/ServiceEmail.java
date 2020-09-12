package com.EmailSender.newEmailSender;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Service
public class ServiceEmail
{
    public String sendEmail(String toEmail){
        //authentication info
//        final String username = "yourUsername@email.com";
//        final String password = "password";
        short flage = 0;
        final String username = "charity.application501@gmail.com";
        final String password = "adeel501";
        String fromEmail = "charity.application501@gmail.com";
//        String toEmail = "muzammal.bsse3310@iiu.edu.pk";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username, password);
            }
        });
        //Start our mail message
        MimeMessage msg = new MimeMessage(session);
        try
        {
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Verification Email");

            Multipart emailContent = new MimeMultipart();
            //Text body part
            String text = "Welcome to Food Distribution Application\n" +
                    "Automated generated Email from system.\n" +
                    "Your Account is successfully created but not activated. Now you have to activate your account by clicking given link.\n" +
                    "https://food-distribution-app.herokuapp.com/";
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(text);
            //Attachment body part.
//            MimeBodyPart pdfAttachment = new MimeBodyPart();
//            pdfAttachment.attachFile("/home/parallels/Documents/docs/javamail.pdf");
            //Attach body parts
            emailContent.addBodyPart(textBodyPart);
//            emailContent.addBodyPart(pdfAttachment);

            //Attach multipart to message
            msg.setContent(emailContent);
            Transport.send(msg);
            flage = 1;
        } catch (MessagingException e)
        {
            e.printStackTrace();
        }
        if(flage ==1){
            return "Email sent";
        }
        return "Email error occured";
    }
}
