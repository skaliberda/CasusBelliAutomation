package com.infinitios.casusbelli.web.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor extends AbstractElement {

	private String getAiming = "return TestUtils.aiming";
	
	public JSExecutor(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	private static Object executeJavascript(WebDriver driver, String script){
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	return js.executeScript(script);
	}
	
	public void clickAtCoordinates(int left, int top){
		String clickOnCanvasJS = " function click(element, x, y) {element = $(element); element.trigger($.Event('mousedown', {which: 1, clientX: x, clientY: y })); element.trigger($.Event('mouseup', { which: 1, clientX: x, clientY: y })); element.trigger($.Event('click', { which: 1, clientX: x, clientY: y }));} click(\""+elementLocator+"\", "+ left +", "+ top +");";
		executeJavascript(driver, clickOnCanvasJS);
		log.debug("Top coordiane: " + top + " and left coordinate: " + left + " are clicked");
	}
	
	
	public int getNearestCheckPointTopCoordinate(){
		String getTopCoordinate = "return TestUtils.getNearestCheckpoint().y";
		int topCoord = ((Number)executeJavascript(driver, getTopCoordinate)).intValue();
		log.debug("Nearest checkpoint Top coordinate = " + topCoord);
		return topCoord;
	}
	
	public int getNearestCheckPointLeftCoordinate(){
		String getLeftCoordinate = "return TestUtils.getNearestCheckpoint().x";
		int leftCoord = ((Number)executeJavascript(driver, getLeftCoordinate)).intValue();
		log.debug("Nearest checkpoint Left coordinate = " + leftCoord);
		return leftCoord;
	}
}