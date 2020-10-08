package com.apexSystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends ParentPage{

    //elements
    WebElement adoptPuppyLnk; //css="[href='/']"
    WebElement learnLnk; //linkText="Learn"
    WebElement animalSheltersLnk; //linkText="Animal Shelters"
    WebElement classifiedsLnk; //linkText="Classifieds"
    WebElement msgBoardsLnk; //linkText="Message Boards"
    WebElement petNewsLnk; //linkText="Pet News"

    public MenuPage(WebDriver driver) {
        super(driver);
    }
    //methods
    public boolean isAt() {return false;}
}
