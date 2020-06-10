package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
      features = "src/test/java/features",
        glue = "steps",plugin={"pretty","json:target/jsonReports/cucumber-report.json"},strict = true)
public class TestRunner {
}
