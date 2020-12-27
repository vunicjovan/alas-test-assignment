package com.alasdoo.developercourseassignment.pages.student;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpecifiedStudentPage extends PageObject {

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div[2]/form/div[6]/button")
    private WebElement toggleCoursesButton;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "surname")
    private WebElement surnameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div[2]/form/div[7]/button[2]")
    private WebElement deleteButton;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div[2]/form/div[7]/button[1]")
    private WebElement saveButton;

    public SpecifiedStudentPage(WebDriver driver) {
        super(driver);
        assertTrue(nameInput.isDisplayed());
    }

    public void updatePersonalInfo(String name, String surname, String email) {
        this.nameInput.clear();
        this.nameInput.sendKeys(name);

        this.surnameInput.clear();
        this.surnameInput.sendKeys(surname);

        this.emailInput.clear();
        this.emailInput.sendKeys(email);
    }

    public void submitChanges() {
        this.saveButton.click();
    }

    public StudentListPage deleteStudent() {
        this.deleteButton.click();
        return new StudentListPage(driver);
    }

    public ToggleCoursesPage toggleCourses() {
        this.toggleCoursesButton.click();
        return new ToggleCoursesPage(driver);
    }

    public String getName() {
        return this.nameInput.getAttribute("value");
    }

    public String getSurname() {
        return this.surnameInput.getAttribute("value");
    }

}
