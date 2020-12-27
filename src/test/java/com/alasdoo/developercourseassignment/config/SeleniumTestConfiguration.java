package com.alasdoo.developercourseassignment.config;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTestConfiguration {

    protected static String browserType = "chrome"; // change to "gecko" for Firefox or to "msedge" for Edge
    protected static String driverPath = "./src/test/resources/webdriver/" + browserType + "driver.exe";
    protected static String driverProperty = "webdriver." + browserType + ".driver";
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty(driverProperty, driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();    // maximize browser window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

}
