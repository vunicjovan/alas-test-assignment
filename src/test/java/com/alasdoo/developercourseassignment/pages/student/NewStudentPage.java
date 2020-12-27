package com.alasdoo.developercourseassignment.pages.student;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewStudentPage extends PageObject {

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

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div[2]/form/div[6]/button[1]")
    private WebElement submitButton;

    public NewStudentPage(WebDriver driver) {
        super(driver);
        assertTrue(nameInput.isDisplayed());
    }

    public void enterNameAndSurname(String name, String surname) {
        this.nameInput.clear();
        this.nameInput.sendKeys(name);

        this.surnameInput.clear();
        this.surnameInput.sendKeys(surname);
    }

    public void enterBusinessData(String accountName, String email, String bankCardNumber) {
        this.accountNameInput.clear();
        this.accountNameInput.sendKeys(accountName);

        this.emailInput.clear();
        this.emailInput.sendKeys(email);

        this.bankCardNumberInput.clear();
        this.bankCardNumberInput.sendKeys(bankCardNumber);
    }

    public SpecifiedStudentPage submitData() {
        this.submitButton.click();
        return new SpecifiedStudentPage(driver);
    }

}
