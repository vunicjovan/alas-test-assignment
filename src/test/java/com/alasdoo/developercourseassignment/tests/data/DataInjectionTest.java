package com.alasdoo.developercourseassignment.tests.data;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.data.SettingsPage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class DataInjectionTest extends SeleniumTestConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(DataInjectionTest.class);

    @Test
    public void injectDataToServer() {
        LOGGER.info("DataInjectionTest started.");
        // Navigate to settings route for data injection
        driver.get("http://localhost:3000/settings");

        SettingsPage settingsPage = new SettingsPage(driver);
        LOGGER.info("Navigated to {}", driver.getCurrentUrl());

        LOGGER.debug("Injecting predefined data to database...");
        // Inject predefined data from scripts to database
        settingsPage.injectData();
        LOGGER.info("Data injected at {}", driver.getCurrentUrl());


        LOGGER.debug("Asserting the data injection info...");
        // Make sure the data is injected through confirmation message
        assertEquals("Injected: Students(20), Teachers(20), Courses(20)", settingsPage.getInjectionInfo());
        LOGGER.info("Data successfully asserted.");

        LOGGER.info("DataInjectionTest finished successfully.");
    }

}
