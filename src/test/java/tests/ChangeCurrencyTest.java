package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDeatilsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	HomePage home;
	ProductDeatilsPage productObject;
	
	@Test(priority = 1)
	public void UserCanChangeCurrency() {
		home=new HomePage(driver);
		home.ChangeCurrency();
		
		
	}
	
	@Test(priority = 2)
	public void UserCanSearchUsingAutoSuggest() {
		searchObject=new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		productObject=new ProductDeatilsPage(driver);
		Assert.assertTrue(productObject.productDeatils.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(productObject.ProductPrice.getText().contains("€"));
		System.out.println(productObject.ProductPrice.getText());
	}
}
