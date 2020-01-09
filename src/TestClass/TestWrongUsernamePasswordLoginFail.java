package TestClass;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Contanst;
import Utilities.EmailPage;
import Utilities.ExtentFactory;
import Utilities.ScreenShot;
import Utilities.UsernameAndPassword;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestWrongUsernamePasswordLoginFail {
	private WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	/**
	 * @throws InterruptedException
	 * Enter incorrect username, correct password and take screenShot if login failed
	 */
  @Test
  public void loginWithWrongUsernameAndPassword() throws InterruptedException {
		//Enter Username
		EmailPage.enterUsername(driver,"test");
		test.log(LogStatus.INFO, "Enter username...");
		
		//Enter password
		EmailPage.enterPassword(driver, "test");
		test.log(LogStatus.INFO, "Enter password");
		Thread.sleep(3000);
		

		
		//Check login status
		boolean loginStatus = EmailPage.isLoginSuccess(driver);
		if( loginStatus == true){
			Assert.assertTrue(true);
			test.log(LogStatus.INFO, "login successfully");
		}else{
			test.log(LogStatus.FAIL,"login failed");
		}
  }
  @BeforeMethod
  public void beforeMethod() {
		driver = new ChromeDriver();
		report = ExtentFactory.getInstance();
		test = report.startTest("Test Eamil login");
		test.log(LogStatus.INFO, "Browser started");
		// maximize window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "maximize window");

		// Waiting Page Loading
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Web Application Opened
		driver.get(Contanst.baseUrl);
		test.log(LogStatus.INFO, "Web Application Opened");


  }

  @AfterMethod
  public void afterMethod(ITestResult testResult) throws InterruptedException, IOException {
		Thread.sleep(2000);
		String path = ScreenShot.takeScreenShot(driver, testResult.getName());
		String imagePath =test.addScreenCapture(path);
		test.log(LogStatus.FAIL, "log in Failed",imagePath);
		driver.quit();
		report.endTest(test);
		report.flush();
  }

}
