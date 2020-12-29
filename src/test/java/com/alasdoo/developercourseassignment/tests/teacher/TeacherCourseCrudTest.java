package com.alasdoo.developercourseassignment.tests.teacher;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.teacher.SpecifiedTeacherPage;
import com.alasdoo.developercourseassignment.pages.teacher.ToggleCoursesPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TeacherCourseCrudTest extends SeleniumTestConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(TeacherCourseCrudTest.class);

    @Test
    public void testTeacherCourseCrud() {
        LOGGER.info("TeacherCourseCrudTest started.");
        // Navigate to specified teacher's detailed info
        driver.get("http://localhost:3000/teacher/21");

        SpecifiedTeacherPage specifiedTeacherPage = new SpecifiedTeacherPage(driver);
        LOGGER.info("Navigated to {}", driver.getCurrentUrl());

        LOGGER.debug("Opening list of courses teacher is assigned to...");
        // Open list of courses teacher is assigned to
        ToggleCoursesPage toggleCoursesPage = specifiedTeacherPage.toggleCourses();
        LOGGER.info("Opened teacher's course list at {}", driver.getCurrentUrl());

        LOGGER.debug("Adding a new course...");
        // Open course selection
        toggleCoursesPage.addNewCourse();
        LOGGER.debug("Selecting a course and entering number of classes...");
        // Select course
        toggleCoursesPage.selectCourse();
        LOGGER.debug("Confirming selection...");
        // Confirm selection
        toggleCoursesPage.saveNewCourse();
        LOGGER.info("Assigned teacher to a new course: {}", toggleCoursesPage.getSelectedCourseName());

        LOGGER.debug("Asserting the entered data...");
        // Make sure that the right course is added to teacher's list of courses
        assertEquals(toggleCoursesPage.getSelectedCourseItemText(), toggleCoursesPage.getSelectedCourseName());
        LOGGER.info("Data successfully asserted.");

        LOGGER.debug("Removing selected course from teacher's course list...");
        // Open info about certain course and remove it from teacher's list of courses
        toggleCoursesPage.removeExistingCourse();

        LOGGER.debug("Asserting the remove operation...");
        // Make sure that the right course is removed (in this case, list of courses goes to empty state)
        assertTrue(toggleCoursesPage.doesElementExist(driver, By.xpath(toggleCoursesPage.getNoRowsXPath())));
        LOGGER.info("Operation successfully asserted.");

        LOGGER.info("TeacherCourseCrudTest successfully finished.");
    }

}
