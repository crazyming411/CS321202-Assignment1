## API Info

Used API: JavaMail
API Site: http://www.oracle.com/technetwork/java/javamail/

# README


* You will need Apache Maven to open this project.
* Please Check out Maven Plugin for Eclipse.
* No GUI is provided.

1. All Java Files are placed in: `{$PROJECT_ROOT}/mailClient/src/main/java/crazystudio/mailClient/*.java`

2. Configure `App.java`

	- Set Mail Subject at LINE 15
	- Set Mail Content at LINE 18
   - Set Recipient at LINE 22 (Under `//Set Recipient`)
		- Use `recipients.add("EMAIL_ADDRESS");` to set multiple recipients.
	- Set BCC at LINE 28 (Under `//Set BCC`)
		- Use `recipients.bcc("EMAIL_ADDRESS");` to set multiple bccs.
	- Set Attachments at LINE 34 (Under `//Set Attachment Path`)
      - Use `attachments.add("FULL_PATH_OF_THE_FILE");` to set multiple attachments.

3. `MailCore.java`
	Set your `username` and `password` (LINE 14, 15) for the selected `host` (LINE 12).

4. You will get a message `Successfully sent.` inside the console if the mail is sent successfully.


© Copyright by ChenYu Hsu 2011 All Rights Reserved.
