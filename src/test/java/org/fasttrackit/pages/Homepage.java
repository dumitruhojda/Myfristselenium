package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class HomePage extends PageObject {

	@FindBy(css = "#menu-item-122 > a")
	private WebElementFacade myAccountButton;

	@FindBy(css = "div.header-search-button")
	private WebElementFacade searchButton;

	@FindBy(css = "input.search-field")
	private WebElementFacade searchInput;

	@FindBy(css = "input[type='submit']")
	private WebElementFacade searchSubmitButton;

	@FindBy(css = "#username")
	private WebElementFacade loginLink;

	@FindBy(css = "h2.woocommerce-loop-product__title")
	private WebElementFacade productTitleHeader;

	public void clickMyAccount() {
		clickOn(myAccountButton);
	}

	public void clickLoginLink() {
		clickOn(loginLink);
	}

	public void clickSearchButton() {
		clickOn(searchButton);
	}

	public void setSearchInputField() {
		typeInto(searchInput, "beanie");
	}

	public void clickSearchSubmitButton() {
		clickOn(searchSubmitButton);
	}

	public boolean checkProductTitle(String productTitle) {
		if (productTitleHeader.isCurrentlyEnabled()
				&& productTitleHeader.getText().toLowerCase().contains(productTitle.toLowerCase())) {
			return true;
		} else {
			return false;
		}
	}
}
