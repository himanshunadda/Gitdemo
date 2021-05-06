package appium;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Browse extends Basechrome {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement>   driver =capabilities();
		driver.get("http://cricbuzz.com");
		//driver.findElementByXPath("//a[@class='btn btn-default']").click();
		//driver.findElementByXPath("//a[@title='Cricbuzz Home']").click();
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,480)","");
		//Assert.assertTrue(driver.findElementByXPath("//h4[text()='Top Stories']").getAttribute("class").contains("header"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		   jse.executeScript("window.scrollBy(0,800)", "");
		   Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));

	}

}
