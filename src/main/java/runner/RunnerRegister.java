package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = "src/test/resources/features/register",
        glue = {"steps/register"},
        tags={"@integration"},
        plugin = {"pretty","html:target/cucumberreports","json:target/cucumber.json"}
)

public class RunnerRegister {
}
