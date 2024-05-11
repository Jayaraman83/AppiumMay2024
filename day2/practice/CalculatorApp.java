package week1.day2.practice;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class CalculatorApp {
	
	@Test
	public void runCode() throws MalformedURLException, URISyntaxException {
		
		//Initializing Appium Driver:
		DesiredCapabilities dc  = new DesiredCapabilities();
		//Defining Desired Capabilities
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
//		Open Calculator Application
		dc.setCapability("appPackage", "com.google.android.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Add number 5 and 3 (5 + 3 =)
		driver.findElement(AppiumBy.accessibilityId("5")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.accessibilityId("3")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
//		Get the value from the answer
		String answer = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		System.out.println("Sum of 5 + 3 = " +answer);
//		Clear the value
		driver.findElement(AppiumBy.accessibilityId("clear")).click();
//		Now click on the number retrieved earlier
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/history_result")).click();
//		Multiply the number by 15 (8 * 15 =)
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		driver.findElement(AppiumBy.accessibilityId("1")).click();
		driver.findElement(AppiumBy.accessibilityId("5")).click();
		String finalResult = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview")).getText();
//		Print the answer
		System.out.println("The Final Result is: " +finalResult);

		
	}

}
