package week1.day2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class AppiumFirstCodeWithAppCapability {

@Test	
public void runCode() throws MalformedURLException, URISyntaxException {
		
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability("platformName", "Android");
	dc.setCapability("automationName", "UiAutomator2");
	dc.setCapability("app",System.getProperty("user.dir")+File.separator+"apks"+File.separator+"leafOrg.apk");
	AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(),dc);
	driver.quit();
	
	
	
}
	
}
