package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDeatilsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase{

	//User Registration 
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDeatilsPage productObject;
	EmailPage emailObject;
	@Test(priority = 1)
	public void UserCanRegisterSucessfuly() {
		homeObject=new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mahmoud", "Alaa", "Testemailsssssxssssddsssad@email.com", "12345678");
		Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed")); 

	}
	//2-SearchProduct
	@Test(priority = 2)
	public void UserCanSearchUsingAutoSuggest() {
		searchObject=new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		productObject=new ProductDeatilsPage(driver);
		Assert.assertTrue(productObject.productDeatils.getText().equalsIgnoreCase(productName));
	}
	
	
	
	//3-email to friend
	@Test(priority = 3)
	public void registerUserCanSendProductToFriend() {
		productObject.sendEmailtoFriend();
		emailObject=new EmailPage(driver);
		emailObject.sendEmailtoFriend("asas@gmail.com", "hello my friend");
		Assert.assertTrue(emailObject.messagenotification.getText().contains("Your message has been sent"));
	}
	
	
	
	//4-User Logout
	@Test(priority = 4)
	public void RegisteruserLogout() {
		registerObject.userLogOut();
	}
}
