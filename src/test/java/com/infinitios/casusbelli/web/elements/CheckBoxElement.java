package com.infinitios.casusbelli.web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class CheckBoxElement extends AbstractElement {

	
	public CheckBoxElement(String locator) {
		super(locator);
	}

	public void check() {

		if (!isChecked()) {
			driver.findElement(By.xpath(elementLocator)).click();
		}
	}

	public void uncheck() {

		if (isChecked()) {
			driver.findElement(By.xpath(elementLocator)).click();
		}
	}

	public boolean isChecked() {
		return driver.findElement(By.xpath(elementLocator)).isSelected();
	}
}
