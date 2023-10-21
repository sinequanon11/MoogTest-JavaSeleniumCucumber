package MoogTest.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports1.html",
                "json:target/json-reports/cucumber1.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = false,
        features = "src/test/resources/features",
        glue = {"MoogTest/stepdefinitions", "MoogTest/hooks"},
        tags = "@moog2",
        dryRun = false
)
// to run parallel, in tags two different tags (Runner and RunnerP..,
// View->Tools Window->Maven->Execute Maven Goal, mvn clean verify

public class RunnerParallelTest {

}
