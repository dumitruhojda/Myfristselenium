package org.fasttrackit.steps;

import jxl.biff.Type;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.*;
import org.fasttrackit.pages.HomePage;
import utiles.Constants;

public class ShopStep {

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
    public void checkCartAdd(){
        String addedProductName = shopPage.getAddedProductName();
        cartPage.checkCartAdd(addedProductName);
    }

    @Step
    public void removeBascket() {
        cartPage.removeBascket();
    }

    @Step
    public void checkCartRemove() {
        cartPage.checkCartRemove();
    }
}
