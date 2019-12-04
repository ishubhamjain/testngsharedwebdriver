package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "stepdef", features = "src/test/resources/features/")
public class RunnerIT extends AbstractTestNGCucumberParallelTests {

}
