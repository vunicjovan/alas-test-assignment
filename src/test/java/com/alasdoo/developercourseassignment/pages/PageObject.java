package com.alasdoo.developercourseassignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    protected WebDriver driver;

    /**
     * The PageFactory processes all the annotated WebElements and locates the element on the
     * page using the annotated selector.
     */
    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
