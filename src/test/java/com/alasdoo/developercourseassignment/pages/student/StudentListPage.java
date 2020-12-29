package com.alasdoo.developercourseassignment.pages.student;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentListPage extends PageObject {

    /*
     * plusButton = button marked as + in bottom right corner of /student route
     * selectedStudentCell = web element marking the student selected for UPDATE/DELETE operation testing
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/button")
    private WebElement plusButton;

    @FindBy(xpath = "//*[contains(text(), 'camden_gray')]")
    private WebElement selectedStudentCell;

    public StudentListPage(WebDriver driver) {
        super(driver);
        assertTrue(plusButton.isDisplayed());  // page will not be created if it isn't ready in time
    }

    /**
     * User action for opening the "Add new student" form.
     * @return NewStudentPage newStudentPage
     */
    public NewStudentPage addNewStudent() {
        this.plusButton.click();
        return new NewStudentPage(driver);
    }

    /**
     * User action for selecting a certain student, thus opening a route with detailed info.
     * @return SpecifiedStudentPage specifiedStudentPage
     */
    public SpecifiedStudentPage selectStudent() {
        this.selectedStudentCell.click();
        return new SpecifiedStudentPage(driver);
    }

    /**
     * Helper method for element presence check.
     * driver = driver used for testing
     * by = selector used for element retrieval
     * @return boolean doesElementExist
     */
    public boolean doesElementExist(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }

}
