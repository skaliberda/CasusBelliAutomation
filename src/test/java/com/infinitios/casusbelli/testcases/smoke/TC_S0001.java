package com.infinitios.casusbelli.testcases.smoke;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.web.structure.pages.HomePage;

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