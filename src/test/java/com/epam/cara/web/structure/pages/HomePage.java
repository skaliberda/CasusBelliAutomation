package com.epam.cara.web.structure.pages;

import com.epam.cara.utils.Utils;
import com.epam.cara.web.elements.NavigationElement;
import com.epam.cara.web.structure.BasePage;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class HomePage extends BasePage{
		
	private NavigationElement startOrderButton = getNavigationElement("//div[@id='order-start-button-callout']/div");
	private NavigationElement tryGroupOrderingLink = getNavigationElement("//a[text()='Try our Group Ordering']");
	private NavigationElement tryOurFavoriteSelectionsLink;
	
//	********************* For Assertion ******************************
	private NavigationElement header = getNavigationElement("//div[@id='header']");
	private NavigationElement footer = getNavigationElement("//div[@id='footer']");
	
	public HomePage(EventFiringWebDriver driver) {
		super(driver);
		log.info("Home Page is opened");
		
	}
	
//	********************** Main functionality **************************

}