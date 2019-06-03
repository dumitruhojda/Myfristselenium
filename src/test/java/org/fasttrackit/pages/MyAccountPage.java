package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class MyAccountPage extends PageObject {

	@FindBy(xpath = "//*[@id=\"post-120\"]/div/div/div/p[1]")
	private WebElementFacade helloMessage;

	@FindBy(css = "strong")
	private WebElementFacade name;

	@FindBy(css = "div.woocommerce-MyAccount-content > p")
	private WebElementFacade welcomeMessage;

	public boolean checkLoggedIn(String userName) {
		// if (helloMessage != null && name != null && helloMessage.containsText("Hello
		// ")
		if (welcomeMessage != null && welcomeMessage.containsText("Welcome") && welcomeMessage.containsText(userName)) {
			return true;
		} else {
			return false;
		}
	}
}
