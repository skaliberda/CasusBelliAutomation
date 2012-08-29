package com.epam.cara.web.structure;

public interface Page {
	void goBack();
	void refresh();
	boolean isTextPresent(String pattern);
	boolean isElementPresent(String locator);
//	boolean isElementPresent(WebElement element);
	String getTitle();
	void waitForPageToLoad();
	boolean verifyPage();
	boolean verifyTitle(String expectedTitle);
	void submitForm();	
}
