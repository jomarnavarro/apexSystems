package com.apexSystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage extends ParentPage {

    //elements
    WebElement enterDetailsHeader; //css="legend"
    WebElement nameTxt; //css="#order_name"
    WebElement addressTxt; //css="#order_address"
    WebElement emailTxt; //css="#order_email"
    WebElement payTypeSel; //css="#order_pay_type"
    WebElement placeOrderBtn; //css="[value^='Place']"

    public DetailsPage(WebDriver driver) {
        super(driver);
    }
    //methods
    boolean isAt() {return false;}
    void placeOrder() {}

}
