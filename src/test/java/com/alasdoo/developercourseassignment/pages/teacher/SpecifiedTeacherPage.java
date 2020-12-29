package com.alasdoo.developercourseassignment.pages.teacher;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecifiedTeacherPage extends PageObject {

    /*
     * toggleCoursesButton = button meant for displaying courses teacher is assigned to
     * nameInput = input field for teacher name
     * surnameInput = input field for teacher surname
     * emailInput = input field for teacher email
     * deleteButton = button meant for removal of specified teacher object
     * saveButton = form-submit button
     */
    @FindBy(xpath = "//span[contains(text(), 'Toggle courses')]")
    private WebElement toggleCoursesButton;

    @FindBy(name = "teacherName")
    private WebElement nameInput;

    @FindBy(name = "teacherSurname")
    private WebElement surnameInput;

    @FindBy(name = "teacherEmail")
    private WebElement emailInput;

    @FindBy(xpath = "//span[contains(text(), 'Delete')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(), 'Save')]")
    private WebElement saveButton;

    public SpecifiedTeacherPage(WebDriver driver) {
        super(driver);
        assertTrue(nameInput.isDisplayed());  // page will not be created if it isn't ready in time
    }

    /**
     * Simple retrieval methods for text content of certain web elements
     * @return String elementTextValue
     */
    public String getName() {
        return this.nameInput.getAttribute("value");
    }

    public String getSurname() {
        return this.surnameInput.getAttribute("value");
    }

    /**
     * Multi-part user action for entering the new info about given teacher.
     * name = updated teacher name typed by user
     * surname = updated teacher surname typed by user
     * email = updated teacher email typed by user
     */
    public void updatePersonalInfo(String name, String surname, String email) {
        clearInput(this.nameInput);
        this.nameInput.sendKeys(name);

        clearInput(this.surnameInput);
        this.surnameInput.sendKeys(surname);

        clearInput(this.emailInput);
        this.emailInput.sendKeys(email);
    }

    /**
     * Confirmation of input data
     */
    public void submitChanges() {
        this.saveButton.click();
    }

    /**
     * Remove specified teacher.
     * @return TeacherListPage teacherListPage
     */
    public TeacherListPage deleteTeacher() {
        this.deleteButton.click();
        return new TeacherListPage(driver);
    }

    /**
     * Display all courses given teacher is assigned to.
     * @return ToggleCoursesPage toggleCoursesPage
     */
    public ToggleCoursesPage toggleCourses() {
        this.toggleCoursesButton.click();
        return new ToggleCoursesPage(driver);
    }

    /**
     * Helper method for input field clearing, considered as a workaround, especially for Chrome.
     * Reference: https://github.com/SeleniumHQ/selenium/issues/6741
     */
    private void clearInput(WebElement element) {
        element.clear();
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

}
