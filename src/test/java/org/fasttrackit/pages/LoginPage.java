package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class LoginPage extends PageObject {

	@FindBy(id = "username")
	private WebElementFacade usernameField;

	@FindBy(id = "password")
	private WebElementFacade passField;

	@FindBy(name = "login")
	private WebElementFacade loginButton;

	@FindBy(css = "ul.woocommerce-error > li")
	private WebElementFacade errorMessage;

	@FindBy(css = "div.woocommerce-MyAccount-content > p")
	private WebElementFacade welcomeMessage;

	public void setEmailField(String username) {
		typeInto(usernameField, username);
	}

	public void setPassField(String password) {
		typeInto(passField, password);
	}

	public void clickLoginButton() {
		clickOn(loginButton);
	}

	public boolean checkErrorMessage() {
		if (errorMessage.isCurrentlyEnabled() && errorMessage.containsText("ERROR")) {
			return true;
		} else {
			return false;
		}
	}

	public void checkUserIsOnLoginPage() {
		loginButton.shouldBeVisible();
	}

	public boolean checkLoggedIn(String userName) {
		if (welcomeMessage.isCurrentlyEnabled() && welcomeMessage.containsText("Hello")
				&& welcomeMessage.containsText(userName)) {
			return true;
		} else {
			return false;
		}
	}
}
