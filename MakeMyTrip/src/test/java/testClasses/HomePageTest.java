package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentListeners.TestNGListeners;
import utilities.ConfigReader;

public class HomePageTest extends TestNGListeners 
{
	
	@Test (priority = 1)
	public void validateTitle()
	{
		String title = homepage.getTitleOfPage();		
		boolean ispresent = title.contains("Flight Booking");				
		Assert.assertEquals(ispresent, true);				
	}
	@Test (priority = 1)
	public void validateURL()
	{
		String url = homepage.getURL();	
		String testUrl = ConfigReader.readConfig("testsiteurl");
		boolean ispresent = url.equals(testUrl);				
		Assert.assertEquals(ispresent, true);				
	}
	
	@Test (priority = 2)
	public void validateSearch() throws InterruptedException
	{
		homepage.selectDepartureDate();
		homepage.selectTravellers();
		homepage.searchFlights();
	}	
}