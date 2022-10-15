package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPageObject;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase{
	HomePage homeObject;
	UserRegisterationPage registerObject;
	MyAccountPageObject myaccountobject;
	LoginPage loginObject;
	String oldPassword ="12345678";
	String newPassword ="123456";
	String firstName="Mahmoud";
	String lastName="Alaa";
	String Email="Testemailssdssdswscfdewwssswsss@email.com";
		
	@Test(priority = 1)
	public void UserCanRegisterSucessfuly() {
		homeObject=new HomePage(driver);
		homeObject.OpenRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstName, lastName, Email, oldPassword);
		Assert.assertTrue(registerObject.successmessage.getText().contains("Your registration completed")); 

	}
	@Test(dependsOnMethods = {"UserCanRegisterSucessfuly"})
	public void RegisterUserCanChangePAssword() throws InterruptedException {
		myaccountobject=new MyAccountPageObject(driver);
		registerObject.openMyAccountPage();
		myaccountobject.clickChangePassword();
		myaccountobject.ChangePassword(oldPassword, newPassword);
		myaccountobject.clickclosebtn();
		Thread.sleep(3000);
	}
	@Test(dependsOnMethods = {"RegisterUserCanChangePAssword"})
	public void RegisteruserLogout() {
		registerObject.userLogOut();
	}
	@Test(dependsOnMethods = {"RegisteruserLogout"})
	public void RegisteruserLogin() {
		homeObject.OpenLoginPage();
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(Email, newPassword);
	}
}
