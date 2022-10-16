package runner;

import common.ImportResultsToXray;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RunWith(Cucumber.class)
@CucumberOptions(
        //dryRun = true,
        features = "src/test/resources/features",
        glue = {"steps/login"},
        //tags={"@TEST_TEAM4-21","@Team4","@REQ_TEAM4-2"},
        //tags={"@totest"},
        plugin = {"pretty","html:target/cucumberreports","json:target/cucumber.json"}
)


public class Runner {

    @AfterClass
    public static void tearDown() throws NoSuchAlgorithmException, KeyStoreException, IOException, InterruptedException, KeyManagementException {

        //import->JIRA
        //ImportResultsToXray res = new ImportResultsToXray();
        //res.RemonteResultats();

        //System.out.println("IMPORT to Xray....");

    }
}