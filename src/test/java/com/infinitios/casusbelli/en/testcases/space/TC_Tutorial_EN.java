package com.infinitios.casusbelli.en.testcases.space;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.utils.Utils;
import com.infinitios.casusbelli.web.en.components.ConfiguratorComponent;
import com.infinitios.casusbelli.web.en.components.ShopComponent;
import com.infinitios.casusbelli.web.structure.en.pages.DockPage;
import com.infinitios.casusbelli.web.structure.en.pages.HomePage;
import com.infinitios.casusbelli.web.structure.en.pages.RegisterPage;
import com.infinitios.casusbelli.web.structure.en.pages.SpacePage;

public class TC_Tutorial_EN extends TestCase {
	
	@Test(groups = { "space" })
//	@Test(groups = { "dev" })
	public void test() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		RegisterPage registerPage = homePage.signUp();
		registerPage.verify();
		registerPage.enterEmail(Utils.getUniqueNameForEmail() + "@mailinator.com");
		registerPage.enterPassword("password1");
		DockPage dockPage = registerPage.playForFree();
		dockPage.verify();
		currentPage.verifyPrecenceOfMsg("Name yourself. This will be your name known to other pilots.");
		dockPage.enterCharacterName("Test_" + Utils.getUniqueUserName());
		dockPage.nextTutorial();
//		currentPage.verifyPrecenceOfMsg("Here you can see how many pilots are in space right now.");
//		dockPage.nextTutorial();         
//		currentPage.verifyPrecenceOfMsg("Money is an important part of a pilot's career!");
//		dockPage.nextTutorial();
//		currentPage.verifyPrecenceOfMsg("With experience, you can open and buy new weapons in the shop!");
//		dockPage.nextTutorial();
		////////////////////////////////////////////
		currentPage.verifyPrecenceOfMsg("Pilot! Now click `TO SPACE` and make your first flight!");
		SpacePage spacePage = dockPage.toSpace();
//		First tutorial quest
		spacePage.waitForVelocity();
		currentPage.verifyPrecenceOfMsg("Pilot! I'm glad to meet you!");
		spacePage.zoomTheSpace();
		currentPage.verifyPrecenceOfMsg("Watch the borders of polygon.");
		spacePage.continueTutorial();
		currentPage.verifyPrecenceOfMsg("Your aim is to fly through the checkpoint.");
		spacePage.goToTheCheckPoint();
		currentPage.verifyPrecenceOfMsg("Excellent! You've completed the task.");
		spacePage.continueTutorial();
//		Second tutorial quest
		currentPage.verifyPrecenceOfMsg("Couple of useful tips.");
		spacePage.lookArround();
		currentPage.verifyPrecenceOfMsg("Fly through all checkpoints at polygon.");
		spacePage.goToTheCheckPoint();
		spacePage.goToTheCheckPoint();
		currentPage.verifyPrecenceOfMsg("You've completed the task.");
		spacePage.continueTutorial();
//		Third tutorial
		currentPage.verifyPrecenceOfMsg("Press key");
		spacePage.launchTheMissileByPressKey1();
		currentPage.verifyPrecenceOfMsg("Now you need to learn how to turn your ship.");
		spacePage.turnTheShip();
		currentPage.verifyPrecenceOfMsg("Launch the missile on target by pressing key");
		spacePage.LaunchMissileOnTarget();
		currentPage.verifyPrecenceOfMsg("Check the ammunition left. You can't restock the weapons in space.");
		spacePage.LaunchMissileOnTarget();
//		Fourth tutorial 
		currentPage.verifyPrecenceOfMsg("It seems that enemy ship approaches us");
		spacePage.seeEnemyCharacteristics();
		spacePage.verifyPrecenceOfEnemyCharacteristics();
		currentPage.verifyPrecenceOfMsg("The characteristics of an enemy are shown on the left. To my mind it's slow and weak.");
		spacePage.continueTutorial();
		spacePage.turnTheShipToTheEnemy();
		currentPage.verifyPrecenceOfMsg("Start the fire when I'll highlight the cross point of your missiles and enemy's ship flightpath.");
		spacePage.killEnemy();
		currentPage.verifyPrecenceOfMsg("Direct hit");
		spacePage.continueTutorial();
//		Fifth tutorial
		currentPage.verifyPrecenceOfMsg("We've got visitor here. Destroy him.");
		spacePage.seeEnemyCharacteristics();
		spacePage.killEnemy();
		currentPage.verifyPrecenceOfMsg("You've completed the last task.");
//		spacePage.goToOuterSpace();
		spacePage.goToDock();
		currentPage.verifyPrecenceOfMsg("Pilot! Now you need to equip the ship");
		dockPage.nextTutorial();		
		currentPage.verifyPrecenceOfMsg("Open Shop and buy one Rocket Launcher.");
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
		currentPage.verifyPrecenceOfMsg("Now let's set the weapons in our ship.");
		ConfiguratorComponent configuratorComponent =  dockPage.openConfigurator();
		currentPage.verifyPrecenceOfMsg("Double click the Rocket Launcher to install it in slot in the Weapon.");
		configuratorComponent.selectMissileLauncher();
		currentPage.verifyPrecenceOfMsg("Drag the Rockets in slot in the Weapon.");
		configuratorComponent.equipRocketL1();
		currentPage.verifyPrecenceOfMsg("Pilot, you are already expected to the Moon's orbit.");
	}
}