package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDeatilsObject extends PageBase{

	public OrderDeatilsObject(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/a[2]")
	WebElement 	pdfInvoiceLink;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[1]/a[1]")
	WebElement printInvoiceLink;
	
	public void printOrderDeatils() {
		clickButton(printInvoiceLink);
	}
	
	public void DownloadPdfInvoice() throws InterruptedException {
		clickButton(pdfInvoiceLink);
		Thread.sleep(2000);
	}

}
