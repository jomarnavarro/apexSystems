package com.apexSystems.pages;

import com.apexSystems.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Constants.LONG_WAIT);
        PageFactory.initElements(this.driver, this);
    }
}
