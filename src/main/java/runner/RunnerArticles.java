package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //dryRun = true,
        features = "src/test/resources/features/articles",
        glue = {"steps/login"},
       // tags={"@articles","@nombretotal"},
         tags={"@articles","@nonpassant"},
        plugin = {"pretty","html:target/cucumberreports","json:target/cucumber.json"}
)

public class RunnerArticles {
}