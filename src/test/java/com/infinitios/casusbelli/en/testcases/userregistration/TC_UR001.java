package com.infinitios.casusbelli.en.testcases.userregistration;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.web.structure.en.pages.HomePage;
import com.infinitios.casusbelli.web.structure.en.pages.RegisterPage;

public class TC_UR001 extends TestCase {

//	@Test(groups = { "smoke" })
//	@Test(groups = { "dev" })
	public void testReservation() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		RegisterPage registerPage = homePage.signUp();
		registerPage.verify();

	}
}
