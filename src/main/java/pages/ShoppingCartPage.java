package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
 	}
    
	@FindBy(name = "updatecart")
	WebElement removeCheck;
	
	//@FindBy(id = "updatecart")
	//WebElement updateCartBtn;
	
	@FindBy(id = "product_enteredQuantity_4")
	public WebElement quantityText;
	
	@FindBy(css = "td.subtotal")
	public WebElement totalLbl;
	
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	
	@FindBy(id = "termsofservice")
	WebElement termsBtn;
	
	public void removeProductFromCart() {
		clickButton(removeCheck);
	}
	
	public void UpdateProductQuantityInCart(String quantity) {
		clearText(quantityText);
		setTextElementText(quantityText, quantity);
		//clickButton(updateCartBtn);
	}
	public void checkout() {
		clickButton(termsBtn);
		clickButton(checkOutBtn);
	}
	
}
