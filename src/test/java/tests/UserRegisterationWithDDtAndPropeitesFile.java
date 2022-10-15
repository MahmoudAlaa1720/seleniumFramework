package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperites;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDtAndPropeitesFile extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String firstname=LoadProperites.userData.getProperty("firstname");
	String lastname=LoadProperites.userData.getProperty("lastname");
	String email=LoadProperites.userData.getProperty("email");
	String password=LoadProperites.userData.getProperty("password");
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSucessfuly() {
		homeObject=new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname,lastname,email,password);
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
		loginObject.UserLogin(email, password);
	}

}
