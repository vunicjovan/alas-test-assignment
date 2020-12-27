package com.alasdoo.developercourseassignment.pages.student;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToggleCoursesPage extends PageObject {

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div[3]/div[1]/button")
    private WebElement addNewCourseButton;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div[3]/div[1]/form/div[1]/div/div")
    private WebElement selectCoursesField;

    @FindBy(xpath = "/html/body/div[2]/div[3]/ul/li[1]")
    private WebElement selectedCourseItem;

    @FindBy(name = "classesBought")
    private WebElement classesBoughtInput;

    public ToggleCoursesPage(WebDriver driver) {
        super(driver);
    }

    public void addNewCourse() {
        this.addNewCourseButton.click();
    }

    public void selectCourse(String classesBought) {
        this.selectCoursesField.click();

        this.selectedCourseItem.click();

        this.classesBoughtInput.clear();
        this.classesBoughtInput.sendKeys(classesBought);
    }

}
