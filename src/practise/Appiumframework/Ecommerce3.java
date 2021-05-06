package practise.Appiumframework;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce3 extends Baseeecommerce {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities("generalstoreapp");
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
	    int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
	    Double sum = 0.0;
	    for(int i =0 ; i < count ; i++)
	    {
	    	String amount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
		     Double amountvalue = getamount(amount);
		     sum = sum + amountvalue;
	    }
	   
	    System.out.println(sum);
	    
	    String total =driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
	    Double totalvalue = getamount(total);
	    System.out.println(sum+""+totalvalue);
	    //Assert.assertEquals(sum, totalvalue);
	    
	    WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
	    TouchAction t = new TouchAction(driver);
	    t.tap(tapOptions().withElement(element(checkbox))).perform();
	    
	    WebElement terms = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
	    t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
	    
	    driver.findElementByXPath("//*[@text='CLOSE']").click();
	    driver.findElementByClassName("android.widget.Button").click();
	    

	}
	private static AndroidDriver<AndroidElement> capabilities(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static double getamount(String value)
	{
		value = value.substring(1);
		Double amountvalue = Double.parseDouble(value);
		return amountvalue;
	}

}

