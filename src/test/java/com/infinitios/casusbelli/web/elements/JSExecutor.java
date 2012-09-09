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
	
	public double getAiming(){
		String getAimingJS = "return TestUtils.aiming";
		double aim = ((Number)executeJavascript(driver, getAimingJS)).doubleValue();
		log.debug("Current aim state = " + aim);
		return aim;
	}
//	Get nearest checkpoint coordinates
	public int getNearestCheckPointYCoordinate(){
		String getYCoordinateJS = "return TestUtils.getNearestCheckpoint().y";
		int coordY = ((Number)executeJavascript(driver, getYCoordinateJS)).intValue();
		log.debug("Nearest checkpoint Y coordinate = " + coordY);
		return coordY;
	}
	
	public int getNearestCheckPointXCoordinate(){
		String getXCoordinateJS = "return TestUtils.getNearestCheckpoint().x";
		int coordX = ((Number)executeJavascript(driver, getXCoordinateJS)).intValue();
		log.debug("Nearest checkpoint X coordinate = " + coordX);
		return coordX;
	}
	
//	Get nearest enemy coordinates
	public int getNearestEnemyYCoordinate(){
		String getYCoordinateJS = "return TestUtils.getNearestEnemy().y";
		int coordY = ((Number)executeJavascript(driver, getYCoordinateJS)).intValue();
		log.debug("Nearest enemy Y coordinate = " + coordY);
		return coordY;
	}
	
	public int getNearestEnemyXCoordinate(){
		String getXCoordinateJS = "return TestUtils.getNearestEnemy().x";
		int coordX = ((Number)executeJavascript(driver, getXCoordinateJS)).intValue();
		log.debug("Nearest enemy X coordinate = " + coordX);
		return coordX;
	}
}