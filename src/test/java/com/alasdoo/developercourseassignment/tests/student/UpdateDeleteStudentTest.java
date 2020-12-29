package com.alasdoo.developercourseassignment.tests.student;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.student.SpecifiedStudentPage;
import com.alasdoo.developercourseassignment.pages.student.StudentListPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UpdateDeleteStudentTest extends SeleniumTestConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(UpdateDeleteStudentTest.class);

    @Test
    public void testStudentUpdateDelete() {
        LOGGER.info("UpdateDeleteStudentTest started.");
        // Navigate to a list display of students
        driver.get("http://localhost:3000/student");

        StudentListPage studentListPage = new StudentListPage(driver);
        LOGGER.info("Navigated to {}", driver.getCurrentUrl());

        LOGGER.debug("Opening list of students in system...");
        // Open detailed view for selected student
        SpecifiedStudentPage specifiedStudentPage = studentListPage.selectStudent();
        LOGGER.info("Opened student list at {}", driver.getCurrentUrl());

        LOGGER.debug("Updating personal information about student...");
        // Update personal information about existing student: name, surname, email
        specifiedStudentPage.updatePersonalInfo("Jack", "Jackson", "jackjackson@gmail.com");
        LOGGER.debug("Confirming entered data...");
        // Confirm entered data
        specifiedStudentPage.submitChanges();
        LOGGER.info("Updated student: {} {}", specifiedStudentPage.getName(), specifiedStudentPage.getSurname());

        LOGGER.debug("Asserting the entered data...");
        // Make sure the student data corresponds to entered data
        assertEquals("Jack", specifiedStudentPage.getName());
        assertEquals("Jackson", specifiedStudentPage.getSurname());
        LOGGER.info("Data successfully asserted.");

        LOGGER.debug("Removing selected student from the system...");
        // Remove selected student from database
        StudentListPage returnStudentListPage = specifiedStudentPage.deleteStudent();

        LOGGER.debug("Asserting the remove operation...");
        // Make sure that the right student is removed
        assertFalse(returnStudentListPage.doesElementExist(driver, By.xpath("//*[contains(text(), 'jackjackson@gmail.com')]")));
        LOGGER.info("Operation successfully asserted.");

        LOGGER.info("UpdateDeleteStudentTest successfully finished.");
    }

}
