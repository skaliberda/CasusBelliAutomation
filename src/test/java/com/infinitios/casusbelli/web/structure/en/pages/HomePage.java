package com.infinitios.casusbelli.web.structure.en.pages;

import com.infinitios.casusbelli.web.elements.InputElement;
import com.infinitios.casusbelli.web.elements.NavigationElement;
import com.infinitios.casusbelli.web.structure.BasePage;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class HomePage extends BasePage{
		
	private NavigationElement signUpButton = getNavigationElement("//a[contains(@class,'sign-up')]");
//	Login section elements
	private InputElement loginField = getInputElement("//input[@id='email']");
	private InputElement passwordField = getInputElement("//input[@id='password']");
	private NavigationElement signInButton = getNavigationElement("//a[@class='sign-in button green']/div[(text()='Sign-in')]");
//	Play button post login
	private NavigationElement playButton = getNavigationElement("//a[@class='my-games button green']");
	
	
	
//	********************* For Assertion ******************************
	private NavigationElement header = getNavigationElement("//div[@id='header']");
	private NavigationElement footer = getNavigationElement("//div[@id='footer']");
	
	public HomePage(EventFiringWebDriver driver) {
		super(driver);
		log.info("Home Page is opened");
		
	}

	
//	********************** Main functionality **************************
	public RegisterPage signUp() throws Exception {
		signUpButton.waitForElement();
		assertThis("Sign UP button is absent on Home page", signUpButton.isElementPresent());
		signUpButton.click();
		return new RegisterPage(driver);
	}


	public void verify() {
	
		
	}


	public void login(String loginName, String password) throws Exception {
		loginField.waitForElement();
		assertThis("Login In Field Cannot be located or is not present", loginField.isElementPresent());
		loginField.typeText(loginName);
		passwordField.typeText(password);
		signInButton.click();
		
		
	}


	public DockPage play() throws Exception {
		playButton.waitForElement();
		assertThis("Play button is missing or xpath has changed", playButton.isElementPresent());
		playButton.click();
		
		return new DockPage(driver) ;
		
	}


	public void changeLanguageTo(String string) {
		
		
	}

}