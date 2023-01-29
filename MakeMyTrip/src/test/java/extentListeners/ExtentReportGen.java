package extentListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGen 
{	
	public static ExtentReports extent;

	public static ExtentReports extentReportGenerator()
	
	{
		String path = System.getProperty("user.dir")+"\\reports\\MakeMyTrip.html";		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("Make My Trip Testing Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Performed By ", "QA Team A");
		extent.setSystemInfo("Environment ", "SIT");
		extent.setSystemInfo("Browser ", "Google Chrome");
		return extent;
	}	
}