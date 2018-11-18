package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Sakib on 11/18/2018.
 */
public class CalculatorPageObjects {

    AndroidDriver driver;

    public CalculatorPageObjects(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBys({
            @AndroidFindBy(id="com.android.calculator2:id/formula"),
            @AndroidFindBy(xpath="//android.widget.EditText[@text='3']")
    })
    public List<WebElement> four;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='1']")
    public WebElement one;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='2']")
    public WebElement two;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='+']")
    public WebElement plus;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='=']")
    public WebElement equal;


    @AndroidFindBy(xpath="//android.widget.EditText[@text='3']")
    public WebElement verifyThree;

    public void clickOne(){
        this.one.click();
    }
    public void clickTwo(){
        this.two.click();
    }
    public void clickPlus(){
        this.plus.click();
    }
    public void clickEqual(){
        this.equal.click();
    }

    public void addTwoNumbers(){
        this.clickOne();
        this.clickPlus();
        this.clickTwo();
        this.clickEqual();
    }

    public String getText(){
        return this.verifyThree.getText();
    }

}
