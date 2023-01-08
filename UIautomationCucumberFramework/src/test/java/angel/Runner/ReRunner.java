package angel.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="@Failed_Scenarios/failed_scenarios.txt",
		glue="angel_step_deinition",
		dryRun = false,
		monochrome = true
)

public class ReRunner {
	
	

}
