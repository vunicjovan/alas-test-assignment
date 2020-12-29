package com.alasdoo.developercourseassignment;

import com.alasdoo.developercourseassignment.tests.course.CourseCrudTest;
import com.alasdoo.developercourseassignment.tests.data.DataInjectionTest;
import com.alasdoo.developercourseassignment.tests.student.AddNewStudentTest;
import com.alasdoo.developercourseassignment.tests.student.StudentCourseCrudTest;
import com.alasdoo.developercourseassignment.tests.student.UpdateDeleteStudentTest;
import com.alasdoo.developercourseassignment.tests.teacher.AddNewTeacherTest;
import com.alasdoo.developercourseassignment.tests.teacher.TeacherCourseCrudTest;
import com.alasdoo.developercourseassignment.tests.teacher.UpdateDeleteTeacherTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Batch suite containing every E2E test, starting from data injection and ending with Course CRUD operation test.
 * In order to run this suite, make sure to previously run both server and client applications.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        // data injection
        DataInjectionTest.class,
        // student suite
        AddNewStudentTest.class,
        StudentCourseCrudTest.class,
        UpdateDeleteStudentTest.class,
        // teacher suite
        AddNewTeacherTest.class,
        TeacherCourseCrudTest.class,
        UpdateDeleteTeacherTest.class,
        // course suite
        CourseCrudTest.class
})
public class BatchTestSuite {
}
