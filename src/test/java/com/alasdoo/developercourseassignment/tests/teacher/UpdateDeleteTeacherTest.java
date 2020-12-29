package com.alasdoo.developercourseassignment.tests.teacher;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.teacher.SpecifiedTeacherPage;
import com.alasdoo.developercourseassignment.pages.teacher.TeacherListPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UpdateDeleteTeacherTest extends SeleniumTestConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(UpdateDeleteTeacherTest.class);

    @Test
    public void testTeacherUpdateDelete() {
        LOGGER.info("UpdateDeleteTeacherTest started.");
        // Navigate to a list display of teachers
        driver.get("http://localhost:3000/teacher");

        TeacherListPage teacherListPage = new TeacherListPage(driver);
        LOGGER.info("Navigated to {}", driver.getCurrentUrl());

        LOGGER.debug("Opening list of teachers in system...");
        // Open detailed view for selected teacher
        SpecifiedTeacherPage specifiedTeacherPage = teacherListPage.selectTeacher();
        LOGGER.info("Opened teacher list at {}", driver.getCurrentUrl());

        LOGGER.debug("Updating personal information about teacher...");
        // Update personal information about existing teacher: name, surname, email
        specifiedTeacherPage.updatePersonalInfo("Magnus", "Magnusson", "magnusmagnusson@gmail.com");
        LOGGER.debug("Confirming entered data...");
        // Confirm entered data
        specifiedTeacherPage.submitChanges();
        LOGGER.info("Updated teacher: {} {}", specifiedTeacherPage.getName(), specifiedTeacherPage.getSurname());

        LOGGER.debug("Asserting the entered data...");
        // Make sure the teacher data corresponds to entered data
        assertEquals("Magnus", specifiedTeacherPage.getName());
        assertEquals("Magnusson", specifiedTeacherPage.getSurname());
        LOGGER.info("Data successfully asserted.");

        LOGGER.debug("Removing selected teacher from the system...");
        // Remove selected teacher from database
        TeacherListPage returnTeacherListPage = specifiedTeacherPage.deleteTeacher();

        LOGGER.debug("Asserting the remove operation...");
        // Make sure that the right teacher is removed
        assertFalse(returnTeacherListPage.doesElementExist(driver, By.xpath("//*[contains(text(), 'magnusmagnusson@gmail.com')]")));
        LOGGER.info("Operation successfully asserted.");

        LOGGER.info("UpdateDeleteTeacherTest successfully finished.");
    }

}
