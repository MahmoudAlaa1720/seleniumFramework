package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndJSON extends TestBase {
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSucessfuly() throws FileNotFoundException, IOException, ParseException {
		JsonDataReader reader = new JsonDataReader(); 
		reader.JsonReader();
		homeObject=new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration("Mahmoud", "Alaa", "Testemailsssssssssddsssad@email.com", "12345678");
		Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed")); 
		registerObject.userLogOut();
		homeObject.OpenLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin("Testemailsssssssssddsssad@email.com", "12345678");
		registerObject.userLogOut();
	}

	

}
