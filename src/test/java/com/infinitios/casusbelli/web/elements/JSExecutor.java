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
//		log.debug("Current aim state = " + aim);
		return aim;
	}
//	Get nearest checkpoint coordinates
	public int getNearestCheckPointYCoordinate(){
		String getYCoordinateJS = "var y = TestUtils.getNearestCheckpoint().y; if(typeof y =='undefined'){y=0}; return y; ";
		int coordY = ((Number)executeJavascript(driver, getYCoordinateJS)).intValue();
//		log.debug("Nearest checkpoint Y coordinate = " + coordY);
		return coordY;
	}
	
	public int getNearestCheckPointXCoordinate(){
		String getXCoordinateJS = "var x = TestUtils.getNearestCheckpoint().x; if(typeof x =='undefined'){x=0}; return x; ";
		int coordX = ((Number)executeJavascript(driver, getXCoordinateJS)).intValue();
//		log.debug("Nearest checkpoint X coordinate = " + coordX);
		return coordX;
	}
	
	public boolean isCheckPointPresent(){
		String checkPoint = "return TestUtils.getNearestCheckpoint()";
		boolean checkPointBool /*= Boolean.parseBoolean(String.valueOf(executeJavascript(driver, checkPoint)))*/;
		if(String.valueOf(executeJavascript(driver, checkPoint)).contains("function")){
			checkPointBool = true;
		}else{
			checkPointBool = false;
		}
//		System.out.println(String.valueOf(executeJavascript(driver, checkPoint)));
//		log.debug("Value"+ String.valueOf(executeJavascript(driver, checkPoint)));
		log.debug("Checkpoin present = " + checkPointBool);
		return checkPointBool;
	}
	
//	Get nearest enemy coordinates
	public int getNearestEnemyYCoordinate(){
		String getYCoordinateJS = "var y = TestUtils.getNearestEnemy().y; if(typeof y =='undefined'){y=0}; return y; "; 
		int coordY = ((Number)executeJavascript(driver, getYCoordinateJS)).intValue();
//		log.debug("Nearest enemy Y coordinate = " + coordY);
		return coordY;
	}
	
	public int getNearestEnemyXCoordinate(){
		String getXCoordinateJS = "var x = TestUtils.getNearestEnemy().x; if(typeof x =='undefined'){x=0}; return x;";
		int coordX = ((Number)executeJavascript(driver, getXCoordinateJS)).intValue();
//		log.debug("Nearest enemy X coordinate = " + coordX);
		return coordX;
	}
	
	public boolean isEnemyPresent(){
		String enemy = "return TestUtils.getNearestEnemy()";
		boolean enemyBool /*= Boolean.parseBoolean(String.valueOf(executeJavascript(driver, checkPoint)))*/;
		if(String.valueOf(executeJavascript(driver, enemy)).contains("function")){
			enemyBool = true;
		}else{
			enemyBool = false;
		}
//		System.out.println(String.valueOf(executeJavascript(driver, checkPoint)));
//		log.debug("Value"+ String.valueOf(executeJavascript(driver, checkPoint)));
		log.debug("Checkpoin present = " + enemyBool);
		return enemyBool;
	}
	
//	Working with zoom 
	public void zoomHalfTheSpace(){
		String zoomJS = "(new Quest()).zoom(0.5)";
		executeJavascript(driver, zoomJS);
		log.debug("Space is zoomed by a half");	
	}
	
	public void zoomMinimumTheSpace(){
		String zoomJS = "(new Quest()).zoom(0)";
		executeJavascript(driver, zoomJS);
		log.debug("Space is zoomed by minimum");
	}
	
	public void zoomMaximumTheSpace(){
		String zoomJS = "(new Quest()).zoom(1)";
		executeJavascript(driver, zoomJS);
		log.debug("Space is zoomed by maximum");		
	}
	
//	Working with turning the ship 
	public void turnShipClockwise(){
		String turnShipJS = "UiController.keyHandlerRotateCw(me)";
		executeJavascript(driver, turnShipJS);
		log.debug("Ship was turned clockwise");		
	}
	
	public void turnShipCounterClockwise(){
		String turnShipJS = "UiController.keyHandlerRotateCcw(me)";
		executeJavascript(driver, turnShipJS);
		log.debug("Ship was turned Conter clockwise");
	}
	
	public void stopRotateShip(){
		String turnShipJS = "UiController.keyHandlerRotateStop(me)";
		executeJavascript(driver, turnShipJS);
		log.debug("Ship rotation was stopped");
	}	
	
//	Get ship coordinates
	public int getShipYCoordinate(){
		String getYCoordinateJS = "return me.getPosition().toReal().y";
		int coordY = ((Number)executeJavascript(driver, getYCoordinateJS)).intValue();
		log.debug("Ship Y coordinate = " + coordY);
		return coordY;
	}
	
	public int getShipXCoordinate(){
		String getXCoordinateJS = "return me.getPosition().toReal().x";
		int coordX = ((Number)executeJavascript(driver, getXCoordinateJS)).intValue();
		log.debug("Ship X coordinate = " + coordX);
		return coordX;
	}
	
//	Get stop ship coordinates
	public int getShipStopYCoordinate(){
		String getYCoordinateJS = "return me.navigator.path.stop.toReal().y";
		int coordY = ((Number)executeJavascript(driver, getYCoordinateJS)).intValue();
//		log.debug("Ship stop Y coordinate = " + coordY);
		return coordY;
	}
	
	public int getShipStopXCoordinate(){
		String getXCoordinateJS = "return me.navigator.path.stop.toReal().x";
		int coordX = ((Number)executeJavascript(driver, getXCoordinateJS)).intValue();
//		log.debug("Ship stop X coordinate = " + coordX);
		return coordX;
	}
}