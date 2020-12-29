package com.alasdoo.developercourseassignment.tests.student;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.student.SpecifiedStudentPage;
import com.alasdoo.developercourseassignment.pages.student.ToggleCoursesPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentCourseCrudTest extends SeleniumTestConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(StudentCourseCrudTest.class);

    @Test
    public void TestCourseCrudOperations() {
        LOGGER.info("StudentCourseCrudTest started.");
        // Navigate to specified student's detailed info
        driver.get("http://localhost:3000/student/21");

        SpecifiedStudentPage specifiedStudentPage = new SpecifiedStudentPage(driver);
        LOGGER.info("Navigated to {}", driver.getCurrentUrl());

        LOGGER.debug("Opening list of courses student has signed for...");
        // Open list of courses student has signed for
        ToggleCoursesPage toggleCoursesPage = specifiedStudentPage.toggleCourses();
        LOGGER.info("Opened student's course list at {}", driver.getCurrentUrl());

        LOGGER.debug("Adding a new course...");
        // Open course selection
        toggleCoursesPage.addNewCourse();
        LOGGER.debug("Selecting a course and entering number of classes...");
        // Select course and enter preferred number of classes
        toggleCoursesPage.selectCourse("20");
        LOGGER.debug("Confirming selection...");
        // Confirm selection
        toggleCoursesPage.saveNewCourse();
        LOGGER.info("Assigned student to a new course: {}", toggleCoursesPage.getSelectedCourseName());

        LOGGER.debug("Asserting the entered data...");
        // Make sure that the right course is added to student's list of courses
        assertEquals(toggleCoursesPage.getSelectedCourseItemText(), toggleCoursesPage.getSelectedCourseName());
        LOGGER.info("Data successfully asserted.");

        LOGGER.debug("Updating number of classes for course with name={}", toggleCoursesPage.getSelectedCourseName());
        // Open info about certain course and update number of classes for it
        toggleCoursesPage.editExistingCourseClassNumber("22");

        LOGGER.debug("Asserting the update data...");
        // Make sure that number of classes corresponds the entered number
        assertEquals("22", toggleCoursesPage.getSelectedCourseClassNumber());
        LOGGER.info("Data successfully asserted.");

        LOGGER.debug("Removing selected course from student's course list...");
        // Open info about certain course and remove it from student's list of courses
        toggleCoursesPage.removeExistingCourse();

        LOGGER.debug("Asserting the remove operation...");
        // Make sure that the right course is removed (in this case, list of courses goes to empty state)
        assertTrue(toggleCoursesPage.doesElementExist(driver, By.xpath(toggleCoursesPage.getNoRowsXPath())));
        LOGGER.info("Operation successfully asserted.");

        LOGGER.info("StudentCourseCrudTest successfully finished.");
    }

}
