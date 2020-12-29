package com.alasdoo.developercourseassignment.tests.student;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.student.SpecifiedStudentPage;
import com.alasdoo.developercourseassignment.pages.student.StudentListPage;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UpdateDeleteStudentTest extends SeleniumTestConfiguration {

    @Test
    public void testStudentUpdateDelete() {
        // Navigate to a list display of students
        driver.get("http://localhost:3000/student");

        StudentListPage studentListPage = new StudentListPage(driver);

        // Open detailed view for selected student
        SpecifiedStudentPage specifiedStudentPage = studentListPage.selectStudent();

        // Update personal information about existing student: name, surname, email
        specifiedStudentPage.updatePersonalInfo("Jack", "Jackson", "jackjackson@gmail.com");
        // Confirm entered data
        specifiedStudentPage.submitChanges();

        // Make sure the student data corresponds to entered data
        assertEquals("Jack", specifiedStudentPage.getName());
        assertEquals("Jackson", specifiedStudentPage.getSurname());

        // Remove selected student from database
        StudentListPage returnStudentListPage = specifiedStudentPage.deleteStudent();

        // Make sure that the right student is removed
        assertFalse(returnStudentListPage.doesElementExist(driver, By.xpath("//*[contains(text(), 'jackjackson@gmail.com')]")));
    }

}
