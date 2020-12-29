package com.alasdoo.developercourseassignment.tests.student;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.student.NewStudentPage;
import com.alasdoo.developercourseassignment.pages.student.SpecifiedStudentPage;
import com.alasdoo.developercourseassignment.pages.student.StudentListPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddNewStudentTest extends SeleniumTestConfiguration {

    @Test
    public void addNewStudent() {
        // Navigate to a list display of students
        driver.get("http://localhost:3000/student");

        StudentListPage studentListPage = new StudentListPage(driver);

        // Open a "New student" form
        NewStudentPage newStudentPage = studentListPage.addNewStudent();

        // Enter data for new student
        newStudentPage.enterNameAndSurname("John", "Doe");
        newStudentPage.enterBusinessData("johndoe", "johndoe@gmail.com", "123123");

        // Confirm entered data
        SpecifiedStudentPage specifiedStudentPage = newStudentPage.submitData();

        // Make sure that newly added student is indeed the one we wanted
        assertEquals("John", specifiedStudentPage.getName());
        assertEquals("Doe", specifiedStudentPage.getSurname());
    }

}
