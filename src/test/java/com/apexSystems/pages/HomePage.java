package com.apexSystems.pages;

import com.apexSystems.pojo.Puppy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends ParentPage{

    //elements
    @FindBy(xpath="//h1[. = 'Puppy List']")
    WebElement puppyListHeader;

   @FindBy(css = "puppy_list")
   WebElement puppyContainer;

   @FindBy(id="notice")
   WebElement noticeLbl;


    //dynamic elements
    WebElement puppyImg; //css=".image img"
    WebElement puppyName; //css=".name h3"
    WebElement puppyBreed; //css=".details h4:first-child"
    WebElement puppySex; //css=".details h4:last-child"
    WebElement viewDetailsBtn; //css="input[value='View Details']"

    public HomePage(WebDriver driver) {
        super(driver);
    }
//methods

    public boolean isAt() {
        return super.isAt(puppyListHeader);
    }
    public void goTo(String url) { driver.get(url);}
    public Puppy selectPuppyByName(String puppyName) {
        String puppyContainerXpath = "//div[@class = 'puppy_list' and contains(., '" + puppyName + "')]";
        WebElement puppyContainer = driver.findElement(By.xpath(puppyContainerXpath));
        String name = getNestedElementText(puppyContainer, By.cssSelector(".name h3"));

        String photoPath = getNestedElementAttribute(puppyContainer, By.cssSelector(".image img"), "src");

        String sex = getNestedElementText(puppyContainer, By.cssSelector(".details h4:last-child"));

        String breed = getNestedElementText(puppyContainer, By.cssSelector(".details h4:first-child"));

        puppyContainer.findElement(By.cssSelector("input[value='View Details']")).click();

        return new Puppy(photoPath, name, sex, breed);
    }
    public Puppy selectPuppyByBreed(String breed) {return null;}
    public Puppy selectPuppyBySex(char sex, int index) {return null;}
    public Puppy selectPuppy(String puppyInfo) {
        return null;
    }

    public String getWelcomeMessage() {
        return noticeLbl.getText();
    }
}
