package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDeatilsObject;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;

public class RegisterdUserCheckOutTest extends TestBase{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDeatilsPage productObject;
	CheckOutPage checkoutObject;
	ShoppingCartPage cartPage;
	OrderDeatilsObject orderObject;
	
	@Test(priority = 1)
	public void UserCanRegisterSucessfuly() {
		homeObject=new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mahmoud", "Alaa", "Testemailasgadsassaaszsasafpadsa@email.com", "12345678");
		Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed")); 

	}
	@Test(priority = 2)
	public void UserCanSearchUsingAutoSuggest() {
		searchObject=new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		productObject=new ProductDeatilsPage(driver);
		Assert.assertTrue(productObject.productDeatils.getText().equalsIgnoreCase(productName));
	}
	@Test(priority = 3)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		productObject=new ProductDeatilsPage(driver);
		productObject.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
		cartPage=new ShoppingCartPage(driver);
		
	}
	@Test(priority = 4)
	public void UserCanCheckOutProduct() throws InterruptedException {
		checkoutObject=new CheckOutPage(driver);
		cartPage.checkout();
		checkoutObject.RegisterdUserCheckoutProduct("Egypt", "Test address", "84888", "65446", "Cairo",productName);
		checkoutObject.ConfirmOrder();
		checkoutObject.OrderDeatils();
		orderObject=new OrderDeatilsObject(driver);
		orderObject.DownloadPdfInvoice();
		orderObject.printOrderDeatils();
	}
	//@Test(priority = 5)
	//public void RegisteruserLogout() {
		//registerObject=new UserRegisterationPage(driver);
		//registerObject.userLogOut();
     // }
}
