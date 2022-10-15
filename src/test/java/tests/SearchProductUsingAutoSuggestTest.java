package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDeatilsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase {
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDeatilsPage productObject;
	@Test
	public void UserCanSearchUsingAutoSuggest() {
		searchObject=new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		productObject=new ProductDeatilsPage(driver);
		Assert.assertTrue(productObject.productDeatils.getText().equalsIgnoreCase(productName));
	}
}
