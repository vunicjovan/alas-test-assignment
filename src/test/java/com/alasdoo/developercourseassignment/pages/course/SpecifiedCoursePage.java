package com.alasdoo.developercourseassignment.pages.course;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecifiedCoursePage extends PageObject {

    /*
     * nameInput = editable input field with current course name
     * costInput = editable input field with current cost of the course per class
     * classesPerWeekInput = editable input field with current number of classes per week on specified course
     * deleteButton = button for removal of given course object
     * saveButton = form-submit button
     */
    @FindBy(name = "developerCourseName")
    private WebElement nameInput;

    @FindBy(name = "costPerClass")
    private WebElement costInput;

    @FindBy(name = "classesPerWeek")
    private WebElement classesPerWeekInput;

    @FindBy(xpath = "//span[contains(text(), 'Delete')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(), 'Save')]")
    private WebElement saveButton;

    public SpecifiedCoursePage(WebDriver driver) {
        super(driver);
        assertTrue(nameInput.isDisplayed());  // page will not be created if it isn't ready in time
    }

    /**
    * Multi-part user action for entering the new info about given course object.
    * name = updated course name typed by user
    * cost = updated course per-class-cost typed by user
    * classesPerWeek = updated course weekly-number of classes typed by user
    */
    public void updateCourseData(String name, String cost, String classesPerWeek) {
        clearInput(this.nameInput);
        this.nameInput.sendKeys(name);

        clearInput(this.costInput);
        this.costInput.sendKeys(cost);

        clearInput(this.classesPerWeekInput);
        this.classesPerWeekInput.sendKeys(classesPerWeek);
    }

    /**
    * Confirmation of input data
    */
    public void submitData() {
        this.saveButton.click();
    }

    /**
     * Remove specified course object.
     * @return CourseListPage courseListPage
     */
    public CourseListPage removeExistingCourse() {
        this.deleteButton.click();
        return new CourseListPage(driver);
    }

    /**
    * Simple retrieval methods for text content of certain web elements
     * @return String elementTextValue
    */
    public String getName() {
        return this.nameInput.getAttribute("value");
    }

    public String getCost() {
        return this.costInput.getAttribute("value");
    }

    public String getClassesPerWeek() {
        return this.classesPerWeekInput.getAttribute("value");
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
