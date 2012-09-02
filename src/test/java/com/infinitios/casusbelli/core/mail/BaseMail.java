package com.infinitios.casusbelli.core.mail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

public class BaseMail {

	private Folder inbox = null;
	private Store store = null;
	private String sBody = null;
	
	private static boolean textIsHtml;
	
	protected Folder openInboxFolder(String email, String passwordForEmail) throws MessagingException{
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		Session session = Session.getDefaultInstance(props, null);
		store = session.getStore("imaps");
		store.connect("imap.gmail.com", email, passwordForEmail);
//		System.out.println(store);

		inbox = store.getFolder("Inbox");
		if (inbox == null) {
			System.out.println("No INBOX");
			System.exit(1);
		}

		inbox.open(Folder.READ_ONLY);

		System.out.println("MESSAGE COUNT: " + inbox.getMessageCount());
		return inbox;
	}
	
	protected void closeInboxFolder() throws MessagingException{
		inbox.close(false);
		store.close();
	}
	
	
	protected boolean verifySubject(String currentSubject, String expectedSubject){

		System.out.println("CURRENT SUBJECT: " + currentSubject); 
		System.out.println("EXPECTED SUBJECT: " + expectedSubject);
		if (currentSubject.contains(expectedSubject)) {
			return true;
		}
		return false;
	}
	
	protected boolean verifyToField(String currentTo, String expectedTo){
		System.out.println("CURRENT TO FIELD: " + currentTo); 
		System.out.println("EXPECTED TO FIELD: " + expectedTo);
		if (currentTo.equals(expectedTo)) {
			return true;
		}
		return false;

	}
	
	protected boolean verifyPhraseInMessageContent(String content, CharSequence searchPhrase){	
		if (content.contains(searchPhrase)) {
			return true;
		} 
		return false;
	}
	
	protected String getMessageContent(Message message) throws IOException, MessagingException{
		try {
			Multipart multipart = (Multipart) message.getContent();
			for (int x = 0; x < multipart.getCount(); x++) {
				BodyPart bodyPart = multipart.getBodyPart(x);
				String sMultiBody = getText(bodyPart);
				sBody = sBody + sMultiBody;
			}
			 return sBody;
		} catch (ClassCastException e) {
			sBody = (String) message.getContent();
			System.out.println(sBody);
			 return sBody;
		}
	}
	
	protected void cleanMessageContent(){
		sBody = null;		
	}
	
	
	@SuppressWarnings("unused")
	protected static String getText(Part p) throws MessagingException, IOException {

		if (p.isMimeType("text/*")) {
			String s = (String) p.getContent();
			textIsHtml = p.isMimeType("text/html");
			return s;
		}
		if (p.isMimeType("APPLICATION/OCTET-STREAM")) {
			System.out.println("Mail have some attachment : ");
			DataHandler handler = p.getDataHandler();
			return "file name : " + handler.getName();
		}

		if (p.isMimeType("multipart/alternative")) {
			// prefer html text over plain text
			Multipart mp = (Multipart) p.getContent();
			ArrayList<String> strOut = new ArrayList<String>();
			String text = null;
			for (int i = 0; i < mp.getCount(); i++) {
				Part bp = mp.getBodyPart(i);
				if (bp.isMimeType("text/plain")) {
					if (text == null)
						text = getText(bp);
					strOut.add(text);
				} else if (bp.isMimeType("text/html")) {
					String s = getText(bp);
					if (s != null)
						strOut.add(s);
				} else {
					strOut.add(getText(bp));
				}
			}
			return strOut.toString();
		} else if (p.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) p.getContent();

			for (int i = 0; i < mp.getCount(); i++) {
				String s = getText(mp.getBodyPart(i));
				if (s != null)
					return s;
			}
		}
		return null;
	}

}
