package com.infinitios.casusbelli.web.structure.en.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.infinitios.casusbelli.web.elements.JSExecutor;
import com.infinitios.casusbelli.web.elements.NavigationElement;
import com.infinitios.casusbelli.web.elements.OutputElement;
import com.infinitios.casusbelli.web.structure.BasePage;

public class SpacePage extends BasePage {
	private NavigationElement spaceLogOutButton = getNavigationElement("//div[@class='exit float-left tooltip']");
	private JSExecutor spaceCanvas = getJSExecutor("#canvas");
	
	private OutputElement velocityIndicator = getOutputElement("//div[@data='velocity']");
//	for scrolling
	private JSExecutor zoomWrapper = getJSExecutor("div.zoom-handle");//
	
//	for watching borders
	private NavigationElement continueQuestButton = getNavigationElement("//div[text()='Continue']");
	
//	verify precence of enemy characteristics
	private NavigationElement allCharacteristics = getNavigationElement("//canvas[@id='canvas-target']");
	private OutputElement enemyShipName = getOutputElement("//div[@class='ship']/div[@class='name']");
	
//	go to theouter space
	private NavigationElement outerSpaceButton = getNavigationElement("//div[contains(text(),'Go to Outer Space')]");
	
	public SpacePage(EventFiringWebDriver driver) {
		super(driver);
		log.info("Space page is opened");
	}
	
	public void verify(){
		assertThis("Current page title: "+ driver.getTitle() + " is not equals to the expected: Casus-Belli", driver.getTitle().equals("Casus-Belli"));
	}

	public void accelerateTo100miles() throws Exception {
		velocityIndicator.waitForElement();
		assertThis("Velocity indicator is absent on Space page", velocityIndicator.isElementPresent());
//		Thread.sleep(3000);
		spaceCanvas.clickAtCoordinates(100, 100);
		Thread.sleep(1000);
		for(int i=0; i<20; i++){
			int currentVelocity = Integer.parseInt(velocityIndicator.getTextValue().split(" ")[0]);
			System.out.println("Current velocity = " + currentVelocity);
			if(currentVelocity>100){
				keys.pressSpace();
				break;
			}
			Thread.sleep(500);
		}
		Thread.sleep(3000);
		
	}

	public void logOutFromSpace() throws Exception {
		spaceLogOutButton.waitForElement();
		assertThis("Space log out button is absent on Space page", spaceLogOutButton.isElementPresent());
		spaceLogOutButton.click();
	}

	public void goToTheCheckPoint() throws Exception {
		velocityIndicator.waitForElement();
		assertThis("Velocity indicator is absent on Space page", velocityIndicator.isElementPresent());
		spaceCanvas.clickAtCoordinates(spaceCanvas.getNearestCheckPointLeftCoordinate(), spaceCanvas.getNearestCheckPointTopCoordinate());
//		while(spaceCanvas.getNearestCheckPointLeftCoordinate()>0||spaceCanvas.getNearestCheckPointTopCoordinate()>0){
			for(int i=0; i<20; i++){
				int currentVelocity = Integer.parseInt(velocityIndicator.getTextValue().split(" ")[0]);
				System.out.println("Current velocity = " + currentVelocity);
				if(currentVelocity>400){
					keys.pressSpace();
					break;
				}
				Thread.sleep(500);
			}
//		}
		
//		for(int i=0; )
		
	}

	public void zoomTheSpace() throws Exception {
//		zoomWrapper.waitForElement();
//		assertThis("Zoom element on the left side is absent on Space page", zoomWrapper.isElementPresent());
		Thread.sleep(3000);
		zoomWrapper.clickAtCoordinates(50, 0);
		
	}

	public void continueTutorial() throws Exception {
		continueQuestButton.waitForElement();
		assertThis("Continue button on tutorial section is absent on Space page", continueQuestButton.isElementPresent());
		continueQuestButton.click();
	}

	public void lookArround() {
//	Hold left mouse button and move up/down, left/right to look around.
		
	}

	public void launchTheMissile() {
//		Press key 1 to launch the missile. It's flightpath is indicated by blue color
		
	}

	public void turnTheShip() {
//		Now you need to learn how to turn your ship. Press A key to turn counterclockwise or D key to turn clockwise.
		
	}

	public void LaunchMissileOnTarget() {
//		Launch the missile on target by pressing key 1. It's easier then in shooting range. Press A key to to turn counterclockwise or 
//		D key to turn clockwise. Start the fire when I'll highlight the cross point of your missles and c
		
	}

	public void seeEnemyCharacteristics() {
//	Click this ship to see it's characteristics
		
		
	}

	public void verifyPrecenceOfEnemyCharacteristics() throws Exception {
		allCharacteristics.waitForElement();
		assertThis("Enemy characteristics is absent in the left bottom corner on space page", allCharacteristics.isElementPresent());
		assertThis("Enemys name: " + enemyShipName.getTextValue() + "is not equals the expected: Scout A", enemyShipName.getTextValue().equals("Scout A"));
		//Scout A
		
	}

	public void turnTheShipToTheEnemy() {
		// TODO Auto-generated method stub
		
	}

	public void fireOnEnemy() {
//		verify two choices press button 1 or click on missile on right equipment section
		
	}

	public void goToOuterSpace() throws Exception {
		outerSpaceButton.waitForElement();
		assertThis("Go to the Outer space button is absent on space pasge", outerSpaceButton.isElementPresent());
		outerSpaceButton.click();
	}
}