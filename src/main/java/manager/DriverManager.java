package manager;

import enums.DriverType;
import enums.EnvironmentType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sakib on 11/20/2018.
 */
public class DriverManager {

    private AndroidDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
   // private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";


    public DriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getDriver();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

//    public WebDriver getDriver() throws MalformedURLException {
//        if (driver == null) driver = createDriver();
//        return driver;
//    }

    public AndroidDriver getAndroidDriver() throws MalformedURLException {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private AndroidDriver createDriver() throws MalformedURLException {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
             //   driver = createRemoteDriver();
                break;
        }
        return driver;

    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }


    private AndroidDriver createLocalDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, FileReaderManager.getInstance().getConfigReader().getDeviceName());

        switch (driverType){
            case FIREFOX:
                //driver=new FirefoxDriver();
                break;
            case CHROME:
                //System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
                //driver=new ChromeDriver();
                break;
            case INTERNETEXPLORER:
                //driver=new InternetExplorerDriver();
                break;
            case APPIUM_LOCAL_APP:
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.android.calculator2");
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.android.calculator2.Calculator");
                driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case APPIUM_INSTALLED_APP:
                //capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());


        }
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }


}