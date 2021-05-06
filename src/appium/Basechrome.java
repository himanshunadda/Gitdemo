package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Basechrome {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub
		//File f = new File("src");
		//File fs = new File(f,"ApiDemos-debug.apk");
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability("chromedriverExecutable","C:\\Users\\Himanshu\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
      cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
      
     
      //cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
      AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
      return driver;
	}

}
