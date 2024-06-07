package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShoppingCart extends BasePage{
	public WebDriver driver;
	
	By havePromo = By.cssSelector(".promo-code-button .collapse-button");
	By promoTextBox = By.cssSelector("input[name='discount_name']");
	By promoAddBtn = By.cssSelector("form[method='post']  span");
	By proceedCheckout = By.linkText("PROCEED TO CHECKOUT");
	By deleteItemOne = By.cssSelector(".material-icons.float-xs-left");
	By deleteItemTwo = By.cssSelector(".cart-items .cart-item:nth-of-type(2) .float-xs-left");
	By totalValue = By.cssSelector(".cart-total .value");
	
	public ShoppingCart() throws IOException {
		super();
		
	}
	public WebElement getHavePromo() throws IOException {
		this.driver = getDriver();
		return driver.findElement(havePromo);
	}
	public WebElement getpromoTextBox() throws IOException {
		this.driver = getDriver();
		return driver.findElement(promoTextBox);
	}
	public WebElement getpromoAddBtn() throws IOException{
		this.driver = getDriver();
		return driver.findElement(promoAddBtn);
	}
	public WebElement getproceedCheckout() throws IOException{
		this.driver = getDriver();
		return driver.findElement(proceedCheckout);
	}
	public WebElement getdeleteItemOne() throws IOException{
		this.driver = getDriver();
		return driver.findElement(deleteItemOne);
	}
	public WebElement gettotalValue() throws IOException{
		this.driver = getDriver();
		return driver.findElement(totalValue);
	}
	public WebElement getdeleteItemTwo() throws IOException{
		this.driver = getDriver();
		return driver.findElement(deleteItemTwo);
	}
	
	
	
}
