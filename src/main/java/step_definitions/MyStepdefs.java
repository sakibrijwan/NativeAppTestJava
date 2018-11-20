package step_definitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import manager.PageObjectManager;
import manager.DriverManager;
import org.junit.Assert;

import pageObjects.CalculatorPageObjects;
import dataProvider.ConfigFileReader;

import java.net.MalformedURLException;

/**
 * Created by Sakib on 11/11/2018.
 */
public class MyStepdefs {


    AndroidDriver driver;
    PageObjectManager pageObjectManager;
    CalculatorPageObjects calc;
    ConfigFileReader configFileReader;
    DriverManager driverManager=new DriverManager();

    @Before
    public void setup() throws MalformedURLException
    {

        //AndroidDriver<AndroidElement> driver;

        // TODO Auto-generated method stub
        //File appDir = new File("aut");
        //File app = new File(appDir, "CoCoin.apk");

        driver=driverManager.getAndroidDriver();


        pageObjectManager = new PageObjectManager(driver);
        calc = pageObjectManager.getCalculator();
        // return driver;
    }

    @Given("^Calculator is launched$")
    public void calculator_is__launched() throws MalformedURLException
    {
        System.out.print("Launched");
    }


    @When("^I press one$")
    public void I_press_one() throws Throwable {
        calc.clickOne();
        // Express the Regexp above with the code you wish you had
        //throw new PendingException();
    }

    @And("^I press plus sing$")
    public void I_press_plus_sing() throws Throwable {
        // Express the Regexp above with the code you wish you had
        calc.clickPlus();
//        throw new PendingException();
    }

    @And("^I press two$")
    public void I_press_two() throws Throwable {
        // Express the Regexp above with the code you wish you had
        calc.clickTwo();
  //      throw new PendingException();
    }

    @And("^I press equal sign$")
    public void I_press_equal_sign() throws Throwable {
        // Express the Regexp above with the code you wish you had
        calc.clickEqual();
    //    throw new PendingException();
    }

    @Then("^Result three will appear$")
    public void Result_three_will_appear() throws Throwable {
        // Express the Regexp above with the code you wish you had
        Thread.sleep(2000);
        System.out.print("Number:"+calc.getText());
        Assert.assertEquals(calc.getText(), "3");
        //throw new PendingException();
    }
}
