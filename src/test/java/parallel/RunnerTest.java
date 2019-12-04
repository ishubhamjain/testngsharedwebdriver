package parallel;

import io.cucumber.core.cli.Main;
import io.cucumber.testng.CucumberOptions;

//Source:

//https://tutorial.grasshopper.tech/parallel-execution

// TO-DO not working yet

@CucumberOptions(plugin = {"timeline:reports/timeline"})

public class RunnerTest {
	
	public static void main(String[] args) {
		/*String[] params = new String[] { 
				"--threads", "4", "-g", "parallel",
				"-p", "timeline:reports/timeline", 
				"src/test/resources/features"
				//,"src/main/java/stepDefinition"
				};
		Main.run(params, Thread.currentThread().getContextClassLoader());*/
		
		String [] argv =  new String[] { 
				"--threads", "4", "-g", "parallel",
				"-p", "timeline:reports/timeline", 
				"./src/test/resources/features/"
				//,"src/main/java/stepDefinition"
				};
		
	//	String [] argv = new String[]{ "-g","","./src/test/resources/features/"};
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		byte exitstatus = Main.run(argv, contextClassLoader);
	}
}
