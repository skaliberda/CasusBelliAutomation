package com.infinitios.casusbelli.web.structure.ru.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.infinitios.casusbelli.web.elements.JSExecutor;
import com.infinitios.casusbelli.web.elements.NavigationElement;
import com.infinitios.casusbelli.web.elements.OutputElement;
import com.infinitios.casusbelli.web.structure.BasePage;

public class SpacePage extends BasePage {
	private NavigationElement spaceLogOutButton = getNavigationElement("//div[contains(@class,'exit')]");
	private JSExecutor spaceCanvas = getJSExecutor("#canvas");
	
	private OutputElement velocityIndicator = getOutputElement("//div[@data='velocity']");
//	for scrolling
	private JSExecutor zoomWrapper = getJSExecutor("");//
	private JSExecutor ship = getJSExecutor("");
	
//	for watching borders
	private NavigationElement continueQuestButton = getNavigationElement("//div[text()='Продолжить']");
	
//	verify precence of enemy characteristics
	private NavigationElement allCharacteristics = getNavigationElement("//canvas[@id='canvas-target']");
	private OutputElement enemyShipName = getOutputElement("//div[@class='ship']/div[@class='name']");
	
//	go to theouter space
	private NavigationElement outerSpaceButton = getNavigationElement("//div[contains(text(),'В открытый космос')]");
	private NavigationElement goDockButton = getNavigationElement("//div[contains(text(),'В Док')]");
	
//	launch a missile
	private NavigationElement missileSlot = getNavigationElement("//div[contains(@class, 'rocket-launcher-1_i')]");
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
		int currentVelocity = 0;
		spaceCanvas.clickAtCoordinates(200, 200);	
		do{
			Thread.sleep(100);
			currentVelocity = Integer.parseInt(velocityIndicator.getTextValue().split(" ")[0]);
//			if(currentVelocity>100){
//				keys.pressSpace();
//				break;
//			}			
		}while(currentVelocity<100);
		keys.pressSpace();
	}

	public void logOutFromSpace() throws Exception {
		spaceLogOutButton.waitForElement();
		assertThis("Space log out button is absent on Space page", spaceLogOutButton.isElementPresent());
		spaceLogOutButton.click();
	}

	public void goToTheCheckPoint() throws Exception {
		velocityIndicator.waitForElement();
		assertThis("Velocity indicator is absent on Space page", velocityIndicator.isElementPresent());
		int currentVelocity = 0;
		int neearestCheckPointCoorX = spaceCanvas.getNearestCheckPointXCoordinate();
		int neearestCheckPointCoorY = spaceCanvas.getNearestCheckPointYCoordinate();
		if(spaceCanvas.isCheckPointPresent()){
			spaceCanvas.clickAtCoordinates(neearestCheckPointCoorX, neearestCheckPointCoorY);
		}else{
			assertThis("Checkpoint is absent on Space page", spaceCanvas.isCheckPointPresent());
		}
		do{
			if(spaceCanvas.isCheckPointPresent()){
				if(neearestCheckPointCoorX==spaceCanvas.getNearestCheckPointXCoordinate()||neearestCheckPointCoorY==spaceCanvas.getNearestCheckPointYCoordinate()){
					if(spaceCanvas.getNearestCheckPointXCoordinate()==ship.getShipStopXCoordinate()||spaceCanvas.getNearestCheckPointYCoordinate()==ship.getShipStopYCoordinate()){
						keys.pressSpace();
						break;
					}
				}else{
					keys.pressSpace();
					break;
				}
			}else{
				keys.pressSpace();
				break;
			}
		}
		while(spaceCanvas.isCheckPointPresent());
		keys.pressSpace();
		do{
			Thread.sleep(100);
			currentVelocity = Integer.parseInt(velocityIndicator.getTextValue().split(" ")[0]);
//			if(currentVelocity>100){
//				keys.pressSpace();
//				break;
//			}			
		}while(currentVelocity>10);
	}

	public void zoomTheSpace() throws Exception {
//		zoomWrapper.waitForElement();
//		assertThis("Zoom element on the left side is absent on Space page", zoomWrapper.isElementPresent());
		zoomWrapper.zoomHalfTheSpace();
		
	}

	public void continueTutorial() throws Exception {
		continueQuestButton.waitForElement();
		assertThis("Continue button on tutorial section is absent on Space page", continueQuestButton.isElementPresent());
		continueQuestButton.click();
	}

	public void lookArround() {
//	Hold left mouse button and move up/down, left/right to look around.
		spaceCanvas.mouseDownAtCoordinates(400, 400);
		spaceCanvas.mouseMoveToCoordinates(200, 200);
		spaceCanvas.mouseReleaseAtCoordinates(200, 200);
	}

	public void launchTheMissileByPressKey1() throws Exception {
//		Press key 1 to launch the missile. It's flightpath is indicated by blue color
		keys.pressSpecificKey("1");
	}
	
	public void launchTheMissileByClickingOnSlot() throws Exception{
		missileSlot.waitForElement();
		assertThis("First slot with missile is absent on Space page", missileSlot.isElementPresent());
		missileSlot.mouseClick();
	}

	public void turnTheShip() throws InterruptedException {
//		Now you need to learn how to turn your ship. Press A key to turn counterclockwise or D key to turn clockwise.
		ship.turnShipClockwise();
		Thread.sleep(8000);
		ship.stopRotateShip();
//		keys.downSpecificKey("D");
//		Thread.sleep(3000);
//		keys.upSpecificKey("D");
	}

	public void LaunchMissileOnTarget() throws Exception {
//		Launch the missile on target by pressing key 1. It's easier then in shooting range. Press A key to to turn counterclockwise or 
//		D key to turn clockwise. Start the fire when I'll highlight the cross point of your missles and c
		ship.turnShipClockwise();
		do{
//			Thread.sleep(500);
			
			if(ship.getAiming()!=0){
//				ship.stopRotateShip();
				this.launchTheMissileByPressKey1();
				break;
			}
			
		}while(spaceCanvas.isCheckPointPresent());
		ship.stopRotateShip();
		this.launchTheMissileByPressKey1();
	}

	public void seeEnemyCharacteristics() {
//	Click this ship to see it's characteristics
//		TestUtils.click('#canvas', TestUtils.getNearestEnemy().x, TestUtils.getNearestEnemy().y)
		spaceCanvas.clickAtCoordinates(spaceCanvas.getNearestEnemyXCoordinate(), spaceCanvas.getNearestEnemyYCoordinate());
	}

	public void verifyPrecenceOfEnemyCharacteristics() throws Exception {
		allCharacteristics.waitForElement();
		assertThis("Enemy characteristics is absent in the left bottom corner on space page", allCharacteristics.isElementPresent());
		assertThis("Enemys name: " + enemyShipName.getTextValue() + "is not equals the expected: Scout A", enemyShipName.getTextValue().equals("Scout A"));

	}

	public void turnTheShipToTheEnemy() {
		ship.turnShipClockwise();
		while(ship.getAiming()==0){
//			System.out.println("Ship rounded");
		}
		ship.stopRotateShip();
		
	}

	public void killEnemy() throws Exception {
//		verify two choices press button 1 or click on missile on right equipment section
//		implement with possibility to check if ship exists and then fire on the ship
		do{
//			Thread.sleep(500);
			ship.turnShipClockwise();
			if(ship.getAiming()!=0){
//				ship.stopRotateShip();
				this.launchTheMissileByPressKey1();
//				break;
			}
			
		}while(spaceCanvas.isEnemyPresent());
		ship.stopRotateShip();
		this.launchTheMissileByPressKey1();
	}

	public void goToOuterSpace() throws Exception {
		outerSpaceButton.waitForElement();
		assertThis("Go to the Outer space button is absent on space pasge", outerSpaceButton.isElementPresent());
		outerSpaceButton.click();
	}

	public void goToDock() throws Exception {
		goDockButton.waitForElement();
		assertThis("Go to the Dock button is absent on space pasge", goDockButton.isElementPresent());
		goDockButton.click();
		
	}

	public void waitForVelocity() throws Exception {
		velocityIndicator.waitForElement();
		assertThis("Velocity indicator is absent on Space page", velocityIndicator.isElementPresent());
		
	}
}