package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.MyAccountPage;
import utiles.Constants;

public class CartSteps{

    CartPage cartPage;
    private String username;

    @Step
    public void navigateToCartPage(){
        cartPage.open();
    }



}
