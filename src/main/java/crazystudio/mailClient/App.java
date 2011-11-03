package crazystudio.mailClient;

import java.util.*;


public class App 
{
    public static void main( String[] args )
    {
        MailCore sender=new MailCore();
        
        String[] mailInfo=new String[2];
        
        //Set Subject
        mailInfo[0]="Subject";
        
        //Set Content
        mailInfo[1]="Content";
        
        ArrayList<String> recipients=new ArrayList<String>();
        //Set Recipient
        recipients.add("example1@example.com");
        recipients.add("example2@example.com");
        //Set as much as you want.
        
        ArrayList<String> bcc=new ArrayList<String>();
        //Set BCC
        bcc.add("example3@example.com");
        bcc.add("example4@example.com");
        //Set as much as you want.
        
        ArrayList<String> attachments=new ArrayList<String>();
        //Set Attachment Path
        attachments.add("/FULL_PATH_OF_THE_FILE/example1.sh");
        attachments.add("/FULL_PATH_OF_THE_FILE/example2.sh");
        //Set as much as you want (total size < 50MB)
        
        String[] attachmentsArray= attachments.toArray(new String[attachments.size()]);
        String[] recipientsArray= recipients.toArray(new String[recipients.size()]);
        String[] bccArray= bcc.toArray(new String[bcc.size()]);
        
        sender.send(mailInfo, recipientsArray, bccArray, attachmentsArray);
    }
}
