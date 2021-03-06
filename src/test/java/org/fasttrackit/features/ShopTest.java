package org.fasttrackit.features;

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

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopTest {

	@Managed(uniqueSession = true)
	private WebDriver driver;

	@Steps
	ShopSteps shopSteps;

	@Before
	public void initEnvironment() {
		shopSteps.initEnvironment();
	}

	@Before
	public void maximiseWindow() {
		driver.manage().window().maximize();
	}

	@Test
	public void addToBasketTest() {
		shopSteps.navigateToShop();
		shopSteps.addBasket();
		shopSteps.navigateToCartPage();
		assert (shopSteps.checkCartAdd());
	}

	@Test
	public void removeFromBasket() {
		shopSteps.navigateToCartPage();
		shopSteps.removeBascket();
		assert (shopSteps.checkCartRemove());
	}
}
