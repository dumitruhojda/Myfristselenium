package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa4.fasttrackit.org:8008/?page_id=119")
public class CheckoutPage extends PageObject {

	@FindBy(css = "input#billing_first_name")
	private WebElementFacade billingFirstNameField;

	@FindBy(css = "input#billing_last_name")
	private WebElementFacade billingLastNameField;

	@FindBy(css = "input#billing_address_1")
	private WebElementFacade billingAddress1Field;

	@FindBy(css = "input#billing_city")
	private WebElementFacade billingCityField;

	@FindBy(css = "input#billing_postcode")
	private WebElementFacade billingPostcodeField;

	@FindBy(css = "input#billing_phone")
	private WebElementFacade billingPhoneField;

	@FindBy(css = "input#billing_email")
	private WebElementFacade billingEmailField;

	@FindBy(css = "button#place_order")
	private WebElementFacade placeOrderButton;

	@FindBy(css = "ul.woocommerce-error > li:nth-of-type(1) > strong")
	private WebElementFacade phoneValidationErrorMessage;

	@FindBy(css = "ul.woocommerce-error > li:nth-of-type(2) > strong")
	private WebElementFacade emailValidationErrorMessage;

	@FindBy(css = "div.woocommerce-order > p.woocommerce-notice.woocommerce-notice--success")
	private WebElementFacade orderPlacementMessage;

	public void setFirstNameField(String firstName) {
		typeInto(billingFirstNameField, firstName);
	}

	public void setLastNameField(String lastName) {
		typeInto(billingLastNameField, lastName);
	}

	public void setAddress1Field(String address1) {
		typeInto(billingAddress1Field, address1);
	}

	public void setCityField(String city) {
		typeInto(billingCityField, city);
	}

	public void setPostcodeField(String postcode) {
		typeInto(billingPostcodeField, postcode);
	}

	public void setPhoneField(String phone) {
		typeInto(billingPhoneField, phone);
	}

	public void setEmailField(String email) {
		typeInto(billingEmailField, email);
	}

	public void clickPlaceOrderButton() {
		clickOn(placeOrderButton);
	}

	public boolean checkInvalidInformation() {
		if (phoneValidationErrorMessage.isCurrentlyEnabled()
				&& phoneValidationErrorMessage.containsText("Billing Phone")
				&& emailValidationErrorMessage.isCurrentlyEnabled()
				&& emailValidationErrorMessage.containsText("Billing Email address")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkOrderPlacementMessage() {
		if (orderPlacementMessage.isCurrentlyEnabled()
				&& orderPlacementMessage.containsText("Thank you. Your order has been received.")) {
			return true;
		} else {
			return false;
		}
	}
}
