package tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	public static String DownloadPath=System.getProperty("user.dir")+"\\Downloads";
	public static ChromeOptions chromeoption() {
		ChromeOptions options=new ChromeOptions();
		HashMap<String, Object> chromeprefs=new HashMap<String, Object>();
		chromeprefs.put("profile.default.content_settings.popups", 0);
		chromeprefs.put("download.default_directory", DownloadPath);
		options.setExperimentalOption("prefs", chromeprefs);
		//options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);
		return options;
	}
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver=new ChromeDriver(chromeoption());
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
	    
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	
	
	
	@AfterSuite
	public void stopDriver() {
		//driver.quit();
	}
	//Take Screenshot when test case fail and add it to screenshot folder
	
	@AfterMethod
	public void ScreenshotOnFailure(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
