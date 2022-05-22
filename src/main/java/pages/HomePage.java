package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;
import java.util.NoSuchElementException;

public class HomePage extends BasePage{
    private final String pageURL = PropertyReader.BASEURL;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.navigate().to(pageURL);
        return checkOnPage();
    }



    public HomePage checkOnPage() {
        Assertions.assertEquals("My Store", driver.getTitle(), "This is not Home Page" +
                " current page is: " + driver.getCurrentUrl());
        return this;
    }




}
