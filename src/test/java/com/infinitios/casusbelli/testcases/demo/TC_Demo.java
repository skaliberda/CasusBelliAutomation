package com.infinitios.casusbelli.testcases.demo;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.utils.Utils;
import com.infinitios.casusbelli.web.components.ConfiguratorComponent;
import com.infinitios.casusbelli.web.components.ShopComponent;
import com.infinitios.casusbelli.web.structure.pages.DockPage;
import com.infinitios.casusbelli.web.structure.pages.HomePage;
import com.infinitios.casusbelli.web.structure.pages.RegisterPage;

public class TC_Demo extends TestCase {
	
//	@Test(groups = { "smoke" })
//	@Test(groups = { "dev" })
	public void test() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		RegisterPage registerPage = homePage.signUp();
		registerPage.verify();
		registerPage.enterEmail(Utils.getUniqueNameForEmail() + "@mailinator.com");
		DockPage dockPage = registerPage.playForFree();
		dockPage.verify();
		dockPage.enterCharacterName("Test_" + Utils.getUniqueUserName());
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
		shopComponent.openAmmunitionAndProjectiles();
		shopComponent.openMissilesAndTorpedoes();
		shopComponent.selectRocketL1();
		shopComponent.buyItem();
		shopComponent.confirmBuying();
		ConfiguratorComponent configuratorComponent =  dockPage.openConfigurator();
		configuratorComponent.selectMissileLauncher();
		configuratorComponent.equipRocketL1();
		dockPage.toSpace();
//		TODO: Verify email pop up window
	}
}