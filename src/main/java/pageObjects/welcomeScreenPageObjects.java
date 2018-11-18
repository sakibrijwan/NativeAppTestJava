package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sakib on 11/11/2018.
 */
public class welcomeScreenPageObjects {
    AndroidDriver driver;

    @AndroidFindBy(xpath = "//*[@text='1']")
    public WebElement one;
    @AndroidFindBy(xpath = "//*[@text='2']")
    public WebElement two;
    @AndroidFindBy(xpath = "//*[@text='3']")
    public WebElement three;
    @AndroidFindBy(xpath = "//*[@text='4']")
    public WebElement four;

    public welcomeScreenPageObjects(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void enterPassword(){
        this.one.click();
        this.two.click();
        this.three.click();
        this.four.click();
    }
}
