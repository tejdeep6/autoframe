package QaAutomation.frameworkqa.config;

import org.openqa.selenium.WebDriver;

/**
 * Main interface for the Browser Configuration
 * 
 * @author Vinothkumar
 * 
 */
public interface Browser {

	public WebDriver getDriver();

	public String getBrowserName();

	public String getVersion();

}
