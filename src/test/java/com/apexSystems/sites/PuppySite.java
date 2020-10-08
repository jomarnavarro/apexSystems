package com.apexSystems.sites;

import com.apexSystems.pages.*;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class PuppySite {

    private WebDriver driver;
    private HomePage home;
    private MenuPage menu;
    private PuppyDetailsPage puppyDetails;
    private ShoppingCartPage cart;
    private DetailsPage details;


    public PuppySite(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage home() {
        if(home == null)
            home = new HomePage(driver);
        return home;
    }

    public MenuPage menu() {
        if(menu == null)
            menu = new MenuPage(driver);
        return menu;
    }

    public PuppyDetailsPage puppyDetails() {
        if (puppyDetails == null)
            puppyDetails = new PuppyDetailsPage(driver);
        return puppyDetails;
    }

    public ShoppingCartPage cart() {
        if(cart == null)
            cart = new ShoppingCartPage(driver);
        return cart;
    }

    public DetailsPage details() {
        if(details == null)
            details = new DetailsPage(driver);
        return details;
    }
}
