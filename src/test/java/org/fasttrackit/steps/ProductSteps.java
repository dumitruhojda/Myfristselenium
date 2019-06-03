package org.fasttrackit.steps;

import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.ProductPage;
import org.fasttrackit.pages.ShopPage;

import net.thucydides.core.annotations.Step;
import utiles.Constants;

public class ProductSteps {

	ShopPage shopPage;
	CartPage cartPage;
	ProductPage productPage;
	HomePage homePage;
	LoginPage loginPage;

	public void initEnvironment() {
		homePage.open();
		homePage.clickMyAccount();
		loginPage.setEmailField(Constants.USER_NAME);
		loginPage.setPassField(Constants.USER_PASSWORD);
		loginPage.clickLoginButton();
	}

	@Step
	public void navigateToShopPage() {
		shopPage.open();
	}

	@Step
	public void navigateToCartPage() {
		cartPage.open();
	}

	@Step
	public void goToProductPage() {
		shopPage.clickProductPageLink();
	}

	@Step
	public void addProductsToCart() {
		productPage.setQuantityField();
		productPage.clickAddToCartButton();
	}

	@Step
	public boolean checkCartAdd() {
		return cartPage.checkCartAdd("beanie");
	}
	
	@Step
	public boolean checkCartAddQuantiy() {
		return cartPage.checkCartAddQuantity("beanie", 4);
	}
}
