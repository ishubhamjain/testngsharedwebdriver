package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import automationframework.AutomationLog;

public class FlightDetailsPage {
	WebDriver driver = null;
	private WebElement element = null;
	private By By = null;

	public FlightDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By By_text_Price() throws Exception {
		return By.xpath("//span[@data-cy='finalPrice']");
		
	}
	
	public List<WebElement> text_HomePageHeader() throws Exception {
		try {
			List<WebElement> list = driver.findElements(By.xpath("//span[@data-cy='finalPrice']"));
			return list;
		} catch (Exception e) {
			AutomationLog.error("HomePageHeader Element not found");
			throw (e);
		}
	}


}
