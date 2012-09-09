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
	
	public void clickAtCoordinates(int x, int y){
		String clickOnCanvasJS = "function click(element, x, y) {element = $(element); element.trigger($.Event('mousedown', {which: 1, clientX: x, clientY: y })); element.trigger($.Event('mouseup', { which: 1, clientX: x, clientY: y })); element.trigger($.Event('click', { which: 1, clientX: x, clientY: y }));} click(\""+elementLocator+"\", "+ x +", "+ y +");";
		executeJavascript(driver, clickOnCanvasJS);
		log.debug("Top coordiane: " + y + " and left coordinate: " + x + " are clicked");
	}
	
	public void mouseDownAtCoordinates(int x, int y){
		String mouseDownOnCanvasJS = "function mdown(element, x, y) { element = $(element); element.trigger($.Event('mousedown', {which: 1, clientX: x, clientY: y}));} mdown(\""+elementLocator+"\", "+ x +", "+ y +");";
		executeJavascript(driver, mouseDownOnCanvasJS);
		log.debug("Mouse down on top coordiane: " + y + " and left coordinate: " + x + ".");
	}
	
	public void mouseReleaseAtCoordinates(int x, int y){
		String mouseUpOnCanvasJS = "function mup(element, x, y) { element = $(element); element.trigger($.Event('mouseup', {which: 1, clientX: x, clientY: y}));} mup(\""+elementLocator+"\", "+ x +", "+ y +");";
		executeJavascript(driver, mouseUpOnCanvasJS);
		log.debug("Mouse up on top coordiane: " + y + " and left coordinate: " + x + ".");
	}
	
	public void mouseMoveToCoordinates(int x, int y){
		String mouseMoveOnCanvasJS = "function mmove(element, x, y) { element = $(element); element.trigger($.Event('mousemove', {which: 1, clientX: x, clientY: y}));} mmove(\""+elementLocator+"\", "+ x +", "+ y +");";
		executeJavascript(driver, mouseMoveOnCanvasJS);
		log.debug("Mouse move to top coordiane: " + y + " and left coordinate: " + x + ".");
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