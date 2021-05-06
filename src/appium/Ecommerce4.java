package appium;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;


public class Ecommerce4 extends Baseecommerce {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		driver.findElementByXPath("//*[@text = 'Argentina']").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Himanshu");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Male']").click();
	    driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	    
	    driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
	    driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
	    Thread.sleep(4000);
	    driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
	    
	    WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
	    TouchAction t = new TouchAction(driver);
	    t.tap(tapOptions().withElement(element(checkbox))).perform();
	    
	    WebElement terms = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
	    t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
	    
	    driver.findElementByXPath("//*[@text='CLOSE']").click();
	    driver.findElementByClassName("android.widget.Button").click();
	    Thread.sleep(7000);
	    
	    Set<String> contexts = driver.getContextHandles();
	    for(String contextname: contexts)
	    {
	    	System.out.println(contextname);
	    }
	    driver.context("WEBVIEW_com.androidsample.generalstore");
	    driver.findElementByName("q").sendKeys("Hello");
	    driver.findElementByName("q").sendKeys(Keys.ENTER);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    

	}
	

}

