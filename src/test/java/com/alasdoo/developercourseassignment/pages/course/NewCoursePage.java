package com.alasdoo.developercourseassignment.pages.course;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewCoursePage extends PageObject {

    /*
    * nameInput = input field for course name
    * costInput = input field for cost of the course per class
    * classesPerWeekInput = input field for number of classes per week on specified course
    * saveButton = form-submit button
    */
    @FindBy(name = "developerCourseName")
    private WebElement nameInput;

    @FindBy(name = "costPerClass")
    private WebElement costInput;

    @FindBy(name = "classesPerWeek")
    private WebElement classesPerWeekInput;

    @FindBy(xpath = "//span[contains(text(), 'Save')]")
    private WebElement saveButton;

    public NewCoursePage(WebDriver driver) {
        super(driver);
        assertTrue(nameInput.isDisplayed());  // page will not be created if it isn't ready in time
    }

    /**
    * Multi-part user action for entering course information into the form inputs.
    */
    public void enterCourseData(String name, String cost, String classesPerWeek) {
        clearInput(this.nameInput);
        this.nameInput.sendKeys(name);

        clearInput(this.costInput);
        this.costInput.sendKeys(cost);

        clearInput(this.classesPerWeekInput);
        this.classesPerWeekInput.sendKeys(classesPerWeek);
    }

    /**
    * Confirmation of input data, redirecting the user to a route meant for displaying newly created course.
    * @return SpecifiedCoursePage specifiedCoursePage
    */
    public SpecifiedCoursePage submitData() {
        this.saveButton.click();
        return new SpecifiedCoursePage(driver);
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
