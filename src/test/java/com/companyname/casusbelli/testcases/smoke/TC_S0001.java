package com.companyname.casusbelli.testcases.smoke;

import org.testng.annotations.Test;

import com.companyname.casusbelli.core.TestCase;
import com.companyname.casusbelli.web.structure.pages.HomePage;

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