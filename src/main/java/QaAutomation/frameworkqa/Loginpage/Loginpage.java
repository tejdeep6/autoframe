package QaAutomation.frameworkqa.Loginpage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import QaAutomation.frameworkqa.commands.Manipulation;
import QaAutomation.frameworkqa.commands.Navigate;
import QaAutomation.frameworkqa.utils.Directory;

public class Loginpage extends Manipulation {
	
	/**
	 * Name :Vinothkumar.M
	 * Created Date:  
	 * Modified Date:
	 * Description :
	 * Purpose : 
	 */
	
	public static void Login(WebDriver driver)
	{
		//Navigate.get(driver, Directory.CLARKS_URL);
		//Navigate.maximize(driver);
		
		WebElement register_login_link= driver.findElement(By.xpath(OR.Clarks_REGISTER_LOGIN_LINK));
		verifyElementIsPresent(driver, register_login_link);
		click(register_login_link);
		wait(driver, "1");
		WebElement email_Mobile_No_Textbox= driver.findElement(By.xpath(OR.Clarks_EMAIL_MOBILE_NUMBER_TEXTBOX));
		WebElement password_Textbox= driver.findElement(By.xpath(OR.Clarks_PASSWORD_TEXTBOX));
		WebElement login_Button= driver.findElement(By.xpath(OR.Clarks_LOGIN_BUTTON));
		/*actionType(driver,Email_Mobile_No_Textbox,ENTEDEAL_USERNAME);*/
		sendKeys(email_Mobile_No_Textbox,Directory.CLARKS_USERNAME);
		wait(driver, "2");
		sendKeys(password_Textbox,Directory.CLARKS_PASSWORD);
		wait(driver, "2");
		click(login_Button);
		wait(driver, "2");

		

	}
	
	

}
