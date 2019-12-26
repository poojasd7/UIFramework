package uiUtils;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.varian.extentListeners.ExtentListeners;

public class BaseTest3 {
	//Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
	protected static ThreadLocal<WebDriver> driver = null;
	public WebDriver webdriver = null;

	public void resetDriver() {
		driver = null;
	}
	@SuppressWarnings("deprecation")
	public void setup (String browser) throws MalformedURLException {
		//Set Browser to ThreadLocalMap
		if(driver==null) {
			switch(browser) {
			case "chrome":  driver = new ThreadLocal<>();
			webdriver = new ChromeDriver(OptionsManager.getChromeOptions());
			driver.set(webdriver);
			case "firefox": driver = new ThreadLocal<>();
			webdriver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
			driver.set(webdriver); 			   
			}
		}

	}

	public WebDriver getDriver() {
		//Get driver from ThreadLocalMap
		return driver.get();
	}

	public void logInfo(String message) {

		ExtentListeners.testReport.get().info(message);
	}


	@AfterClass 
	void terminate () {
		//Remove the ThreadLocalMap element
		driver.remove();
	}
}