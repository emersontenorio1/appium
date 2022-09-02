package br.bt.emerson.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculadoraAsus {

    @Test
	public void deveSomar() throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Android Emulator
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");

     

        dc.setCapability("appPackage", "com.asus.calculator");
        dc.setCapability("appActivity", "com.asus.calculator.Calculator"); // This is Launcher activity of your app
                                                                                // (you can get it from apk info app)

        URL url = new URL("http://127.0.0.1:4723/wd/hub");	

		AndroidDriver driver = new AndroidDriver(url, dc);
		 
		  Thread.sleep(5000);
		  
		  
		  WebElement seven =
		  driver.findElement(By.id("com.asus.calculator:id/digit7"));
		  seven.click();
		  
		  WebElement plus =
		  driver.findElement(By.id("com.asus.calculator:id/plus")); plus.click();
		  WebElement three =
		  driver.findElement(By.id("com.asus.calculator:id/digit5"));
		  three.click(); WebElement equalTo =
		  driver.findElement(By.id("com.asus.calculator:id/equal")); equalTo.click();
		  
		  // locate the edit box WebElement 
		  WebElement results = driver.findElement(By.id("com.asus.calculator:id/resultEditTextID"));
		  
		  Assert.assertEquals("12", results.getText());
		 
		 
		  driver.quit();
			
    }

}