package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import driver.Configuration;
import driver.Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SharedDriver {

	public SharedDriver() {
		if (DriverFactory.getDriver() == null) {
			WebDriver driver = null;
			
			//WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().version(Configuration.getConfigurationValueForProperty("chrome-version"))
					.setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			// options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			driver = new ChromeDriver(options);
			driver.get(Configuration.applicationUnderTestURL());
			Page.setDriver(driver);
			
			DriverFactory.addDriver(driver);
		}
	}
}
