package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import driver.AutomationLog;

public class FlightDetailsPage extends LoadableComponent<FlightDetailsPage>{
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


	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}

}
