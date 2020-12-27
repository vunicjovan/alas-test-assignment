package com.alasdoo.developercourseassignment.pages.data;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsPage extends PageObject {

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/div/button")
    private WebElement startButton;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/span")
    private WebElement injectionInfoSpan;

    public SettingsPage(WebDriver driver) {
        super(driver);
        assertTrue(startButton.isDisplayed());
    }

    public void injectData() {
        this.startButton.click();
    }

    public String getInjectionInfo() {
        return this.injectionInfoSpan.getAttribute("innerHTML");
    }

}
