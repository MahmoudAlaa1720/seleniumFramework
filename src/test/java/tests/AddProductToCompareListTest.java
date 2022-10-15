package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareListPage;
import pages.HomePage;
import pages.ProductDeatilsPage;
import pages.SearchPage;

public class AddProductToCompareListTest extends TestBase{
	String firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";
	ProductDeatilsPage productObject;
	HomePage homeObject;
	CompareListPage compareObject;
	SearchPage searchObject;

	@Test(priority = 1)
	public void UserCanCompareProduct() {
		searchObject=new SearchPage(driver);
		productObject=new ProductDeatilsPage(driver);
		compareObject=new CompareListPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		Assert.assertTrue(productObject.productDeatils.getText().equalsIgnoreCase(firstProductName));
		productObject.AddProductToCompare();

		searchObject.ProductSearchUsingAutoSuggest("asus");
		Assert.assertTrue(productObject.productDeatils.getText().equalsIgnoreCase(secondProductName));
		productObject.AddProductToCompare2();
		
		driver.navigate().to("https://demo.nopcommerce.com"+ "/compareproducts");
		compareObject.CompareProducts();

	}
	@Test(priority = 2)
	public void UserCanClearCompareList() {
		compareObject.clearCompareList();
	}
	
}
