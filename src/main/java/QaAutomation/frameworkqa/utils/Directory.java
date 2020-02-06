package QaAutomation.frameworkqa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

import QaAutomation.frameworkqa.EmbitelReports;
import QaAutomation.frameworkqa.enums.ReportLabels;
import QaAutomation.frameworkqa.exceptions.EmbitelReporterException;
import QaAutomation.frameworkqa.writers.HTMLDesignFilesWriter;
/**
 * Configurations
 * @author vinothkumar
 *
 */
public class Directory {

	static Logger log = Logger.getLogger(Directory.class.getName());
	public static final String CURRENTDir = System.getProperty("user.dir");
	public static final String SEP = System.getProperty("file.separator");
	public static String REPORTSDIRName = "embitel Reports";
	public static String REPORTSDir = CURRENTDir + SEP + REPORTSDIRName;
	public static String RESULTSDir = REPORTSDir + SEP + "Results";
	public static String HTMLDESIGNDIRName = "HTML_Design_Files";
	public static String HTMLDESIGNDir = REPORTSDir + SEP + HTMLDESIGNDIRName;
	public static String CSSDIRName = "CSS";
	public static String CSSDir = HTMLDESIGNDir + SEP + CSSDIRName;
	public static String IMGDIRName = "IMG";
	public static String IMGDir = HTMLDESIGNDir + SEP + IMGDIRName;
	public static String JSDIRName = "JS";
	public static String JSDir = HTMLDESIGNDir + SEP + JSDIRName;
	public static String RUNName = "Test Execution_1"; 
	public static String RUNDir = RESULTSDir + SEP + RUNName;
	public static String SETTINGSFile = RESULTSDir + SEP + "Settings.properties";
	public static final char JS_SETTINGS_DELIM = ';';
	public static final String REPO_DELIM = "##@##@##";
	public static final char JS_FILE_DELIM = ',';
	public static final String MENU_LINK_NAME = "Run ";
	public static final String SCREENSHOT_TYPE = "PNG";
	public static final String SCREENSHOT_EXTENSION = ".PNG";
	private static String logo = null;
	public static String SCREENSHOT_DIRName = "img";
	public static boolean generateConfigReports = true;
	public static boolean generateExcelReports = false;
	public static boolean takeScreenshot = false;
	public static boolean continueExecutionAfterStepFailed = false;
	public static boolean recordExecutionAvailable = false;
	public static boolean recordSuiteExecution = false;
	public static boolean recordTestMethodExecution = false;
	public static final String MAIN_RECORD_FILE_NAME = "ATU_CompleteSuiteRecording";
	public static String userName=null;
	public static String password=null;
	public static String smtpHost=null;
	public static String fromAddress=null;
	public static String toAddress=null;
	public static String ccAddress=null;
	//public static String bccAddress=null;
	public static String testCasePath=null;
	public static String ORSheetPath=null;
	public static String browser=null;
	public static String Subject=null;
	public static String Reports_Path=null;
	public static String Zipfolder_Path=null;
	public static String WIDGET_HTML_FILE=null;
	public static String WaitFor=null;
	public static String uploadFilePath=null;
	public static String CMS_NOC_URL=null;
	public static String DEMO_URL=null;
	public static String CMS_Write_URL=null;
	public static String CMS_Read_URL=null;
	public static String CMS_NA_URL=null;
	public static String URL_PROPERTIES=null;
	public static boolean reexecution=true;
	//Mobile Configuration
	public static String MOBILE_APPPATH=null;
	public static String MOBILEAPP_APK_NAME=null;
	public static String MOBILE_DEVICE_NAME=null;
	public static String MOBILE_DEVICE_VERSION=null;
	public static String MOBILE_APK_APPPACKAGE=null;
	public static String MOBILE_DEVICE_TYPE=null;
	public static String MOBILE_IOSDEVICE_UDID= null;
	public static String MOBILE_APP_TYPE=null;
	public static String MOBILE_WEB_BROWSER_NAME=null;
	public static String MOBILE_WEB_URL=null;
	public static String MOBILE_APPWAITACTIVITY=null;
	public static String ENVIRONMENT = null;
	
	//Resolution
	public static String MOBILE_SCREEN_RESOLUTION_SIZE=null;
	public static String WEB_SCREEN_RESOLUTION_SIZE=null;

	
	public static String CLARKS_URL = null;
	public static String CLARKS_USERNAME = null;
	public static String CLARKS_PASSWORD = null;
	
	

