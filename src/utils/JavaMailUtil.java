/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 21650
 */
public class JavaMailUtil {
    public static void sendMail(String recepient , String is_verified ) throws Exception
    {
         System.out.println("prepairing to sent email");
        Properties properties =new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String myAccountEmail = "hayacampi@gmail.com";
        String myAccountPassword="hayacampi12345";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, myAccountPassword); //To change body of generated methods, choose Tools | Templates.
            }

        
        });
        Message message = prepareMessage(session, myAccountEmail, recepient, is_verified);
       // Transport.send(message);
        Transport.send(message);
       System.out.println("Message sent successfuly");
        
    }
    private static Message prepareMessage(Session session, String myAccountEmail,String recepient, String is_verified ){
  
        try {
            Message message= new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Activation du compte");
            message.setText("wellcome to HayaCampi click on the link below to activate your acount \n http://127.0.0.1:8000/activation/"+is_verified);
            System.out.println("Message set succfuly");
            return message;
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    return null;
    }

    
    
}
