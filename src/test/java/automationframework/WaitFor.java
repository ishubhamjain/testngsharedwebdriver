package automationframework;

/**
 * @author Shubham Jain
 *
 */
import java.time.Duration;
/**
 * @author Shubham Jain
 *
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitFor 
{
    public static WebElement presenceOfTheElement(WebDriver driver, final By elementIdentifier) 
    {
        // Wait time and polling time get it from global configuration.
        String globalPageTimeoutProperty = Configuration.getConfigurationValueForProperty("global-page-timeout");
        long globalPageTimeout = Long.parseLong(globalPageTimeoutProperty);

        String globalPageElementPollingTimeoutProperty = Configuration.getConfigurationValueForProperty("global-page-element-polling-timeout");
        long globalPageElementPollingTimeout = Long.parseLong(globalPageElementPollingTimeoutProperty);

        Wait<WebDriver> wait =
        		 new FluentWait<>(driver)
                 .withTimeout(Duration.ofSeconds(globalPageTimeout))
                 .pollingEvery(Duration.ofMillis(globalPageElementPollingTimeout))
                 .ignoring(WebDriverException.class);
 
        return wait.until(new Function<WebDriver, WebElement>()
                {
                    public WebElement apply(WebDriver driver) {
                           return driver.findElement(elementIdentifier);
                    }
                });
    }

    private static void waitUntil(WebDriver driver, ExpectedCondition < Boolean > pageLoad)
    {
        String globalPageTimeoutProperty = Configuration.getConfigurationValueForProperty("global-page-timeout");
        long globalPageTimeout = Long.parseLong(globalPageTimeoutProperty);

        Wait < WebDriver > wait = new WebDriverWait(driver, globalPageTimeout);
        try
        {
            wait.until(pageLoad);
        }
        catch (Throwable pageLoadWaitError)
        {
            
        }
    }

    public static boolean isloadComplete(WebDriver driver)
    {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
                || ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

}
