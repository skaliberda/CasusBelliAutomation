package com.infinitios.casusbelli.web.ru.components;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.infinitios.casusbelli.web.elements.NavigationElement;
import com.infinitios.casusbelli.web.structure.BasePage;

public class ShopComponent extends BasePage {

	private NavigationElement turretsAndLaunchersLink = getNavigationElement("//a[contains(text(), 'Орудия и пусковые установки')]");
	private NavigationElement ammunitionAndProjectilesLink = getNavigationElement("//a[text()='Боеприпасы и заряды']");
	
	private NavigationElement missileLaunchersLink = getNavigationElement("//div[contains(text(),'Ракетные пусковые установки')]");
	private NavigationElement missilesAndTorpedoesLink = getNavigationElement("//div[contains(text(),'Ракеты и торпеды')]");
	
	private NavigationElement missileLauncherL1Link = getNavigationElement("//div[@id='shop-items-body']//div[contains(text(), 'Ракетная установка t.Co l1')]");
	private NavigationElement RocketL1Link = getNavigationElement("//div[@id='shop-items-body']//div[text()='Ракета l1']");
	
	private NavigationElement buyItemButton = getNavigationElement("//div[contains(@class,'footer')]//div[contains(text(), 'Купить')]");
	private NavigationElement confirmBuyingItemButton = getNavigationElement("//div[@id='dialog']//div[contains(text(), 'Купить')]");
	
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

	public void openAmmunitionAndProjectiles() throws Exception {
		ammunitionAndProjectilesLink.waitForElement();
		assertThis("Ammunition And Projectiles link is absent on Shop Component", ammunitionAndProjectilesLink.isElementPresent());
		ammunitionAndProjectilesLink.click();	
	}

	public void openMissilesAndTorpedoes() throws Exception {
		missilesAndTorpedoesLink.waitForElement();
		assertThis("Missiles And Torpedoes link is absent on Shop Component", missilesAndTorpedoesLink.isElementPresent());
		missilesAndTorpedoesLink.click();		
	}

	public void selectRocketL1() throws Exception {
		RocketL1Link.waitForElement();
		assertThis("Rocket L1 link is absent on Shop Component", RocketL1Link.isElementPresent());
		RocketL1Link.click();		
	}	
}