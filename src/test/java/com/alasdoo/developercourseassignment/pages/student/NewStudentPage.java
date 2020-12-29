package com.alasdoo.developercourseassignment.pages.student;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewStudentPage extends PageObject {

    /*
     * nameInput = input field for student name
     * surnameInput = input field for student surname
     * accountNameInput = input field for account name of the student
     * emailInput = input field for student email
     * bankCardNumberInput = input field for bank card number of the student
     * submitButton = form-submit button
     */
    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "surname")
    private WebElement surnameInput;

    @FindBy(name = "accountName")
    private WebElement accountNameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "bankCardNumber")
    private WebElement bankCardNumberInput;

    @FindBy(xpath = "//span[contains(text(), 'Save')]")
    private WebElement submitButton;

    public NewStudentPage(WebDriver driver) {
        super(driver);
        assertTrue(nameInput.isDisplayed());  // page will not be created if it isn't ready in time
    }

    /**
     * Multi-part user action for entering personal information about student into the form inputs.
     */
    public void enterNameAndSurname(String name, String surname) {
        clearInput(this.nameInput);
        this.nameInput.sendKeys(name);

        clearInput(this.surnameInput);
        this.surnameInput.sendKeys(surname);
    }

    /**
     * Multi-part user action for entering business information about student into the form inputs.
     */
    public void enterBusinessData(String accountName, String email, String bankCardNumber) {
        clearInput(this.accountNameInput);
        this.accountNameInput.sendKeys(accountName);

        clearInput(this.emailInput);
        this.emailInput.sendKeys(email);

        clearInput(this.bankCardNumberInput);
        this.bankCardNumberInput.sendKeys(bankCardNumber);
    }

    /**
     * Confirmation of input data, redirecting the user to a route meant for displaying newly added student.
     * @return SpecifiedStudentPage specifiedStudentPage
     */
    public SpecifiedStudentPage submitData() {
        this.submitButton.click();
        return new SpecifiedStudentPage(driver);
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
