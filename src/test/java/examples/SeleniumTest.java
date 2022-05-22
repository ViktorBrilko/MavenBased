package examples;

import automationpractice.AuthorizationTest;
import automationpractice.BaseTest;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JSONUtils;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest extends BaseTest {

    @Test
    public void initDriverTest() {
        driver.get("https://google.com");
        assertTrue(driver.getCurrentUrl().contains("google.com"));
    }

    @Test
    public void useDriverManager() {
        driver.get("http://automationpractice.com/");
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='login']"));
        if (signInButton.isDisplayed())
            signInButton.click();
        assertTrue(driver.getCurrentUrl().contains("authentication"));
    }

    @Test
    public void addProductsToCartWithCookies() throws IOException {
        driver.get("http://automationpractice.com/");
        driver.manage().deleteAllCookies();

        JSONObject jsonCookies = JSONUtils.getFileContentsAsJsonObject("src/test/resources/attachments/cookies.json");
        Cookie cookie = new Cookie(
                jsonCookies.getString("name"),
                jsonCookies.getString("value")
        );

        driver.manage().addCookie(cookie);

        WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        cart.click();

//      WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
//      Actions action = new Actions(driver);
//      action.moveToElement(cart).build().perform();

        //берем из итоговой таблицы заказа строку суммы, отрезаем $ и парсим в число
        double totalProducts = Double.parseDouble(driver.findElement(By.id("total_product")).getText().substring(1));
        double shipping = Double.parseDouble(driver.findElement(By.id("total_shipping")).getText().substring(1));
        double tax = Double.parseDouble(driver.findElement(By.id("total_tax")).getText().substring(1));
        double totalPrice = totalProducts + shipping + tax;

        double totalAmounts = Double.parseDouble(driver.findElement(By.id("total_price")).getText().substring(1));
        Assertions.assertEquals(totalPrice, totalAmounts);


    }
}
