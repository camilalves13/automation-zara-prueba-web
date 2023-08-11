package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = {"@ZaraTest"},
        glue = {"steps"}

)
public class RunCucumberTest extends RunBase {

    @AfterClass
    public static void stop() {
        getDriver().quit();
    }
}
