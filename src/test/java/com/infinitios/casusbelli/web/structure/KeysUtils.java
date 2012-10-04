package com.infinitios.casusbelli.web.structure;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.infinitios.casusbelli.core.TestCase;

public class KeysUtils {

	protected EventFiringWebDriver driver;
	protected Logger log = TestCase.log;
	
	public KeysUtils(EventFiringWebDriver driver) {
		this.driver = driver;		
	}

	public void pressSpace() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.SPACE).build().perform();
		log.debug("Space button is pressed");
	}
	
	public void pressSpecificKey(String specificKey){
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.chord(specificKey)).build().perform();
		log.debug("Button " + specificKey + " is pressed");
	}

	public void downSpecificKey(String specificKey) {
		Actions builder = new Actions(driver);
//		builder.k
//		builder.keyDown(Keys.specificKey)).build().perform();
		log.debug("Button " + specificKey + " is down");
	}
	
	public void upSpecificKey(String specificKey) {
		Actions builder = new Actions(driver);
		builder.keyUp(Keys.valueOf(specificKey)).build().perform();
		log.debug("Button " + specificKey + " is up");
		
	}
}
