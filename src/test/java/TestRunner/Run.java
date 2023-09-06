package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;*/

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./Features/",
		glue = "StepDefinition",
		tags = "@Regression or @Smoke",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:target/Cucumber-Reports/reports.html", /* "json:target/Cucumber-Reports/reports.json", "junit:target/Cucumber-Reports/reports.xml*/ }
		
		// For Json we use this
		// plugin = {"pretty", "json:target/Cucumber-Reports/reports.json"}
		
		// For XML we use this
		// plugin = {"pretty", "junit:target/Cucumber-Reports/reports.xml"}
		)
public class Run extends AbstractTestNGCucumberTests {

}
