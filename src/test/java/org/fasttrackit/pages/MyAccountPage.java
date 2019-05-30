package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class MyAccountPage extends PageObject {

    @FindBy(  xpath = "//*[@id=\"post-120\"]/div/div/div/p[1]")
    private WebElementFacade helloMessage;

    @FindBy(css = "strong")
    private WebElementFacade name;

    public void checkLoggedIn(String userName) {
        helloMessage.shouldContainText("Hello ");
        name.shouldContainText(userName);

    }
}
