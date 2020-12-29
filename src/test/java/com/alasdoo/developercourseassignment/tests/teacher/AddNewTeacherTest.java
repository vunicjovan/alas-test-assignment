package com.alasdoo.developercourseassignment.tests.teacher;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.teacher.NewTeacherPage;
import com.alasdoo.developercourseassignment.pages.teacher.SpecifiedTeacherPage;
import com.alasdoo.developercourseassignment.pages.teacher.TeacherListPage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class AddNewTeacherTest extends SeleniumTestConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(AddNewTeacherTest.class);

    @Test
    public void addNewTeacher() {
        LOGGER.info("AddNewTeacherTest started.");
        // Navigate to a list display of teachers
        driver.get("http://localhost:3000/teacher");

        TeacherListPage teacherListPage = new TeacherListPage(driver);
        LOGGER.info("Navigated to {}", driver.getCurrentUrl());

        LOGGER.debug("Opening form for addition of new teacher...");
        // Open a "New teacher" form
        NewTeacherPage newTeacherPage = teacherListPage.addNewTeacher();
        LOGGER.info("Opened form for teacher addition at {}", driver.getCurrentUrl());

        LOGGER.debug("Entering data about teacher...");
        // Enter data for new teacher
        newTeacherPage.enterTeacherInfo("Marco", "Marconi", "marcomarconi@gmail.com");

        LOGGER.debug("Confirming entered data...");
        // Confirm entered data
        SpecifiedTeacherPage specifiedTeacherPage = newTeacherPage.submitData();
        LOGGER.info("Added new teacher: {} {} and navigated to {}", specifiedTeacherPage.getName(),
                specifiedTeacherPage.getSurname(), driver.getCurrentUrl());

        LOGGER.debug("Asserting the entered data...");
        // Make sure that newly added teacher is indeed the one we wanted
        assertEquals("Marco", specifiedTeacherPage.getName());
        assertEquals("Marconi", specifiedTeacherPage.getSurname());
        LOGGER.info("Data successfully asserted.");

        LOGGER.info("AddNewTeacherTest successfully finished.");
    }

}
