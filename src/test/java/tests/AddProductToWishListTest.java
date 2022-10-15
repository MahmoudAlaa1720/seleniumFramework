package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
  
	SearchPage searchObject;
	ProductDeatilsPage productObject;
	WishListPage wishlistObject;
	String productName="Apple MacBook Pro 13-inch";
	
	@Test
	public void UserCanSearchUsingAutoSuggest() {
		searchObject=new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		productObject=new ProductDeatilsPage(driver);
		Assert.assertTrue(productObject.productDeatils.getText().equalsIgnoreCase(productName));
	}
	@Test(priority = 2)
	public void UserCanAddProductToWishList() {
		productObject=new ProductDeatilsPage(driver);
		productObject.AddProductToWishList();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist"+"/wishlist");
		wishlistObject=new WishListPage(driver);
		Assert.assertTrue(wishlistObject.wishlistHeader.isDisplayed());
		Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() {
		wishlistObject=new WishListPage(driver);
		wishlistObject.removeProductFromCart();
	}
}
