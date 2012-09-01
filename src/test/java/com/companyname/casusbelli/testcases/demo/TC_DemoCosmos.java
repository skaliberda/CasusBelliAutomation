package com.companyname.casusbelli.testcases.demo;

import org.testng.annotations.Test;

import com.companyname.casusbelli.core.TestCase;
import com.companyname.casusbelli.web.structure.pages.DockPage;
import com.companyname.casusbelli.web.structure.pages.HomePage;

public class TC_DemoCosmos extends TestCase {
	
	@Test(groups = { "dev" })
	public void test() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		homePage.login("archyyudin@mailinator.com", "ares94080");
		DockPage dockPage = homePage.play();
		dockPage.toSpace();
		
	}
}
