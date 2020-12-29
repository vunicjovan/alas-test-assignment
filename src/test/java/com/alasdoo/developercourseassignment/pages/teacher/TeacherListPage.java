package com.alasdoo.developercourseassignment.pages.teacher;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeacherListPage extends PageObject {

    /*
     * plusButton = button marked as + in bottom right corner of /teacher route
     * selectedStudentCell = web element marking the teacher selected for UPDATE/DELETE operation testing
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/button")
    private WebElement plusButton;

    @FindBy(xpath = "//*[contains(text(), 'Linda')]")
    private WebElement selectedTeacherCell;

    public TeacherListPage(WebDriver driver) {
        super(driver);
        assertTrue(plusButton.isDisplayed());  // page will not be created if it isn't ready in time
    }

    /**
     * User action for opening the "Add new teacher" form.
     * @return NewTeacherPage newTeacherPage
     */
    public NewTeacherPage addNewTeacher() {
        this.plusButton.click();
        return new NewTeacherPage(driver);
    }

    /**
     * User action for selecting a certain teacher, thus opening a route with detailed info.
     * @return SpecifiedTeacherPage specifiedTeacherPage
     */
    public SpecifiedTeacherPage selectTeacher() {
        this.selectedTeacherCell.click();
        return new SpecifiedTeacherPage(driver);
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
