package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	private WebDriver driver;
	
	private @FindBy (xpath = "//label[@for='departure']")
	WebElement departureDatePickerbutton;

	private @FindBy (xpath = "(//div[@class='DayPicker-Caption'])[2]")
	WebElement monthYearHeading;
	
	private @FindBy (xpath = "//span[@aria-label='Next Month']")
	WebElement nextMonthButton;
		
	private @FindBy (xpath = "//div[@aria-label='Sat Jul 01 2023']")
	WebElement departureDate;
	
	private @FindBy (xpath = "//label[@for='travellers']")
	WebElement travellersButton;
	
	private @FindBy (xpath = "//li[@data-cy='adults-2']")
	WebElement adultCount;
	
	private @FindBy (xpath = "//li[@data-cy='children-1']")
	WebElement childrenCount;
	
	private @FindBy (xpath = "//li[@data-cy='infants-1']")
	WebElement infantsCount;	
	
	private @FindBy (xpath = "//button[@data-cy='travellerApplyBtn']")
	WebElement applyButton;
	
	private @FindBy (xpath = "//a[text()='Search']")
	WebElement searchButton;
	
	//Constructor to initialize data member 
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// To get title of page
	public String getTitleOfPage()
	{
		String titleofpage = driver.getTitle();		
		System.out.println(titleofpage);		
		return titleofpage;	
	}
	
	// To get URL of Current Page
	public String getURL()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	// To select Departure Date
	public void selectDepartureDate() throws InterruptedException
	{
		departureDatePickerbutton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(nextMonthButton));
		
		while (true)
		{
			String monthyearheading = monthYearHeading.getText();
			if (!(monthyearheading.equals("July 2023")))
			{
				nextMonthButton.click();
			}
			else
			{
				break;
			}
		}
		Thread.sleep(1000);
		departureDate.click();
	}
	
	// To select Number of adults, children and infants
	public void selectTravellers() throws InterruptedException
	{
		Thread.sleep(1000);
		
		travellersButton.click();
		
		Thread.sleep(1000);
		
		adultCount.click();
		childrenCount.click();
		infantsCount.click();
		applyButton.click();		
	}
	
	// To search flights
	public void searchFlights()
	{
		searchButton.click();
	}	
}