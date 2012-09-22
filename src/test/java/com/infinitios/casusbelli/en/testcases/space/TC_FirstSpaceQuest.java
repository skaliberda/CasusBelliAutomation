package com.infinitios.casusbelli.en.testcases.space;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.web.structure.en.pages.DockPage;
import com.infinitios.casusbelli.web.structure.en.pages.HomePage;
import com.infinitios.casusbelli.web.structure.en.pages.SpacePage;

public class TC_FirstSpaceQuest extends TestCase {

//	@Test(groups = { "dev" })
	public void test() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		homePage.login("fuihjmrxb@mailinator.com", "password1");
		homePage.switchToEnLanguage();
		DockPage dockPage = homePage.play();
		currentPage.verifyPrecenceOfMsg("Pilot! Now click `TO SPACE` and make your first flight!");
		SpacePage spacePage = dockPage.toSpace();
//		First tutorial quest            
		currentPage.verifyPrecenceOfMsg("Change the scale to see the entire polygon.");
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
		currentPage.verifyPrecenceOfMsg("It takes a few seconds to reload the weapons after each shot.");
		spacePage.launchTheMissileByPressKey1();
		currentPage.verifyPrecenceOfMsg("Now you need to learn how to turn your ship.");
		spacePage.turnTheShip();
		currentPage.verifyPrecenceOfMsg("Launch the missile on target by pressing key");
		spacePage.LaunchMissileOnTarget();
		currentPage.verifyPrecenceOfMsg("Check the ammunition left. You can't restock the weapons in space.");
		spacePage.LaunchMissileOnTarget();
//		Fourth tutorial 
		currentPage.verifyPrecenceOfMsg("Click this ship to see its characteristics and flightpath.");
		spacePage.seeEnemyCharacteristics();
		spacePage.verifyPrecenceOfEnemyCharacteristics();
		currentPage.verifyPrecenceOfMsg("The characteristics of an enemy are shown on the left. To my mind it's slow and weak.");
		spacePage.continueTutorial();
		currentPage.verifyPrecenceOfMsg("To start fire turn your ship towards the enemy");
		spacePage.turnTheShipToTheEnemy();
		currentPage.verifyPrecenceOfMsg("Start the fire when I'll highlight the cross point of your missiles and enemy's ship flightpath.");
		spacePage.killEnemy();
		currentPage.verifyPrecenceOfMsg("All Clear! You destroyed it.");
		spacePage.continueTutorial();
//		Fifth tutorial
		currentPage.verifyPrecenceOfMsg("We've got visitor here. Destroy him.");
		spacePage.seeEnemyCharacteristics();
		spacePage.killEnemy();
		currentPage.verifyPrecenceOfMsg("You've completed the last task.");
		spacePage.goToOuterSpace();
		spacePage.logOutFromSpace();		
	}
}
