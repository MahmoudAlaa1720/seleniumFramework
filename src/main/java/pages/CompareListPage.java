package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareListPage extends PageBase{

	public CompareListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.clear-list")
	WebElement clearlistLink;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div")
	WebElement noDataLbl;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table")
	WebElement compareTable;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRow;
	
	@FindBy(tagName = "td")
	public List<WebElement> allCol;	
	
	
	public void clearCompareList() {
		clickButton(clearlistLink);
	}
	
	public void CompareProducts() {
		System.out.println(allRow.size());
		for(WebElement row: allRow) {
			System.out.println(row.getText()+"\t");
			for(WebElement col: allCol) {
				System.out.print(col.getText()+"\t");
			}
		}
	}

}
