package runner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import io.cucumber.testng.CucumberOptions;

@ExtendedCucumberOptions(jsonReport = "target/cucumber.json"
		,retryCount = 0
		,detailedReport = true
		,detailedAggregatedReport = true
		,overviewReport = true
		,coverageReport = true
		,jsonUsageReport = "target/cucumber-usage.json"
		,usageReport = true
		,toPDF = true
		//,excludeCoverageTags = {"@flaky" }
		,includeCoverageTags = {"@passed" }
		,outputFolder = "target"
)

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
