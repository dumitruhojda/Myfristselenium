package org.fasttrackit.steps;

import org.fasttrackit.pages.CheckoutPage;

import net.thucydides.core.annotations.Step;

public class CheckoutSteps {

	CheckoutPage checkoutPage;

	@Step
	public void navigateToCheckoutPage() {
		checkoutPage.open();
	}

	@Step
	public void populateCheckoutFormCorrect() {
		checkoutPage.setFirstNameField("First Name");
		checkoutPage.setLastNameField("Last Name");
		checkoutPage.setAddress1Field("Address");
		checkoutPage.setCityField("City");
		checkoutPage.setPostcodeField("0000-0000");
		checkoutPage.setPhoneField("(12)34-5678");
		checkoutPage.setEmailField("example@mail.com");
	}

	@Step
	public void populateCheckoutFormIncorrect() {
		checkoutPage.setFirstNameField("First Name");
		checkoutPage.setLastNameField("Last Name");
		checkoutPage.setAddress1Field("Address");
		checkoutPage.setCityField("City");
		checkoutPage.setPostcodeField("0000-0000");
		checkoutPage.setPhoneField("example_phone");
		checkoutPage.setEmailField("example_mail");
	}

	@Step
	public void placeOrder() {
		checkoutPage.clickPlaceOrderButton();
	}

	@Step
	public boolean checkValidInformation() {
		return checkoutPage.checkOrderPlacementMessage();
	}

	@Step
	public boolean checkInvalidInformation() {
		return checkoutPage.checkInvalidInformation();
	}
}
