package QaAutomation.frameworkqa.datadriver;

/**
 * Executing and add results in reports
 */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import QaAutomation.frameworkqa.EmbitelReports;
import QaAutomation.frameworkqa.enums.LogAs;
import QaAutomation.frameworkqa.util.AndroidCommandUtils;
import QaAutomation.frameworkqa.util.IOSCommandUtils;
import QaAutomation.frameworkqa.util.WebCommandUtils;
import QaAutomation.frameworkqa.utils.Directory;

public class TestCaseRunner {
	public static void exectuteTestCase(AndroidDriver adriver,IOSDriver idriver,WebDriver driver, List<CaseStep> steps) throws Exception {

		final Map<String,String> mapAppVersion = new HashMap<String,String>();
		getAppVersions(new WebDriver[] {driver,adriver,idriver}, mapAppVersion);
		System.out.println(mapAppVersion);

		Iterator<CaseStep> stepIterator = steps.iterator();

		while (stepIterator.hasNext()) {
			CaseStep eachStep = stepIterator.next();
			WebCommandUtils util = new WebCommandUtils();
			AndroidCommandUtils autil = new AndroidCommandUtils(); 
			IOSCommandUtils iutil = new IOSCommandUtils();
			WebElement element = null;
			if (eachStep.getOrLocator()!=null) {		
				try
				{
					if(Directory.browser.equalsIgnoreCase("android")) {
						element = autil.findElement(adriver, eachStep.getLocateBy(),
								eachStep.getOrLocator(),eachStep.getOrLocatorStart(),eachStep.getOrLocatorEnd(),eachStep.getReferenceStep());
					}
					else if(Directory.browser.equalsIgnoreCase("IOS")) {
						element = iutil.findElement(idriver, eachStep.getLocateBy(),
								eachStep.getOrLocator(),eachStep.getOrLocatorStart(),eachStep.getOrLocatorEnd(),eachStep.getReferenceStep());
					}
					else {
						element = util.findElement(driver, eachStep.getLocateBy(),
								eachStep.getOrLocator(),eachStep.getOrLocatorStart(),eachStep.getOrLocatorEnd(),eachStep.getReferenceStep());
					}
				}

				catch(Exception exception) {}
			}
			if(Directory.browser.equalsIgnoreCase("android")) {
				Object returnObj = autil.executeAction(adriver, element, eachStep.getAction(),
						eachStep.getInputData(),eachStep.getStepNo(),eachStep.getReferenceStep());	    
				EmbitelReports.add(eachStep.getAction(),eachStep.getDescription(),eachStep.getInputData(), eachStep.getExpectedResult(),Objects.toString(returnObj, ""),LogAs.PASSED, null);

			}
			else if(Directory.browser.equalsIgnoreCase("IOS")) {
				Object returnObj = iutil.executeAction(idriver, element, eachStep.getAction(),
						eachStep.getInputData(),eachStep.getStepNo(),eachStep.getReferenceStep());	    
				EmbitelReports.add(eachStep.getAction(),eachStep.getDescription(),eachStep.getInputData(), eachStep.getExpectedResult(),Objects.toString(returnObj, ""),LogAs.PASSED, null);

			}
			else {
				Object returnObj = util.executeAction(driver, element, eachStep.getAction(),
						eachStep.getInputData(),eachStep.getStepNo(),eachStep.getReferenceStep());
				EmbitelReports.add(eachStep.getAction(),eachStep.getDescription(),eachStep.getInputData(), eachStep.getExpectedResult(),Objects.toString(returnObj, ""),LogAs.PASSED, null);
			}
		}
	}

	private static void getAppVersions(final WebDriver[] webDrivers, final Map<String, String> mapAppVersion) {
		// find first non-null driver
		WebDriver driver = null;
		for (final WebDriver d : webDrivers) {
			if (driver == null && d != null) {
				driver = d;
			}
		}
		if (driver == null) {
			System.err.println("Cannot find non-null WebDriver.");
			return;
		}
	}

	private static final Pattern patternRevision = Pattern.compile("Revision.*:\\s*(\\S*)");

	private static void getAppVersion(final WebDriver driver, final String app, final String url, final Map<String, String> mapAppVersion) {
		driver.navigate().to(url);
		final String page = driver.getPageSource();

		// Search for revision comment:
		// <!-- Built from Revision #: 158bc5a-17.07.00.05 -->

		final Matcher matcher = TestCaseRunner.patternRevision.matcher(page);
		if (matcher.find() && matcher.groupCount() >= 1) {
			mapAppVersion.put(app, matcher.group(1));
		}
	}
}
