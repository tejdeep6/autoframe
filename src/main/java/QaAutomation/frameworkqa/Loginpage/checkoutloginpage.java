package QaAutomation.frameworkqa.Loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import QaAutomation.frameworkqa.commands.Manipulation;
import QaAutomation.frameworkqa.utils.Directory;

public class checkoutloginpage extends Manipulation {
	/**
	 * Name :Tejdeep.D
	 * Created Date:  
	 * Modified Date:
	 * Description :
	 * Purpose : 
	 * @throws Exception 
	 */

	public static void Checkoutlogin(WebDriver driver) throws Exception
	{
		/*
		 * Navigate.get(driver, Directory.CLARKS_URL); Navigate.maximize(driver);
		 * 
		 * WebElement register_login_link=
		 * driver.findElement(By.xpath(OR.Clarks_REGISTER_LOGIN_LINK));
		 * verifyElementIsPresent(driver, register_login_link);
		 * click(register_login_link); wait(driver, "1");
		 */
		WebElement email_Mobile_No_Textbox= driver.findElement(By.xpath(OR.Clarks_Checkout_Email));
		WebElement password_Textbox= driver.findElement(By.xpath(OR.Clarks_Checkout_Password));
		WebElement login_Button= driver.findElement(By.xpath(OR.Clarks_Checkout_Signinbutton));
		/*actionType(driver,Email_Mobile_No_Textbox,ENTEDEAL_USERNAME);*/
		sendKeys(email_Mobile_No_Textbox,Directory.CLARKS_USERNAME);
		//Thread.sleep(5000);
		wait(driver, "2");
		sendKeys(password_Textbox,Directory.CLARKS_PASSWORD);
		//Thread.sleep(5000);
		wait(driver, "2");
		click(login_Button);
		wait(driver, "2");

		


	}

}
