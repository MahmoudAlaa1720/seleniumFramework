package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSucessfuly() {
		homeObject=new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mahmoud", "Alaa", "Testemailsssssssssddsssad@email.com", "12345678");
		Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed")); 

	}
	@Test(dependsOnMethods = {"UserCanRegisterSucessfuly"})
	public void RegisteruserLogout() {
		registerObject.userLogOut();
	}
	@Test(dependsOnMethods = {"RegisteruserLogout"})
	public void RegisteruserLogin() {
		homeObject.OpenLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin("Testemailsssssssssddsssad@email.com", "12345678");
	}

}
