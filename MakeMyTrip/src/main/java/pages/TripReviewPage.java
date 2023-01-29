package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripReviewPage 
{
	WebDriver driver;	
	
	private @FindBy(xpath = "//h2[@class='blackFont']")
	WebElement tripFromAndTo ;
	private @FindBy(xpath = "(//div[@class='fareRow']//span[contains(@class,'fontSize14')])[1]")
	WebElement baseFareAmount;
	private @FindBy(xpath = "(//div[@class='fareRow']//span[contains(@class,'fontSize14')])[2]")
	WebElement feeAndSurchargesAmount;
	private @FindBy(xpath = "(//p[contains(@class,'fareRow ')]//span[contains(@class,'fontSize14')])[2]")
	WebElement otherservicesAmount;	
	private @FindBy(xpath = "(//div[@class='fareFooter']//span[contains(@class,'fontSize16')])[2]")
	WebElement TotalAmount;
	private @FindBy(xpath = "//input[@class='promoInput']")
	WebElement promocodeTextbox;	
	

	
	public TripReviewPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// To get From City and To City on Trip Review Page
	public String getTripFromAndTo() throws InterruptedException
	{
		String parent = driver.getWindowHandle();					// To get parent window id
		
		Set<String> allwin = driver.getWindowHandles();				// To get id of all windows
		
		for(String id :allwin)
		{
			if(!(id.equals(parent)))								
			{
				driver.switchTo().window(id);						// To switch window control
			}
		}

		Thread.sleep(30000);
		String places = tripFromAndTo.getText();
		System.out.println(places);
		return places;
	}
	
	//To get Base Fare Amount
	public String getBaseFareAmount()
	{
		String baseFare = baseFareAmount.getText();
		return baseFare;
	}
	
	//To get Fee and Surcharges Fare Amount
	public String getFeeAmount()
	{
		String feeamount = feeAndSurchargesAmount.getText();
		return feeamount;
	}
	
	//To get Other Services Fare Amount
	public String getOtherServicesAmount()
	{
		String otherAmount = otherservicesAmount.getText();
		return otherAmount;
	}
	
	// To get Total Amount
	public String getTotalAmount()
	{
		String totalAmount = TotalAmount.getText();
		return totalAmount;
	}
}