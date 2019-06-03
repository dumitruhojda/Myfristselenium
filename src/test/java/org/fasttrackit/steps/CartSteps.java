package org.fasttrackit.steps;

import org.fasttrackit.pages.CartPage;

import net.thucydides.core.annotations.Step;

public class CartSteps {

	CartPage cartPage;

	@Step
	public void navigateToCartPage() {
		cartPage.open();
	}
	
	@Step
	public void updateCart() {
		cartPage.setProductQuantityField();
		cartPage.clickUpdateCartButton();
	}
	
	@Step
	public boolean checkCartUpdate() {
		return cartPage.checkCartUpdate();
	}
}
