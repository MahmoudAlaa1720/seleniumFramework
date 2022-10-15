package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(xpath = "//*[@id=\"small-search-box-form\"]/button")
	WebElement searchbtn;
    
	@FindBy(id = "ui-id-1")
	List<WebElement> Productlist;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")
	WebElement productTitle;
	
	public void ProductSearch(String productName) {
		setTextElementText(searchTxtBox, productName);
		clickButton(searchbtn);
	}
	public void OpenProductDeatilsPage() {
		clickButton(productTitle);
	}
	public void ProductSearchUsingAutoSuggest(String searchTxt) {
		setTextElementText(searchTxtBox, searchTxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Productlist.get(0).click();
	}
}
	