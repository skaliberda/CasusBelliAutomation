package com.infinitios.casusbelli.en.testcases.demo;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.web.structure.en.pages.DockPage;
import com.infinitios.casusbelli.web.structure.en.pages.HomePage;

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
