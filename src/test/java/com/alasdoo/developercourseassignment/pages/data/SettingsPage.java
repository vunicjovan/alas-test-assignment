package com.alasdoo.developercourseassignment.pages.data;

import com.alasdoo.developercourseassignment.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsPage extends PageObject {

    /*
     * startButton = trigger-button for data injection
     * injectionInfoSpan = span with confirmation text in terms of successful data injection
     */
    @FindBy(xpath = "//span[contains(text(), 'Start')]")
    private WebElement startButton;

    @FindBy(xpath = "//span[contains(text(), 'Injected')]")
    private WebElement injectionInfoSpan;

    public SettingsPage(WebDriver driver) {
        super(driver);
        assertTrue(startButton.isDisplayed());  // page will not be created if it isn't ready in time
    }

    /**
     * Injecting predefined data from scripts to database.
     */
    public void injectData() {
        this.startButton.click();
    }

    /**
     * Retrieve confirmation info about data injection.
     * @return String injectionInfo
     */
    public String getInjectionInfo() {
        return this.injectionInfoSpan.getAttribute("innerHTML");
    }

}
