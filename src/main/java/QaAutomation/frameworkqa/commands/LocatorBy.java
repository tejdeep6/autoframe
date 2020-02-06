package QaAutomation.frameworkqa.commands;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorBy {

	public static WebElement locateById(WebDriver driver, String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement locateByName(WebDriver driver, String name) {
		return driver.findElement(By.name(name));
	}

	public static WebElement locateByIdOrName(WebDriver driver, String idOrName) {
		return driver.findElement(By.id(idOrName));
	}

	public static WebElement locateByXPath(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement locateByLinkText(WebDriver driver, String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

	public static WebElement locateByTagName(WebDriver driver, String tagName) {
		return driver.findElement(By.tagName(tagName));
	}

	public static WebElement locateByClassName(WebDriver driver,String className) {
		return driver.findElement(By.className(className));
	}

	public static WebElement locateByCssSelector(WebDriver driver,String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));
	}

	public static WebElement locateByPartialLinkText(WebDriver driver,String partialLinkText) {
		return driver.findElement(By.partialLinkText(partialLinkText));
	}

	public static String linkCount(WebDriver driver, String partialLinkText){
		return partialLinkText;
	}
	public static WebElement locateByResourceId(AndroidDriver driver, String resourceID){			
		return driver.findElementByAndroidUIAutomator("resourceId(\""+resourceID+"\")");		
	}
	public static WebElement locateByAccessibilityId(AndroidDriver driver, String accessibilityID){		
		return driver.findElementByAccessibilityId(accessibilityID);		
	}
	
	public static void ScrollingToSubElement(AndroidDriver driver, String linkText)
	{
		
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
			      + "new UiSelector().textContains(\""+linkText+"\"));"));

	}

}
