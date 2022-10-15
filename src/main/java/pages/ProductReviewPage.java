package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
    @FindBy(id = "AddProductReview_Title")
    WebElement ReviewTitletxtBox;
    
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement ReviewTxt;
    
    @FindBy(id = "addproductrating_4")
    WebElement Rating4RdBtn;
    
    @FindBy(name = "add-review")
    WebElement submitReviewBtn;
    
    @FindBy(css = "div.result")
    public WebElement reviewNotification;
    
    public void AddProductReview(String reviewTitle,String reviewMsg) {
    	setTextElementText(ReviewTitletxtBox, reviewTitle);
    	setTextElementText(ReviewTxt, reviewMsg);
    	clickButton(Rating4RdBtn);
    	clickButton(submitReviewBtn);
    	
    }
}
