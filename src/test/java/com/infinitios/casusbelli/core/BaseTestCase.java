package com.infinitios.casusbelli.core;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.infinitios.casusbelli.utils.Constants;
import com.infinitios.casusbelli.web.structure.BasePage;
import com.opera.core.systems.OperaDriver;


public class BaseTestCase {
	
//	public enum selectedBrowser {
//
//        FIREFOX, IE6, IE7, IE8, IE9, SAFARI, OPERA, GOOGLECHROME, ANDROID, IPHONE, HTMLUNIT
//    }
	
	protected static final String HTML = ".html";
	protected Date date = new Date();
	protected Format formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	public static Logger log;
	protected FileAppender fileappender;
	protected File seleniumDir;
	protected String seleniumDirPath;
	protected String imageDirPath;
	protected File imageDir;
    protected EventFiringWebDriver driver;
    protected StringBuffer logFileName;
    protected String seleniumReportPathParam;
    protected String serverAddress;
//    private static final String MAXIMIZE_BROWSER_WINDOW = "if (window.screen) {window.moveTo(0, 0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);};";
   
    protected BasePage currentPage;
   
    
    protected String getCurrentlyExecutingClassName() {
		return this.getClass().getSimpleName();
	}
	
    
    protected void maximizeWindow(String browser) {
    	if(browser.equals("opera")){
//    		driver.manage().window().setPosition(new Point(0, 0));
//    		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    		Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
//    		driver.manage().window().setSize(dim);
    	}else{
    		driver.manage().window().maximize();
    	}
	}
    
    protected static Object executeJavascript(WebDriver driver, String script){
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	return js.executeScript(script);
	}
	
    /**
     * Configure the FireFox profile if using FireFox Driver
     *
     * @return FirefoxProfile
     * @throws IOException 
     */

	protected FirefoxProfile generateFirefoxProfile() throws IOException {
        FirefoxProfile prf = new FirefoxProfile();
        prf.setAcceptUntrustedCertificates(true);
        prf.setAssumeUntrustedCertificateIssuer(false);
        return (prf);
    }
	
	 /**
     * Set the driver type based upon settings scraped from Env.properties
     * run function to get release number of website being tested
     *
     * @param driverObject - object to instantiate
     * @return WebDriver
     */
    public WebDriver setBrowser(WebDriver driverObject, String browser) {
        try {
        	if(browser.equals("firefox")){
        		driverObject = new FirefoxDriver(generateFirefoxProfile());
        		log.debug("Using FIREFOX Driver...");
        	} else if(browser.equals("ie")){
        		System.setProperty("webdriver.ie.driver", ".\\libs\\IEDriverServer.exe ");
        		driverObject = new InternetExplorerDriver();
                log.debug("Using INTERNET EXPLORER Driver...");
        	}else if(browser.equals("chrome")){
        		System.setProperty("webdriver.chrome.driver", ".\\libs\\chromedriver.exe ");
              driverObject = new ChromeDriver();
              log.debug("Using GOOGLECHROME Driver...");
        	}else if(browser.equals("safari")){
        		 //FUTURE
        	}else if(browser.equals("opera")){
                driverObject = new OperaDriver();
                log.debug("Using Opera Driver...");
        	}else{
//              driverObject = new HtmlUnitDriver(setHTMLUnitCapabilities(browserDetails.getHTMLUnitEmulation()));
              log.debug("Using HTMLUNIT Driver...");	
        	}
        } catch (Exception x) {
            log.error("Error in setBrowser: {}");
            return driverObject;
        }
        return driverObject;
    }

    
	protected StackTraceElement getCurrentlyExecutingElement() {
		Throwable t = new Throwable();
		StackTraceElement[] elements = t.getStackTrace();
		if (elements.length < 3) return null;
		// if hierarchy will changed please edit this statement!!!
		StackTraceElement calledElement = elements[2];
		return calledElement;
	}
	
	public boolean takeScreenshot(boolean isNeeded) {
		if (isNeeded) {
			String className = getCurrentlyExecutingClassName();
			String methodName = getCurrentlyExecutingElement().getMethodName();
			StringBuffer generatedFileName = new StringBuffer(className).append("_").append(methodName).append(Calendar.getInstance().getTimeInMillis()).append(Constants.PNG); 
			StringBuffer fileName = new StringBuffer(seleniumDir.toString()).append(File.separator).append("IMG").append(File.separator).append(generatedFileName);
			StringBuffer reportFileName = new StringBuffer("IMG").append(File.separator).append(generatedFileName);
			File scrFile = this.screenshot();
			try {
				FileUtils.copyFile(scrFile, new File(fileName.toString()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.warn(reportFileName);
		}
		return isNeeded;
	}
	
	public File screenshot(){
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}
}
