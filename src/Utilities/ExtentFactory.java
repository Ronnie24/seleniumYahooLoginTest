package Utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance(){
		ExtentReports extent;
		String path ="E:\\EW\\TestNGYahooLogin\\report-demo.html";
		extent = new ExtentReports(path,false);
		
		return extent;
	}

}
