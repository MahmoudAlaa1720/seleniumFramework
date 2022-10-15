package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FullName")
	WebElement fullNameTxt;

	@FindBy(id="Email")
	WebElement EmailTxt;

	@FindBy(id="Enquiry")
	WebElement enqueryTxt;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successmsg;
	
	public void ContactUs(String fullName,String email,String message) {
		setTextElementText(fullNameTxt, fullName);
		setTextElementText(EmailTxt, email);
		setTextElementText(enqueryTxt, message);
		clickButton(submitBtn);
		
	}
}
