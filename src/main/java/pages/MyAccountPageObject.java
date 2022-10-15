package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageObject extends PageBase {

	public MyAccountPageObject(WebDriver driver) {
		super(driver);

	}

	@FindBy(linkText = "Change password")
	WebElement Changepassword;

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id = "NewPassword")
	WebElement newPasswordTxt;

	@FindBy(id="ConfirmNewPassword")
	WebElement ConfirmPasswordTxt;

	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
	WebElement ChangePasswordBtn;
	
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
	WebElement closealert;

	public void ChangePassword(String oldpassword,String newpassword) {
		setTextElementText(oldPasswordTxt, oldpassword);
		setTextElementText(newPasswordTxt, newpassword);
		setTextElementText(ConfirmPasswordTxt, newpassword);
		clickButton(ChangePasswordBtn);
	}

	public void clickChangePassword() {
		clickButton(Changepassword);
	}
	public void clickclosebtn() {
		clickButton(closealert);
	}

}
