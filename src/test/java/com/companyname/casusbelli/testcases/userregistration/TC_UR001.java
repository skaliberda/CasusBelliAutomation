package com.companyname.casusbelli.testcases.userregistration;

import org.testng.annotations.Test;
import com.companyname.casusbelli.core.TestCase;
import com.companyname.casusbelli.web.structure.pages.HomePage;
import com.companyname.casusbelli.web.structure.pages.RegisterPage;

public class TC_UR001 extends TestCase {

//	@Test(groups = { "smoke" })
	@Test(groups = { "dev" })
	public void testReservation() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		RegisterPage registerPage = homePage.signUp();
		registerPage.verify();

	}
}
