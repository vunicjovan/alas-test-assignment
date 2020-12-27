package com.alasdoo.developercourseassignment.tests.data;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.data.SettingsPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataInjectionTest extends SeleniumTestConfiguration {

    @Test
    public void injectDataToServer() {
        driver.get("http://localhost:3000/settings");

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.injectData();

        assertEquals("Injected: Students(20), Teachers(20), Courses(20)", settingsPage.getInjectionInfo());
    }

}
