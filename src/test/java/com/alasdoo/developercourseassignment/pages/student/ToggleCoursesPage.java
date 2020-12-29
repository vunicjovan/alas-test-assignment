package com.alasdoo.developercourseassignment.pages.student;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToggleCoursesPage extends PageObject {

    /*
    * addNewCourseButton = button for opening course selection for student
    * selectCoursesField = selection of courses
    * selectedCourseItem = selected course object
    * classesBoughtInput = number of classes student has bought
    * saveButton = form submit button
    * removeButton = button meant for removal of specified course object from list of student's courses
    * selectedCourseName = checking property for Assert
    * selectedCourseClassNumber = checking property for Assert
    * courseText = checking property for Assert
    */
    @FindBy(xpath = "//span[contains(text(), 'Add new course')]")
    private WebElement addNewCourseButton;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[1]/div/div")
    private WebElement selectCoursesField;

    @FindBy(xpath = "/html/body/div[2]/div[3]/ul/li[1]")
    private WebElement selectedCourseItem;

    @FindBy(name = "classesBought")
    private WebElement classesBoughtInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[3]/button[1]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[1]/form/div[3]/button[3]")
    private WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div/div[1]")
    private WebElement selectedCourseName;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div/div[2]")
    private WebElement selectedCourseClassNumber;

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

    public String getSelectedCourseClassNumber() {
        String xpath = "//div[contains(text(), '22')]";
        return driver.findElement(By.xpath(xpath)).getAttribute("innerHTML");
    }

    /**
     * User action for opening the course selection.
     */
    public void addNewCourse() {
        this.addNewCourseButton.click();
    }

    /**
     * Input number of classes for selected course.
     * @param classesBought - number of classes student wants to sign for
     */
    public void selectCourse(String classesBought) {
        this.selectCoursesField.click();

        this.courseText = this.selectedCourseItem.getText();
        this.selectedCourseItem.click();

        clearInput(this.classesBoughtInput);
        this.classesBoughtInput.sendKeys(classesBought);
    }

    /**
     * Sign student up for previously chosen course.
     */
    public void saveNewCourse() {
        this.saveButton.click();
    }

    /**
     * Update number of classes student wants to sign up for.
     * @param classNumber - updated number of classes student wants to sign for
     */
    public void editExistingCourseClassNumber(String classNumber) {
        this.selectedCourseName.click();

        clearInput(this.classesBoughtInput);
        this.classesBoughtInput.sendKeys(classNumber);

        this.saveButton.click();
    }

    /**
     * Unsign student from chosesn course.
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

    /**
     * Helper method for input field clearing, considered as a workaround, especially for Chrome.
     * Reference: https://github.com/SeleniumHQ/selenium/issues/6741
     */
    private void clearInput(WebElement element) {
        element.clear();
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

}
