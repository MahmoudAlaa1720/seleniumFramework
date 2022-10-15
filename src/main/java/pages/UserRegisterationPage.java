package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
		

	}
	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id = "FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id = "LastName")
	WebElement lnTxtBox;
	
	@FindBy(id = "Email")
	WebElement emTxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxt;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmpassTxt;
	
	@FindBy(id ="register-button" )
	WebElement registerbtn;
	
	@FindBy(css = "div.result")
	public WebElement successmessage;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public WebElement logoutLink;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement myAccountLink;
	
	public void userRegisteration(String FirstName,String LastName,String Email,String Password) {
		clickButton(genderRdoBtn);
		setTextElementText(fnTxtBox, FirstName);
		setTextElementText(lnTxtBox, LastName);
		setTextElementText(emTxtBox, Email);
		setTextElementText(passwordTxt, Password);
		setTextElementText(confirmpassTxt, Password);
		clickButton(registerbtn);
	}
	public void userLogOut() {
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}


}
