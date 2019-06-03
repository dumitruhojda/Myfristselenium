package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {

	@FindBy(name = "quantity")
	private WebElementFacade quantityField;

	@FindBy(name = "add-to-cart")
	private WebElementFacade addToCartButton;

	public void setQuantityField() {
		typeInto(quantityField, "4");
	}

	public void clickAddToCartButton() {
		clickOn(addToCartButton);
	}
}
