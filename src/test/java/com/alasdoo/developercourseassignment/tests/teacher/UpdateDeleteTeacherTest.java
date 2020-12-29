package com.alasdoo.developercourseassignment.tests.teacher;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.teacher.SpecifiedTeacherPage;
import com.alasdoo.developercourseassignment.pages.teacher.TeacherListPage;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UpdateDeleteTeacherTest extends SeleniumTestConfiguration {

    @Test
    public void testTeacherUpdateDelete() {
        // Navigate to a list display of teachers
        driver.get("http://localhost:3000/teacher");

        TeacherListPage teacherListPage = new TeacherListPage(driver);

        // Open detailed view for selected teacher
        SpecifiedTeacherPage specifiedTeacherPage = teacherListPage.selectTeacher();

        // Update personal information about existing teacher: name, surname, email
        specifiedTeacherPage.updatePersonalInfo("Magnus", "Magnusson", "magnusmagnusson@gmail.com");
        // Confirm entered data
        specifiedTeacherPage.submitChanges();

        // Make sure the teacher data corresponds to entered data
        assertEquals("Magnus", specifiedTeacherPage.getName());
        assertEquals("Magnusson", specifiedTeacherPage.getSurname());

        // Remove selected teacher from database
        TeacherListPage returnTeacherListPage = specifiedTeacherPage.deleteTeacher();

        // Make sure that the right teacher is removed
        assertFalse(returnTeacherListPage.doesElementExist(driver, By.xpath("//*[contains(text(), 'magnusmagnusson@gmail.com')]")));
    }

}
