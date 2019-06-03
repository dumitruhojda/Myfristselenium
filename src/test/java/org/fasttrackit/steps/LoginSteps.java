package org.fasttrackit.steps;

import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.MyAccountPage;

import net.thucydides.core.annotations.Step;
import utiles.Constants;

public class LoginSteps {

	HomePage homepage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;

	@Step
	public void navigateToHomepage() {
		homepage.open();
	}

	@Step
	public void goToLoginPage() {
		homepage.clickMyAccount();
	}

	@Step
	public void loginUser(String username, String password) {
		loginPage.setEmailField(username);
		loginPage.setPassField(password);
		loginPage.clickLoginButton();
	}

	@Step
	public boolean checkUserIsLoggedIn() {
		return loginPage.checkLoggedIn(Constants.USER_NAME);
	}

	@Step
	public boolean checkUserNotLoggedIn() {
		return loginPage.checkErrorMessage();
	}

	@Step
	public void userStillOnLoginPage() {
		loginPage.checkUserIsOnLoginPage();
	}
}
