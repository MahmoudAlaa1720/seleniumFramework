package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndDataProviderTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;


	@DataProvider(name = "testData")
	public static Object[][] userData() {
		return new Object[][] {
			{"Moataz","Nabil","testsxxasasa@gmail.com","123456"},{"Ahmed","Ali","testasuasssser@gmail.com","12345678"}
		};
	}
	@Test(priority = 1,alwaysRun = true,dataProvider ="testData" )
	public void UserCanRegisterSucessfuly(String fname,String lname,String email,String password) {
		homeObject=new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.userLogOut();
		homeObject.OpenLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(email, password);
		registerObject.userLogOut();

	}


}
