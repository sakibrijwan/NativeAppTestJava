
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/features",
//        glue = "src/main/step_definitions",
        //glue = {"src/test/resources/stepDefinition"},
//        tags="@functionalTest",
        plugin = {"pretty","html:target/cucumber-reports" })
public class RunCucumberTest {
}