package com.test.UI;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generalUtils.WaitUtil;
import uiUtils.BaseTestWebDriverManager;

public class AirBnBTest extends BaseTestWebDriverManager {

	@BeforeMethod
	@Parameters(value={"browser"})
	public void beforeTestMethod(String browser) throws MalformedURLException {
		super.setup(browser);
	}

	/************************Aventstack extent report is enabled here!!!!********************/
	/*********************package: com.varian.extentListeners*************************************/
	@Test
	public void AirBnb1() {
		logInfo("AirBnb Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
		getDriver().get("http://www.airbnb.com");
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Log.info("Google1 Test's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
		logInfo("AirBnb Test's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
		WebElement lnkShowAdventures = getDriver().findElement(By.xpath("//a/span[text()='Show all adventures']/.."));

		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", lnkShowAdventures);

		lnkShowAdventures.click();

		/*
		 * getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		 * 
		 * js.
		 * executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);"
		 * );
		 */
		
		By locatorRecommendedDest= By.xpath("//h3/div[text()='Recommended destinations']");
		
		WebElement eleRecommendedDest = WaitUtil.WaitFluently(locatorRecommendedDest, getDriver());//WaitFluently(locatorRecommendedDest,getDriver());
		
		Assert.assertEquals(eleRecommendedDest.isDisplayed(), true);
		logInfo("Recommended Destinations is displayed!");
		Assert.assertEquals(getDriver().getTitle(), "Airbnb Adventures");
		logInfo("AirBnb Test's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
		//Recommended destinations
		//Log.info("Google1 Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
		logInfo("AirBnb Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		if(getDriver()!=null) {
			getDriver().quit();
			resetDriver();
		}
	}

}
