package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinition"}, //  Se hace referecnia a una carpeta completa
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true,
        tags= "@TEST_OrangeHRM_004"
)
public class Runner {
}
