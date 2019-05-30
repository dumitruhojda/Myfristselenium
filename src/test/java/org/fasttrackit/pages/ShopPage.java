package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa4.fasttrackit.org:8008/?post_type=product")
public class ShopPage extends PageObject {

    String addedProductName;

    @FindBy(css="a[href='/?post_type=product&add-to-cart=48']")
    private WebElementFacade productLink;

    @FindBy(css=".cart-item-number")
    private WebElementFacade cartNumber;

    @FindBy(css="fa fa-shopping-cart")
    public WebElementFacade cartButton;

    public void addBasket() {
        clickOn(productLink);
        this.addedProductName = productLink.getAttribute("aria-label").split("“")[1].split("”")[0];
    }

    public String getAddedProductName() {
        return addedProductName;
    }
}
