package com.alasdoo.developercourseassignment.tests.teacher;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.teacher.SpecifiedTeacherPage;
import com.alasdoo.developercourseassignment.pages.teacher.ToggleCoursesPage;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TeacherCourseCrudTest extends SeleniumTestConfiguration {

    @Test
    public void testTeacherCourseCrud() {
        // Navigate to specified teacher's detailed info
        driver.get("http://localhost:3000/teacher/21");

        SpecifiedTeacherPage specifiedTeacherPage = new SpecifiedTeacherPage(driver);

        // Open list of courses teacher is assigned to
        ToggleCoursesPage toggleCoursesPage = specifiedTeacherPage.toggleCourses();

        // Open course selection
        toggleCoursesPage.addNewCourse();
        // Select course
        toggleCoursesPage.selectCourse();
        // Confirm selection
        toggleCoursesPage.saveNewCourse();

        // Make sure that the right course is added to teacher's list of courses
        assertEquals(toggleCoursesPage.getSelectedCourseItemText(), toggleCoursesPage.getSelectedCourseName());

        // Open info about certain course and remove it from teacher's list of courses
        toggleCoursesPage.removeExistingCourse();

        // Make sure that the right course is removed (in this case, list of courses goes to empty state)
        assertTrue(toggleCoursesPage.doesElementExist(driver, By.xpath(toggleCoursesPage.getNoRowsXPath())));
    }

}
