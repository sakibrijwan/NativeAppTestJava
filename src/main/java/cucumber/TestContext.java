package cucumber;

import manager.DriverManager;
import manager.PageObjectManager;

import java.net.MalformedURLException;

/**
 * Created by Sakib on 11/22/2018.
 */
public class TestContext {


        private DriverManager driverManager;
        private PageObjectManager pageObjectManager;

        public TestContext() throws MalformedURLException {
            driverManager = new DriverManager();
            pageObjectManager = new PageObjectManager(driverManager.getAndroidDriver());
        }

        public DriverManager getDriverManager() {
            return driverManager;
        }

        public PageObjectManager getPageObjectManager() {
            return pageObjectManager;
        }
 }

