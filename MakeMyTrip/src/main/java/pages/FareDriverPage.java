package pages;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FareDriverPage 
{
	WebDriver driver;
	
	private @FindBy(xpath = "//button[text()='OKAY, GOT IT!']")
	WebElement okayButton;
	
	private @FindBy(xpath = "//div[@class='multiDropDownVal']")
	WebElement tripType;
	
	private @FindBy(xpath = "//input[@id='fromCity']")
	WebElement fromCity;
	
	private @FindBy(xpath = "//input[@id='toCity']")
	WebElement toCity;
			
	private @FindBy(xpath = "//input[@id='departure']")
	WebElement departureDate;
	
	private @FindBy(xpath = "//input[@id='travellerAndClass']")
	WebElement travellersAndClass;
	
	private @FindBy(xpath = "//p[@class='flightsLayoverInfo']")
	List <WebElement> flightsLayoverInfo;
	
	private @FindBy(xpath = "//div[@aria-orientation='horizontal']")
	WebElement priceSlider;
	
	private @FindBy(xpath = "//p[contains(@class, 'blackText')][contains(@class, 'fontSize18')]")
	List <WebElement> pricesbelow5k;
	
	private @FindBy(xpath = "(//input[@id='listingFilterCheckbox'])[1]")
	WebElement nonStopFilterCheckbox;
		
	private @FindBy(xpath = "//p[@class='flightsLayoverInfo']")
	List <WebElement> flightsInfoforNonStopFilter;
	
	private @FindBy(xpath = "(//p[@class='checkboxTitle'])[1]")
	WebElement nonStopFilter;
	
	private @FindBy(xpath = "//p[text()='I5 1534']")
	WebElement eighthFlight;
	
	private @FindBy(xpath = "//p[text()='6E 5186']")
	WebElement sixteenthFlight;
	
	private @FindBy(xpath = "//p[text()='UK 815']")
	WebElement twentyFourthFlight;
	
	private @FindBy(xpath = "//p[text()='AI 506']")
	WebElement thirtySecondFlight;	
	
	private @FindBy(xpath = "//p[text()='AI 504']")
	WebElement lastFlight;
	
	private @FindBy(xpath = "(//input[@id='listingFilterCheckbox'])[7]")
	WebElement airlinetFilterCheckbox;
	
	private @FindBy(xpath = "(//p[@class='checkboxTitle'])[7]")
	WebElement airIndiaFilter;
	
	private @FindBy(xpath = "//p[@class='flightsLayoverInfo']")
	List <WebElement> flightsInfoforAirlineFilter;
	
	private @FindBy(xpath = "(//div[contains(@id,'flight_list_item')]//span[@class='appendRight8'])[1]")
	WebElement viewPriceButton;
	
	private @FindBy(xpath = "(//button[text()='Book Now'])[1]")
	WebElement bookNowButton;

	public FareDriverPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String gettripType()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(okayButton));
		okayButton.click();
		String type = tripType.getText();
		return type;
	}
	
	// To get From City name
	public String getFromCity()
	{
		String fcity = fromCity.getDomAttribute("value");
		System.out.println(fcity);
		return fcity;		
	}
	// To get To City name
	public String getToCity()
	{
		String tcity = toCity.getDomAttribute("value");
		System.out.println(tcity);
		return tcity;
	}
	
	// To get Departure date
	public String getDepartDate()
	{
		String departDate = departureDate.getDomAttribute("value");
		System.out.println(departDate);
		return departDate;
	}
	
	// To get number of adult, children and infants travellers
	public String getPassangersAndClass()
	{
		String nos = travellersAndClass.getDomAttribute("value");
		System.out.println(nos);
		return nos;
	}	
	
	// To Apply Price Filter i.e. Price less than 7200
	public void applyPriceFilter() 
	{
		Actions act = new Actions(driver);		
		act.clickAndHold(priceSlider).moveByOffset(-150, 0).release().build().perform();		
	}
	
	// To get all prices as per applied filter
	public String[] getPrices()
	{
		int i = pricesbelow5k.size();
		String [] ar = new String [i];
		int n = 0;	
		for (WebElement price : pricesbelow5k)
		{
			ar[n] = price.getText();
			n++;
		}
		for (String s : ar)
		{
			System.out.println(s);
		}
		return ar;		
	}
	
	// To Apply Non Stop Filter
	public String applyNonStopFilter() throws InterruptedException
	{
		nonStopFilterCheckbox.click();
		String nonStop = nonStopFilter.getText();
		System.out.println(nonStop);
		Actions act = new Actions(driver);
		act.scrollToElement(eighthFlight).perform();
		Thread.sleep(2000);
		act.scrollToElement(sixteenthFlight).perform();
		Thread.sleep(2000);
		act.scrollToElement(twentyFourthFlight).perform();
		Thread.sleep(2000);
		act.scrollToElement(thirtySecondFlight).perform();
		Thread.sleep(2000);
		act.scrollToElement(lastFlight).perform();
		return nonStop;
	}
	
	// To get number of Non Stop Flights 
	public int getNonStopFlightsCount()
	{
		int i = flightsInfoforNonStopFilter.size();
		System.out.println(i);
		return i;
	}
	
	// To apply Airline Filter  
	public String applyAirlineFilter() throws InterruptedException
	{
		Actions act = new Actions(driver);		
		act.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP)
		.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP)
		.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP)
		.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP)
		.build().perform();
		
		airlinetFilterCheckbox.click();
		String airlineFilter = airIndiaFilter.getText();
		System.out.println(airlineFilter);
		return airlineFilter;
	}
	
	// To get number of Air line filtered Flights 
	public int getAirLineFilterCount()
	{
		int i = flightsInfoforAirlineFilter.size();
		System.out.println(i);
		return i;
	}
	
	// To book flight
	public void booking()
	{
		viewPriceButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(bookNowButton));		
		bookNowButton.click();
	}
}