package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement PersonalmsgTxt;
	
	@FindBy(name = "send-email")
	WebElement sendEmailBtn;
	
	@FindBy(css = "div.result")
	public WebElement messagenotification;
     
	public void sendEmailtoFriend(String friendEmail,String personalmessage) {
		setTextElementText(friendEmailTxt, friendEmail);
		setTextElementText(PersonalmsgTxt, personalmessage);
		clickButton(sendEmailBtn);
	}
}
