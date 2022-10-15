package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;
	
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lnTxt;
	
	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postCodeTxt;
	
	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[4]")
	WebElement continueBtn;
	
	@FindBy(id = "shippingoption_1")
	WebElement shippingMethodRdo;
	
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
	WebElement continueShippingBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
	WebElement continuePaymentBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	WebElement continueInfoBtn;
	
	@FindBy(css = "a.product-name")
	WebElement productName;
	
	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
	WebElement confirmBtn;
	
	@FindBy(css = "h1")
	public WebElement Thankulabl;
	
	@FindBy(css = "div.title")
	public WebElement successMsg;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")
	public WebElement orderDeatilsLink;
	
	public void RegisterdUserCheckoutProduct(String countryName,String address,String postcode,String phone,String city,String productName) throws InterruptedException {
	   select=new Select(countryList);
	   select.selectByVisibleText(countryName);
	   setTextElementText(cityTxt, city);
	   setTextElementText(addressTxt, address);
	   setTextElementText(postCodeTxt, postcode);
	   setTextElementText(phoneTxt, phone);
	   //setTextElementText(Thankulabl, productName);
	   clickButton(continueBtn);
	   System.out.println("Error1");
	   Thread.sleep(1000);
	   clickButton(shippingMethodRdo);
	   System.out.println("Error2");
	   clickButton(continueShippingBtn);
	   System.out.println("Error3");
	   Thread.sleep(3000);
	   clickButton(continuePaymentBtn);
	   Thread.sleep(1000);
	   clickButton(continueInfoBtn);
	   
	}
	public void ConfirmOrder() throws InterruptedException {
		Thread.sleep(1000);
		clickButton(confirmBtn); 
	}
	public void OrderDeatils() throws InterruptedException {
		Thread.sleep(1000);
		clickButton(orderDeatilsLink);
	}

}
