package crazystudio.mailClient;

import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class MailCore{
	//Change these values if needed.
	String host = "smtpauth.net.nthu.edu.tw";
	
	String username = "s9962210@m99.nthu.edu.tw";
	String password = ""; //Set your password first
	
	String from = username;
	
	public void send(String[] mailInfo, String[] recipients, String[] bcc, String[] attachments){
		try{
			
			Properties props = System.getProperties();
			props.put("mail.smtp.host",host);
			props.put("mail.transport.protocol","smtp");
			props.put("mail.smtp.auth","true");
			
			Session mailSession = Session.getInstance(props,null);
			
			Message mailMsg = new MimeMessage(mailSession);
			
			//Set Basic Information
			mailMsg.setFrom(new InternetAddress(from));
			
			InternetAddress[] recipientsAddress=new InternetAddress[recipients.length];
			for(int i=0; i<recipients.length; i++){
				recipientsAddress[i]=new InternetAddress(recipients[i]);
			}
			mailMsg.setRecipients(Message.RecipientType.TO, recipientsAddress);
			
			InternetAddress[] bccAddress=new InternetAddress[bcc.length];
			for(int i=0; i<bcc.length; i++){
				bccAddress[i]=new InternetAddress(bcc[i]);
			}
			mailMsg.setRecipients(Message.RecipientType.BCC, bccAddress);
			
			mailMsg.setSubject(mailInfo[0]);
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(mailInfo[1]+"\n");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			//Set Attachments
			for(String s:attachments){
				messageBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(s);
				messageBodyPart.setDataHandler(new DataHandler(source));
			
				String fileName=s.substring(s.lastIndexOf('/')+1, s.length()); 
				messageBodyPart.setFileName(fileName);
			
				multipart.addBodyPart(messageBodyPart);
			}
			
			mailMsg.setContent(multipart);
			
			//Send Mail
			Transport transport = mailSession.getTransport("smtp");;
			transport.connect(host, username, password);
			transport.sendMessage(mailMsg,mailMsg.getAllRecipients());
			transport.close();
			System.out.println("Successfully sent.");
		
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}