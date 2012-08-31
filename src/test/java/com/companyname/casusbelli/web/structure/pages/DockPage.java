package com.companyname.casusbelli.web.structure.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.companyname.casusbelli.web.components.ConfiguratorComponent;
import com.companyname.casusbelli.web.components.ShopComponent;
import com.companyname.casusbelli.web.elements.InputElement;
import com.companyname.casusbelli.web.elements.NavigationElement;
import com.companyname.casusbelli.web.structure.BasePage;

public class DockPage extends BasePage {
	
	private InputElement characterNameField = getInputElement("//input[@id='character-name']");
	private NavigationElement nextTutorialButton = getNavigationElement("//div[@id='girl-helper']/div[contains(@class, 'button')]");
	private NavigationElement shopLink = getNavigationElement("//a[@id='shop-button']");
	private NavigationElement configuratorLink = getNavigationElement("//a[@id='config-button']");
	private NavigationElement toSpaceLink = getNavigationElement("//a[@id='launch-button']");
	

	public DockPage(EventFiringWebDriver driver) {
		super(driver);
		log.info("Dock page is opened");
	}

	public void enterCharacterName(String characterName) throws Exception {
		characterNameField.waitForElement();
		assertThis("Character Name field is absent on Dock page", characterNameField.isElementPresent());
		characterNameField.typeTextAndPressEnter(characterName);
	}

	public void verify() {
		// TODO Auto-generated method stub
	}

	public void nextTutorial() throws Exception {
		nextTutorialButton.waitForElement();
		assertThis("Next tutorial button is absent on Dock page", nextTutorialButton.isElementPresent());
		nextTutorialButton.click();		
	}

	public ShopComponent openShop() throws Exception {
		shopLink.waitForElement();
		assertThis("Shop link is absent on Dock page", shopLink.isElementPresent());
		shopLink.click();	
		return new ShopComponent(driver);
	}

	public ConfiguratorComponent openConfigurator() throws Exception {
		configuratorLink.waitForElement();
		assertThis("Configuration link is absent on Dock page", configuratorLink.isElementPresent());
		configuratorLink.mouseClick();	
		return new ConfiguratorComponent(driver);
	}
	
	public void toSpace() throws Exception {
		toSpaceLink.waitForElement();
		assertThis("To Space Link is absent on Dock page", toSpaceLink.isElementPresent());
		toSpaceLink.click();	
		
	}
}