package com.companyname.casusbelli.web.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.companyname.casusbelli.web.elements.NavigationElement;
import com.companyname.casusbelli.web.structure.BasePage;

public class ConfiguratorComponent extends BasePage {
	
	private NavigationElement missileLauncherButton = getNavigationElement("//div[contains(@class, 'rocket-launcher-1_i')]");
	private NavigationElement rocketL1Button = getNavigationElement("//div[@id='store-equipment-id-1027722']");
//	private NavigationElement rocketLauncherSlotButton = getNavigationElement("//div[@id='slots-equipment-id-1018900']");
	private WebElement rocketLauncherSlotButton = driver.findElement(By.xpath("//div[@id='slots-equipment-id-1018900']"));
	
	
	public ConfiguratorComponent(EventFiringWebDriver driver) {
		super(driver);
		log.info("Configurator Component is opened");
	}

	public void selectMissileLauncher() throws Exception {
		missileLauncherButton.waitForElement();
		assertThis("Missile Launcher button is absent on Dock page", missileLauncherButton.isElementPresent());
		missileLauncherButton.doubleClick();		
	}

	public void equipRocketL1() throws Exception {
		rocketL1Button.waitForElement();
		assertThis("Rocket L1 button is absent on Dock page", rocketL1Button.isElementPresent());
		rocketL1Button.drugAndDrop(rocketLauncherSlotButton);		
	}
}