package stepdef;
/**
 * @author Shubham Jain
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automationframework.AutomationLog;
import automationframework.DriverFactory;
import automationframework.SharedDriver;
import automationframework.WaitFor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FlightDetailsPage;
import pageobjects.GoibiboHomePage;
import pico.FullName;

public class GoibiboPostiveScenario {
	
	WebDriver driver = null;
	GoibiboHomePage gohomepage= null;
	FlightDetailsPage flightPage=null;
//	ExcelLib xls= new ExcelLib();
	private FullName name;
	
	// pico container source : https://tutorial.grasshopper.tech/sharing-state-with-picocontainer-spring/
	// complete source: https://grasshopper.tech/1478/ or https://grasshopper.tech/
	// Thread local - http://grasshopper.tech/732/
	
	public GoibiboPostiveScenario(SharedDriver driver,FullName name) {
		this.driver=DriverFactory.getDriver();
		gohomepage = new GoibiboHomePage(this.driver);
		flightPage= new FlightDetailsPage(this.driver);
		this.name = name;
	}
	
	public GoibiboPostiveScenario(FullName name) {
		this.driver=DriverFactory.getDriver();
		gohomepage = new GoibiboHomePage(this.driver);
		flightPage= new FlightDetailsPage(this.driver);
		this.name = name;
	}
			
	@Given("^User logs into the application and on the home page$")
	public void backgroundTest() throws Throwable {
	System.out.println("When Exexutes background");
	}
	
	@Given("^verify if GoIbibo homepage goibibo works as expected$")
	public void verify_if_GoIbibo_homepage_goibibo_works_as_expected() throws Throwable {
		
		try {
			WaitFor.isloadComplete(driver);
			
			String PageTitle = driver.getTitle();
			
			name.setFirstName(PageTitle);
			
			name.setLastName("last name ="+PageTitle);
			
		//	Assert.assertEquals(PageTitle, xls.getXLcellValue("Assertion", 1, 1),"PageTitle is not as expected"); // reading assert data from excel file
			
			AutomationLog.info("PageTitle is as expected");
			
			Assert.assertEquals(true,false);
			
		//	String PageHeader = gohomepage.text_HomePageHeader().getText();
			
			String PageHeader = gohomepage.text_HomePageHeader.getText();
			
			System.out.println("PageHeader is"+PageHeader);

//			Assert.assertEquals(PageHeader, xls.getXLcellValue("Assertion", 2, 1),"PageHeader is not as expected");  // reading assert data from excel file

		    }catch (Exception e) {
				e.printStackTrace();
				AutomationLog.error("Search operation is failed");
			};
	}

	@When("^search for one-way flights between \"([^\"]*)\" and \"([^\"]*)\"$")
	public void search_for_one_way_flights_between_source_and_destination(String source, String destination) throws Throwable {

		search_for_one_way_flights(source,destination); // we can write this function in separate page wise class also
		
		gohomepage.dropdown_dateSelect().click();
		
		AutomationLog.info("current date selected");
		
		gohomepage.button_Search().click();
		
		AutomationLog.info("Click on search button");
	}
	

	public void search_for_one_way_flights(String source, String destination) throws Throwable {
	   
		gohomepage.textFiled_From().sendKeys(source);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(gohomepage.By_dropdown_From(source)));
		wait.until(ExpectedConditions.elementToBeClickable(gohomepage.By_dropdown_From(source)));

		AutomationLog.info("city is entered in from");
	
		Actions ob = new Actions(driver);
		ob.click(gohomepage.dropdown_FromCity(source)).perform();
		
		AutomationLog.info("from city is clicked");
		
		WaitFor.isloadComplete(driver);

		gohomepage.textFiled_Desc().sendKeys(destination);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(gohomepage.By_dropdown_Destination(destination)));
		wait.until(ExpectedConditions.elementToBeClickable(gohomepage.By_dropdown_Destination(destination)));
		
		AutomationLog.info("city is entered in desc");
		
		ob.click(gohomepage.dropdown_FromDestination(destination)).perform();
		
		AutomationLog.info("desc city is clicked");
	}

	@Then("^verify if the page results are ordered in decreasing order of cost$")
	public void verify_if_the_page_results_are_ordered_in_decreasing_order_of_cost() throws Throwable {
	
		WaitFor.isloadComplete(driver);
		
		AutomationLog.info("Page load done");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(flightPage.By_text_Price()));
		WaitFor.isloadComplete(driver);
		AutomationLog.info("*************************");
		List<WebElement> prices=flightPage.text_HomePageHeader();

		List<Integer> Sortprices = new ArrayList<Integer>();
		
		List<Integer> realprices = new ArrayList<Integer>();
		
		for(WebElement price:prices) {
			AutomationLog.info("************Price*************");
			AutomationLog.info(price.getText());
			Integer priceofFlight = Integer.parseInt(price.getText().replaceAll(",", ""));
			Sortprices.add(priceofFlight);
			realprices.add(priceofFlight);
		}
		
		AutomationLog.info("Getting all price shown on the Page");
		
		Collections.sort(Sortprices);
		
		AutomationLog.info("sorted price of first list");

		AutomationLog.info("Sortprices "+Sortprices);
		AutomationLog.info("realprices "+realprices);
		
		Boolean equal = Sortprices.equals(realprices);
		
		if(equal) {
			AutomationLog.info("Getting all price shown are in ascending order");
		}else {
			AutomationLog.info("The list is not in ascending orde, actual ="+Sortprices+ "but found = "+realprices);
			Assert.fail("The list is not in ascending orde, actual  ="+Sortprices+ "but found = "+realprices);
		}
	}
}
