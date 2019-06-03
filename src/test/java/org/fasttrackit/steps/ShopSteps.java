package org.fasttrackit.steps;

import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.ShopPage;

import net.thucydides.core.annotations.Step;
import utiles.Constants;

public class ShopSteps {

    ShopPage shopPage;
    CartPage cartPage;
    HomePage homePage;
    LoginPage loginPage;

    public void initEnvironment(){
        homePage.open();
        homePage.clickMyAccount();
        loginPage.setEmailField(Constants.USER_NAME);
        loginPage.setPassField(Constants.USER_PASSWORD);
        loginPage.clickLoginButton();
    }

    @Step
    public void navigateToShop(){
        shopPage.open();
    }

    @Step
    public void navigateToCartPage() {
        cartPage.open();
    }

    @Step
    public void addBasket(){
        shopPage.addBasket();
    }

    @Step
    public boolean checkCartAdd(){
        String addedProductName = shopPage.getAddedProductName();
        return cartPage.checkCartAdd(addedProductName);
    }

    @Step
    public void removeBascket() {
        cartPage.removeBascket();
    }

    @Step
    public boolean checkCartRemove() {
        return cartPage.checkCartRemove();
    }
}
