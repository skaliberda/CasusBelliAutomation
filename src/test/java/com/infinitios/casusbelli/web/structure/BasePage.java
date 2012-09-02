package com.infinitios.casusbelli.web.structure;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.infinitios.casusbelli.core.BaseTestCase;
import com.infinitios.casusbelli.web.elements.AbstractElement;
import com.infinitios.casusbelli.web.elements.CheckBoxElement;
import com.infinitios.casusbelli.web.elements.InputElement;
import com.infinitios.casusbelli.web.elements.NavigationElement;
import com.infinitios.casusbelli.web.elements.OutputElement;
import com.infinitios.casusbelli.web.elements.SelectElement;

import static org.fest.assertions.Assertions.assertThat;

public class BasePage /*implements Page*/ {
	protected EventFiringWebDriver driver;
	protected Logger log = Logger.getLogger(BaseTestCase.class);
	
	
	public BasePage(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	
	public void acceptConfirmation()throws Exception{
		Alert alert = driver.switchTo().alert();
		log.debug("Alert window is accepted");
		alert.accept();
	}
	
    public int getElementCount(String locator) {
        List<?> elementsFound = driver.findElements(By.xpath(locator));
        return elementsFound.size();
    }
	
	
	public boolean isTextPresent(String text) {
		return driver.findElement(By.tagName("body")).getText().contains(text);
	}

	public void goBack() {
		driver.navigate().back();
	}

	protected NavigationElement getNavigationElement(String locator) {
		NavigationElement webElement = new NavigationElement(locator);
		webElement.setDriver(driver);
		return webElement;
	}
	
	protected CheckBoxElement getCheckBoxElement(String locator){
		CheckBoxElement webElement = new CheckBoxElement(locator);
		webElement.setDriver(driver);
		return webElement;
	}

	protected InputElement getInputElement(String locator) {
		InputElement webElement = new InputElement(locator);
		webElement.setDriver(driver);
		return webElement;
	}

	protected OutputElement getOutputElement(String locator) {
		OutputElement webElement = new OutputElement(locator);
		webElement.setDriver(driver);
		return webElement;
	}

	protected SelectElement getSelectElement(String locator) {
		SelectElement webElement = new SelectElement(locator);
		webElement.setDriver(driver);
		return webElement;
	}

	protected AbstractElement getWebElement(String locator) {
		AbstractElement webElement = new AbstractElement(locator);
		webElement.setDriver(driver);
		return webElement;
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void openLink(String link){
		driver.navigate().to(link);
	}
	
	public void switchToIframe(String frameName){
		driver.switchTo().frame(frameName);
//		((JavascriptExecutor) driver).executeScript("document.body.innerHTML = '<br>'");
	}
	
	public void switchToWindow(String windowName){
		driver.switchTo().window(windowName);
	}
	
	public void switchToWindow(){
		for (String handle : driver.getWindowHandles()) {
		    driver.switchTo().window(handle);
		}
	}
	
	public void switchToSpecificWindow(String windowName){
		WebDriver popup = null;
		Set<String> handles =  driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		while (windowIterator.hasNext()) {
			String windowHandle = windowIterator.next();
			popup = driver.switchTo().window(windowHandle);
			if (popup.getTitle().equals(windowName)) {
				break;
			}
		}
	}
		
	public void switchToDefaultContent(){
		driver.switchTo().defaultContent();
	}
	
	public void verifyPrecenceOfMsg(String verMsg) throws Exception{
		waitForMessage(verMsg);
		assertThis("Error message \"" + verMsg + "\" is absent on current page.", isTextPresent(verMsg));
		log.debug("Error message \"" + verMsg + "\" is present on current page.");
	}
	
//	************************ Assertion ************************
	public void assertThis(String errMsg, boolean condition) {
		log.assertLog(condition, errMsg);
		assertThat(condition).overridingErrorMessage(errMsg).isTrue();
//		TestData.collectErrorMsg(errMsg);
		
	}
	
	public boolean waitForMessage(String text) throws Exception {
		return waitForMessage(500, text);
	}

	public boolean waitForMessage(long time, String text) throws Exception {
		return waitForMessage(time, 8, text);
	}
	
	public synchronized boolean waitForMessage(long time, int timesToTry, String text) throws Exception {
		for (int i = 0; i < timesToTry; i++) {
			try {
				Thread.sleep(time);
//				System.out.println("Times to try :" + i);
//				log.info("Times to try :" + i);
			} catch (Exception e) {
				System.out.println("Interrupted exception");
			}
			if (isTextPresent(text)) {
				return true;
			}
	}
	return false;
}

	
}