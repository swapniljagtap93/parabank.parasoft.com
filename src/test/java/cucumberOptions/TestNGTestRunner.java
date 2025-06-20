package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (features = "src/test/java/features",
                glue = "stepDefinitions",
                monochrome = true,
                tags="",
                plugin = { "pretty",
                        "html:target/cucumber-reports/cucumber.html"
                }
        )

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
