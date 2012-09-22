package com.infinitios.casusbelli.ru.testcases.space;

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
		homePage.login("kzqivj@mailinator.com", "password1");
		homePage.switchToEnLanguage();
		DockPage dockPage = homePage.play();
		SpacePage spacePage = dockPage.toSpace();
//		spacePage.verify();
//		First Tutorial Quest
		currentPage.verifyPrecenceOfMsg("Your aim is to achieve");
		spacePage.accelerateTo100miles();
//		Second tutorial quest
		currentPage.verifyPrecenceOfMsg("You can zoom in or out the game screen with the ");
		spacePage.zoomTheSpace();
		currentPage.verifyPrecenceOfMsg("Watch the borders of polygon.");
		spacePage.continueTutorial();
		currentPage.verifyPrecenceOfMsg("Your next aim is to fly through the checkpoint.");
		spacePage.goToTheCheckPoint();
		currentPage.verifyPrecenceOfMsg("Excellent! You've completed the task. Your reward is");
		spacePage.continueTutorial();
//		Third tutorial quest
		currentPage.verifyPrecenceOfMsg("and move up/down, left/right to look around");
		spacePage.lookArround();
		spacePage.goToTheCheckPoint();
		currentPage.verifyPrecenceOfMsg("the new area at polygon) to fly through the last checkpoint.");
		spacePage.goToTheCheckPoint();
		currentPage.verifyPrecenceOfMsg("You've completed the task.");
		spacePage.continueTutorial();
//		Fourth tutorial
		currentPage.verifyPrecenceOfMsg("to launch the missile. It's flightpath is indicated by");
		spacePage.launchTheMissileByPressKey1();
		currentPage.verifyPrecenceOfMsg("Now you need to learn how to turn your ship.");
		spacePage.turnTheShip();
		currentPage.verifyPrecenceOfMsg("Launch the missile on target by pressing key");
		spacePage.LaunchMissileOnTarget();
		currentPage.verifyPrecenceOfMsg("Check the ammunition left. You can't restock the weapons in space.");
		spacePage.LaunchMissileOnTarget();
//		fifth tutorial 
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
		currentPage.verifyPrecenceOfMsg("We've got visitor here. Destroy him.");
		spacePage.seeEnemyCharacteristics();
		spacePage.killEnemy();
//		spacePage.killEnemy();//not implemented
		currentPage.verifyPrecenceOfMsg("You've completed the last task.");
		spacePage.goToOuterSpace();
		spacePage.logOutFromSpace();		
	}
}
