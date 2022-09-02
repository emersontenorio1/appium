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

public class Calculadora {

    @Test
	public void deveSomar() throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Android Emulator
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");

     

        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator"); // This is Launcher activity of your app
                                                                                // (you can get it from apk info app)

        URL url = new URL("http://127.0.0.1:4723/wd/hub");	

        AndroidDriver driver = new AndroidDriver(url, dc);

        Thread.sleep(5000);

		
        WebElement seven = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        seven.click();
		
		  WebElement plus = driver.findElement(By.id("com.android.calculator2:id/op_add")); 
		  plus.click();
		  WebElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3")); 
		  three.click();
		  WebElement equalTo = driver.findElement(By.id("com.android.calculator2:id/eq"));
		  equalTo.click();
		 
		  // locate the edit box WebElement 
		  WebElement results = driver.findElement(By.id("com.android.ca	culator2:id/result"));
		  
		  Assert.assertEquals( "10",results.getText());
		 
		  driver.quit();
			
    }

}