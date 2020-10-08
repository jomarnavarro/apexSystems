package com.apexSystems.pages;

import com.apexSystems.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DetailsPage extends ParentPage {

    //elements
    @FindBy(css=".puppy_form legend")
    WebElement enterDetailsHeader;

    @FindBy(css="#order_name")
    WebElement nameTxt;

    @FindBy(css="#order_address")
    WebElement addressTxt;

    @FindBy(css="#order_email")
    WebElement emailTxt;

    @FindBy(css="#order_pay_type")
    WebElement payTypeSel;

    @FindBy(css="[value^='Place']")
    WebElement placeOrderBtn;

    public DetailsPage(WebDriver driver) {
        super(driver);
    }
    //methods
    public boolean isAt() {
        return super.isAt(enterDetailsHeader, nameTxt, addressTxt, emailTxt, payTypeSel, placeOrderBtn);
    }
    public void placeOrder(String payType) {
        nameTxt.sendKeys(Utils.randomName());
        addressTxt.sendKeys(Utils.randomAddress());
        emailTxt.sendKeys(Utils.randomEmail());
        Select s = new Select(payTypeSel);
        s.selectByValue(payType);
        placeOrderBtn.click();
    }

}
