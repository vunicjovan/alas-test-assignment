package com.alasdoo.developercourseassignment.suites;

import com.alasdoo.developercourseassignment.tests.course.CourseCrudTest;
import com.alasdoo.developercourseassignment.tests.data.DataInjectionTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite with data injection and every Course test included.
 * In order to run this suite, make sure to previously run both server and client applications.
 * NOTE: in order to successfully run this suite after you have previously ran some other available suite, please
 * restart the server application. This is due to data injection.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DataInjectionTest.class,
        CourseCrudTest.class
})
public class CourseTestSuite {
}
