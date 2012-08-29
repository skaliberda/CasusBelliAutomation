package com.epam.cara.testcases.smoke;

import org.testng.annotations.Test;

import com.epam.cara.core.TestCase;
import com.epam.cara.web.structure.pages.HomePage;

public class TC_S0001 extends TestCase {

//	private HomePage homePage = PageFactory.initElements(getWebDriver(),
//			HomePage.class);
	
//	@Test(groups = { "smoke" })
//	@Test(groups = { "dev" })
	public void testReservation() throws Exception {
		HomePage homePage = new HomePage(driver);  
//		OrderSetupPage cUP = homePage.loginAs(null, null);
	}
}