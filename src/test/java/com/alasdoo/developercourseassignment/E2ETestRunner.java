package com.alasdoo.developercourseassignment;

import com.alasdoo.developercourseassignment.tests.data.DataInjectionTest;
import com.alasdoo.developercourseassignment.tests.student.AddNewStudentTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DataInjectionTest.class,
        AddNewStudentTest.class
})
public class E2ETestRunner {
}
