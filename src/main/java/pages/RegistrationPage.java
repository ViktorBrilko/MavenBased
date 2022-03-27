package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By titleLocator = By.id("id_gender1");
    By firstNameLocator = By.id("customer_firstname");
    By lastNameLocator = By.id("customer_lastname");
    By passLocator = By.id("passwd");
    By dayOfBirthLocator = By.id("days");
    By monthOfBirthLocator = By.id("months");
    By yearOfBirthLocator = By.id("years");
    By addressLocator = By.id("address1");
    By cityLocator = By.id("city");
    By stateLocator = By.id("id_state");
    By postalCodeLocator = By.id("postcode");
    By mobilePhoneLocator = By.id("phone_mobile");
    By submitButtonLocator = By.id("submitAccount");

    @Step ("Step for acomplishing registration")
    public MyAccountPage completeRegistration(String firstName, String lastname, String password, String address, String city, String postalCode, String mobilePhone) {
        WebElement title = driver.findElement(titleLocator);
        title.click();
        WebElement firstNameCustomer = driver.findElement(firstNameLocator);
        firstNameCustomer.sendKeys(firstName);
        WebElement lastNameCustomer = driver.findElement(lastNameLocator);
        lastNameCustomer.sendKeys(lastname);
        WebElement pass = driver.findElement(passLocator);
        pass.sendKeys(password);
        Select dayOfBirth = new Select(driver.findElement(dayOfBirthLocator));
        dayOfBirth.selectByValue("13");
        Select monthOfBirth = new Select(driver.findElement(monthOfBirthLocator));
        monthOfBirth.selectByValue("4");
        Select yearOfBirth = new Select(driver.findElement(yearOfBirthLocator));
        yearOfBirth.selectByValue("1996");
        WebElement addressCustomer = driver.findElement(addressLocator);
        addressCustomer.sendKeys(address);
        WebElement cityCustomer = driver.findElement(cityLocator);
        cityCustomer.sendKeys(city);
        Select stateCustomer = new Select(driver.findElement(stateLocator));
        stateCustomer.selectByValue("18");
        WebElement postalCodeCustomer = driver.findElement(postalCodeLocator);
        postalCodeCustomer.sendKeys(postalCode);
        WebElement mobilePhoneCustomer = driver.findElement(mobilePhoneLocator);
        mobilePhoneCustomer.sendKeys(mobilePhone);
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
        return new MyAccountPage(driver);
    }
}
