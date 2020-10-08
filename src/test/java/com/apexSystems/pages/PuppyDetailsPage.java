package com.apexSystems.pages;

import com.apexSystems.pojo.Puppy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PuppyDetailsPage extends ParentPage {
    //elements
    WebElement puppyImg; //css="#intro + div img"
    WebElement puppyName; //css="#intro + div h2"
    WebElement puppyBreed; //css="#intro + div h3"
    WebElement puppyDescription; //css="#intro + div p"
    WebElement puppyFees; //css="#intro + div .fees_line > span"
    WebElement adoptBtn; //css="[value*='Adopt']"
    WebElement returnLink; //css="[href='/']"

    public PuppyDetailsPage(WebDriver driver) {
        super(driver);
    }
    //methods
    public boolean isAt() {return false;}
    Puppy verifyPuppyInfo(Puppy pup) {return null;}
    public void adoptPuppy() {}
}
