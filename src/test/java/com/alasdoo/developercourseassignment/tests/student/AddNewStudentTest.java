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
        driver.get("http://localhost:3000/student");

        StudentListPage studentListPage = new StudentListPage(driver);
        NewStudentPage newStudentPage = studentListPage.addNewStudent();

        newStudentPage.enterNameAndSurname("John", "Doe");
        newStudentPage.enterBusinessData("johndoe", "johndoe@gmail.com", "123123");

        SpecifiedStudentPage specifiedStudentPage = newStudentPage.submitData();

        System.out.println(specifiedStudentPage.getName());
        System.out.println(specifiedStudentPage.getSurname());
        assertEquals("John", specifiedStudentPage.getName());
        assertEquals("Doe", specifiedStudentPage.getSurname());
    }

}
