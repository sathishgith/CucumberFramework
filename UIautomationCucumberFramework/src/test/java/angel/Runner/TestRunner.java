package angel.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/CucumberFeatures",
		glue="angel_step_deinition",
		dryRun = false,
		monochrome = true)
		//plugin={"rerun:Failed_Scenarios/failed_scenarios.txt"})
public class TestRunner {
	
	

}
