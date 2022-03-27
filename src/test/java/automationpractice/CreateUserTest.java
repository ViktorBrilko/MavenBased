package automationpractice;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegistrationPage;
import utils.PropertyReader;

@Epic("Witcher 3 tests")
public class CreateUserTest extends BaseTest {
    Fairy fairy = Fairy.create();
    Person person = fairy.person();
    String address = "Belarus str.";
    String city = "Homel";
    String postalCode = "66666";

    @Story("Skellige isles")
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
