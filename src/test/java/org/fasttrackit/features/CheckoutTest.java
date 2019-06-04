package org.fasttrackit.features;

import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.CheckoutSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.steps.ProductSteps;
import org.fasttrackit.steps.ShopSteps;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import utiles.Constants;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckoutTest {

	@Managed(uniqueSession = true)
	private WebDriver driver;

	@Steps
	LoginSteps loginSteps;

	@Steps
	ShopSteps shopSteps;

	@Steps
	ProductSteps productSteps;

	@Steps
	CartSteps cartSteps;

	@Steps
	CheckoutSteps checkoutSteps;

	@Before
	public void initEnvironment() {
		loginSteps.navigateToHomepage();
		loginSteps.goToLoginPage();
		loginSteps.loginUser(Constants.USER_NAME, Constants.USER_PASSWORD);

		productSteps.navigateToShopPage();
		productSteps.goToProductPage();
		productSteps.addProductsToCart();

		checkoutSteps.navigateToCheckoutPage();
	}

	@Before
	public void maximiseWindow() {
		driver.manage().window().maximize();
	}


	@Test
	public void checkoutValidInformation() {
		checkoutSteps.populateCheckoutFormCorrect();
		checkoutSteps.placeOrder();
		assert (checkoutSteps.checkValidInformation());
	}



	@Test
	public void checkoutInvalidInformation() {
		checkoutSteps.populateCheckoutFormIncorrect();
		checkoutSteps.placeOrder();
		assert (checkoutSteps.checkInvalidInformation());
	}
}