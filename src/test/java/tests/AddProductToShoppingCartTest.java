package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{
	String productName="Apple MacBook Pro 13-inch";
	ProductDeatilsPage productObject;
	ShoppingCartPage cartPage;
	SearchPage searchObject;
	
	@Test(priority = 1)
	public void UserCanSearchUsingAutoSuggest() {
		searchObject=new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		productObject=new ProductDeatilsPage(driver);
		Assert.assertTrue(productObject.productDeatils.getText().equalsIgnoreCase(productName));
	}
	@Test(priority = 2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		productObject=new ProductDeatilsPage(driver);
		productObject.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		
	}
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() {
		cartPage=new ShoppingCartPage(driver);
		cartPage.removeProductFromCart();
	}
}
