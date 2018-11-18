
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/features",
//        glue = "src/main/step_definitions",
        //glue = {"src/test/resources/stepDefinition"},
//        tags="@Login",
        plugin = {"pretty"})
public class RunCucumberTest {
}