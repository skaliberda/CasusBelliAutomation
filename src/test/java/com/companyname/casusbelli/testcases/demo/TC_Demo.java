package com.companyname.casusbelli.testcases.demo;

import org.testng.annotations.Test;

import com.companyname.casusbelli.core.TestCase;
import com.companyname.casusbelli.web.components.ShopComponent;
import com.companyname.casusbelli.web.structure.pages.DockPage;
import com.companyname.casusbelli.web.structure.pages.HomePage;
import com.companyname.casusbelli.web.structure.pages.RegisterPage;

public class TC_Demo extends TestCase {
	
//	@Test(groups = { "smoke" })
	@Test(groups = { "dev" })
	public void testReservation() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		RegisterPage registerPage = homePage.signUp();
		registerPage.verify();
		registerPage.enterEmail("test3h1ty@mailinator.com");
		DockPage dockPage = registerPage.playForFree();
		dockPage.verify();
		dockPage.enterCharacterName("Space_user2");
		dockPage.nextTutorial();
		dockPage.nextTutorial();
		dockPage.nextTutorial();
		dockPage.nextTutorial();
		ShopComponent shopComponent =  dockPage.openShop();
		shopComponent.openTurretsAndLaunchers();
		shopComponent.openMissileLaunchers();
		shopComponent.selectMissileLauncherL1();
		shopComponent.buyItem();
		shopComponent.confirmBuying();
	}
}