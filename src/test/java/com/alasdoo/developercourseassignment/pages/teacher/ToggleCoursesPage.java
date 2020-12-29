package com.alasdoo.developercourseassignment.pages.teacher;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToggleCoursesPage extends PageObject {

    /*
     * addNewCourseButton = button for opening course selection for teacher
     * selectCoursesField = selection of courses
     * selectedCourseItem = selected course object
     * saveButton = form submit button
     * removeButton = button meant for removal of specified course object from list of teacher's courses
     * selectedCourseName = checking property for Assert
     * courseText = checking property for Assert
     */
    @FindBy(xpath = "//span[contains(text(), 'Assign new course')]")
    private WebElement addNewCourseButton;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[1]/div/div")
    private WebElement selectCoursesField;

    @FindBy(xpath = "/html/body/div[2]/div[3]/ul/li[1]")
    private WebElement selectedCourseItem;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[2]/button[1]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[2]/button[1]")
    private WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div/div")
    private WebElement selectedCourseName;

    private String courseText;

    public ToggleCoursesPage(WebDriver driver) {
        super(driver);
        assertTrue(addNewCourseButton.isDisplayed());  // page will not be created if it isn't ready in time
    }

    /**
     * Simple retrieval methods for text content of certain web elements
     * @return String elementTextValue
     */
    public String getSelectedCourseItemText() {
        return this.courseText;
    }

    public String getSelectedCourseName() {
        String xpath = "//*[contains(text(), '" + this.courseText + "')]";
        return driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
    }

    /**
     * User action for opening the course selection.
     */
    public void addNewCourse() {
        this.addNewCourseButton.click();
    }

    /**
     * Select course for specified teacher.
     */
    public void selectCourse() {
        this.selectCoursesField.click();
        this.courseText = this.selectedCourseItem.getText();
        this.selectedCourseItem.click();
    }

    /**
     * Assign chosen course to the specified teacher.
     */
    public void saveNewCourse() {
        this.saveButton.click();
    }

    /**
     * Remove teacher from specified course.
     */
    public void removeExistingCourse() {
        this.selectedCourseName.click();
        this.removeButton.click();
    }

    /**
     * Retrieve information about empty state of student's course list.
     * @return noRowsMessage
     */
    public String getNoRowsXPath() {
        return "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]";
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
