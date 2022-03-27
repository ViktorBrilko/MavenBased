package automationpractice;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AuthorizationPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegistrationPage;
import utils.PropertyReader;

public class CreateUserTest extends BaseTest {
    Fairy fairy = Fairy.create();
    Person person = fairy.person();
    String address = "Belarus str.";
    String city = "Homel";
    String postalCode = "66666";

    @Test
    public void registrationTest() {
        driver.get(PropertyReader.BASEURL);
        HomePage homePage = new HomePage(driver).waitOnPage();
        AuthorizationPage authorizationPage = homePage.clickSignIn();
        RegistrationPage registrationPage = authorizationPage.startRegistration(person.getEmail());
        MyAccountPage myAccountPage = registrationPage.completeRegistration(
                person.getFirstName(),
                person.getLastName(),
                person.getPassword(),
                address,
                city,
                postalCode,
                person.getTelephoneNumber());
        String account = myAccountPage.getAuthorizedAccount();
        String userName = person.getFirstName() + " " + person.getLastName();
        Assertions.assertEquals(userName, account);




    }
}
