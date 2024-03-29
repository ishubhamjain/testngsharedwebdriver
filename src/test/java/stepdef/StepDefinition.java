package stepdef;


import automationframework.SharedDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.GoogleHomePO;
import pageobjects.GoogleSearchPO;

public class StepDefinition {
	
	private GoogleHomePO ghPO;
	private GoogleSearchPO gsPO;
	
	public StepDefinition(SharedDriver driver, GoogleHomePO ghPO, GoogleSearchPO gsPO) {
		this.ghPO = ghPO;
		this.gsPO = gsPO;
	}
	
	@Given("Go to google page")
	public void given() {
		ghPO.get();
	}
	
	@When("Enter search {string}")
	public void when(String search) {
		gsPO = ghPO.performSearch(search);
		System.out.format("\nCount results for %s search is %s.\n", search, gsPO.searchResultCount());
	}
}
