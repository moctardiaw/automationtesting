package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //dryRun = true,
        features = "src/test/resources/features/accountdetails",
        glue = {"steps/login"},
        tags={"@accountdetails"},
        plugin = {"pretty","html:target/cucumberreports","json:target/cucumber.json"}
)

public class RunnerAccountdetails {
}