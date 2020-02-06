package QaAutomation.frameworkqa.commands;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import QaAutomation.frameworkqa.commands.Navigate;
import QaAutomation.frameworkqa.util.WebCommandUtils;
import QaAutomation.frameworkqa.utils.Directory;
import QaAutomation.frameworkqa.utils.Platform;

public class Manipulation extends WebCommandUtils{

	static Logger log = Logger.getLogger(Manipulation.class.getName());
	public static String ElementWait=Directory.WaitFor;
	public static int WaitElementSeconds=new Integer(ElementWait);

	public static void click(WebElement webElement) {
		try {
			if(webElement.isDisplayed()) {
				webElement.click();
			}
		}
		catch (StaleElementReferenceException e){ }
	}

	public static void jsClickByXPath(WebDriver driver,String NormalXpath) {
		WebElement element = driver.findElement(By.xpath(NormalXpath));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public static void jsTypeByXPath(WebDriver driver,String NormalXpath, String InputData) {
		WebElement element = driver.findElement(By.xpath(NormalXpath));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		executor.executeScript("arguments[0].type ='"+InputData+"';",element);
	}
	
	public static void actionClick(WebDriver driver, WebElement webElement) {
		try {
			if(webElement.isEnabled()) {
				webElement.click();
			}
		} catch (StaleElementReferenceException e) { }
	}

	public static void actionType(WebDriver driver,WebElement webElement,CharSequence... keysToSend){
		try {
			if(webElement.isEnabled())
			{
				webElement.sendKeys(keysToSend);
			}
		} catch (StaleElementReferenceException e) { }
	}

	public static void doubleClick(WebDriver driver, WebElement webElement) {
		try {
			Actions action = new Actions(driver).doubleClick(webElement);
			action.build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document ");
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM ");
		} catch (Exception e) {
			log.info("Element " + webElement + " was not clickable ");
		}
	}
	
	public static void clear(WebElement webElement) {
		webElement.clear();

	}
	public static void actionClear(WebDriver driver,WebElement webElement) {
		webElement.click();
		Actions action = new Actions(driver);
		webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
		action.sendKeys(Keys.DELETE);
		
	}

	public static String clearAndType(WebElement webElement, String keysToSend) {
		webElement.clear();
		try{Thread.sleep(2000);}catch(InterruptedException e){e.printStackTrace();}
		webElement.sendKeys(keysToSend);
		return keysToSend;
	}

	public static String sendKeys(WebElement webElement,String keysToSend) {
		webElement.sendKeys(keysToSend);
		return keysToSend;
	}

	public static void submit(WebElement webElement) {
		webElement.submit();
	}

	public static void keyDown(Actions actions, Keys keys) {
		actions.keyDown(keys);
	}

	public static void keyUp(Actions actions, Keys keys) {
		actions.keyUp(keys);
	}

	public static String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public static void mouseOver(WebDriver driver, WebElement webElement) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document ");
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM ");
		} catch (Exception e) {
			log.info("Element " + webElement + " was not mouseOver ");
		}
	}

	public static void mouseOverAndClick(WebDriver driver, WebElement webElement) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(webElement).click().build().perform();
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document ");
		} catch (NoSuchElementException e) {
			log.info("Element " + webElement + " was not found in DOM ");
		} catch (Exception e) {
			log.info("Element " + webElement + " was not mouseOver ");
		}
	}

	public static void selectCheckBox(WebElement element) {
		try {
			if (element.isSelected()) {
				log.info("Checkbox: " + element + "is already selected");
			} else {
				element.click();
			}
		} catch (Exception e) {
			log.info("Unable to select the checkbox: " + element);
		}
	}

	public static void deSelectCheckBox(WebElement element) {
		try {
			if (element.isSelected()) {
				element.click();
			} else {
				log.info("Checkbox: " + element + "is already deselected");
			}
		} catch (Exception e) {
			log.info("Unable to deselect checkbox: " + element);
		}
	}

	public static void selectByIndex(WebElement element, String inputData) {
		try {
			Integer index = new Integer(inputData);
			Select selectBox = new Select(element);
			selectBox.selectByIndex(index);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void selectByValue(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.selectByValue(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static String selectByVisibletext(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.selectByVisibleText(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
		return inputData;
	}

	public static void deSelectByVisibletext(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.deselectByVisibleText(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void deSelectByIndex(WebElement element, String inputData) {
		try {
			Integer index = new Integer(inputData);
			Select selectBox = new Select(element);
			selectBox.deselectByIndex(index);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static void deSelectByValue(WebElement element, String inputData) {
		try {
			Select selectBox = new Select(element);
			selectBox.deselectByValue(inputData);
		} catch (Exception e) {
			log.info("Unable to select selectbox: " + element);
		}
	}

	public static String Main_Window = "";
	public static void getWindow(WebDriver driver, WebElement webElement)
	{
		Navigate.waitTime(driver, "5");
		Main_Window = driver.getWindowHandle();
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
		wait(driver, "3");
		click(webElement);
		wait(driver, "3");

		ArrayList<String> tabs2=new ArrayList<String>(driver.getWindowHandles());
		wait(driver, "3");

		driver.switchTo().window(tabs2.get(1));
		wait(driver, "3");
		System.out.println("Entered tabs");
		wait(driver, "3");
	}

	public static void getWindowUsingJsclick(WebDriver driver, String xpath) {
		Navigate.waitTime(driver, "5");
		Main_Window = driver.getWindowHandle();
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
		wait(driver, "3");
		jsClickByXPath(driver, xpath);
		wait(driver, "2");
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
		ArrayList<String> allWindows=new ArrayList<String>(driver.getWindowHandles());
		allWindows.remove(Main_Window);
		driver.switchTo().window(allWindows.get(0));
	}

	public static String Main_Window1 ="";
	public static void getwindowandclose(WebDriver driver, WebElement webElement) {
		Navigate.waitTime(driver, "5");
		Main_Window1 = driver.getWindowHandle();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait(driver, "3");
		click(webElement);
		wait(driver, "2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ArrayList<String> allWindows = new ArrayList<String>(
				driver.getWindowHandles());
		allWindows.remove(Main_Window1);
		driver.switchTo().window(allWindows.get(0));
		wait(driver, "3");
		driver.switchTo().window(Main_Window1).close();
		driver.switchTo().window(allWindows.get(0));

	}

	public static void getSecondWindow(WebDriver driver, WebElement webElement) {
		String Second_Window = driver.getWindowHandle();
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webElement);
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
		wait(driver, "10");
		ArrayList<String> allWindows=new ArrayList<String>(driver.getWindowHandles());
		System.out.println("No of windows is: "
				+ "" +allWindows.size());
		allWindows.remove(Main_Window);
		allWindows.remove(Second_Window);
		driver.switchTo().window(allWindows.get(0));
	
	}

	public static String GetCurrentWindow(WebDriver driver) {
		String CurrentWindow = driver.getWindowHandle();
		return CurrentWindow;
	}

	public static void switchParticularWindow(WebDriver driver,String Window) {
		driver.switchTo().window(Window);
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
	}
    
	public static void switchWindow(WebDriver driver) {
		driver.switchTo().window(Main_Window);
		try{Thread.sleep(1000);}
		catch(InterruptedException e){e.printStackTrace();}
	}

	public static void switchDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
	}

	public static void getAutoit(WebDriver driver, String inputData) {
		try {
			Runtime.getRuntime().exec(inputData);
		} catch (IOException e1){
			e1.printStackTrace();
		}
	}

	public static void wait(WebDriver driver,String inputData) {
		try {
			int time = Integer.parseInt(inputData);
			int seconds = time*1000;
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static WebElement fromElement;
	public static void dragElement(WebDriver driver, WebElement webElement)	{
		fromElement=webElement;
	}

	public static void dropElement(WebDriver driver, WebElement webElement) {
		Actions action = new Actions(driver);
		Action dragDrop = action.dragAndDrop(fromElement, webElement).build();
		dragDrop.perform();
	}

	public static boolean elementIsSelected(WebDriver driver, WebElement webElement) {
		try {
			webElement.isSelected();
			return true;
		} catch(NoSuchElementException e) {
			log.info("Unable to Select WebElement: " + webElement);
			return false;
		}
	}

	public static String verifyElementIsPresent(WebDriver driver, WebElement webElement){
		try {
			webElement.isDisplayed();
			return "element is present";
		} catch(NoSuchElementException e)   {
			log.info("Unable to Displayed WebElement: " + webElement);
			return "element is not present";
		}
	}
	
	  public static String verifyElementIsnotdisplayed(WebDriver driver, String
	  webElement){ String Result=""; try {
	  if(driver.findElement(By.xpath(webElement)).isDisplayed()) {
	  Result="Element is present"; Assert.fail(); } else {
	  Result="Element is Not present"; }
	 

 

        } catch(Exception e) {
            Result="Element is Not present";
        }

 

        return Result;
    }

	
	/*
	 * public static String verifyElementIsnotdisplayed(WebDriver driver, String
	 * webElement) { String Result=""; try {
	 * if(driver.findElement(By.xpath(webElement)).isDisplayed()) {
	 * Result="Element is present"; } else { Result="Element is Not present"; }
	 * 
	 * } catch(Exception e) { Result="Element is Not present"; }
	 * 
	 * return Result; }
	 */
	  public static String verifyElementIsNotPresent(WebDriver driver, WebElement
	  webElement){ try { WebDriverWait wait = new WebDriverWait(driver,
	  WaitElementSeconds);
	  wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(webElement)
	  )); } catch(Exception e) { return "Verified Element is Hidden"; } return
	  "Verified Element is Visible"; }
	 
	public static boolean elementIsEnable(WebDriver driver, WebElement webElement){
		try {
			webElement.isEnabled();
			return true;
		} catch(NoSuchElementException e)  {
			log.info("Unable to Enabled WebElement: " + webElement);
			return false;
		}
	}

	public static void visibilityElement(WebDriver driver, WebElement webElement){
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public static void inVisibilityElement(WebDriver driver, String NormalXpath){
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(NormalXpath)));
	}

	public static void textIsPresent(WebDriver driver,WebElement webElement, String inputData){
		driver.getPageSource().contains(inputData);
	}

	public static void textTobePresent(WebDriver driver,WebElement webElement, String inputData){
		WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
		waits.until(ExpectedConditions.textToBePresentInElement(webElement, inputData));
	}

	public static void testIsNotPresent(WebDriver driver, String NormalXpath,String inputData){
		WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
		waits.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(NormalXpath), inputData));
	}

	public static void elementTobeClickable(WebDriver driver,WebElement webElement)	{
		WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
		waits.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public static void elementToBeSelected(WebDriver driver,WebElement webElement)	{
		WebDriverWait waits = new WebDriverWait(driver, WaitElementSeconds);
		waits.until(ExpectedConditions.elementToBeSelected(webElement));
	}

	public static void waitForElement(WebDriver driver, String NormalXpath)	{
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(NormalXpath)));
	}

	public static void waitForElementNotpresent(WebDriver driver,String NormalXpath) {
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(NormalXpath))));
	}

	public static void textElementPresentValue(WebDriver driver,WebElement webElement, String inputData){
		WebDriverWait wait = new WebDriverWait(driver, WaitElementSeconds);
		wait.until(ExpectedConditions.textToBePresentInElementValue(webElement, inputData));
	}

	public static String linkCounts(WebDriver driver, String NormalXpath){
		int count = driver.findElements(By.xpath(NormalXpath)).size();
		String elementCounts = String.valueOf(count);
		return elementCounts;
	}
	public static String dynamicSendkeys(WebDriver driver,String inputData, WebElement webElement){
		webElement.clear();
		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		String currenttime = new SimpleDateFormat("EHHmmss").format(Calendar.getInstance().getTime());
		String originalValue = inputData;
		String combinedValues = currenttime+originalValue;
		sendKeys(webElement, combinedValues);
		return combinedValues;
	}

	public static void waitForAjax(WebDriver driver) {
		new WebDriverWait(driver, 180).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) 	{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return (Boolean) js.executeScript("return jQuery.active == 0");
			}
		});
	}

	public static String condtionMatch(String GetText1, String GetText2){
		String output = "";
		System.out.println("Object is Before :" +GetText1);
		System.out.println("Object to After : "+GetText2);
		try	{
			if((GetText1.trim()).equalsIgnoreCase(GetText2.trim()))	{
				output = "The value "+GetText2+" is Verified";
				return output;
			}
			else
			{
				output = "The value is not matched";
				Assert.fail();
				return output;
			}
		} catch(NoSuchElementException e)
		{
			log.info("Unable to Matched WebElement: " + output);
			output = "The value "+GetText2+" is not Matched";
			return output;
		}
	}
	public static String condtionNotMatch(String GetText1, String GetText2){
		String output = "";
		System.out.println("Object is Before :" +GetText1);
		System.out.println("Object to After : "+GetText2);
		try	{
			if(!GetText1.trim().equalsIgnoreCase(GetText2.trim()))
			{
				output = "The value is not matched";
				return output;
			}
			else
			{
				output = "The value"+GetText2+" is Verified";
				Assert.fail();
				return output;
			}
		} catch(NoSuchElementException e)
		{
			log.info("Unable to Matched WebElement: " + output);
			output = "The value"+GetText2+" is not Matched";
			return output;
		}
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
	public static String getSelectedFirstElementOfSelectBox(WebElement element) {
		Select dropdown= new Select(element);
		WebElement option = dropdown.getFirstSelectedOption();
		String text=option.getText();
		return text;
	}
	public static String checkPartialText(String GetText1, String GetText2){
		String output = "";
		System.out.println("Object is Before :" +GetText1.trim().toLowerCase());
		System.out.println("Object to After : "+GetText2);
		try	{
			if((GetText1.trim()).toLowerCase().contains(GetText2.trim().toLowerCase())||(GetText2.trim()).toLowerCase().contains(GetText1.trim().toLowerCase()))	{
				output = "The value "+GetText2+" is Verified";
				return output;
			}
			else
			{
				output = "The value is not matched";
				Assert.fail();
				return output;
			}
		} catch(NoSuchElementException e)
		{
			log.info("Unable to Matched WebElement: " + output);
			output = "The value "+GetText2+" is not Matched";
			return output;
		}
	}
	public static void clickUsingSize(WebDriver driver,String NormalXpath) {
		int size =driver.findElements(By.xpath(NormalXpath)).size();
		driver.findElements(By.xpath(NormalXpath)).get(size-1).click();
	}

	public static String stringIsEmpty(String refSte2)
	{
		if (refSte2.equalsIgnoreCase(" "))
		{
			System.out.println("The value is Empty");
		}
		else
		{
			System.out.println("The value is not Empty");
			Assert.fail();

		}
		return refSte2;

	}
	public static void getWindow1(WebDriver driver, WebElement webElement)
	{
		Navigate.waitTime(driver, "5");
		Main_Window = driver.getWindowHandle();
		try{Thread.sleep(1000);}catch(InterruptedException e){e.printStackTrace();}
		wait(driver, "3");
		click(webElement);
		wait(driver, "15");

		ArrayList<String> tabs2=new ArrayList<String>(driver.getWindowHandles());
		wait(driver, "3");

		driver.switchTo().window(tabs2.get(2));
		wait(driver, "3");
		System.out.println("Entered tabs");
		wait(driver, "3");
	}
	
	public static String dynamickeys(WebDriver driver){

		try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		String currenttime = new SimpleDateFormat("yyyy"+"-"+"MM"+"-"+"dd").format(Calendar.getInstance().getTime());
		String combinedValues = currenttime;
		System.out.println(combinedValues);
		return combinedValues;
		
	}
}
