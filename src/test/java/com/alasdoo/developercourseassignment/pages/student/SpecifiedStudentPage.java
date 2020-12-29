package com.alasdoo.developercourseassignment.pages.student;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecifiedStudentPage extends PageObject {

    /*
     * toggleCoursesButton = button meant for displaying courses student signed for
     * nameInput = input field for student name
     * surnameInput = input field for student surname
     * emailInput = input field for student email
     * deleteButton = button meant for removal of specified student object
     * saveButton = form-submit button
     */
    @FindBy(xpath = "//span[contains(text(), 'Toggle courses')]")
    private WebElement toggleCoursesButton;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "surname")
    private WebElement surnameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//span[contains(text(), 'Delete')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(), 'Save')]")
    private WebElement saveButton;

    public SpecifiedStudentPage(WebDriver driver) {
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
     * Multi-part user action for entering the new info about given student.
     * name = updated student name typed by user
     * surname = updated student surname typed by user
     * email = updated student email typed by user
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
     * Remove specified student.
     * @return StudentListPage studentListPage
     */
    public StudentListPage deleteStudent() {
        this.deleteButton.click();
        return new StudentListPage(driver);
    }

    /**
     * Display all courses given student signed for.
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
