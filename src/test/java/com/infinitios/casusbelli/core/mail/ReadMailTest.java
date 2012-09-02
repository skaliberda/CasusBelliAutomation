package com.infinitios.casusbelli.core.mail;

import org.testng.annotations.Test;

public class ReadMailTest {
	
//	@Test(groups = { "system" })
//	@Test(groups = { "dev" })
	public void testReservation() throws Exception {
		String email = "test.cara.ordering@gmail.com";
        String passwordForemail = "carapassword";
        String host_email = "smtp.gmail.com";
        String provider = "gmail.com";
        Mail mailBox = new Mail();
        mailBox.receiveEmailWithActivationLink(email, passwordForemail, "a6253546523656", "aaa@aaa.aaa");
	}
	
}