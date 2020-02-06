
package QaAutomation.frameworkqa.Loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import QaAutomation.frameworkqa.commands.Manipulation;

public class pdpsizeselect extends Manipulation {

	/*
	 * WebElement register_login_link=
	 * driver.findElement(By.xpath(OR.Clarks_REGISTER_LOGIN_LINK));
	 * verifyElementIsPresent(driver, register_login_link);
	 * click(register_login_link);
	 */

	public static void pdpsize(WebDriver driver) throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
		boolean outOfStock = false;
		WebElement size;
		if (driver.findElement(By.xpath(OR.Clarks_size3)).getAttribute("class").contains("sizebox2 sizeboxtext")) {
			size = driver.findElement(By.xpath(OR.Clarks_size3));
			click(size);

		} else if (driver.findElement(By.xpath(OR.Clarks_size3plus)).getAttribute("class").contains("sizebox2 sizeboxtext"))
				 {
			size = driver.findElement(By.xpath(OR.Clarks_size3plus));
			click(size);
		} else if (driver.findElement(By.xpath(OR.Clarks_size4)).getAttribute("class").contains("sizebox2 sizeboxtext"))
				 {
			size = driver.findElement(By.xpath(OR.Clarks_size4));
			click(size);
		} else if (driver.findElement(By.xpath(OR.Clarks_size5)).getAttribute("class").contains("sizebox2 sizeboxtext"))
				 {
			size = driver.findElement(By.xpath(OR.Clarks_size5));
			click(size);
		} else if (driver.findElement(By.xpath(OR.Clarks_size5plus)).getAttribute("class").contains("sizebox2 sizeboxtext"))
				 {
			size = driver.findElement(By.xpath(OR.Clarks_size5plus));
			click(size);
		} else if (driver.findElement(By.xpath(OR.Clarks_size6)).getAttribute("class").contains("sizebox2 sizeboxtext"))
				 {
			size = driver.findElement(By.xpath(OR.Clarks_size6));
			click(size);

		} else if (driver.findElement(By.xpath(OR.Clarks_size6plus)).getAttribute("class").contains("sizebox2 sizeboxtext"))
				 {
			size = driver.findElement(By.xpath(OR.Clarks_size6plus));
			click(size);
		} 
		else if (driver.findElement(By.xpath(OR.Clarks_size7)).getAttribute("class").contains("sizebox2 sizeboxtext")) 
		{ 
			size=driver.findElement(By.xpath(OR.Clarks_size7)); 
			click(size);
		} 
		else if(driver.findElement(By.xpath(OR.Clarks_size7plus)).getAttribute("class").contains("sizebox2 sizeboxtext")) 
		{ 
			size=driver.findElement(By.xpath(OR.Clarks_size7plus)); 
			click(size);
		} 
		else if(driver.findElement(By.xpath(OR.Clarks_size8)).getAttribute("class").contains("sizebox2 sizeboxtext")) 
		{ 
			size=driver.findElement(By.xpath(OR.Clarks_size8)); 
			click(size); 
		} 
		else if(driver.findElement(By.xpath(OR.Clarks_size8plus)).getAttribute("class").contains("sizebox2 sizeboxtext")) 
		{ 
			size =driver.findElement(By.xpath(OR.Clarks_size8plus)); 
			click(size);
		}
			 
		else {
			outOfStock = true;
		}
		if (!outOfStock) {
			Thread.sleep(3000);

		}

	}
}
