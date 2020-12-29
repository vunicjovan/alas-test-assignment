package com.alasdoo.developercourseassignment.pages.course;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseListPage extends PageObject {

    /*
    * plusButton = button marked as + in bottom right corner of /course route
    */
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/button")
    private WebElement plusButton;

    public CourseListPage(WebDriver driver) {
        super(driver);
        assertTrue(plusButton.isDisplayed());   // page will not be created if it isn't ready in time
    }

    /**
    * User action for opening the "New course" form, redirecting the user to a route meant for course creation.
    * @return NewCoursePage newCoursePage
    */
    public NewCoursePage addNewCourse() {
        this.plusButton.click();
        return new NewCoursePage(driver);
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
