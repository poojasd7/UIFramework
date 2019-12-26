package uiUtils;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.varian.extentListeners.ExtentListeners;
 
public class BaseTestRemote {
    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<WebDriver> driver = null;
    public CapabilityFactory capabilityFactory = new CapabilityFactory();
    
    public void resetDriver() {
		driver = null;
	}
    
    public void setup (String browser) throws MalformedURLException {
        //Set Browser to ThreadLocalMap
    	if(driver==null) {
    	driver = new ThreadLocal<>();
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
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