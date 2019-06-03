package org.fasttrackit.steps;

import org.fasttrackit.pages.HomePage;

import net.thucydides.core.annotations.Step;

public class SearchResultsSteps {
	
	HomePage homePage;

	@Step
	public void navigateToHomePage() {
		homePage.open();
	}
	
	@Step
	public void searchProduct() {
		homePage.clickSearchButton();
		homePage.setSearchInputField();
		homePage.clickSearchSubmitButton();
	}
	
	@Step
	public boolean checkSearchProduct() {
		return homePage.checkProductTitle("beanie");
	}
}
