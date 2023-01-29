package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentListeners.TestNGListeners;
import utilities.ConfigReader;

public class TripReviewPageTest extends TestNGListeners 
{
	@Test (priority = 12)
	public void validateTripFromAndTo() throws InterruptedException
	{
		String place = tripreviewpage.getTripFromAndTo();
		Boolean ispresent = place.contains(ConfigReader.readConfig("fromAirport")) && place.contains(ConfigReader.readConfig("toAirPort"));
		Assert.assertTrue(ispresent);		
	}
	@Test (priority = 13)
	public void validateTotalAmount()
	{
		String baseFare = tripreviewpage.getBaseFareAmount();
		String baseFareString = baseFare.replaceAll("[₹ ,]", "");
		int baseFareAmounts = Integer.parseInt(baseFareString);
		
		String feeAndSurcharge = tripreviewpage.getFeeAmount();
		String feeAndSurchargeString = feeAndSurcharge.replaceAll("[₹ ,]", "");
		int feeAndSurchargeAmount = Integer.parseInt(feeAndSurchargeString);
		
		String otherServices = tripreviewpage.getOtherServicesAmount();
		String otherServicesString = otherServices.replaceAll("[₹ ,]", "");
		int otherServicesAmount = Integer.parseInt(otherServicesString);
		
		String totalAmounts = tripreviewpage.getTotalAmount();
		String totalAmountString = totalAmounts.replaceAll("[₹ ,]", "");
		int totalAmount = Integer.parseInt(totalAmountString);
		
		boolean total=false;
		if (baseFareAmounts+feeAndSurchargeAmount+otherServicesAmount==totalAmount)
		{
			total = true;
		}		
		Assert.assertTrue(total);
	}
}
