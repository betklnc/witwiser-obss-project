package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"}, glue={"stepDefinitions"},
        tags = ""  ,monochrome = true, dryRun = false,
        plugin = {"pretty",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber.json", "html:target/cucumber-html-report", "usage:target/cucumber-usage.json",""+
                "junit:target/cucumber-results.xml"
        }
)
public class MainRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}