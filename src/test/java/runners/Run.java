package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions (
        glue = {"StepDefinitions"},
        features = {"test.feature"},
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" },
        monochrome = true,
        tags = "Test"
)

public class Run extends AbstractTestNGCucumberTests {
}
