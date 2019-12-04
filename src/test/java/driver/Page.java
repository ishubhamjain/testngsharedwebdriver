package driver;
/**
 * @author Shubham Jain
 *
 */
import org.openqa.selenium.WebDriver;

public class Page {
	
	private static WebDriver driver = null;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Page.driver = driver;
	}

}
