package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class LoginPage extends PageObject {


    @FindBy(id = "email")
    private WebElementFacade emailField;

    @FindBy(id = "pass")
    private WebElementFacade passField;

    @FindBy(id = "send2")
    private WebElementFacade loginButton;

    @FindBy(css = "li.error-msg span")
    private WebElementFacade errorMessage;

    public void setEmailField(String email){
        typeInto(emailField, email);
    }

    public void setPassField(String pass){
        typeInto(passField, pass);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }


    public void checkErrorMessage(){
        errorMessage.shouldContainText("Invalid login or password.");
    }

    public void checkUserIsOnLoginPage(){
        loginButton.shouldBeVisible();
    }
}
