package com.apexSystems.steps;

import com.apexSystems.sites.PuppySite;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.apexSystems.utils.Constants;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private WebDriver driver;
    private PuppySite site;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Constants.SHORT_WAIT, TimeUnit.SECONDS);
        site = new PuppySite(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    public PuppySite getApexSite() {
        return this.site;
    }
}
