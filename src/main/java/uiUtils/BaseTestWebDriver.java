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

public class BaseTestWebDriver {
	//Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
	protected static WebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}
	public void resetDriver() {
		driver = null;
	}
	@SuppressWarnings("deprecation")
	public void setup (String browser) throws MalformedURLException {
		//Set Browser to ThreadLocalMap
		if(driver==null) {
			switch(browser) {
			case "chrome":  
			driver = new ChromeDriver(OptionsManager.getChromeOptions());
			case "firefox": 
			driver = new FirefoxDriver(OptionsManager.getFirefoxOptions());
			}
		}

	}



	public void logInfo(String message) {

		ExtentListeners.testReport.get().info(message);
	}


}