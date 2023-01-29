package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.FareDriverPage;
import pages.HomePage;
import pages.TripReviewPage;
import utilities.ConfigReader;

public class BaseTest 
{
	public static WebDriver driver;
	public HomePage homepage;
	public FareDriverPage faredrivenpage;
	public TripReviewPage tripreviewpage;
	
	@BeforeSuite
	public void initBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url = ConfigReader.readConfig("testsiteurl");
		driver.get(url);
	}
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
	@BeforeClass
	public void createObject()
	{
		homepage = new HomePage(driver);
		faredrivenpage = new FareDriverPage(driver);
		tripreviewpage = new TripReviewPage(driver);
	}

}
