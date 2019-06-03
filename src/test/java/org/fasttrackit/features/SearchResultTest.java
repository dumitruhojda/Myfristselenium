package org.fasttrackit.features;

import org.fasttrackit.steps.SearchResultsSteps;
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
public class SearchResultTest {

	@Managed(uniqueSession = true)
	private WebDriver driver;

	@Steps
	SearchResultsSteps searchResultsSteps;

	@Before
	public void maximiseWindow() {
		driver.manage().window().maximize();
	}

	@Test
	public void searchProductTest() {
		searchResultsSteps.navigateToHomePage();
		searchResultsSteps.searchProduct();
		assert (searchResultsSteps.checkSearchProduct());
	}
}
