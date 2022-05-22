package automationpractice;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AuthorizationPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.PropertyReader;


public class AuthorizationTest extends BaseTest {

    Logger log = LoggerFactory.getLogger(AuthorizationTest.class);

    @Description("In this cool test we will check cool thing")
    @Test
    public void authorizeTest() {
        log.warn("Warn");
        log.info("Сейчас мы здесь");
        log.debug("А теперь тут");
        driver.get(PropertyReader.BASEURL);
        HomePage homePage = (HomePage) new HomePage(driver).waitOnPage();
        AuthorizationPage authorizationPage = homePage.clickSignIn();
        authorizationPage.checkOnPage();
        MyAccountPage myAccountPage = authorizationPage.doAuthorize("skillupdemo@gmail.com", "12345");
        String account = myAccountPage.getAuthorizedAccount();
        Assertions.assertEquals("name lasr", account);
        saveAllureScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
