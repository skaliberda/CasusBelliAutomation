package com.infinitios.casusbelli.en.testcases.space;

import org.testng.annotations.Test;

import com.infinitios.casusbelli.core.TestCase;
import com.infinitios.casusbelli.web.structure.en.pages.DockPage;
import com.infinitios.casusbelli.web.structure.en.pages.HomePage;
import com.infinitios.casusbelli.web.structure.en.pages.SpacePage;

public class TC_FirstSpaceQuest extends TestCase {

	@Test(groups = { "dev" })
	public void test() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.verify();
		homePage.login("usercas@mailinator.com", "password1");
		homePage.changeLanguageTo("en");
		DockPage dockPage = homePage.play();
		SpacePage spacePage = dockPage.toSpace();
		Thread.sleep(3000);
//		spacePage.verify();
//		spacePage.accelerateTo100miles();
		currentPage.verifyPrecenceOfMsg("You can zoom in or out the game screen with the ");//Implement me
		spacePage.zoomTheSpace();
		currentPage.verifyPrecenceOfMsg("Watch the borders of polygon.");
		spacePage.goToTheFirstPoint();
		spacePage.logOutFromSpace();
		
		
	}
}
