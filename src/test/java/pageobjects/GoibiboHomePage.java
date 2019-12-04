package pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import automationframework.AutomationLog;
import automationframework.DriverFactory;

//public class GoibiboHomePage extends LoadableComponent<GoibiboHomePage> {
public class GoibiboHomePage {

	WebDriver driver = null;
	private WebElement element = null;
	private By By = null;

	public GoibiboHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	/*public WebElement text_HomePageHeader() throws Exception {
		try {
		//	element = driver.findElement(By.xpath("//h1[@class='txtCenter white ico30']"));
			element = driver.findElement(By.xpath("//h1[@class='txtCenter white ico30 txtCap']"));

		} catch (Exception e) {
			AutomationLog.error("HomePageHeader Element not found");
			throw (e);
		}
		return element;
	}*/
	
    @FindBy(xpath="//h1[@class='txtCenter white ico30 txtCap']")
    public WebElement text_HomePageHeader;
	
	public WebElement textFiled_From() throws Exception {
		try {
			element = driver.findElement(By.id("gosuggest_inputSrc"));

		} catch (Exception e) {
			AutomationLog.error("From text field Element not found");
			throw (e);
		}
		return element;
	}
	
	public WebElement textFiled_Desc() throws Exception {
		try {
			element = driver.findElement(By.id("gosuggest_inputDest"));

		} catch (Exception e) {
			AutomationLog.error("From text field Element not found");
			throw (e);
		}
		return element;
	}
	
	public By By_dropdown_From(String city) throws Exception {
		return By.xpath("//input[@id='gosuggest_inputSrc']/..//*[@role='listbox']/*[contains(.,'"+city+"')]");
		
	}
	
	public WebElement dropdown_FromCity(String city) throws Exception {
		try {
			element = driver.findElement(By_dropdown_From(city));
			
		} catch (Exception e) {
			AutomationLog.error("From text field Element not found");
			throw (e);
		}
		return element;
	}
	
	public By By_dropdown_Destination(String city) throws Exception {
		return By.xpath("//input[@id='gosuggest_inputDest']/..//*[@role='listbox']/*[contains(.,'"+city+"')]");
		
	}
	
	public WebElement dropdown_FromDestination(String city) throws Exception {
		try {
			element = driver.findElement(By_dropdown_Destination(city));

		} catch (Exception e) {
			AutomationLog.error("From text field Element not found");
			throw (e);
		}
		return element;
	}
	
	public WebElement dropdown_dateSelect() throws Exception {
		try {
			element = driver.findElement(By.xpath("//div[@class='DayPicker-Body']//div[@class='DayPicker-Day DayPicker-Day--today DayPicker-Day--selected']"));

		} catch (Exception e) {
			AutomationLog.error("From text field Element not found");
			throw (e);
		}
		return element;
	}

	
	public WebElement button_Search() throws Exception {
		try {
			element = driver.findElement(By.id("gi_search_btn"));

		} catch (Exception e) {
			AutomationLog.error("From text field Element not found");
			throw (e);
		}
		return element;
	}
	
	public By By_textErrorMessage_SrcDes() throws Exception {
		return By.xpath("//span[@class='alert_msg failure_msg dF brdrRd5']/span");
		
	}
	
	public WebElement textErrorMessage_SrcDes() throws Exception {
		try {
			element = driver.findElement(By_textErrorMessage_SrcDes());

		} catch (Exception e) {
			AutomationLog.error("From text field Element not found");
			throw (e);
		}
		return element;
	}
	
	public List<WebElement> dropdown_disableOldDates() throws Exception {
		try {
			List<WebElement> oldDates = driver.findElements(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--disabled']"));
			return oldDates;
		} catch (Exception e) {
			AutomationLog.error("From text field Element not found");
			throw (e);
		}
	}
	
	public WebElement dropdown_DepartureSelection() throws Exception {
		try {
			element = driver.findElement(By.id("departureCalendar"));

		} catch (Exception e) {
			AutomationLog.error("From text field Element not found");
			throw (e);
		}
		return element;
	}

}
