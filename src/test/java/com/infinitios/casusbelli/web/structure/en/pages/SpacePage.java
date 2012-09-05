package com.infinitios.casusbelli.web.structure.en.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.infinitios.casusbelli.web.elements.AbstractElement;
import com.infinitios.casusbelli.web.elements.NavigationElement;
import com.infinitios.casusbelli.web.elements.OutputElement;
import com.infinitios.casusbelli.web.structure.BasePage;

public class SpacePage extends BasePage {
	private NavigationElement spaceLogOutButton = getNavigationElement("//div[@class='exit float-left tooltip']");
	private AbstractElement spaceCanvas = getNavigationElement("//canvas[@id='canvas']");
	
	private OutputElement velocityIndicator = getOutputElement("//div[@data='velocity']");

	public SpacePage(EventFiringWebDriver driver) {
		super(driver);
		log.info("Space page is opened");
	}
	
	public void verify(){
		assertThis("Current page title: "+ driver.getTitle() + " is not equals to the expected: Casus-Belli", driver.getTitle().equals("Casus-Belli"));
	}

	public void accelerateTo100miles() throws InterruptedException {
		Thread.sleep(3000);
		spaceCanvas.clickAtCoordinates(100, 100);
		Thread.sleep(1000);
		for(int i=0; i<20; i++){
			int currentVelocity = Integer.parseInt(velocityIndicator.getTextValue().split(" ")[0]);
			System.out.println("Value after split = " + currentVelocity);
			if(currentVelocity>100){
				spaceCanvas.pressSpace();
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
	
	

}
