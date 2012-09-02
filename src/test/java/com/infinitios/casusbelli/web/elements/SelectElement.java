package com.infinitios.casusbelli.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Entity that represents drop-down list, check box and radio button
 * @author Sergey_Kaliberda
 *
 */

public class SelectElement extends AbstractElement {

	private Select select;
	
	public SelectElement(String locator) {
		super(locator);
	}
	
	public void select(String option) {
		select = new Select(driver.findElement(By.xpath(elementLocator)));
		try {
//			By label
//			driver.findElement(By.xpath(elementLocator+"/option[@value='" + option + "']")).click();
			select.selectByVisibleText(option);
			log.debug("WebDriver selecting " + "\"" + option + "\"" + " by label, in select element found By.xpath" + elementLocator);
		} catch (Exception e) {
			log.error("WebDriver have not found " + "\"" + option + "\"" + " by label, in select element found By.xpath" + elementLocator);
//			By value
//			driver.findElement(By.xpath(elementLocator+"/option[.='" + option + "']")).click();
			select.selectByValue(option);
			log.error("WebDriver selecting value " + "\"" + option + "\"" + "by value, in select element found By.xpath" + elementLocator);
		}
	}	
	public void selectByIndex(int index){
		select = new Select(driver.findElement(By.xpath(elementLocator)));
		select.selectByIndex(index);
	}
}