package org.fasttrackit.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import utiles.Constants;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
    }

    @Test
    public void loginWithValidCredentials() {
        loginSteps.navigateToHomepage();
        loginSteps.goToLoginPage();
        loginSteps.loginUser(Constants.USER_NAME,Constants.USER_PASSWORD);
        loginSteps.checkUserIsLoggedIn();
    }

    @Test
    public void loginWithInvalidPassword() {
        loginSteps.navigateToHomepage();
        loginSteps.goToLoginPage();
        loginSteps.loginUser("admin", "pasrola11");
        loginSteps.checkUserNotLoggedIn();
    }

    @Test
    public void loginWithIncorrectEmail() {
        loginSteps.navigateToHomepage();
        loginSteps.goToLoginPage();
        loginSteps.loginUser("admin@.com", "passrola11");
        loginSteps.checkUserNotLoggedIn();
    }

    @Test
    public void loginWithInvalidEmail() {
        loginSteps.navigateToHomepage();
        loginSteps.goToLoginPage();
        loginSteps.loginUser("asaasa","1234556");
        loginSteps.userStillOnLoginPage();
    }

}
