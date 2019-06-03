package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa4.fasttrackit.org:8008/?page_id=118")
public class CartPage extends PageObject {

	@FindBy(css = "td.product-name")
	private WebElementFacade productName;

	@FindBy(css = "td.product-quantity > div.quantity > input")
	private WebElementFacade productQuantityField;

	@FindBy(css = "a.remove")
	private WebElementFacade productRemoveButton;

	@FindBy(css = "p.cart-empty")
	private WebElementFacade emptyCartMessage;

	@FindBy(css = "button[name='update_cart']")
	private WebElementFacade updateCartButton;

	public boolean checkCartAdd(String addedProductName) {
		if (this.productName.getText().toLowerCase().equals(addedProductName.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkCartAddQuantity(String addedProductName, int addedProductQuantity) {
		if (this.productName.getText().toLowerCase().equals(addedProductName.toLowerCase())
				&& Integer.valueOf(this.productQuantityField.getValue()).equals(addedProductQuantity)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkCartRemove() {
		if (this.emptyCartMessage != null && this.emptyCartMessage.getText().equals("Your cart is currently empty.")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkCartUpdate() {
		if (Integer.valueOf(this.productQuantityField.getTextValue()).equals(1)) {
			return true;
		} else {
			return false;
		}
	}

	public void removeBascket() {
		this.productRemoveButton.click();
	}

	public void setProductQuantityField() {
		typeInto(productQuantityField, "1");
	}

	public void clickUpdateCartButton() {
		clickOn(updateCartButton);
	}

}
