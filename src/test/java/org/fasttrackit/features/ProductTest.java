package org.fasttrackit.features;

import org.fasttrackit.steps.ProductSteps;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTest {

	@Managed(uniqueSession = true)
	private WebDriver driver;

	@Steps
	ProductSteps productSteps;

	@Before
	public void initEnvironment() {
		productSteps.initEnvironment();
	}

	@Before
	public void maximiseWindow() {
		driver.manage().window().maximize();
	}

	@Test
	public void addProductToCartTest() {
		productSteps.navigateToShopPage();
		productSteps.goToProductPage();
		productSteps.addProductsToCart();
		productSteps.navigateToCartPage();
		assert (productSteps.checkCartAddQuantiy());
	}
}
