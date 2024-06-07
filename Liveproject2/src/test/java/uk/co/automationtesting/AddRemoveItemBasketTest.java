package uk.co.automationtesting;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;
import PageObjects.Homepage;
import PageObjects.ShopContentPanel;
import PageObjects.ShopHomepage;
import PageObjects.ShopProductPage;
import PageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks {

	public AddRemoveItemBasketTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void addRemoveItem() throws IOException {
ExtentManager.log("Starting AddRemoveItemBasketTest...");
		
		// creating an object of the automationtesting.co.uk webpage
		Homepage home = new Homepage();

		//handles cookie prompt
		home.getCookie().click();

		home.getTestStoreLink().click();

		// creating an object of the test store homepage
		ShopHomepage shopHome = new ShopHomepage();
		ExtentManager.pass("Reached the shop homepage");
		shopHome.getProdOne().click();

		// creating an object of the shop products page (when a product has been
		// selected)
		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Reached the shop product page");
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("M");
		ExtentManager.pass("Have successfully selected product size");
		shopProd.getQuantIncrease().click();
		ExtentManager.pass("Have successfully increased quantity");
		shopProd.getAddToCartBtn().click();
		ExtentManager.pass("Have successfully added product to basket");

		// creating an object of the cart content panel (once an item was added)
		ShopContentPanel cPanel = new ShopContentPanel();
		cPanel.getContinueShopBtn().click();
		shopProd.getHomepageLink().click();
		shopHome.getProdTwo().click();
		shopProd.getAddToCartBtn().click();
		cPanel.getCheckoutBtn().click();


		// creating an object for the shopping cart page and deleting item 2
		ShoppingCart cart = new ShoppingCart();
		cart.getdeleteItemTwo().click();

		// using a wait to ensure the deletion has taken place
		//waitForElementInvisible(cart.getdeleteItemTwo(), 10);

		// printing the total amount to console
		System.out.println(cart.gettotalValue().getText());
		
		// using an assertion to make sure the total amount is what we are expecting
		Assert.assertEquals(cart.gettotalValue().getText(), "$45.23");
		try {
			// using an assertion to make sure the total amount is what we are expecting
			Assert.assertEquals(cart.gettotalValue().getText(), "$45.23");
			ExtentManager.pass("The total amount matches the expected amount.");
		} catch (AssertionError e) {
			Assert.fail("Cart amount did not match the expected amount, it found" + cart.gettotalValue().getText() +
					" expected $45.23");
			ExtentManager.fail("The total amount did not match the expected amount.");
		}


	}

}