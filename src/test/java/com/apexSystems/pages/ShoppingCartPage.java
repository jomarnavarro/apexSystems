package com.apexSystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends ParentPage {

    //elements
    WebElement yourLittlerHeader; //css="#content > h2"
    WebElement puppyTable; //css="table"
    WebElement puppyImg; //
    WebElement puppyName; //
    WebElement puppyBreed; //
    WebElement cartTotal; //css=".total_cell"
    WebElement completeAdoptionBtn; //css="[value*='Complete']"
    WebElement adoptAnotherBtn; //css="[value^='Adopt']"
    WebElement changeMindBtn; //css="[value*='Change']"

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    //methods
    public boolean isAt() {return false;}
    public void completeAdoption() {}

}
