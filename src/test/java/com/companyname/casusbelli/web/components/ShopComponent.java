package com.companyname.casusbelli.web.components;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.companyname.casusbelli.web.elements.NavigationElement;
import com.companyname.casusbelli.web.structure.BasePage;

public class ShopComponent extends BasePage {

	private NavigationElement turretsAndLaunchersLink = getNavigationElement("//a[contains(text(), 'Turrets & Launchers')]");
	private NavigationElement missileLaunchersLink = getNavigationElement("//div[contains(text(),'Missile Launchers')]");
	private NavigationElement missileLauncherL1Link = getNavigationElement("//div[@id='shop-items-body']//div[contains(text(), 'Missile Launcher t.Co l1')]");
	private NavigationElement buyItemButton = getNavigationElement("//div[contains(@class,'footer')]//div[contains(text(), 'Buy')]");
	private NavigationElement confirmBuyingItemButton = getNavigationElement("//div[@id='dialog']//div[contains(text(), 'Buy')]");
		
	public ShopComponent(EventFiringWebDriver driver) {
		super(driver);
		log.info("Shop Component is opened");
	}
	
	public void openTurretsAndLaunchers() throws Exception {
		turretsAndLaunchersLink.waitForElement();
		assertThis("Turrets And Launchers link is absent on Shop Component", turretsAndLaunchersLink.isElementPresent());
		turretsAndLaunchersLink.click();	
	}

	public void openMissileLaunchers() throws Exception {
		missileLaunchersLink.waitForElement();
		assertThis("Missile Launchers link is absent on Shop Component", missileLaunchersLink.isElementPresent());
		missileLaunchersLink.click();	
	}

	public void selectMissileLauncherL1() throws Exception {
		missileLauncherL1Link.waitForElement();
		assertThis("Missile Launcher L1 link is absent on Shop Component", missileLauncherL1Link.isElementPresent());
		missileLauncherL1Link.click();	
		
	}
	
	public void buyItem() throws Exception {
		buyItemButton.waitForElement();
		assertThis("Buy Item Button is absent on Shop Component", buyItemButton.isElementPresent());
		buyItemButton.click();	
		
	}

	public void confirmBuying() throws Exception {
		confirmBuyingItemButton.waitForElement();
		assertThis("Confirm Buying Item Button is absent on Shop Component", confirmBuyingItemButton.isElementPresent());
		confirmBuyingItemButton.click();	
	}	
}