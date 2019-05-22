package org.fasttrackit.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class Homepage extends PageObject {

    @FindBy(css = "#menu-item-122 > a")
    private WebElementFacade myAccountButton;

    @FindBy(css = "#username")
    private WebElementFacade loginLink;

    public void clickMyAccount(){
        clickOn(myAccountButton);
    }

    public void clickLoginLink(){
        clickOn(loginLink);
    }

}
