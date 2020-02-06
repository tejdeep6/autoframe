package QaAutomation.frameworkqa.commands;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import QaAutomation.frameworkqa.util.AndroidCommandUtils;

public class AndroidActions 
{

	public static void wait(WebDriver driver,String inputData) {
		try {
			int time = Integer.parseInt(inputData);
			int seconds = time*1000;
			Thread.sleep(seconds);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	public static String sendKeys(WebElement webElement,String keysToSend) {
		webElement.sendKeys(keysToSend);
		return keysToSend;
	}    

	public static void click(AndroidDriver driver, String NormalXpath) {
		driver.findElement(By.xpath(NormalXpath)).click();;
	}
	public static void type(AndroidDriver driver, String xpath,String value) {
		driver.findElement(By.xpath( xpath )).sendKeys(value);
	}

	public static void scrollToAParticularElement(AndroidDriver driver, String xpath)
	{

		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
				+ "new UiSelector().textContains(\""+xpath+"\"));"));

	}

	public static void longPressAndMoveToElement(AndroidDriver driver, WebElement element1,WebElement element2)	
	{
	   TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(element1).moveTo(element2).release().perform();

	}
	
	public static String androidDynamicSendkeys(WebDriver driver,String inputData, WebElement webElement){    
		webElement.clear();
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		String currenttime = new SimpleDateFormat("E").format(Calendar.getInstance().getTime());
		String originalValue = inputData;
		String combinedValues = currenttime+originalValue;
		sendKeys(webElement, combinedValues);
		return combinedValues;
	}	

	public static void hideKeyboard(AndroidDriver driver) throws MalformedURLException 
	{
		driver.hideKeyboard();
	}

	public static String sumOfTwoString(String GetText1, String GetText2)
	{
		System.out.println("Object is Before :" +GetText1);  		
		System.out.println("Object to After : "+GetText2);
		int string1= Integer.parseInt(GetText1);
		int string2= Integer.parseInt(GetText2);
		int sum1= string1+string2;
		String sum= Integer.toString(sum1);
		System.out.println("Sum of two strings"+sum);
		return sum;
	}
	
	public static void keyboardEnter(AndroidDriver driver)
	{
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);

	}

}

