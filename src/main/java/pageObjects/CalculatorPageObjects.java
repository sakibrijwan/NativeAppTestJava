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
    public WebElement oneButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='2']")
    public WebElement twoButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='+']")
    public WebElement plusButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='=']")
    public WebElement equalButton;


    @AndroidFindBy(xpath="//android.widget.EditText[@text='3']")
    public WebElement verifyThree;

    @AndroidFindBy(id="com.android.calculator2:id/clr")
    public WebElement clearButton;

    public void clickOne(){this.oneButton.click();}
    public void clickTwo(){
        this.twoButton.click();
    }
    public void clickPlus(){
        this.plusButton.click();
    }
    public void clickEqual(){
        this.equalButton.click();
    }

    public void clickClear(){
        this.clearButton.click();
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
