package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/mailchimp/test/features/landing.feature",
glue = "steps",
monochrome = true,
plugin = {"pretty","json:target/cucumber.json","html:target/cucumber.html"})
public class TestRunner {
}
