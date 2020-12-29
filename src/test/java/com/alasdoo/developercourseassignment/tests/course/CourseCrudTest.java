package com.alasdoo.developercourseassignment.tests.course;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.course.CourseListPage;
import com.alasdoo.developercourseassignment.pages.course.NewCoursePage;
import com.alasdoo.developercourseassignment.pages.course.SpecifiedCoursePage;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CourseCrudTest extends SeleniumTestConfiguration {

    @Test
    public void testCourseCrud() {
        // Navigating to a list display of courses
        driver.get("http://localhost:3000/course");
        CourseListPage courseListPage = new CourseListPage(driver);
        NewCoursePage newCoursePage = courseListPage.addNewCourse();

        // Creating a new course
        newCoursePage.enterCourseData("Test course", "10", "40");

        SpecifiedCoursePage specifiedCoursePage = newCoursePage.submitData();

        // Check if data corresponds
        assertEquals("Test course", specifiedCoursePage.getName());
        assertEquals("10", specifiedCoursePage.getCost());
        assertEquals("40", specifiedCoursePage.getClassesPerWeek());

        // Update info about an existing course
        specifiedCoursePage.updateCourseData("Updated test course", "12", "42");
        specifiedCoursePage.submitData();

        // Check if updated data corresponds
        assertEquals("Updated test course", specifiedCoursePage.getName());
        assertEquals("12", specifiedCoursePage.getCost());
        assertEquals("42", specifiedCoursePage.getClassesPerWeek());

        // Remove an existing course
        CourseListPage returnCourseListPage = specifiedCoursePage.removeExistingCourse();

        // Check if removed course still exists
        assertFalse(returnCourseListPage.doesElementExist(driver, By.xpath("//*[contains(text(), 'Updated test course')]")));
    }

}
