package com.infinitios.casusbelli.web.structure.en.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.infinitios.casusbelli.web.elements.InputElement;
import com.infinitios.casusbelli.web.elements.NavigationElement;
import com.infinitios.casusbelli.web.structure.BasePage;

public class RegisterPage extends BasePage {
	
	private InputElement emailField = getInputElement("//input[@id='reg-email']");
	private InputElement passwordField = getInputElement("//input[@id='reg-password']");
	private NavigationElement playForFreeButton = getNavigationElement("//dd[@id='submit-element']/input");

	public RegisterPage(WebDriver driver) {
		super(driver);
		log.info("Register Page is opened");
	}

	public void verify() {
		// TODO Auto-generated method stub
		
	}

	public void enterEmail(String email) throws Exception {
		emailField.waitForElement();
		assertThis("Email field is absent on Register page", emailField.isElementPresent());
		emailField.typeText(email);
	}

	public DockPage playForFree() throws Exception {
		playForFreeButton.waitForElement();
		assertThis("Play For Free button is absent on Register page", playForFreeButton.isElementPresent());
		playForFreeButton.click();
		return new DockPage(driver);
	}

	public void enterPassword(String psw) throws Exception {
		passwordField.waitForElement();
		assertThis("Password field is absent on Register page", passwordField.isElementPresent());
		passwordField.typeText(psw);
		
	}

}