	/**
	 * Retrieve values from custom properties
	 * @throws mothercareReporterException
	 * @throws Exception 
	 */
	public static void init() throws EmbitelReporterException, Exception {
		if (getCustomProperties() != null) {
			log.info("Reading from custom properties");
			Properties localProperties = new Properties();

			try {
				localProperties.load(new FileReader(getCustomProperties()));
				String reportsDir = localProperties.getProperty("embitel.reports.dir")			.trim();
				String headerText = localProperties.getProperty(			"embitel.proj.header.text").trim();
				logo = localProperties.getProperty("embitel.proj.header.logo")			.trim();
				String projectDescription = localProperties.getProperty(			"embitel.proj.description").trim();
				String takeScreenShot = localProperties.getProperty(			"embitel.reports.takescreenshot").trim();
				String configReports = localProperties.getProperty(			"embitel.reports.configurationreports").trim();
				String excelReport = localProperties.getProperty("embitel.reports.excel")			.trim();
				String contExectution = localProperties.getProperty(			"embitel.reports.continueExecutionAfterStepFailed").trim();
				String reExecution = localProperties.getProperty(			"embitel.failures.reexecution").trim();

				userName = localProperties.getProperty(			"embitel.mail.username").trim();
				password = localProperties.getProperty(			"embitel.mail.password").trim();
				smtpHost = localProperties.getProperty(			"embitel.mail.smtp.host").trim();
				fromAddress = localProperties.getProperty(			"embitel.mail.from.address").trim();
				toAddress = localProperties.getProperty(			"embitel.mail.to.address").trim();
				ccAddress = localProperties.getProperty(				"embitel.mail.cc.address").trim();	
				Subject = localProperties.getProperty(				"embitel.mail.subject").trim();
				Reports_Path = localProperties.getProperty(				"embitel.reports.dir").trim();
				Zipfolder_Path = localProperties.getProperty(				"embitel.mail.zipfolder").trim();
				testCasePath = localProperties.getProperty(			"embitel.proj.testcasePath").trim();
				ORSheetPath = localProperties.getProperty(			"embitel.proj.ORSheet.path").trim();
				browser = localProperties.getProperty(			"embitel.browser.name").trim().toLowerCase();
				WaitFor = localProperties.getProperty(			"embitel.proj.waitSec").trim().toLowerCase();
			

				//Mobile Configuration
				MOBILE_APPPATH=localProperties.getProperty(			"embitel.mobileapp.apk.path").trim();
				MOBILEAPP_APK_NAME=localProperties.getProperty(			"embitel.mobile.apk.name").trim();
				MOBILE_DEVICE_NAME=localProperties.getProperty(			"embitel.mobile.devicename").trim();
				MOBILE_DEVICE_VERSION=localProperties.getProperty(			"embitel.mobile.version").trim();
				MOBILE_APK_APPPACKAGE=localProperties.getProperty(			"embitel.mobile.apppackage.name").trim();
				MOBILE_APP_TYPE = localProperties.getProperty(			"embitel.mobile.app.type").trim();
				MOBILE_WEB_BROWSER_NAME = localProperties.getProperty(			"embitel.mobile.web.browser").trim();
				MOBILE_WEB_URL = localProperties.getProperty(			"embitel.mobile.web.Url").trim();
				MOBILE_DEVICE_TYPE = localProperties.getProperty(			"embitel.mobile.device.type").trim();
				MOBILE_IOSDEVICE_UDID = localProperties.getProperty(			"embitel.ios.mobile.udid").trim();
				MOBILE_APPWAITACTIVITY=localProperties.getProperty(			"embitel.mobile.appwaitactivity.name").trim();
				ENVIRONMENT=localProperties.getProperty(			"embitel.environment").trim();
				
				
				Properties urlProperties = new Properties();
				InputStream input = new FileInputStream(testCasePath+"/"+ENVIRONMENT+".properties");
				urlProperties.load(input);	

				CLARKS_URL = urlProperties.getProperty(			"CLARKS_URL").trim();			
				CLARKS_USERNAME=urlProperties.getProperty(			"CLARKS_USERNAME").trim();
				CLARKS_PASSWORD=urlProperties.getProperty(			"CLARKS_PASSWORD").trim();

				try {
					if ((headerText != null) && (headerText.length() > 0)) {
						ReportLabels.HEADER_TEXT.setLabel(headerText);
					}
					if ((takeScreenShot != null) && (takeScreenShot.length() > 0)) {
						try {
							takeScreenshot = Boolean.parseBoolean(takeScreenShot);
						} catch (Exception localException1) {
						}
					}
					if ((reExecution != null) && (reExecution.length() > 0)) {
						try {
							reexecution = Boolean.parseBoolean(reExecution);
						} catch (Exception localException1) {
						}
					}
					if ((configReports != null) && (configReports.length() > 0)) {
						try {
							generateConfigReports = Boolean.parseBoolean(configReports);
						} catch (Exception localException2) {
						}
					}
					if ((excelReport != null) && (excelReport.length() > 0)) {
						try {
							generateExcelReports = Boolean.parseBoolean(excelReport);
						} catch (Exception localException3) {
						}
					}
					if ((contExectution != null) && (contExectution.length() > 0)) {
						try {
							continueExecutionAfterStepFailed = Boolean
									.parseBoolean(contExectution);
						} catch (Exception localException4) {
						}
					}

					File outputFile = new File(Directory.Zipfolder_Path);
					if(!outputFile.exists()){
						outputFile.mkdir();
					}
					File file = new File(reportsDir);
					if(file.exists())
					{
					}
					if ((projectDescription != null) && (projectDescription.length() > 0)) {
						EmbitelReports.indexPageDescription = projectDescription;
					}
					if ((reportsDir != null) && (reportsDir.length() > 0)) {
						REPORTSDir = reportsDir;
						REPORTSDIRName = new File(REPORTSDir).getName();
						RESULTSDir = REPORTSDir + SEP + "Results";
						HTMLDESIGNDIRName = "HTML_Design_Files";
						HTMLDESIGNDir = REPORTSDir + SEP + HTMLDESIGNDIRName;
						CSSDIRName = "CSS";
						CSSDir = HTMLDESIGNDir + SEP + CSSDIRName;
						IMGDIRName = "IMG";
						IMGDir = HTMLDESIGNDir + SEP + IMGDIRName;
						JSDIRName = "JS";
						JSDir = HTMLDESIGNDir + SEP + JSDIRName;
						RUNName = "Run_";
						RUNDir = RESULTSDir + SEP + RUNName;
						SETTINGSFile = RESULTSDir + SEP + "Settings.properties";
					}
				} catch (Exception localException5) {
					throw new EmbitelReporterException(localException5.toString());
				}
			} catch (FileNotFoundException localFileNotFoundException) {
				throw new EmbitelReporterException(
						"The Path for the Custom Properties file could not be found");
			} catch (IOException localIOException) {
				throw new EmbitelReporterException(
						"Problem Occured while reading the embitel Reporter Config File");
			}
		}
	}

