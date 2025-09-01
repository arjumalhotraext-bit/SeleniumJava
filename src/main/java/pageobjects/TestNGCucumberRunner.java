package pageobjects;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/java/pageobjects/features",
        glue = "pageobjects",
        plugin = {"pretty", "html:target/cucumber.html"}
)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {}
