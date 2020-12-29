package com.alasdoo.developercourseassignment.tests.course;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.course.CourseListPage;
import com.alasdoo.developercourseassignment.pages.course.NewCoursePage;
import com.alasdoo.developercourseassignment.pages.course.SpecifiedCoursePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CourseCrudTest extends SeleniumTestConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(CourseCrudTest.class);

    @Test
    public void testCourseCrud() {
        LOGGER.info("CourseCrudTest started.");
        // Navigating to a list display of courses
        driver.get("http://localhost:3000/course");

        CourseListPage courseListPage = new CourseListPage(driver);
        LOGGER.info("Navigated to {}", driver.getCurrentUrl());

        NewCoursePage newCoursePage = courseListPage.addNewCourse();
        LOGGER.info("Opened form for addition of new course at {}", driver.getCurrentUrl());

        // Creating a new course
        newCoursePage.enterCourseData("Test course", "10", "40");
        LOGGER.debug("Entering course data...");

        SpecifiedCoursePage specifiedCoursePage = newCoursePage.submitData();
        LOGGER.info("Created a new course with name={}, cost={} and number of weekly classes={}",
                specifiedCoursePage.getName(), specifiedCoursePage.getCost(), specifiedCoursePage.getClassesPerWeek());

        LOGGER.debug("Asserting the entered data...");
        // Check if data corresponds
        assertEquals("Test course", specifiedCoursePage.getName());
        assertEquals("10", specifiedCoursePage.getCost());
        assertEquals("40", specifiedCoursePage.getClassesPerWeek());
        LOGGER.info("Data successfully asserted.");

        // Update info about an existing course
        LOGGER.info("Opened form for course update at {}", driver.getCurrentUrl());
        specifiedCoursePage.updateCourseData("Updated test course", "12", "42");
        LOGGER.debug("Entering course update data...");
        specifiedCoursePage.submitData();
        LOGGER.info("Updated a course with following data: name={}, cost={} and number of weekly classes={}",
                specifiedCoursePage.getName(), specifiedCoursePage.getCost(), specifiedCoursePage.getClassesPerWeek());

        LOGGER.debug("Asserting the update data...");
        // Check if updated data corresponds
        assertEquals("Updated test course", specifiedCoursePage.getName());
        assertEquals("12", specifiedCoursePage.getCost());
        assertEquals("42", specifiedCoursePage.getClassesPerWeek());
        LOGGER.info("Data successfully asserted.");

        // Remove an existing course
        CourseListPage returnCourseListPage = specifiedCoursePage.removeExistingCourse();
        LOGGER.info("Removed selected course and navigated to {}", driver.getCurrentUrl());

        LOGGER.debug("Asserting the remove operation...");
        // Check if removed course still exists
        assertFalse(returnCourseListPage.doesElementExist(driver, By.xpath("//*[contains(text(), 'Updated test course')]")));
        LOGGER.info("Operation successfully asserted.");

        LOGGER.info("CourseCrudTest finished successfully.");
    }

}
