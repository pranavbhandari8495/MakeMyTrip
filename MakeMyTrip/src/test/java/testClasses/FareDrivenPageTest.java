package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentListeners.TestNGListeners;
import utilities.ConfigReader;

public class FareDrivenPageTest extends TestNGListeners 
{
	@Test (priority = 3)
	public void validateTripType()
	{
		String testType = ConfigReader.readConfig("tripType");
		String type = faredrivenpage.gettripType();
		
		Boolean ispresent = testType.equals(type);
		Assert.assertTrue(ispresent);		
	}
	@Test (priority = 4)
	public void validateFromCity() 
	{
		String testfType = ConfigReader.readConfig("fromWhichCity");
		String city = faredrivenpage.getFromCity();
		
		Boolean ispresent = testfType.equals(city);
		Assert.assertTrue(ispresent);		
	}
	@Test (priority = 5) 
	public void validateToCity() 
	{
		String testTcity = ConfigReader.readConfig("toWhichCity");
		String city = faredrivenpage.getToCity();
		
		Boolean ispresent = testTcity.equals(city);
		Assert.assertTrue(ispresent);		
	}
	@Test (priority = 6)
	public void validateDepartureDate()
	{
		String testDate = ConfigReader.readConfig("departDate");
		String date = faredrivenpage.getDepartDate();
		
		Boolean ispresent = testDate.equals(date);
		Assert.assertTrue(ispresent);		
	}
	@Test (priority = 7)
	public void validatePassangersAndClass() 
	{
		String testPAC = ConfigReader.readConfig("passengersAndclass");
		String passAndClass = faredrivenpage.getPassangersAndClass();
		
		Boolean ispresent = testPAC.equals(passAndClass );
		Assert.assertTrue(ispresent);		
	}
	@Test (priority = 8)
	public void validatePriceSlider()
	{
		faredrivenpage.applyPriceFilter();		
		String[] listofPrice = faredrivenpage.getPrices();
		for (String price : listofPrice)
		{
			Boolean ispresent = false;
			String prices = price.replaceAll("[₹ ,]", "");
			int priceAmount = Integer.parseInt(prices);			 
			if (priceAmount<7200)
			{
				ispresent = true;
			}
			Assert.assertTrue(ispresent);
		}		
	}
	@Test (priority = 9)
	public void validateNonStopFiter() throws InterruptedException
	{
		String nonStopFilter = faredrivenpage.applyNonStopFilter();
		int count = faredrivenpage.getNonStopFlightsCount();
		String countString = String.valueOf(count); 
		Boolean ispresent = nonStopFilter.contains(countString);
		Assert.assertTrue(ispresent);		
//		faredrivenpage.applyNonStopFilter();
//		String[] info = faredrivenpage.getLayOverInfo();
//		for (String travelinfo : info)
//		{
//			Boolean ispresent = false;
//			if (travelinfo.equals("Non stop"))
//			{
//				ispresent = true;
//			}
//			Assert.assertTrue(ispresent);
//		}
	}
	@Test (priority = 10)
	public void validateAirLineFilter() throws InterruptedException
	{
		String airLine = faredrivenpage.applyAirlineFilter();
		int count = faredrivenpage.getAirLineFilterCount();
		String countString = String.valueOf(count);
		Boolean ispresent = airLine.contains(countString);
		Assert.assertTrue(ispresent);
	}	
	
	@Test (priority = 11)
	public void validateBookingButton()
	{
		faredrivenpage.booking();
	}
	
}