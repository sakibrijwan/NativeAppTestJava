package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.net.MalformedURLException;

public class SecondFeatureSteps {

    @Given("^A feature \"([^\"]*)\"$")
    public void A_feature(String arg1) throws MalformedURLException
    {
        System.out.print("Testing\t"+ arg1);
    }

    @Then("^It will run$")
    public void It_will_run() throws Throwable {
        //System.out.print("Number:"+calc.getText());

    }

}
