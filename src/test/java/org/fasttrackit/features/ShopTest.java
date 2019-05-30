package org.fasttrackit.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.ShopStep;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ShopTest {


    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    ShopStep shopStep;

    @Before
    public void maximiseWindow() {
        driver.manage().window().maximize();
        shopStep.initEnvironment();
    }

    @Test
    public void addToBasketTest() {
        shopStep.navigateToShop();
        shopStep.addBasket();
        shopStep.navigateToCartPage();
        shopStep.checkCartAdd();
    }

    @Test
    public void removeFromBasket() {
        shopStep.navigateToCartPage();
        shopStep.removeBascket();
        shopStep.checkCartRemove();
    }
}
