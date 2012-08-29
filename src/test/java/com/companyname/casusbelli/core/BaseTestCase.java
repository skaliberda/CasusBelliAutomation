package com.companyname.casusbelli.core;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.companyname.casusbelli.core.configuration.GroupInviteGuestsConfiguration;
import com.companyname.casusbelli.core.configuration.GroupLoginConfiguration;
import com.companyname.casusbelli.core.configuration.GroupOrderSetupConfiguration;
import com.companyname.casusbelli.core.configuration.GroupPaymentConfiguration;
import com.companyname.casusbelli.core.configuration.LoginConfiguration;
import com.companyname.casusbelli.core.configuration.OrderSetupConfiguration;
import com.companyname.casusbelli.core.configuration.PaymentConfiguration;
import com.companyname.casusbelli.utils.Constants;
import com.companyname.casusbelli.web.structure.BasePage;

public class BaseTestCase {
	
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
    protected String testCaseName;

//  Test data configuration for ordering
    protected LoginConfiguration validLoginData;
    protected LoginConfiguration invalidLoginData;
    protected OrderSetupConfiguration validOrderSetupData;
    protected OrderSetupConfiguration invalidOrderSetupData;
    protected PaymentConfiguration validPaymentData;
    protected PaymentConfiguration invalidPaymentData;
    
//  Test data configuration for group ordering
    protected GroupLoginConfiguration validGroupLoginData;
    protected GroupLoginConfiguration invalidGroupLoginData;
    protected GroupOrderSetupConfiguration validGroupOrderSetupData;
    protected GroupOrderSetupConfiguration invalidGroupOrderSetupData;
    protected GroupPaymentConfiguration validGroupPaymentData;
    protected GroupPaymentConfiguration invalidGroupPaymentData;
    protected GroupInviteGuestsConfiguration validGroupInviteData;
    protected GroupInviteGuestsConfiguration invalidGroupInviteData;
    
    protected String getCurrentlyExecutingClassName() {
		return this.getClass().getSimpleName();
	}
	
    
    protected void maximizeWindow() {
		driver.manage().window().maximize();
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
