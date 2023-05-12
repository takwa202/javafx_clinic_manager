/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.util.*;  
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
//https://myaccount.google.com/lesssecureapps?pli=1&rapt=AEjHL4Mpxdj9L1D6YwAyiU8G-4SE3ztypf1dI2odpN9qMY6R4CPxViRqPXFesShaH866N1ywwCE2PgbvNJb8vrYDXKgppB0RLQ
/**
 *
 * @author lenovo
 */
public class Mail {

    public Mail() {
    }
    
    
  public void mail(String msg,String Subj,String to){ 
      
    String host="smtp.gmail.com";  
  final String user="tabibiapp8@gmail.com";//change accordingly  
  final String password="oouqsueogwkcphyn";//change accordingly  
  final String  port ="587";
    
  //String to="takwalassoued066@gmail.com";//change accordingly  
  System.out.println("prepering to send mail");
   //Get the session object  
    Properties props = new Properties();  
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.auth", "true");  
   props.put("mail.smtp.starttls.enable", "true"); 
   props.put("mail.smtp.port", port);
     props.put("mail.smtp.ssl.trust","smtp.gmail.com");
       //props.put("mail.smtp.ssl.trust","mail.man.com");
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject(Subj);  
     message.setText(msg);  
       
    //send the message  
     Transport.send(message);  
  
     System.out.println(msg);  
   
     } catch (MessagingException e) {e.printStackTrace();}  
 }  
    
}
