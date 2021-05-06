package appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class Ecommerce2 extends Baseecommerce {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text = 'Argentina']").click();
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Himanshu");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Male']").click();
	    driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	
	//android.widget.Toast[1]
	    String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
	    System.out.println(toastMessage);
	    Assert.assertEquals("Please enter your name", toastMessage);
	
	}

}
