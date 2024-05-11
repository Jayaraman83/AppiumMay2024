package week1.day2;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class AppiumFirstCode {

@Test	
public void runCode() throws MalformedURLException, URISyntaxException {
		
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability("platformName", "Android");
	dc.setCapability("automationName", "UiAutomator2");
	AppiumDriver driver = new AppiumDriver(new URI("http://127.0.0.1:4723/").toURL(),dc);
	driver.quit();
	
	
	
}
	
}
