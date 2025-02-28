package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {".//features/Login.feature"}, glue = {"stepDefinations"},
        dryRun = false, monochrome = true, plugin = {"pretty", "html:test-output.html"})
public class TestRun extends AbstractTestNGCucumberTests {
}
