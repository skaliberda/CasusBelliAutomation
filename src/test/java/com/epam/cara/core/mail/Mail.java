package com.epam.cara.core.mail;

import java.io.IOException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;

public class Mail extends BaseMail {

	private String activationLink = null; // Activation link for new user
	private boolean messageContainsLetter = false;
	private int startNumber = 0;

	public String receiveEmailWithActivationLink(String email, String passwordForEmail, String orderName, String guestEmail)	throws Exception {

		Message[] messages = this.openInboxFolder(email, passwordForEmail).getMessages(); // Receiving messages from Inbox folder
		if(messages.length<40){
			startNumber = 0;
		}else{
			startNumber = messages.length - 40;
		}
		
		for (int i = startNumber; i < messages.length; i++) {
			this.cleanMessageContent();
			String subject = messages[i].getSubject().toString().toLowerCase().trim(); // get current message Subject
			String letterConfirmationSubject = "group order invitation"; // expected message subject 
			System.out.println("Message[" + i + "] has subject" + subject);
			if (!this.verifySubject(subject,letterConfirmationSubject)) {
				System.err.println("Message is skipped. Because this is not activation letter");
				continue;
			}

			System.out.println("Message is processing! ");

			String content = this.getMessageContent(messages[i]);
			 
//			System.out.println("CONTENT: " + content);
			
//			Verification if letter contains our unique identity 
//			CharSequence searchOrderName = orderName;
			if (content.contains(orderName)) {
				System.out.println("OK. Letter contains our unique Order Name: " + orderName);
			} else {
				System.err.println("ERROR: Letter does not contains our unique Order Name: " + orderName);
				continue;
			}
				
			String to = InternetAddress.toString( messages[i].getRecipients(Message.RecipientType.TO));
			
			if (this.verifyToField(to, guestEmail)) {
				System.out.println("OK. Current recipient is correct: " + to);
			} else {
				System.err.println("ERROR: Current recipient is incorrect: " + to);
				continue;
			}
			
//			System.out.println("Letter Content: " + sBody);

			// Check if activation link is here
			CharSequence searchPhrase = "http://epuadnist0000v9/order/order/group/member/accept?";
			if (this.verifyPhraseInMessageContent(content, searchPhrase)) {
				System.out.println("OK. Letter contains activation link");
			} else {
				System.err.println("ERROR: Letter does not contains activation link");
				continue;
			}
			
			int indexOf = content.lastIndexOf("http://epuadnist0000v9/order/order/group/member/accept?");
			int lastIndexOf = content.lastIndexOf(">here</a> to start your order") - 1;

			System.out.println("indexOf: " + indexOf);
			System.out.println("lastIndexOf: " + lastIndexOf);
			// Getting activation link from letter
			this.activationLink = content.substring(indexOf, lastIndexOf).trim();

		}
		
		this.closeInboxFolder();
		return activationLink;
	}

	public boolean verifyConfirmationLetter(String email, String passwordForEmail, String confirmationNumber, String guestEmail) throws MessagingException, IOException {
		Message[] messages = this.openInboxFolder(email, passwordForEmail).getMessages(); // Receiving messages from Inbox folder
		
		if(messages.length<40){
			startNumber = 0;
		}else{
			startNumber = messages.length - 40;
		}
		
		
		for (int i = startNumber; i < messages.length; i++) {
			this.cleanMessageContent();
			
			String subject = messages[i].getSubject().toString().toLowerCase().trim(); // get current message Subject
			String letterConfirmationSubject = "order confirmation"; // expected message subject 

			if (!this.verifySubject(subject,letterConfirmationSubject)) {
				System.err.println("Message is skipped. Because this is not confirmation letter");
				continue;
			}

			System.out.println("Message is processing! ");
			String content = this.getMessageContent(messages[i]);
			
//			System.out.println("CONTENT: " + content);
			
			String to = InternetAddress.toString( messages[i].getRecipients(Message.RecipientType.TO));
			
			if (this.verifyToField(to, guestEmail)) {
				System.out.println("OK. Current recipient is correct: " + to);
			} else {
				System.err.println("ERROR: Current recipient is incorrect: " + to);
				continue;
			}
			
//			System.out.println("Letter Content: " + sBody);

			// Check if confirmation number is here
			if (this.verifyPhraseInMessageContent(content, confirmationNumber)) {
				System.out.println("OK. Letter contains confirmation number");
			} else {
				System.err.println("ERROR: Letter does not contains confirmation number");
				continue;
			}
			messageContainsLetter = true;
		}
		this.closeInboxFolder();
		if(messageContainsLetter){
			return true;
		}else{
			return false;
		}
	}
}