package Utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EmailPage {
	
	public static WebElement element = null;


	/**
	 * Enter username
	 */
	public static void enterUsername(WebDriver driver,String username) {
		element = driver.findElement(By.xpath("//input[@id='login-username']"));
		element.sendKeys(username);
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		

	}

	/**
	 * Enter password
	 */
	public static void enterPassword(WebDriver driver,String password) {
		element = driver.findElement(By.xpath("//input[@name='password']"));
		element.sendKeys(password);
		driver.findElement(By.xpath("//button[@id='login-signin']")).click();
		
	}


	/**
	 * Check is login successfully
	 */
	public static boolean isLoginSuccess(WebDriver driver) {
		WebElement welcomeText = null;
		try {
			welcomeText = driver.findElement(By.xpath("//img[@class='_yb_1jtso _yb_9v04m']"));
			if (welcomeText != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}

		return false;
	}

	/**
	 * Click New Letter button
	 */
	public static void clickNewLetter(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='e_dRA l_T cn_dBP cg_FJ k_w r_P A_6EqO u_e69 p_R S_n C_52qC I_ZamTeg D_F H_6VdP gl_C ab_C en_0 M_1Eu7sD ir3_1JO2M7 it3_dRA']"));
		element.click();
		
	}

	/**
	 * Enter email address and subject
	 */
	public static void enterEmailAddress(WebDriver driver,String emailAddress) {
		element = driver.findElement(By.xpath("//input[@id='message-to-field']"));
		element.sendKeys(emailAddress);
		
		//Enter subject
		element.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("test");;
		
	}

	/**
	 * Upload attachment
	 * 
	 * @throws IOException
	 */
	public static void uploadAttachment(WebDriver driver) throws IOException {
		// click add attachment button
		element = driver.findElement(By.xpath("//span[@class='D_X P_3gIMd V_GI O_cMu O4_N I4_2ieea9 O0_N I0_7l9bL ir3_1JO2M7 it3_dRA H_6NIX W_6VdP k_w b_efTvb e_dRA rtlR_h_2gl0WC']"));
		element.click();
		
	}

	/**
	 * Click send button
	 */
	public static void sendEmail(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='q_Z2aVTcY e_dRA k_w r_P H_6VdP s_3mS2U en_0 M_1gLo4F V_M cZ1RN91d_n y_Z2uhb3X A_6EqO u_e69 b_0 C_52qC I4_Z29WjXl ir3_1JO2M7 it3_dRA']"));
		element.click();
		//test.log(LogStatus.INFO, "Click send button");
	}

	/**
	 * Check is email send successfully
	 */
	public static boolean isEamilSent(WebDriver driver) {
		WebElement emailSent = null;
		try {
			emailSent = driver.findElement(By.xpath("//body[@id='Atom']/div[@id='mail-app-container']/div[@class='pointer-mode H_6D6F']/div[@class='D_F ek_BB H_6D6F aw_2941hk ba_10I1Qt az_oOItw ay_Z1nkUQx I_kt4zd']/div[@id='app']/div[5]"));
			if (emailSent.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

}