	public static void mkDirs(String paramString) {
		File localFile = new File(paramString);
		if (!localFile.exists()) {
			localFile.mkdirs();
		}
	}

	public static boolean exists(String paramString) {
		File localFile = new File(paramString);
		return localFile.exists();
	}
	/**
	 * Verifying required files for report generation
	 * @throws Exception 
	 */
	public static void verifyRequiredFiles() throws Exception {
		init();
		log.info("Setting Reports Dir---"+REPORTSDir);
		log.info("Setting Results Dir---"+RESULTSDir);
		mkDirs(REPORTSDir);
		if (!exists(RESULTSDir)) {
			mkDirs(RESULTSDir);
			SettingsFile.initSettingsFile();
		}
		if (!exists(HTMLDESIGNDir)) {
			mkDirs(HTMLDESIGNDir);
			mkDirs(CSSDir);
			mkDirs(JSDir);
			mkDirs(IMGDir);
			HTMLDesignFilesWriter.writeCSS();
			HTMLDesignFilesWriter.writeIMG();
			HTMLDesignFilesWriter.writeJS();
		}
		if ((logo != null) && (logo.length() > 0)) {
			String str = new File(logo).getName();
			if (!new File(IMGDir + SEP + str).exists()) {
				copyImage(logo);
			}
			ReportLabels.PROJ_LOGO.setLabel(str);
		}
	}

	private static void copyImage(String paramString) throws EmbitelReporterException {
		File localFile = new File(paramString);
		if (!localFile.exists()) {
			return;
		}
		FileImageInputStream localFileImageInputStream = null;
		FileImageOutputStream localFileImageOutputStream = null;
		try {
			localFileImageInputStream = new FileImageInputStream(new File(
					paramString));
			localFileImageOutputStream = new FileImageOutputStream(new File(
					IMGDir + SEP + localFile.getName()));
			int i = 0;
			while ((i = localFileImageInputStream.read()) >= 0) {
				localFileImageOutputStream.write(i);
			}
			localFileImageOutputStream.close();
			return;
		} catch (Exception localException2) {
		} finally {
			try {
				localFileImageInputStream.close();
				localFileImageOutputStream.close();
				localFile = null;
			} catch (Exception localException4) {
				localFileImageInputStream = null;
				localFileImageOutputStream = null;
				localFile = null;
			}
		}
	}

	public static String getCustomProperties() {
		return System.getProperty("embitel.reporter.config");
	}

	public static String createTestRunDateTime() {
		Calendar cal = Calendar.getInstance();
		return DateFormatUtils.format(cal, "dd-MM-yy, hh.mm aa");
	}

	public static String getTestRunDateTime(int run) {
		try {
			String testRun = SettingsFile.get("testRunDT");
			String timeArray [] = testRun.split(";");
			return timeArray[run-1];
		} catch (EmbitelReporterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return " ";
	}
}
