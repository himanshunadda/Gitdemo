package appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobjects.Homepage;
import pageobjects.Prefrences;

public class Basics extends Base {

	public static void main(String[] args) throws MalformedURLException {
		
		
		
		AndroidDriver<AndroidElement>   driver =capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Homepage h = new Homepage(driver);
		h.Prefrences.click();
		
		
		//driver.findElementByAndroidUIAutomator("text(\"Preference\")").click();
		
		Prefrences p = new Prefrences(driver);
		p.dependencies.click();
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementById("android:id/edit").sendKeys("keys");
		driver.findElementById("android:id/button1").click();
	}
}
