package week1.day2;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AppiumFirstCodeWithAppCapabilityAppActivity {

@Test	
public void runCode() throws URISyntaxException, InterruptedException, IOException {
		
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability("platformName", "Android");
	dc.setCapability("automationName", "UiAutomator2");
	dc.setCapability("appPackage","com.testleaf.leaforg");
	dc.setCapability("appActivity","com.testleaf.leaforg.MainActivity");
	AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(),dc);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//Entering the User id and pwd:
	driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("rajkumar@testleaf.com");
	driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).sendKeys("Leaf@123");
	//Clicking on Login button:
	driver.findElement(AppiumBy.className("android.widget.Button")).click();
	Thread.sleep(50000);	
	//Always kill the session with quit() method else we may get SocketHangup Error 
	File source = driver.getScreenshotAs(OutputType.FILE);
	File destination = new File("./snaps/LoginSuccess.png");
	FileUtils.copyFile(source, destination);
	System.out.println("Screenshot Captured!!!");
	driver.quit();
	
	
	}
	
}
