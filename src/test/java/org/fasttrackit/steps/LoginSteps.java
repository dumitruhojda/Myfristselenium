package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.Homepage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.MyAccountPage;

import java.sql.Driver;

public class LoginSteps {

    Homepage homepage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @Step
    public void navigateToHomepage(){

        homepage.open();
    }

    @Step
    public void goToLoginPage(){
        homepage.clickMyAccount();
        homepage.clickLoginLink();
    }

    @Step
    public void loginUser(String email, String password){
        loginPage.setEmailField(email);
        loginPage.setPassField(password);
        loginPage.clickLoginButton();
    }

    @Step
    public void checkUserIsLoggedIn(){
        myAccountPage.checkLoggedIn("");
    }

    @Step
    public void checkUserNotLoggedIn(){
        loginPage.checkErrorMessage();
    }

    @Step
    public void userStillOnLoginPage(){
        loginPage.checkUserIsOnLoginPage();
    }

}
