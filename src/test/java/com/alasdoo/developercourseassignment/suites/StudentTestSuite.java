package com.alasdoo.developercourseassignment.suites;

import com.alasdoo.developercourseassignment.tests.data.DataInjectionTest;
import com.alasdoo.developercourseassignment.tests.student.AddNewStudentTest;
import com.alasdoo.developercourseassignment.tests.student.StudentCourseCrudTest;
import com.alasdoo.developercourseassignment.tests.student.UpdateDeleteStudentTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite with data injection and every Student test included.
 * In order to run this suite, make sure to previously run both server and client applications.
 * NOTE: in order to successfully run this suite after you have previously ran some other available suite, please
 * restart the server application. This is due to data injection.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DataInjectionTest.class,
        AddNewStudentTest.class,
        StudentCourseCrudTest.class,
        UpdateDeleteStudentTest.class
})
public class StudentTestSuite {
}
