package stepdef;
/**
 * @author Shubham Jain
 *
 */
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import driver.AutomationLog;
import driver.DriverFactory;
import driver.SharedDriver;
/*import driver.Page;*/
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.FlightDetailsPage;
import pageobject.GoibiboHomePage;
import pico.FullName;

public class GoibiboNegativeScenarios {
	WebDriver driver = null;
	GoibiboHomePage gohomepage= null;
	FlightDetailsPage flightPage=null;
	private FullName name;

	public GoibiboNegativeScenarios(SharedDriver driver,FullName name) {
		this.driver=DriverFactory.getDriver();
	//	this.driver= Page.getDriver();
		gohomepage = new GoibiboHomePage(this.driver);
		flightPage= new FlightDetailsPage(this.driver);
		this.name = name;
	}

	@Then("^An error message should appears and no search process should initiate$")
	public void an_error_message_should_appears_and_no_search_process_should_initiate() throws Throwable {
		
		AutomationLog.info("Test pico containers ***************************");
		
		AutomationLog.info(name.getFirstName());
		AutomationLog.info(name.getLastName());
		
		AutomationLog.info("Test pico containers ***************************");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(gohomepage.By_textErrorMessage_SrcDes()));
		
		String errorMessage = gohomepage.textErrorMessage_SrcDes().getText();
		
		if(errorMessage.equalsIgnoreCase("Source and Destination cannot be same")) {
			AutomationLog.info("Required error message shown");
		}
		else {
			Assert.fail("Required error message is not shown");
		}
				
		Boolean isPresent = driver.findElements(flightPage.By_text_Price()).size() > 0;
		
		if(!isPresent) {
			AutomationLog.info("As required Page hasn't move to next flight search due to error");
		}else {
			Assert.fail("Page has move to next flight search even error message shown");
		}
		
	}
	
	@When("^search for one-way flights between \"([^\"]*)\" and \"([^\"]*)\" on old date$")
	public void search_for_one_way_flights_between_and_on_old_date(String source, String destination) throws Throwable {
		GoibiboPostiveScenario scenario = new GoibiboPostiveScenario(name);
		scenario.search_for_one_way_flights(source, destination);
		
		List<WebElement> oldDates = gohomepage.dropdown_disableOldDates();
		oldDates.get(0).click();
		AutomationLog.info("Click operation on old date");
	}

	@Then("^Old date must not be selected$")
	public void old_date_must_not_be_selected() throws Throwable {
				
		String departureDate = gohomepage.dropdown_DepartureSelection().getAttribute("value");
		
		AutomationLog.info("departureDate  =="+departureDate);
		
		if(departureDate.isEmpty()) {
			AutomationLog.info("Old date is not selected as required");
		}
		else {
			AutomationLog.info("Old date is selected");
			Assert.fail("Old date is selected");
		}	
	}

}
