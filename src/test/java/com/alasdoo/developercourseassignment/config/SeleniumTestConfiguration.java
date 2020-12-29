package com.alasdoo.developercourseassignment.config;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTestConfiguration {

    /*
    * browserType = property defining type of web driver used for E2E testing (e.g. chrome or gecko)
    * driverPath = relative path to chosen web driver pointing to test resources
    * driverProperty = property used for configuration of Selenium web driver
    * driver = Selenium web driver used in every test class
    */
    protected static String browserType = "chrome";
    protected static String driverPath = "./src/test/resources/webdriver/" + browserType + "driver.exe";
    protected static String driverProperty = "webdriver." + browserType + ".driver";
    protected static WebDriver driver;

     /**
     * Initialization for every test class:
     * setting up web driver property on chosen relative path
     * initializing Selenium web driver
     * setting up different options of Selenium web driver
     */
    @BeforeClass
    public static void setUp() {
        System.setProperty(driverProperty, driverPath);
        setUpTheDriver();
        driver.manage().window().maximize();    // maximize browser window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    // wait 10 seconds max for element to appear
    }

    /**
    * Cleanup method for Selenium web driver, disposing all cookies
    */
    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    /**
    * One of the most important parts of Selenium web driver lifecycle: dispose after usage.
    * If called driver.close() instead of driver.quit(), it would eventually lead to possible memory leak.
    */
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    /**
     * Helper method for Selenium web driver initialization.
     */
    private static void setUpTheDriver() {
        switch (browserType) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "gecko":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "opera":
                driver = new OperaDriver();
                break;
        }
    }

}
