package com.alasdoo.developercourseassignment.pages.student;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentListPage extends PageObject {

    @FindBy(xpath = "/html/body/div/div/main/div[2]/button")
    private WebElement plusButton;

    public StudentListPage(WebDriver driver) {
        super(driver);
        assertTrue(plusButton.isDisplayed());
    }

    public NewStudentPage addNewStudent() {
        this.plusButton.click();
        return new NewStudentPage(driver);
    }
}
