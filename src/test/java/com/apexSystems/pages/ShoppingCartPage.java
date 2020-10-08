package com.apexSystems.pages;

import com.apexSystems.pojo.Puppy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends ParentPage {

    //elements
    @FindBy(css="#content > h2")
    WebElement yourLittlerHeader;

    @FindBy(css="table")
    WebElement puppyTable;

    @FindBy(css=".total_cell")
    WebElement cartTotal;

    @FindBy(css="[value*='Complete']")
    WebElement completeAdoptionBtn;

    @FindBy( css="[value^='Adopt']")
    WebElement adoptAnotherBtn;

    @FindBy( css="[value*='Change']")
    WebElement changeMindBtn;

    //dynamic elements
    WebElement puppyImg; //
    WebElement puppyName; //
    WebElement puppyBreed; //
    WebElement puppySex; //


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    //methods
    public boolean isAt() {
        return super.isAt(yourLittlerHeader, puppyTable, cartTotal, completeAdoptionBtn, adoptAnotherBtn, changeMindBtn);
    }
    public void completeAdoption() {
        completeAdoptionBtn.click();
    }

    public List<Puppy> getPuppiesInCart() {
        List<Puppy> puppies = new ArrayList<Puppy>();
        List<WebElement> puppyRows = driver.findElements(By.xpath("//table//tr/td/img/ancestor::tr"));
        for(WebElement row: puppyRows) {
            String puppyImgPath = row.findElement(By.xpath(".//img")).getAttribute("src");
            String puppyName = row.findElement(By.xpath(".//h2[contains(., ':')]")).getText().split(":")[0];
            String sexBreed = row.findElement(By.xpath(".//h2[contains(., '-')]")).getText();
            String sex = sexBreed.split(" - ")[0];
            String breed = sexBreed.split(" - ")[1];
            double price = Double.parseDouble(
                    row.findElement(By.xpath(".//td[@class='item_price']"))
                            .getText()
                            .substring(1)
            );

            puppies.add(new Puppy(puppyImgPath, puppyName, sex, breed, price));
        }
        return puppies;
    }
}
