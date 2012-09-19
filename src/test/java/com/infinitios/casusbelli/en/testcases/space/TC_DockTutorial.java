package com.infinitios.casusbelli.en.testcases.space;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.utils.Utils;
import com.infinitios.casusbelli.web.en.components.ConfiguratorComponent;
import com.infinitios.casusbelli.web.en.components.ShopComponent;
import com.infinitios.casusbelli.web.structure.en.pages.DockPage;
import com.infinitios.casusbelli.web.structure.en.pages.HomePage;
import com.infinitios.casusbelli.web.structure.en.pages.RegisterPage;

public class TC_DockTutorial extends TestCase {
	
//	@Test(groups = { "smoke" })
	@Test(groups = { "dev" })
	public void test() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		RegisterPage registerPage = homePage.signUp();
		registerPage.verify();
		registerPage.enterEmail(Utils.getUniqueNameForEmail() + "@mailinator.com");
		DockPage dockPage = registerPage.playForFree();
		dockPage.verify();
		currentPage.verifyPrecenceOfMsg("Welcome pilot! Name yourself and earn 100 silvers!");
		dockPage.enterCharacterName("Test_" + Utils.getUniqueUserName());
		currentPage.verifyPrecenceOfMsg("Here you can see how many pilots are in space right now.");
		dockPage.nextTutorial();
		currentPage.verifyPrecenceOfMsg("Money is an important part of a pilot's career! Complete a tutorial and make money on your first purchase.");
		dockPage.nextTutorial();
		currentPage.verifyPrecenceOfMsg("With experience, you can open and buy new weapons in the shop!");
		dockPage.nextTutorial();
		currentPage.verifyPrecenceOfMsg("Pilot! Now you need to equip the ship!");
		dockPage.nextTutorial();		
		currentPage.verifyPrecenceOfMsg("Open Shop and buy one Rocket Launcher. Award: 500 silvers!");
		ShopComponent shopComponent =  dockPage.openShop();
		currentPage.verifyPrecenceOfMsg("Select the category of Turrets & Launchers.");
		shopComponent.openTurretsAndLaunchers();
		currentPage.verifyPrecenceOfMsg("Select the category of Missile Launchers.");
		shopComponent.openMissileLaunchers();
		currentPage.verifyPrecenceOfMsg("Select and buy Rocket Launcher. All the equipment of first level is free of charge.");
		shopComponent.selectMissileLauncherL1();
		currentPage.verifyPrecenceOfMsg("Click this button to buy one Rocket Launcher.");
		shopComponent.buyItem();
		currentPage.verifyPrecenceOfMsg("Each purchase needs your confirmation.");
		shopComponent.confirmBuying();
		currentPage.verifyPrecenceOfMsg("Select the category of Ammunition and projectiles.");
		shopComponent.openAmmunitionAndProjectiles();
		currentPage.verifyPrecenceOfMsg("Select the category of Missiles and torpedoes");
		shopComponent.openMissilesAndTorpedoes();
		currentPage.verifyPrecenceOfMsg("All the charges are worth money. Spent it wisely.");
		shopComponent.selectRocketL1();
		currentPage.verifyPrecenceOfMsg("The more expensive weapon you chose, the more damage will be inflicted.");
		shopComponent.buyItem();
		currentPage.verifyPrecenceOfMsg("Finally you finished your shopping! Let's go to equip your first ship.");
		shopComponent.confirmBuying();
		currentPage.verifyPrecenceOfMsg("Now let's set the weapons in our ship. Open the Configurator and find the unit warehouse!");
		ConfiguratorComponent configuratorComponent =  dockPage.openConfigurator();
		currentPage.verifyPrecenceOfMsg("Double click the Rocket Launcher to install it in slot in the Weapon.");
		configuratorComponent.selectMissileLauncher();
		currentPage.verifyPrecenceOfMsg("Drag the Rockets in slot in the Weapon.");
		configuratorComponent.equipRocketL1();
		currentPage.verifyPrecenceOfMsg("Pilot! Now click `TO SPACE` and make your first flight!");
		dockPage.toSpace();
		currentPage.verifyPrecenceOfMsg("Pilot, the notice was sent to your e-mail. Confirm it to make your first flight!");
	}
}
