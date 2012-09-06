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
	private JSExecutor zoomWrapper = getJSExecutor("div[class*='zoom-wrapper'] > div.body");//
	
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

	public void goToTheFirstPoint() throws Exception {
		velocityIndicator.waitForElement();
		assertThis("Velocity indicator is absent on Space page", velocityIndicator.isElementPresent());
		
		
//		for(int i=0; )
		
	}

	public void zoomTheSpace() throws Exception {
		zoomWrapper.waitForElement();
		assertThis("Zoom element on the left side is absent on Space page", zoomWrapper.isElementPresent());
		zoomWrapper.clickAtCoordinates(2, 100);
		
	}
}