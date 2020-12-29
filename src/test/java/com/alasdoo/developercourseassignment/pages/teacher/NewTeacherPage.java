package com.alasdoo.developercourseassignment.pages.teacher;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewTeacherPage extends PageObject {

    /*
     * nameInput = input field for teacher name
     * surnameInput = input field for teacher surname
     * emailInput = input field for teacher email
     * submitButton = form-submit button
     */
    @FindBy(name = "teacherName")
    private WebElement nameInput;

    @FindBy(name = "teacherSurname")
    private WebElement surnameInput;

    @FindBy(name = "teacherEmail")
    private WebElement emailInput;

    @FindBy(xpath = "//span[contains(text(), 'Save')]")
    private WebElement submitButton;

    public NewTeacherPage(WebDriver driver) {
        super(driver);
        assertTrue(nameInput.isDisplayed());  // page will not be created if it isn't ready in time
    }

    /**
     * Multi-part user action for entering information about teacher into the form inputs.
     */
    public void enterTeacherInfo(String name, String surname, String email) {
        clearInput(this.nameInput);
        this.nameInput.sendKeys(name);

        clearInput(this.surnameInput);
        this.surnameInput.sendKeys(surname);

        clearInput(this.emailInput);
        this.emailInput.sendKeys(email);
    }

    /**
     * Confirmation of input data, redirecting the user to a route meant for displaying newly added teacher.
     * @return SpecifiedTeacherPage specifiedTeacherPage
     */
    public SpecifiedTeacherPage submitData() {
        this.submitButton.click();
        return new SpecifiedTeacherPage(driver);
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
