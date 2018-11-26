package step_definitions;

import cucumber.TestContext;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manager.FileReaderManager;
import org.junit.Assert;

import pageObjects.CalculatorPageObjects;
import testDataTypes.TestNumbers;

import java.net.MalformedURLException;

/**
 * Created by Sakib on 11/11/2018.
 */
public class AddNumbersSteps {

    CalculatorPageObjects calc;
    TestContext testContext;

    public AddNumbersSteps(TestContext context) {
        testContext = context;
        calc = testContext.getPageObjectManager().getCalculator();
    }

    @Given("^Calculator is launched$")
    public void calculator_is__launched() throws MalformedURLException
    {
        System.out.print("Launched");
    }

    @When("^I press one$")
    public void I_press_one() {
        calc.clickOne();
    }

    @And("^I press plus sing$")
    public void I_press_plus_sing(){
        calc.clickPlus();
    }

    @And("^I press two$")
    public void I_press_two(){
        calc.clickTwo();
    }

    @And("^I press equal sign$")
    public void I_press_equal_sign() {
        calc.clickEqual();
    }

    @Then("^Result three will appear$")
    public void Result_three_will_appear() throws Throwable {
        Thread.sleep(2000);
     //   TestNumbers numbers = FileReaderManager.getInstance().getJsonReader().getCustomerByName(3);

        //System.out.print("Number:"+calc.getText());
       // Assert.assertEquals(calc.getText(), numbers);
        Assert.assertEquals(calc.getText(), "3");
    }
}
