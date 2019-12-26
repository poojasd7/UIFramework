package com.test.UI;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import reportingLogging.Log;

//import com.test.reporting.StartProcess;

import uiUtils.BaseTestRemote;
import uiUtils.BaseTestWebDriver;
import uiUtils.BaseTestWebDriverManager;

public class GoogleTest extends BaseTestWebDriverManager {

	@BeforeClass
	public void init() {
		Log.initiateLogs(GoogleTest.class.getClass());
		
	}
	
	@BeforeMethod
	@Parameters(value={"browser"})
	public void beforeTestMethod(String browser) throws MalformedURLException {
		super.setup(browser);
	}
/************************Aventstack extent report is enabled here!!!!********************/
	/*********************package: com.varian.extentListeners*************************************/
	@Test
	public void GOOGLE1() {
		//Log.info("Google1 Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
		logInfo("Google1 Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
		getDriver().get("http://www.google.com");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Log.info("Google1 Test's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
		logInfo("Google1 Test's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
		Assert.assertEquals(getDriver().getTitle(), "Google");
		//Log.info("Google1 Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
		logInfo("Google1 Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
	}

	@Test
	public void GOOGLE2() {
		//Log.info("Google2 Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
		logInfo("Google2 Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
		getDriver().get("http://www.google.com");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logInfo("Google2 Test's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
		Assert.assertEquals(getDriver().getTitle(), "Google");
		logInfo("Google2 Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
	}

	@Test
	public void GOOGLE3() throws Exception {
		logInfo("Google3 Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
		getDriver().get("http://www.google.com");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logInfo("Google3 Test's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
		//Log.error("LOG Info:Test Case ETL failing");
		//throw new Exception();
	}

	/*
	 * @Test(enabled=false) public void dragAndDrop() {
	 * Log.info("Drag and Drop Test Started! " + "Thread Id: " +
	 * Thread.currentThread().getId());
	 * getDriver().navigate().to("http://www.google.com");
	 * Log.info("Google3 Test's Page title is: " + getDriver().getTitle() +" " +
	 * "Thread Id: " + Thread.currentThread().getId()); Actions act = new
	 * Actions(getDriver()); Log.info("Google3 Test Ended! " + "Thread Id: " +
	 * Thread.currentThread().getId()); }
	 */
	
	 @AfterMethod(alwaysRun=true)
	    public void tearDown() {
	    	if(getDriver()!=null) {
	        getDriver().quit();
	        resetDriver();
	    	}
	    }
	
}
