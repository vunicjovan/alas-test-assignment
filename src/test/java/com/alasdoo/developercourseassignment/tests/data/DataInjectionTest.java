package com.alasdoo.developercourseassignment.tests.data;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.data.SettingsPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataInjectionTest extends SeleniumTestConfiguration {

    @Test
    public void injectDataToServer() {
        // Navigate to settings route for data injection
        driver.get("http://localhost:3000/settings");

        SettingsPage settingsPage = new SettingsPage(driver);

        // Inject predefined data from scripts to database
        settingsPage.injectData();

        // Make sure the data is injected through confirmation message
        assertEquals("Injected: Students(20), Teachers(20), Courses(20)", settingsPage.getInjectionInfo());
    }

}
