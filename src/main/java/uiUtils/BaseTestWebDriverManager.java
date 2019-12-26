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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestWebDriverManager {
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
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			case "firefox": 
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}

	}



	public void logInfo(String message) {

		ExtentListeners.testReport.get().info(message);
	}


}