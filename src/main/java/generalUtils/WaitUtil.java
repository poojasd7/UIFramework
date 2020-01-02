package generalUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;
import uiUtils.*;

public class WaitUtil {
	
	static BaseTestWebDriverManager basicTestWebMgr=null;
	WebDriverWait wait = null;
	
	public WaitUtil() {
		basicTestWebMgr = new BaseTestWebDriverManager();
		
		wait =  new WebDriverWait(basicTestWebMgr.getDriver(),10);

	}
	
	public void waitImplicitly(long time) {
		basicTestWebMgr.getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);	
	}

	public void waitExplicitly(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
    public static void WaitForComponents()
    {
    	JavascriptExecutor js;
    	js = (JavascriptExecutor)basicTestWebMgr.getDriver();

    	
    	js.executeScript("", "");
    }
    
    
	public static WebElement WaitFluently(By locator, WebDriver driver) {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
    		    .withTimeout(Duration.ofSeconds(40))
    		    .pollingEvery(Duration.ofSeconds(5))
    		    .ignoring(NoSuchElementException.class)
    		    .ignoring(TimeoutException.class);
    	
    	return wait.until(new Function<WebDriver, WebElement>() 
    	{
    	  public WebElement apply(WebDriver driver) {
    	  return driver.findElement(locator);
    	}
    	});



    }
	
}
