package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;

import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.MyAccountPage;
import utiles.Constants;

import java.sql.Driver;

public class LoginSteps {

    HomePage homepage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    private String username;

    @Step
    public void navigateToHomepage(){

        homepage.open();
    }

    @Step
    public void goToLoginPage(){
        homepage.clickMyAccount();

    }

    @Step
    public void loginUser(String username, String password){
        loginPage.setEmailField(username);
        loginPage.setPassField(password);
        loginPage.clickLoginButton();
    }

    @Step
    public void checkUserIsLoggedIn(){
        myAccountPage.checkLoggedIn(Constants.USER_NAME);
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

