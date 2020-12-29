package com.alasdoo.developercourseassignment.tests.teacher;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.teacher.NewTeacherPage;
import com.alasdoo.developercourseassignment.pages.teacher.SpecifiedTeacherPage;
import com.alasdoo.developercourseassignment.pages.teacher.TeacherListPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddNewTeacherTest extends SeleniumTestConfiguration {

    @Test
    public void addNewTeacher() {
        // Navigate to a list display of teachers
        driver.get("http://localhost:3000/teacher");

        TeacherListPage teacherListPage = new TeacherListPage(driver);

        // Open a "New teacher" form
        NewTeacherPage newTeacherPage = teacherListPage.addNewTeacher();

        // Enter data for new teacher
        newTeacherPage.enterTeacherInfo("Marco", "Marconi", "marcomarconi@gmail.com");

        // Confirm entered data
        SpecifiedTeacherPage specifiedTeacherPage = newTeacherPage.submitData();

        // Make sure that newly added teacher is indeed the one we wanted
        assertEquals("Marco", specifiedTeacherPage.getName());
        assertEquals("Marconi", specifiedTeacherPage.getSurname());
    }

}
