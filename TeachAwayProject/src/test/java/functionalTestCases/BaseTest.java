package functionalTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pageObjects.HomePageObjects;

public class BaseTest {
	
	public WebDriver driver;
	HomePageObjects homepage;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.teachaway.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage = new HomePageObjects(driver);
	}
	
//	@BeforeMethod
//	public void launchURL() {
//		
//	}
//	
	@AfterClass
	public void closeBrowser() {
		//driver.close();
		driver.quit();
	}

}
