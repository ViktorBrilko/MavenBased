package automationpractice;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.AuthorizationPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.PropertyReader;

public class AuthorizationTest extends BaseTest {
    public By accountLocator = By.cssSelector("a.account span");
    @Step("Verify that we are on my account page")
    public String getAuthorizedAccount2() {
        return driver.findElement(accountLocator).getText();
    }

    @Description("In this cool test we will check cool thing")
    @Test
    public void authorizeTest() {
        driver.get(PropertyReader.BASEURL);
        HomePage homePage = new HomePage(driver).waitOnPage();
        AuthorizationPage authorizationPage = homePage.clickSignIn();
        authorizationPage.checkOnPage();
        MyAccountPage myAccountPage = authorizationPage.doAuthorize("skillupdemo@gmail.com", "12345");
        String account = getAuthorizedAccount2();
        Assertions.assertEquals("name lasr", account);
        saveAllureScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
