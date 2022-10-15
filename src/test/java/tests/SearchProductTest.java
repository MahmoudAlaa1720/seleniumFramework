package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.ProductDeatilsPage;
public class SearchProductTest extends TestBase {

	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
    ProductDeatilsPage productObject;

    @Test
    public void userCanSearchForProduct() {
    	searchObject=new SearchPage(driver);
    	productObject=new ProductDeatilsPage(driver);
    	searchObject.ProductSearch(productName);
    	searchObject.OpenProductDeatilsPage();
    	Assert.assertTrue(productObject.productDeatils.getText().equalsIgnoreCase(productName));
    }
}
