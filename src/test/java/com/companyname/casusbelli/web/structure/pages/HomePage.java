package com.companyname.casusbelli.web.structure.pages;

import com.companyname.casusbelli.utils.Utils;
import com.companyname.casusbelli.web.elements.NavigationElement;
import com.companyname.casusbelli.web.structure.BasePage;

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