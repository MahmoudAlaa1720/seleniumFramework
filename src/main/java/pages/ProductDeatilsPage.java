package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDeatilsPage extends PageBase {

	public ProductDeatilsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[1]/ul/li[4]/strong")
	public WebElement productDeatils;
    
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[3]/button")
	WebElement emailtofriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement ProductPrice;
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[3]/div[2]/a[2]")
	WebElement addReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addtoWishListLink;
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[10]/div[2]/button")
	WebElement addtoCompareBtn;
	
	@FindBy(xpath = "//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[9]/div[2]/button")
	WebElement addtoCompareBtn2;
	
	@FindBy(id ="add-to-cart-button-4")
	WebElement addToCartBtn;
	
	public void sendEmailtoFriend() {
		clickButton(emailtofriendBtn);
	}
	public void openREviewPage() {
		clickButton(addReviewLink);
	}
	public void AddProductToWishList() {
		clickButton(addtoWishListLink);
	}
	public void AddProductToCompare() {
		clickButton(addtoCompareBtn);
	}
	public void AddProductToCompare2() {
		clickButton(addtoCompareBtn2);
	}
	public void AddToCart() {
		clickButton(addToCartBtn);
	}
}
