package QaAutomation.frameworkqa.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Class to configure and get Details for IE Browser
 * 
 * @author vinothkumar
 * 
 */
public class IEBrowser implements Browser {

	private WebDriver ieDriver;
	public static final Log log = LogFactory
			.getLog(QaAutomation.frameworkqa.config.IEBrowser.class);

	public IEBrowser() {
		System.setProperty(ApplicationConstants.IE_DRIVER_NAME,	ApplicationConstants.IE_DRIVER_PATH);
		log.info("IE Driver config set and return InternetExplorer Object");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

		ieCapabilities.setCapability("ignoreProtectedModeSettings" , true);
		ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieDriver = new InternetExplorerDriver(ieCapabilities);

	}

	public String getBrowserName() {
		return ((RemoteWebDriver) ieDriver).getCapabilities().getBrowserName();
	}

	public String getVersion() {
		return ((RemoteWebDriver) ieDriver).getCapabilities().getVersion();
	}

	public WebDriver getDriver() {
		return ieDriver;
	}

}
