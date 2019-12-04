package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"classpath:features"} 
		, glue = "stepdef"
		,plugin = { "progress:reports/progress/progress.txt"
				,"timeline:reports/timeline" 
				,"pretty", "html:target/cucumber-default-report",
				"json:target/cucumber.json"
				//,"junit:target/cucumber-results.xml"
				,"usage:target/cucumber-usage.json"
				,"rerun:reports/rerun.txt"}
//		,tags= {"@smoke"}  // Run tests in groups
		,monochrome = true
//		,dryRun = true
		)

public class RunnerIT extends AbstractTestNGCucumberParallelTests {

}
