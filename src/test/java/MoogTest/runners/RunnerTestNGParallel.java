package MoogTest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html"
        },
        monochrome = false,
        features = "src/test/resources/features",
        glue = {"MoogTest/stepdefinitions", "MoogTest/hooks"},
        tags = "@moog1",
        dryRun = false
)

public class RunnerTestNGParallel extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
