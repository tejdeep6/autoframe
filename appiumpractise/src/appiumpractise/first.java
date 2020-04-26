package appiumpractise;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.remote.MobileCapabilityType;

public class first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      File f = new File("src");
      File fs = new File("original.apk");
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
      cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
      //AndroidDriver<Andriod Element> driver= new AndroidDriver<>(new URL("http;"))
      
		
	}

}
