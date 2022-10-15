package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.OrderDeatilsObject;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class E2ETest extends TestBase{
	ProductDeatilsPage productObject;
	ShoppingCartPage cartPage;
	SearchPage searchObject;
	CheckOutPage checkoutpage;
	OrderDeatilsObject orderpage;
	CheckOutPage checkoutObject;
	String productName="Apple MacBook Pro 13-inch";
	@Given("user is on Home Page")
	public void user_is_on_home_page() {
	  Assert.assertTrue(driver.getCurrentUrl().contains("demp.hopcommerce.com"));
	}
	@When("he search for {string}")
	public void he_search_for(String productName) {
	    searchObject=new SearchPage(driver);
	    searchObject.ProductSearchUsingAutoSuggest(productName);
	    productObject=new ProductDeatilsPage(driver);
	    Assert.assertTrue(productObject.productDeatils.getText().contains(productName));
	}
	@When("choose to buy Two items")
	public void choose_to_buy_two_items() {
	    cartPage=new ShoppingCartPage(driver);
	    productObject.AddToCart();
	    driver.navigate().to("http://demp.hopcommerce.com/"+"cart");
	    
	}
	@When("moves to checkout cart and enter personal deatails on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_deatails_on_checkout_page_and_place_the_order() throws InterruptedException {
		checkoutObject=new CheckOutPage(driver);
		cartPage.checkout();
		checkoutObject.RegisterdUserCheckoutProduct("Egypt", "Test address", "84888", "65446", "Cairo",productName);
		checkoutObject.ConfirmOrder();
		
		
	}
	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException {
		checkoutObject.OrderDeatils();
		orderpage=new OrderDeatilsObject(driver);
		orderpage.DownloadPdfInvoice();
		orderpage.printOrderDeatils();
	}
}
