package week1.day2.practice;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;


public class CameraApp {

	@Test
	public void runCode() throws URISyntaxException, InterruptedException, IOException {
		
	//Open the camera App
	//	Click on the capture icon without inspecting the element
	//	Open the captured image by clicking on the thumbnail	
		
		//Setting Desired Capabilities:
		DesiredCapabilities dc  = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator2");
		//Launching the Camera App:
		dc.setCapability("appPackage","com.android.camera2");
		dc.setCapability("appActivity", "com.android.camera.CameraLauncher");	
		AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(), dc);
		//Clicking on the Next button:
		driver.findElement(AppiumBy.className("android.widget.Button")).click();
		//Giving permissions while using the App:
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.id("com.android.camera2:id/mode_options_overlay")).click();
		Thread.sleep(3000);		
		//Click on the Capture icon:
		driver.findElement(AppiumBy.accessibilityId("Shutter")).click();
		Thread.sleep(5000);
		//Clicking on Thumbnail icon to see the captured image:
		driver.findElement(AppiumBy.id("com.android.camera2:id/rounded_thumbnail_view")).click();
		Thread.sleep(50000);
		//Taking screenshot for evidence:
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/cameraThumnail.png");
		FileUtils.copyFile(source, destination);
		System.out.println("Camera App Closed Successfully!!!");
		driver.quit();

	}

}
