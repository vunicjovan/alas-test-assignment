package com.alasdoo.developercourseassignment.tests.student;

import com.alasdoo.developercourseassignment.config.SeleniumTestConfiguration;
import com.alasdoo.developercourseassignment.pages.student.NewStudentPage;
import com.alasdoo.developercourseassignment.pages.student.SpecifiedStudentPage;
import com.alasdoo.developercourseassignment.pages.student.StudentListPage;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class AddNewStudentTest extends SeleniumTestConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(AddNewStudentTest.class);

    @Test
    public void addNewStudent() {
        LOGGER.info("AddNewStudentTest started.");
        // Navigate to a list display of students
        driver.get("http://localhost:3000/student");

        StudentListPage studentListPage = new StudentListPage(driver);
        LOGGER.info("Navigated to {}", driver.getCurrentUrl());

        LOGGER.debug("Opening form for addition of new student...");
        // Open a "New student" form
        NewStudentPage newStudentPage = studentListPage.addNewStudent();
        LOGGER.info("Opened form for student addition at {}", driver.getCurrentUrl());

        LOGGER.debug("Entering data about student...");
        // Enter data for new student
        newStudentPage.enterNameAndSurname("John", "Doe");
        newStudentPage.enterBusinessData("johndoe", "johndoe@gmail.com", "123123");

        LOGGER.debug("Confirming entered data...");
        // Confirm entered data
        SpecifiedStudentPage specifiedStudentPage = newStudentPage.submitData();
        LOGGER.info("Added new student: {} {} and navigated to {}", specifiedStudentPage.getName(),
                specifiedStudentPage.getSurname(), driver.getCurrentUrl());

        LOGGER.debug("Asserting the entered data...");
        // Make sure that newly added student is indeed the one we wanted
        assertEquals("John", specifiedStudentPage.getName());
        assertEquals("Doe", specifiedStudentPage.getSurname());
        LOGGER.info("Data successfully asserted.");

        LOGGER.info("AddNewStudentTest successfully finished.");
    }

}
