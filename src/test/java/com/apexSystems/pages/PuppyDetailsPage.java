package com.apexSystems.pages;

import com.apexSystems.pojo.Puppy;
import com.apexSystems.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PuppyDetailsPage extends ParentPage {
    //elements

    @FindBy(css="#intro + div img")
    WebElement puppyImg;

    @FindBy(css="#intro + div h2")
    WebElement puppyName;

    @FindBy(css="#intro + div h3")
    WebElement puppySexBreed;

    @FindBy(css="#intro + div p")
    WebElement puppyDescription;

    @FindBy(css="#intro + div .fees_line > span")
    WebElement puppyFees;

    @FindBy(css="[value*='Adopt']")
    WebElement adoptBtn;

    @FindBy(css="[href='/']")
    WebElement returnLink;

    public PuppyDetailsPage(WebDriver driver) {
        super(driver);
    }
    //methods
    public boolean isAt() {
        return super.isAt(puppyImg, puppyName, puppySexBreed, puppyDescription, puppyFees, adoptBtn, returnLink);
    }

    public Puppy verifyPuppyInfo(Puppy pup) {return null;}

    public void adoptPuppy() {
        adoptBtn.click();
    }

    public Puppy getPuppyInfo() {
        String sexBreed = puppySexBreed.getText();
        String sex = Utils.getSex(sexBreed);
        String breed = Utils.getBreed(sexBreed);
        String photoPath = puppyImg.getAttribute("src");
        Puppy pup = new Puppy(puppyImg.getAttribute("src"), puppyName.getText(), sex, breed);
        pup.setAdoptionFees(Utils.getAdoptionFees(puppyFees.getText()));
        return pup;
    }
}
