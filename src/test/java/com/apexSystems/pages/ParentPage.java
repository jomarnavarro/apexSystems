package com.apexSystems.pages;

import com.apexSystems.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Constants.LONG_WAIT);
        PageFactory.initElements(this.driver, this);
    }

    protected boolean isAt(WebElement ... pageElements) {
        boolean allFound = true;
        for(WebElement we: pageElements) {
            allFound = allFound && wait.until(ExpectedConditions.visibilityOf(we)).isDisplayed();
        }
        return allFound;
    }

    protected String getNestedElementAttribute(WebElement parent, By selector, String attribute) {
        return wait.until(
                ExpectedConditions.
                        presenceOfNestedElementLocatedBy(parent, selector)
        ).getAttribute(attribute);
    }

    protected String getNestedElementText(WebElement parent, By nestedElementLocator) {
        return wait.until(
                ExpectedConditions.
                        presenceOfNestedElementLocatedBy(parent, nestedElementLocator)
        ).getText();
    }
}
