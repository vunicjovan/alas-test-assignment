package com.alasdoo.developercourseassignment.tests.student;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.student.SpecifiedStudentPage;
import com.alasdoo.developercourseassignment.pages.student.ToggleCoursesPage;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentCourseCrudTest extends SeleniumTestConfiguration {

    @Test
    public void TestCourseCrudOperations() {
        // Navigate to specified student's detailed info
        driver.get("http://localhost:3000/student/21");

        SpecifiedStudentPage specifiedStudentPage = new SpecifiedStudentPage(driver);

        // Open list of courses student has signed for
        ToggleCoursesPage toggleCoursesPage = specifiedStudentPage.toggleCourses();

        // Open course selection
        toggleCoursesPage.addNewCourse();
        // Select course and enter preferred number of classes
        toggleCoursesPage.selectCourse("20");
        // Confirm selection
        toggleCoursesPage.saveNewCourse();

        // Make sure that the right course is added to student's list of courses
        assertEquals(toggleCoursesPage.getSelectedCourseItemText(), toggleCoursesPage.getSelectedCourseName());

        // Open info about certain course and update number of classes for it
        toggleCoursesPage.editExistingCourseClassNumber("22");

        // Make sure that number of classes corresponds the entered number
        assertEquals("22", toggleCoursesPage.getSelectedCourseClassNumber());

        // Open info about certain course and remove it from student's list of courses
        toggleCoursesPage.removeExistingCourse();

        // Make sure that the right course is removed (in this case, list of courses goes to empty state)
        assertTrue(toggleCoursesPage.doesElementExist(driver, By.xpath(toggleCoursesPage.getNoRowsXPath())));
    }

}
