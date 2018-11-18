package manager;

import io.appium.java_client.android.AndroidDriver;

import pageObjects.CalculatorPageObjects;

/**
 * Created by Sakib on 11/18/2018.
 */
public class PageObjectManager {

    private AndroidDriver driver;
    private CalculatorPageObjects calcObjects;
    public PageObjectManager(AndroidDriver driver) {
        this.driver = driver;
    }

    public CalculatorPageObjects getCalculator(){
        return (calcObjects == null) ? new CalculatorPageObjects(driver) : calcObjects;
    }
}
