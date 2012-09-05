package com.infinitios.casusbelli.web.elements;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.infinitios.casusbelli.core.TestCase;

/**
 * @author Sergey_Kaliberda
 */

public class AbstractElement  {

	protected EventFiringWebDriver driver;
	protected String elementLocator;
	protected Logger log = TestCase.log;

	private String getAiming = "return TestUtils.aiming";
	
	private static Object executeJavascript(WebDriver driver, String script){
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	return js.executeScript(script);
	}
	
	public AbstractElement(String locator) {
		this.elementLocator = locator;
	}

	public void setDriver(EventFiringWebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * @param selenium
	 * @uml.property name="selenium"
	 */

	public String getLocator() {
		return elementLocator;
	}

	public String getAttribute(String attribute) {
		return driver.findElement(By.xpath(elementLocator)).getAttribute(attribute);
	}

	public void click() throws Exception {
		if (isElementPresent()) {
			driver.findElement(By.xpath(elementLocator)).click();
		}		
	}
	
	public void mouseClick() throws Exception {
		if (isElementPresent()) {
			Actions builder = new Actions(driver);
			log.debug("Mouse click the element found By.xpath: " + elementLocator);
			builder.click(driver.findElement(By.xpath(elementLocator))).build().perform();
		}
	}
	
	public void clickAndHold() throws Exception {
		if (isElementPresent()) {
			Actions builder = new Actions(driver);
			log.debug("Mouse click and hold the element found By.xpath: " + elementLocator);
			builder.clickAndHold(driver.findElement(By.xpath(elementLocator))).release(driver.findElement(By.xpath(elementLocator))).build().perform();
			log.debug("Mouse release the element found By.xpath: " + elementLocator);
		}
	}

	public void robotMouseMoveAndClick(int leftCorrection, int topCorrection) throws Exception{
		Robot robot = new Robot();
//		GET ELEMENT POSITION
//		int topElementPosition =  Integer.parseInt((executeJavascript(driver, "return document.getElementById('cart-clear-button').style.top")).toString());
//		int leftElementPosition = Integer.parseInt((executeJavascript(driver, "return document.getElementById('cart-clear-button').style.left")).toString());
//		int elemHeight = driver.findElement(By.id("cart-clear-button")).getSize().height;
//		int elemWidht = driver.findElement(By.id("cart-clear-button")).getSize().width;
		int leftElementPosition = driver.findElement(By.xpath(elementLocator)).getLocation().getX();
		int topElementPosition = driver.findElement(By.xpath(elementLocator)).getLocation().getY();
		
		System.out.println("Locator: "+elementLocator);
////		System.out.println("HEIGHT: "+ elemHeight);
////		System.out.println("WIDTH: "+ elemWidht);
		System.out.println("LEFT: "+ (leftElementPosition + leftCorrection));
		System.out.println("TOP: "+ (topElementPosition + topCorrection));
////		TOP: 1329
////		LEFT: 356
//// 		SET THE MOUSE X Y POSITION
		robot.mouseMove(leftElementPosition+leftCorrection, topElementPosition + topCorrection); //left - 10  right   - 140
//// 		LEFT CLICK
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
//		executeJavascript(driver, "window.onload = function() {var elem = document.getElementById('cart-clear-button');  if(document.dispatchEvent) {   var oEvent = document.createEvent( 'MouseEvents' ); oEvent.initMouseEvent('click', true, true,window, 1, 1, 1, 1, 1, false, false, false, false, 0, elem); elem.dispatchEvent( oEvent );  }};");
		
//		System.out.println("JS Executed!!!!");
	}

//	public void warmClick() {
//		if (selenium.isElementPresent(elementLocator)) {
//			selenium.mouseOver(elementLocator);
//			selenium.mouseDown(elementLocator);
//			selenium.mouseUp(elementLocator);
//		}
//	}
//
//	public void doubleClick() {
//		selenium.doubleClick(elementLocator);
//	}
//
//	public boolean isVisible() throws Exception{
//		try {
//
//			return true;
//		} catch (NoSuchElementException e) {
//			System.out.println(e);
//			return false;
//		}
//
//	}
	
	public void clickAtCoordinates(int left, int top){
//		Actions builder = new Actions(driver);
//		builder.moveToElement(driver.findElement(By.xpath(elementLocator))).moveByOffset(left, top).clickAndHold().release().build().perform();
//		log.debug("Driver clicks on top coordiane: " + top + " and left coordinate: " + left);
		
		String clickOnCanvasJS = " function click(element, x, y) {element = $(element); element.trigger($.Event('mousedown', {which: 1, clientX: x, clientY: y })); element.trigger($.Event('mouseup', { which: 1, clientX: x, clientY: y })); element.trigger($.Event('click', { which: 1, clientX: x, clientY: y }));} click('#canvas', "+ left +", "+ top +");";
		executeJavascript(driver, clickOnCanvasJS);
//		System.out.println("Ship aiming: " + executeJavascript(driver, getAiming));
	}
	
	public void pressSpace() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.SPACE).build().perform();
		log.debug("Space button is pressed");
	}
		
	public boolean isElementPresent() throws Exception {
		try {
			driver.findElement(By.xpath(elementLocator)).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	
	public boolean isElementEnabled() throws Exception {
		try{
			driver.findElement(By.xpath(elementLocator)).isEnabled();
			return true;
		} catch(NoSuchElementException e){
			System.out.println(e);
			return false;
		}
	}

	public boolean waitForElement() throws Exception {
		return waitForElement(500);
	}

	public boolean waitForElement(long time) throws Exception {
		return waitForElement(time, 5);
	}
	
	public void moveToElement(){  
		Actions builder = new Actions(driver);
		log.debug("Mouse moving to the element found By.xpath: " + elementLocator);
		builder.moveToElement(driver.findElement(By.xpath(elementLocator))).build().perform();
	}
	
	public void dragAndDrop(String targetLocator){
		Actions builder = new Actions(driver);
		log.debug("Mouse drug element found By.xpath: " + elementLocator);
		builder.clickAndHold(driver.findElement(By.xpath(elementLocator))).moveToElement(driver.findElement(By.xpath(targetLocator))).release().build().perform();
//		builder.dragAndDrop(driver.findElement(By.xpath(elementLocator)), driver.findElement(By.xpath(targetLocator))).build().perform();
	}
	
	public void contextClick(){  
		Actions builder = new Actions(driver);
		log.debug("Right click on the element found By.xpath: " + elementLocator);
		builder.contextClick(driver.findElement(By.xpath(elementLocator))).build().perform();
	}
	
	public void release(){  
		Actions builder = new Actions(driver);
		log.debug("Mouse release the element found By.xpath: " + elementLocator);
		builder.release(driver.findElement(By.xpath(elementLocator))).build().perform();
	}

	public synchronized boolean waitForElement(long time, int timesToTry) throws Exception {
			for (int i = 0; i < timesToTry; i++) {
				try {
					Thread.sleep(time);
//					System.out.println("Times to try :" + i);
//					log.info("Times to try :" + i);
				} catch (Exception e) {
					System.out.println("Interrupted exception");
				}
				if (isElementPresent()) {
					return true;
				}
		}
		return false;
	}
}