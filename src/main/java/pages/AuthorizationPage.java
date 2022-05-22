package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationPage extends BasePage{
    private final String pageURL = "http://automationpractice.com/index.php?controller=authentication";

    //относится к авторизации юзера
    public By signInLocator = By.id("SubmitLogin");
    public By emailInputLocator = By.cssSelector("input#email");
    public By passwordInputLocator = By.xpath("//input[@id='passwd']");
    public By navigationPanelLocator = By.cssSelector("span.navigation_page");

    //относится к созданию юзера
    public By registrationInputLocator = By.id("email_create");
    public By registrationButtonLocator = By.id("SubmitCreate");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public AuthorizationPage open() {
        driver.navigate().to(pageURL);
        return this;
    }

    public MyAccountPage doAuthorize(String login, String password) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(login);

        WebElement passInput = driver.findElement(passwordInputLocator);
        passInput.sendKeys(password);

        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();
        return new MyAccountPage(driver);
    }

    public AuthorizationPage checkOnPage() {
        WebElement navigationPanel = driver.findElement(navigationPanelLocator);
        Assertions.assertTrue(navigationPanel.isDisplayed());
        Assertions.assertEquals("Authentication", navigationPanel.getText());
        return this;
    }

    @Step ("Step for starting registration")
    public RegistrationPage startRegistration(String email) {
        WebElement registrationEmailInput = driver.findElement(registrationInputLocator);
        registrationEmailInput.sendKeys(email);
        WebElement registrationButton = driver.findElement(registrationButtonLocator);
        registrationButton.click();
        return new RegistrationPage(driver);
    }




}
