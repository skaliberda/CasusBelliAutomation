package com.companyname.casusbelli.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Entity that represents input text and text area
 * 
 * @author Sergey_Kaliberda
 * 
 */
public class InputElement extends AbstractElement {

	
	
	public InputElement(String locator) {
		super(locator);
	}

	public boolean isEditable() {
		return driver.findElement(By.xpath(elementLocator)).isEnabled();
	}

	public void typeText(String text) {
		driver.findElement(By.xpath(elementLocator)).clear();
		driver.findElement(By.xpath(elementLocator)).sendKeys(text);
	}
	
	public void typeText(int text) {
		driver.findElement(By.xpath(elementLocator)).clear();
		driver.findElement(By.xpath(elementLocator)).sendKeys(Integer.toString(text));
	}
	
	public void typeTextAndPressEnter(String text) {
		driver.findElement(By.xpath(elementLocator)).clear();
		driver.findElement(By.xpath(elementLocator)).sendKeys(text);
		driver.findElement(By.xpath(elementLocator)).sendKeys(Keys.RETURN);
	}
	
	public void typeTextAndPressTab(String text){
		driver.findElement(By.xpath(elementLocator)).clear();
		driver.findElement(By.xpath(elementLocator)).sendKeys(text);
		driver.findElement(By.xpath(elementLocator)).sendKeys(Keys.TAB);
	}
	
	public String getValue(){
		return driver.findElement(By.xpath(elementLocator)).getAttribute("value");
//		return driver.findElement(By.xpath(elementLocator)).getCssValue("background-color");
		
	}
}