package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import static utiles.Constants.USER_NAME;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class LoginPage extends PageObject {


    @FindBy(id = "username")
    private WebElementFacade usernameField;

    @FindBy(id = "password")
    private WebElementFacade passField;

    @FindBy(name = "login")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//*[@id=\"post-120\"]/div/div/ul/li")
    private WebElementFacade errorMessage;


    public void setEmailField(String username) {
        typeInto(usernameField, username);
    }

    public void setPassField(String password) {
        typeInto(passField, password);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }


    public void checkErrorMessage() {
        errorMessage.shouldContainText("ERROR");
    }

    public void checkUserIsOnLoginPage() {
        loginButton.shouldBeVisible();
    }
}
