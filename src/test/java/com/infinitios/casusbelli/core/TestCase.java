package com.infinitios.casusbelli.core;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.infinitios.casusbelli.core.logging.LoggingWebDriverEventListener;
import com.infinitios.casusbelli.core.logging.XHTMLLayout;
import com.infinitios.casusbelli.web.structure.BasePage;

public class TestCase extends BaseTestCase{
	
    
    /**
     * Start the WebDriver Instance
     */
    
    @Parameters({ "seleniumReportPathParam", "serverAddress" })
    @BeforeMethod(alwaysRun = true)
    protected void setUp(String seleniumReportPathParam, @Optional("") String serverAddress)throws Exception{
    	this.seleniumReportPathParam = seleniumReportPathParam;
    	this.serverAddress = serverAddress;
    	seleniumDir = new File(seleniumReportPathParam);
 		logFileName = new StringBuffer(getCurrentlyExecutingClassName()).append("_").append(formatter.format(date)).append(HTML);
		// logging
		System.out.println("==============================");
		System.out.println(getCurrentlyExecutingClassName());
		System.out.println("==============================");

    	final StringBuffer resultHtmlFileName = new StringBuffer(seleniumReportPathParam).append(File.separator).append(logFileName);
  
		seleniumDir.mkdirs();
		imageDir = new File(seleniumDir + File.separator + "IMG");
		imageDir.mkdirs();

		System.out.println("SERVER NAME: " + serverAddress);
		log = Logger.getLogger(BaseTestCase.class);

		if (log.getLevel() == null){
			log.setLevel(Level.DEBUG);
		}
		fileappender = new FileAppender(new XHTMLLayout(), resultHtmlFileName.toString());
		log.addAppender(fileappender);

		driver = new EventFiringWebDriver(new FirefoxDriver(generateFirefoxProfile()));
    	driver.register(new LoggingWebDriverEventListener(log));
    	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    	maximizeWindow();
		
		driver.get(serverAddress);
		currentPage = new BasePage(driver);
		
    }
    
    /**
     * Shut down any browser instances still open now that tests have finished
     *
     * @param driverObject - driver object to stop
     * @throws IOException 
     */
	@SuppressWarnings({ "deprecation", "static-access" })
	@AfterMethod(alwaysRun = true)
    public void stopDriver() throws Exception {
		takeScreenshot(true);
        driver.quit();
        if(log != null){
        	log.shutdown();
        	log = null;
        	fileappender.close();
         }
     }
}