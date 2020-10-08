package com.apexSystems.pages;

import com.apexSystems.pojo.Puppy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends ParentPage{

    //elements
    WebElement puppyListHeader; //css="#intro + h1"
    WebElement puppyContainer; //css="puppy_list"
    WebElement puppyImg; //css=".image img"
    WebElement puppyName; //css=".name h3"
    WebElement puppyBreed; //css=".details h4:first-child"
    WebElement puppySex; //css=".details h4:last-child"
    WebElement viewDetailsBtn; //css="input[value='View Details']"

    public HomePage(WebDriver driver) {
        super(driver);
    }
//methods

    public boolean isAt() { return false;}
    public Puppy selectPuppyByName(String name) {return null;}
    public Puppy selectPuppyByBreed(String breed) {return null;}
    public Puppy selectPuppyBySex(char sex, int index) {return null;}
    public Puppy selectPuppy(String puppyInfo) {return null;}

}
