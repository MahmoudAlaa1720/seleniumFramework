package tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithDDTAndExcel extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException {
		// get data from Excel Reader class
		ExcelReader er =new ExcelReader();
		return er.getExcelData();
	}
	
	@Test(priority = 1,alwaysRun = true,dataProvider = "ExcelData")
	public void UserCanRegisterSucessfuly(String firstname,String lastname,String email,String password) {
		homeObject=new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed"));
		registerObject.userLogOut();
		homeObject.OpenLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(email, password);
		registerObject.userLogOut();

	}
	

}
