package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa4.fasttrackit.org:8008/?page_id=118")
public class CartPage  extends PageObject {

    @FindBy(css=".product-name")
    private WebElementFacade productName;

    @FindBy(css="a.remove")
    private WebElementFacade productRemoveButton;

    @FindBy(css="p.cart-empty")
    private WebElementFacade emptyCartMessage;

    public void checkCartAdd(String addedProductName) {
        this.productName.getText().equals(addedProductName);
    }

    public void removeBascket() {
        this.productRemoveButton.click();
    }

    public boolean checkCartRemove() {
        if (this.emptyCartMessage != null && this.emptyCartMessage.getText().equals("Your cart is currently empty.")) {
            return true;
        } else {
            return false;
        }
    }
}
