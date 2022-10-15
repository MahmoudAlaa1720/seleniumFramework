package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse=(JavascriptExecutor) driver;
		action=new Actions(driver);
	 
	}
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement registerlink;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	WebElement loginlink;
	
	@FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[1]/ul/li[6]/a")
	WebElement ContactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencydrl;
	
	@FindBy(xpath =  "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement ComputerMenu;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement NotBooksMenu;
	
	
	
	public void OpenRegisterationPage() {
		clickButton(registerlink);
	}
	
	public void OpenLoginPage() {
		clickButton(loginlink);
	}
	public void OpenContactUsPage() {
		scrollToBottom();
		clickButton(ContactUsLink);
	}
	public void ChangeCurrency() {
		select=new Select(currencydrl);
		select.selectByVisibleText("Euro");
	}
	public void selectNotBooksMenu() {
		action.moveToElement(ComputerMenu).moveToElement(NotBooksMenu).click().build().perform();
	}

}
