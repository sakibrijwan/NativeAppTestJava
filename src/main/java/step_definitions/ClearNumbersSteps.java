package step_definitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.CalculatorPageObjects;

/**
 * Created by Sakib on 11/22/2018.
 */
public class ClearNumbersSteps {

    CalculatorPageObjects calc;
    TestContext testContext;

    public ClearNumbersSteps(TestContext context) {
        testContext = context;
        calc = testContext.getPageObjectManager().getCalculator();
    }

    @Then("^Clear the result$")
    public void Clear_the_result() throws Throwable {
        calc.clickClear();
    }
}
