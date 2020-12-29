# Alas d.o.o. Java developer test assignment

## How to run the application

1. Install Java 8: Go to https://adoptopenjdk.net/ and download version 8. If the Operating System is Windows: set the system environments for `JAVA_HOME` (jdk root folder) and `PATH` (jdk root folder\bin)
2. To start the backend run `mvnw spring-boot:run` command (control + c will kill the application)
3. Build the frontend: `cd src/frontend`, `yarn`. (install `yarn` and `node` if needed)
4. To start the frontend go to `src/frontend` and run `yarn start`. It will run on `localhost:3000`.

## What is covered with tests

There are in total 8 E2E tests:

1. *DataInjectionTest* - injecting predefined data to database, mandatory for other tests to run
2. *AddNewStudentTest* - process of adding a new student
3. *StudentCourseCrudTest* - assign a course to previously added student, edit number of its classes and remove it afterwards
4. *UpdateDeleteStudentTest* - update personal information about specified student and remove given student
5. *AddNewTeacherTest* - process of adding a new teacher
6. *TeacherCourseCrudTest* - assign a course to previously added teacher and remove it afterwards
7. *UpdateDeleteTeacherTest* - update personal information about specified teacher and remove given teacher
8. *CourseCrudTest* - define a new developer course, update it with new information and remove it afterwards

Tests are made to support following web browsers:
* [*Chrome*](https://github.com/vunicjovan/alas-test-assignment/blob/master/src/test/resources/webdriver/chromedriver.exe)
* [*Firefox*](https://github.com/vunicjovan/alas-test-assignment/blob/master/src/test/resources/webdriver/geckodriver.exe)
* [*Opera*](https://github.com/vunicjovan/alas-test-assignment/blob/master/src/test/resources/webdriver/operadriver.exe)
* [*Edge*](https://github.com/vunicjovan/alas-test-assignment/blob/master/src/test/resources/webdriver/edgedriver.exe)

In order to change the browser, all you need to do is to change a single parameter of [*SeleniumConfiguration*](https://github.com/vunicjovan/alas-test-assignment/blob/master/src/test/java/com/alasdoo/developercourseassignment/config/SeleniumTestConfiguration.java) class:

`protected static String browserType = "YOUR_BROWSER_TYPE";`, where `YOUR_BROWSER_TYPE` can be one of the following values:
* *chrome*
* *gecko*
* *opera*
* *edge*

## How to run tests

Since the tests are organized in [test suits](https://github.com/vunicjovan/alas-test-assignment/tree/master/src/test/java/com/alasdoo/developercourseassignment/suites), there are two ways to run them:

1. Using [*BatchTestSuite*](https://github.com/vunicjovan/alas-test-assignment/blob/master/src/test/java/com/alasdoo/developercourseassignment/BatchTestSuite.java)
2. Using isolated test suites

### 1. Using *BatchTestSuite*

In order to run batch test suite, you first need to run both server and client applications.
After that, just run *BatchTestSuite* class to initialize the test run.

### 2. Using isolated test suits

Isolated test suits represent set of test suits, where every suit is meant for testing of a single entity.
For example, *StudentTestSuite* covers only tests refering to *Student* entity.

In order to run isolated test suite, you first need to run both server and client applications.
After that, just run chosen test suite class to initialize the test run.

### NOTE

In addition, below are demo shots of batch test suite in action, with both *Chrome* and *Opera* browsers:
* [Chrome demo](https://drive.google.com/file/d/1reLGfSrA2DccU1iliax9IshMv9ThpK-2/view?usp=sharing)
* [Opera demo](https://drive.google.com/file/d/1DwVX5ArYHmebsRrMyyCfTjduNCzHIwtF/view?usp=sharing)

Additional takeaways:

* Solution was developed in IntelliJ IDEA IDE
* Client and server side can be executed from shell (explained at the start of document), but test suites cannot - one should open them in IDE and run them
* slf4j was used as a test logging system
