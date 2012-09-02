package com.infinitios.casusbelli.web.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;


/**
 * Entity that represents output text and image
 * @author Sergey_Kaliberda
 *
 */
public class OutputElement extends AbstractElement{

	public OutputElement(String locator) {
		super(locator);
	}
	
	public String getTextValue(){
		return driver.findElement(By.xpath(elementLocator)).getText();
	}
	
	public String getPictureUrl() {
		return getAttribute("src");
	}
	
	public List<WebElement> getElements(){
		return driver.findElements(By.xpath(elementLocator));
	}
}